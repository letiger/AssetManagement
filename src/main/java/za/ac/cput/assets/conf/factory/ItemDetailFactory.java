package za.ac.cput.assets.conf.factory;

import za.ac.cput.assets.domain.ItemDetail;

/**
 * Created by student on 2015/07/28.
 */
public class ItemDetailFactory {
    public static ItemDetail createItemDetail(String dateCreated, String heading, String comment)
    {
        ItemDetail newObject = new ItemDetail
                .Builder(dateCreated)
                .heading(heading)
                .comments(comment)
                .build();
        return newObject;
    }
}
