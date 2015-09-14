package za.ac.cput.assets.conf.factory;

import za.ac.cput.assets.domain.OwnerType;

import java.util.Map;

/**
 * Created by student on 2015/07/30.
 */
public class OwnerTypeFactory {
    public static OwnerType createOwnerType(Map<String,String> values){
        OwnerType ownerType = new OwnerType
                .Builder(values.get("code"))
                .name(values.get("name"))
                .build();
        return ownerType;
    }
}
