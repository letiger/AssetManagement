package za.ac.cput.assets.conf.factory;

import za.ac.cput.assets.domain.OwnerRegion;

import java.util.Map;

/**
 * Created by student on 2015/07/30.
 */
public class RegionFactory {
    public static OwnerRegion createRegion(Map<String,String> values){
        OwnerRegion region = new OwnerRegion
                .Builder(values.get("code"))
                .name(values.get("name"))
                .build();
        return region;
    }
}
