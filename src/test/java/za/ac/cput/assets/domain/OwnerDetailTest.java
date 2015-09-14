package za.ac.cput.assets.domain;

import org.junit.Test;
import org.testng.Assert;
import za.ac.cput.assets.conf.factory.DepartmentFactory;
import za.ac.cput.assets.conf.factory.OwnerDetailFactory;
import za.ac.cput.assets.conf.factory.OwnerTypeFactory;
import za.ac.cput.assets.conf.factory.RegionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/07/31.
 */
public class OwnerDetailTest {
    private OwnerDetail detail;
    private OwnerRegion reg;
    private Department dept;
    private OwnerType ot;

    @Test
    public void create() throws Exception{
        //OwnerType
        Map<String,String> ownerTypeValues = new HashMap<String,String>();
        ownerTypeValues.put("code","T1");
        ownerTypeValues.put("name","N/A");
        ot = OwnerTypeFactory
                .createOwnerType(ownerTypeValues);
        Assert.assertEquals("T1", ot.getCode()); //createTest
        //OwnerType

        //department
        Map<String,String> departmentValues = new HashMap<String,String>();
        departmentValues.put("code","D1");
        departmentValues.put("name","N/A");
        dept = DepartmentFactory
                .createOwnerType(departmentValues);
        Assert.assertEquals("D1", dept.getCode());//createTest
        //department

        //region
        Map<String,String> regionValues = new HashMap<String,String>();
        regionValues.put("code","R1");
        regionValues.put("name","N/A");
        reg = RegionFactory
                .createRegion(regionValues);
        Assert.assertEquals("R1", reg.getCode());//createTest
        //region

        //Detail
        detail = OwnerDetailFactory
                .createDetail( ot.getName(), dept.getName(), reg.getName());
        Assert.assertEquals(detail.getDepartment(), dept.getName());
        Assert.assertEquals(detail.getRegion(), reg.getName());
        Assert.assertEquals(detail.getUserType(), ot.getName());
        //Detail
    }

    @Test
    public void update() throws Exception{
        //OwnerType
        Map<String,String> ownerTypeValues = new HashMap<String,String>();
        ownerTypeValues.put("code","T1");
        ownerTypeValues.put("name","N/A");
        ot = OwnerTypeFactory
                .createOwnerType(ownerTypeValues);
        Assert.assertEquals("T1", ot.getCode()); //createTest
        OwnerType employee = new OwnerType
                .Builder("T2")
                .copy(ot)
                .name("Employee")
                .build();
        Assert.assertEquals("Employee", employee.getName()); //updateTest
        //OwnerType

        //department
        Map<String,String> departmentValues = new HashMap<String,String>();
        departmentValues.put("code","D1");
        departmentValues.put("name","N/A");
        dept = DepartmentFactory
                .createOwnerType(departmentValues);
        Assert.assertEquals("D1", dept.getCode());//createTest

        Department hr = new Department
                .Builder("D1")
                .copy(dept)
                .name("Human Resource")
                .build();
        Assert.assertEquals("Human Resource", hr.getName());//updateTest
        //department

        //region
        Map<String,String> regionValues = new HashMap<String,String>();
        regionValues.put("code","R1");
        regionValues.put("name","N/A");
        reg = RegionFactory
                .createRegion(regionValues);

        OwnerRegion ct = new OwnerRegion
                .Builder("R2")
                .copy(reg)
                .name("Cape Town")
                .build();
        Assert.assertEquals("Cape Town", ct.getName());//updateTest
        //region

        //Detail
        OwnerDetail detailUpdate = OwnerDetailFactory
                .createDetail(hr.getName(), ct.getName(),employee.getName());
        Assert.assertEquals(detailUpdate.getDepartment(), hr.getName());
        Assert.assertEquals(detailUpdate.getRegion(), ct.getName());
        Assert.assertEquals(detailUpdate.getUserType(), employee.getName());
        //Detail
    }

}
