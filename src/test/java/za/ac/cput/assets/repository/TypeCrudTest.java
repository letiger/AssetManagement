package za.ac.cput.assets.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.assets.App;
import za.ac.cput.assets.conf.factory.OwnerTypeFactory;
import za.ac.cput.assets.domain.OwnerType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/08/03.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TypeCrudTest extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    private OwnerTypeRepository repository;
    private OwnerType ot;
    private String txtCode = "T1";

    @Test
    public void create() throws Exception{
        Map<String,String> ownerTypeValues = new HashMap<String,String>();
        ownerTypeValues.put("code",txtCode);
        ownerTypeValues.put("name","N/A");
        ot = OwnerTypeFactory
                .createOwnerType(ownerTypeValues);
        Assert.assertEquals(txtCode, ot.getCode());
        repository.save(ot);
        id=ot.getId();
        Assert.assertNotNull(id);
        Assert.assertNotNull(ot.getId());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        OwnerType read = repository.findOne(id);
        Assert.assertEquals(txtCode, read.getCode());
        Assert.assertNotNull(read);

    }
    @Test(dependsOnMethods = "read")
    public void update() throws Exception{
        OwnerType read = repository.findOne(id);
        OwnerType updated = new OwnerType
                .Builder("T2")
                .copy(read)
                .id(read.getId())
                .name("Employee")
                .build();
        repository.save(updated);

        OwnerType updatedOwnerType = repository.findOne(id);

        Assert.assertEquals("Employee", updatedOwnerType.getName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception{
        OwnerType ot = repository.findOne(id);
        repository.delete(ot);
        OwnerType deleted = repository.findOne(id);
        Assert.assertNull(deleted);
    }
}
