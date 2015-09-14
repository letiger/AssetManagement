package za.ac.cput.assets.repository;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.assets.App;
import za.ac.cput.assets.conf.factory.RegionFactory;
import za.ac.cput.assets.domain.OwnerRegion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/08/08.
 */
@SpringApplicationConfiguration(classes=App.class)
@WebAppConfiguration
public class RegionTest extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    private RegionRepository repository;
    private OwnerRegion reg;
    private String txtCode = "R1";

    @Test
    public void create() throws Exception{
        Map<String,String> ownerTypeValues = new HashMap<String,String>();
        ownerTypeValues.put("code",txtCode);
        ownerTypeValues.put("name","N/A");
        reg = RegionFactory
                .createRegion(ownerTypeValues);

        //Test object in memory
        Assert.assertEquals(txtCode, reg.getCode());
        repository.save(reg);
        id = reg.getId();
        Assert.assertNotNull(id);
        Assert.assertNotNull(reg);
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        OwnerRegion read = repository.findOne(id);
        Assert.assertEquals(txtCode, read.getCode());
        Assert.assertNotNull(read);
    }
    @Test(dependsOnMethods = "read")
    public void update() throws Exception{
        OwnerRegion read = repository.findOne(id);
        OwnerRegion updated = new OwnerRegion
                .Builder("R2")
                .copy(read)
                .id(read.getId())
                .name("UK")
                .build();
        repository.save(updated);
        OwnerRegion newRegion = repository.findOne(id);
        Assert.assertEquals("UK", newRegion.getName());
    }
    @Test(dependsOnMethods = "update")
    public void delete()throws Exception{
        //Region update = repository.findOne(id);
        repository.delete(id);
        OwnerRegion delete = repository.findOne(id);
        Assert.assertNull(delete);
    }

}
