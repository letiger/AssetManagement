package za.ac.cput.assets.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.assets.domain.ItemType;
import za.ac.cput.assets.services.ItemTypeService;

import java.util.List;

/**
 * Created by student on 2015/08/09.
 */
@RestController
@RequestMapping(value="/itemtype/**")
public class ItemTypePage {
    @Autowired
    private ItemTypeService service;
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemType>> getAllRooms() {
        List<ItemType> itemList = service.getAllTypes();
        return new ResponseEntity<List<ItemType>>(itemList, HttpStatus.OK);
    }
    @RequestMapping(value = "/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createItemType(@RequestParam ItemType itemType) {
        boolean status=false;

        status = service.createItemType(itemType);// .createRoom(roomNumber, roomType, roomView, roomPrice);
        if(status)
            return new ResponseEntity<>(status, HttpStatus.OK);
        return null;
    }
    @RequestMapping(value = "/update", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateItemType(@RequestParam ItemType itemType) {
        boolean status = false;

        status = service.updateItemType(itemType);
        if(status)
            return new ResponseEntity<Boolean>(status, HttpStatus.OK);
        return  null;
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteItemType(@RequestParam ItemType itemType)
    {
        boolean status = false;

        status = service.deleteItemType(itemType);
        if(status)
            return new ResponseEntity<Boolean>(status, HttpStatus.OK);
        return null;
    }
}
