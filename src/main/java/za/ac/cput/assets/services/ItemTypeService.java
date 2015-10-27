package za.ac.cput.assets.services;

import za.ac.cput.assets.domain.ItemType;

import java.util.List;

/**
 * Created by student on 2015/08/09.
 */
public interface ItemTypeService {
    List<ItemType> getAllTypes();
    boolean  createItemType ( ItemType itemType);
    ItemType readItemType   ( ItemType itemType);
    boolean  updateItemType ( ItemType itemType);
    boolean  deleteItemType ( ItemType itemType);


}
