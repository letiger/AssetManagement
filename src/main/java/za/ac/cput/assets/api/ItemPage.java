package za.ac.cput.assets.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.assets.domain.Item;
import za.ac.cput.assets.domain.Owner;
import za.ac.cput.assets.services.ItemService;
import za.ac.cput.assets.services.OwnerService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/14.
 */
@RestController
@RequestMapping(value="/item/**")
public class ItemPage {
    @Autowired
    private ItemService itemService;
    @Autowired
    private OwnerService ownerService;

    //Get all Items
    @RequestMapping(value="/items", method = RequestMethod.GET)
    public List<Item>  getItems(){
        return itemService.getAllTypes();
    }

    //Get items by owner_id
    @RequestMapping(value = "/onwer/{id}", method = RequestMethod.GET)
    public List<Item> getItemByOwner(@PathVariable Long id,
                               HttpServletResponse response){
        List<Item> itemList = new ArrayList<>();
        try {
            Owner owner = ownerService.find(id);
            if (owner==null){
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return null;
            }else{
                Iterable<Item> values = owner.getItemList();
                for(Item value: values){
                    itemList.add(value);
                }
            }
                return itemList;
        }catch (Exception e){
            try {
                System.out.println("ErrorCode for GetItemByOwner by id:\n" + e);
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                return null;
            }catch ( IOException ioe ){
                System.out.println("ErrorCode for GetItemByOwner by id:\n" + ioe);
                return null;
            }
        }
    }

}
