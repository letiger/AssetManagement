package za.ac.cput.assets.conf.factory;

import za.ac.cput.assets.domain.OwnerDetail;

/**
 * Created by student on 2015/07/29.
 */
public class OwnerDetailFactory {
    public static OwnerDetail createDetail(String department, String region, String typeOwner){
        OwnerDetail detail = new OwnerDetail
                .Builder(department)
                .region(region)
                .userType(typeOwner)
                .build();
        return detail;
    }
}
