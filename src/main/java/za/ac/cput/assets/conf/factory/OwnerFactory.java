package za.ac.cput.assets.conf.factory;

import za.ac.cput.assets.domain.Owner;

import java.util.Map;

/**
 * Created by student on 2015/07/27.
 */
public class OwnerFactory {
    public static Owner createOwner( String pk, Map<String,String> values/*,List<Item> itemList, OwnerDetail detail*/)
    {
        Owner owner = new Owner
                .Builder(pk)
                .name(values.get("name"))
                .surname(values.get("surname"))
                .email(values.get("email"))
                .startDate(values.get("startDate"))
                .endDate(values.get("endDate"))
                //.itemList(itemList)
                //.detail(detail)
                .build();

        return owner;
    }
}
