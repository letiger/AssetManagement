package za.ac.cput.assets.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.assets.App;
import za.ac.cput.assets.conf.factory.ItemFactory;
import za.ac.cput.assets.conf.factory.ItemTypeFactory;
import za.ac.cput.assets.domain.Item;
import za.ac.cput.assets.domain.ItemType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/08.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class ItemTypeTest extends AbstractTestNGSpringContextTests{
    private Long id;
    @Autowired
    private ItemTypeRepository repository;
    private ItemType itemType;
    private String code = "I1";
    private String item = "Hardware";
    @Test
    public void create()throws Exception{
        String barcode = "600100701243";
        String name = "Monitor";
        String expireDate = "YYYY/MM/DD";
        //We don't worry about our neighbours neighbour
            //List<ItemDetail> itemDetailList;
        List<Item> itemList = new ArrayList<>();

        Item monitor = ItemFactory
                .createItem("barcode",name,expireDate,null/*itemDetailList*/);
        itemList.add(monitor);
        itemType = ItemTypeFactory
                .createItemType( code, "Hardware", null);
        repository.save(itemType);
        id=itemType.getId();
        //@Letiger:Negative Test
            Assert.assertNotNull(id);
        //@Letiger:Positive Test
            Assert.assertNotNull(itemType);

    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        ItemType read = repository.findOne(id);
        //@Letiger:Negative Test
            Assert.assertNotNull(read);
        //@Letiger:Positive Test
            Assert.assertEquals( "Hardware", read.getName());

    }
    @Test(dependsOnMethods = "read")
    public void update()throws Exception{
        ItemType read = repository.findOne(id);
        ItemType updated = new ItemType
                .Builder("I2")
                .copy(read)
                .id(read.getId())
                .name(item)
                .build();
        repository.save(updated);

        ItemType newType = repository.findOne(id);
        //@Letiger:Negative Test
            Assert.assertNotNull(newType);
        //@Letiger:Positive Test
            Assert.assertEquals(item, newType.getName());
        //@Letiger:Equals Test
        Assert.assertEquals(id, itemType.getId(), "Item Type create test has passed 100%");
    }
    //@Test(dependsOnMethods = "update")
    public void delete() throws Exception{
        repository.delete(id);
        ItemType deleted = repository.findOne(id);
        //@Letiger:Negative Test
            Assert.assertNotNull(id);
        //@Letiger:Positive Test
            Assert.assertNull(deleted);
    }

}
