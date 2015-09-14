package za.ac.cput.assets.conf.factory;

import za.ac.cput.assets.domain.Item;
import za.ac.cput.assets.domain.ItemType;

import java.util.List;

/**
 * Created by student on 2015/08/08.
 */
public class ItemTypeFactory {
    public static ItemType createItemType(String code, String name, List<Item> itemList) {
        ItemType itemType = new ItemType
                .Builder(code)
                .name(name)
                .itemList(itemList)
                .build();
        return itemType;
    }
}
