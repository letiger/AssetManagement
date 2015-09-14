package za.ac.cput.assets.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.assets.domain.Owner;
import za.ac.cput.assets.model.OwnerResource;
import za.ac.cput.assets.services.OwnerService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * Created by student on 2015/09/14.
 */
@RestController
@RequestMapping(value="/owner/**")
public class OwnerPage {
    @Autowired
    private OwnerService service;

    //Get all Owners
    @RequestMapping(value = "/owners", method = RequestMethod.GET)
    public List<Owner> getOwners(){
        return service.getAllTypes();
    }

    //Get Owner by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Owner getOwner(@PathVariable Long id,
                          HttpServletResponse response)throws IOException{
        try {
            Owner owner = service.find(id);
            if (owner==null){
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return null;
            }else
                return owner;
        }catch (Exception e){
            System.out.println("ErrorCode for GetOwner by id:\n"+e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            return null;
        }
    }
    @RequestMapping(value="/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addOwner(@Valid
                         @RequestBody
                         OwnerResource ownerResource,
                         HttpServletResponse response) throws Exception{
        try {
            Owner owner = new Owner
                    .Builder(ownerResource.getPk())
                    .startDate("2015/08/16")
                    .name("Brandon")
                    .email("203115848@mycput.ac.za")
                    .surname("Walze")
                    .build();
            service.createOwner(owner);
        }catch (Exception e){
            System.out.println("Error Message for CreateItemType \n" +e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void deleteOwner(@PathVariable Long id, HttpServletResponse response) throws IOException{
        service.deleteOwner(id);
    }

}
