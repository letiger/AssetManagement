package za.ac.cput.assets.domain;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
import za.ac.cput.assets.conf.factory.ItemFactory;
import za.ac.cput.assets.conf.factory.OwnerDetailFactory;
import za.ac.cput.assets.conf.factory.OwnerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/07/28.
 */
public class OwnerTest {
    private Item hdd;
    private Item monitor;
    private List<Item> itemList;
    private String userCode1;
    private String userCode2;
    private OwnerDetail detail;

    @Before
    public void setUp() throws Exception {
        //Detail
        detail = OwnerDetailFactory
                .createDetail( "Development", "Cape Town", "Project Management");
        //Detail

        //Items
        itemList = new ArrayList<Item>();
        hdd = ItemFactory
                .createItem( "6001011", "HDD", "2015/07/28", null);
        monitor = ItemFactory
                .createItem("6001012", "Monitor", "2016/07/01", null);

        itemList.add(hdd);
        itemList.add(monitor);
        //Items

        userCode1 = "U001";
        userCode2 = "U002";
    }

    @Test
    public void testOwner() throws Exception{
        Map<String,String> ownerValues = new HashMap<String,String>();
        ownerValues.put("name","Travis");
        ownerValues.put("surname","Wade");
        ownerValues.put("email","travis@groveis.com");
        ownerValues.put("startDate","2010/05/01");
        ownerValues.put("endDate","2015/07/01");
        Owner owner = OwnerFactory
                //.createOwner( userCode1, ownerValues, itemList, detail);
                .createOwner( userCode1, ownerValues);

        //createTest()
        Assert.assertEquals(userCode1, owner.getPk());
        Assert.assertEquals("Travis", owner.getName());
        Assert.assertTrue(owner.getItemList().size() == 2);
        Assert.assertEquals("Development",owner.getDetail().getDepartment());

        Owner ownerCopy = new Owner
                .Builder(userCode2)
                .copy(owner)
                .name("Ray")
                .surname("Musvibe")
                .build();

        //updateTest()
        Assert.assertEquals(userCode1, ownerCopy.getPk());
        Assert.assertTrue(ownerCopy.getItemList().size() == 2);
        Assert.assertEquals("Ray",ownerCopy.getName());
        Assert.assertEquals("Musvibe",ownerCopy.getSurname());
        Assert.assertEquals( "Development", ownerCopy.getDetail().getDepartment() );
    }
}
