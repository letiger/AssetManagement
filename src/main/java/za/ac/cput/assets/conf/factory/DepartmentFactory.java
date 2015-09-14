package za.ac.cput.assets.conf.factory;

import za.ac.cput.assets.domain.Department;

import java.util.Map;

/**
 * Created by student on 2015/07/30.
 */
public class DepartmentFactory {
    public static Department createOwnerType(Map<String,String> values){
        Department department = new Department
                .Builder(values.get("code"))
                .name(values.get("name"))
                .build();
        return department;
    }
}
