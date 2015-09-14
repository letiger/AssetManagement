package za.ac.cput.assets.services;

import za.ac.cput.assets.domain.Item;
import za.ac.cput.assets.domain.ItemType;
import za.ac.cput.assets.domain.Owner;

import java.util.List;

/**
 * Created by student on 2015/09/14.
 */
public interface ItemService {
    List<Item> getAllTypes();
    Item find(Long id);

    void createItem(Item item);
        List<ItemType> displayAllItemTypes();
            ItemType findType(Long id);
        List<Owner> displayAllOwners();
            Owner findOwner(Long id);
    //void createItem(Item item) is finished
    void deleteItem(Long id);

}
