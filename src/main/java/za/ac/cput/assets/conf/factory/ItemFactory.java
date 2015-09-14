package za.ac.cput.assets.conf.factory;

import za.ac.cput.assets.domain.ItemDetail;
import za.ac.cput.assets.domain.Item;

import java.util.List;

/**
 * Created by student on 2015/07/28.
 */
public class ItemFactory {
    public static Item createItem( String barcode, String name, String expireDate, List<ItemDetail> itemDetailList)
    {
        Item item = new Item
                .Builder(barcode)
                .name(name)
                .expireDate(expireDate)
                .detailList(itemDetailList)
                .build();
        return item;
    }
}
