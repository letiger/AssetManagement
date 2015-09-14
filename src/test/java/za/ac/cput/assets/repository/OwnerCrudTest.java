package za.ac.cput.assets.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.assets.App;
import za.ac.cput.assets.conf.factory.ItemFactory;
import za.ac.cput.assets.conf.factory.OwnerDetailFactory;
import za.ac.cput.assets.conf.factory.OwnerFactory;
import za.ac.cput.assets.domain.Item;
import za.ac.cput.assets.domain.ItemDetail;
import za.ac.cput.assets.domain.Owner;
import za.ac.cput.assets.domain.OwnerDetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/08/06.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class OwnerCrudTest extends AbstractTestNGSpringContextTests{
    private Long id;
    @Autowired
    private OwnerRepository repository;
    private OwnerDetail ownerDetail;
    private Item hdd;
    private Item monitor;
    private List<Item> itemList;

    //WE DON'T WORRY ABOUT OUR NEIGHBOURS NEIGHBOUR
        //private List<ItemDetail> hddList;
        //private List<ItemDetail> monitorList;
    //WE DON'T WORRY ABOUT OUR NEIGHBOURS NEIGHBOUR

    private Map<String,String> ownerDetails;
    private Map<String,String> ownerValues;

    @BeforeMethod
    public void setUp() throws Exception {
        //Owner
        ownerValues = new HashMap<>();
        ownerValues.put("name","Travis");
        ownerValues.put("surname","Wades");
        ownerValues.put("email","travis@groveis.com");
        ownerValues.put("startDate","2010/05/01");
        ownerValues.put("endDate","2015/07/01");
        //Owner

    }

    @Test
    public void create() throws Exception{
        /*//WE DON'T WORRY ABOUT OUR NEIGHBOURS NEIGHBOUR
            //hddDetail
            ItemDetail hddDetail1 = ItemDetailFactory
                    .createItemDetail("2015/08/07", "Make", "Seagate");
            ItemDetail hddDetail2 = ItemDetailFactory
                    .createItemDetail("2015/08/07", "Description", "2.5\" 2TB hard drive");

            hddList = new ArrayList<>();
            hddList.add(hddDetail1);
            hddList.add(hddDetail2);
            //hddDetail


            //monitorDetail
            ItemDetail monitorDetail1 = ItemDetailFactory
                    .createItemDetail("2015/08/07", "Make", "Samsung 29 LED Monitor");
            ItemDetail monitorDetail2 = ItemDetailFactory
                    .createItemDetail("2015/0/8/07", "Type", "LED Monitor");
            ItemDetail monitorDetail3 = ItemDetailFactory
                    .createItemDetail("2015/0/8/07", "Ports", "HDMI, DVI, VGA");

            monitorList = new ArrayList<>();
            monitorList.add(monitorDetail1);
            monitorList.add(monitorDetail2);
            monitorList.add(monitorDetail3);
            //monitorDetail
        //WE DON'T WORRY ABOUT OUR NEIGHBOURS NEIGHBOUR*/

        //Items
        itemList = new ArrayList<>();

        List<ItemDetail> hddList = new ArrayList<>();
        hdd = ItemFactory
                .createItem("6001011", "HDD", "2015/07/28", null);
                //WE DON'T WORRY ABOUT OUR NEIGHBOURS NEIGHBOUR
                    //.createItem("6001011", "HDD", "2015/07/28", hddList);
        List<ItemDetail> monitorList = new ArrayList<>();
        monitor = ItemFactory
                .createItem("6001012", "Monitor", "2016/07/01", null);
                //WE DON'T WORRY ABOUT OUR NEIGHBOURS NEIGHBOUR
                   // .createItem("6001012", "Monitor", "2016/07/01", monitorList);

        //WE DON'T WORRY ABOUT OUR NEIGHBOURS NEIGHBOUR
            //itemList.add(hdd);
            //itemList.add(monitor);
            //Items

        ownerDetail = OwnerDetailFactory
                .createDetail("Development", "Cape Town", "Project Management");

        Owner owner = OwnerFactory
                .createOwner( "U001", ownerValues/*, itemList, ownerDetail*/);
                //.createOwner( "U001", ownerValues);
        repository.save(owner);
        id=owner.getId();
        //How to use assertNotNull
            Assert.assertNotNull(owner);
        //How to use assertEquals
            Assert.assertEquals(id, owner.getId());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        Owner read = repository.findOne(id);
        //Assert.assertEquals("Development", read.getDetail().getDepartment());
        Assert.assertEquals(id, read.getId());
        Assert.assertNotNull(read);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception{
        Owner read = repository.findOne(id);
        Owner updated = new Owner
                .Builder("U002")
                .copy(read)
                .id(read.getId())
                .surname("Wade")
                .build();
        repository.save(updated);
        //id = updated.getId();
        Owner updatedOwner = repository.findOne(id);

        Assert.assertEquals("Wade", updatedOwner.getSurname());
    }

    //@Test(dependsOnMethods = "update")
    public void delete() throws Exception{
        Owner owner = repository.findOne(id);
        repository.delete(this.id);
        Owner deleted = repository.findOne(id);

        //How to use assertNull
            Assert.assertNull(deleted);
        //Assert.assertEquals(id, deleted.getId());
    }
    @AfterMethod
    public void tearDown() throws Exception {
        //repository.deleteAll();
    }
}
