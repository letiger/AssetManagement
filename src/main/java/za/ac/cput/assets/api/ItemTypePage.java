package za.ac.cput.assets.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.assets.domain.ItemType;
import za.ac.cput.assets.model.ItemTypeResource;
import za.ac.cput.assets.services.ItemTypeService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * Created by student on 2015/08/09.
 */
@RestController
@RequestMapping(value="/itemtype/**")
public class ItemTypePage {
    @Autowired
    private ItemTypeService service;


    //Get all ItemTypes
    @RequestMapping(value =  "/items", method = RequestMethod.GET)
    public List<ItemType> getItemTypes(){
        return service.getAllTypes();
    }

    //Get ItemType by id
    @RequestMapping(value =  "/{id}", method = RequestMethod.GET)
    public ItemType getItemType(@PathVariable Long id, HttpServletResponse response) throws IOException{
        try{
            ItemType itemType = service.find(id);
            if (itemType == null){
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return null;
            }else{
                return itemType;
            }
        }catch (Exception e){
            System.out.println("ErrorCode for GetItemType by id:\n"+e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            return null;
        }
    }
    @RequestMapping(value =  "/add" ,method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public void addItemType(@Valid
                            @RequestBody
                            ItemTypeResource itemTypeResource,
                            HttpServletResponse response) throws IOException {
        try{
            ItemType itemType = new ItemType
                    .Builder(itemTypeResource.getCode())
                    .name(itemTypeResource.getName())
                    .itemList(null)
                    .build();

            service.createItemType(itemType);
        }catch(Exception e){
            System.out.println("Error Message for CreateItemType \n" +e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @RequestMapping(value =  "/delete/{id}", method = RequestMethod.GET)
    public void deleteItemType(@PathVariable Long id, HttpServletResponse response) throws IOException{
            service.deleteItemType(id);
    }
}
