package za.ac.cput.assets.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.assets.App;
import za.ac.cput.assets.conf.factory.DepartmentFactory;
import za.ac.cput.assets.domain.Department;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/08/08.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class DepartmentTest extends AbstractTestNGSpringContextTests{
    private Long id;
    @Autowired
    DepartmentRepository repository;
    private Department deparment;
    private String code  = "D1";

    @Test
    public void create() throws Exception{
        Map<String,String> departmentValues = new HashMap<String,String>();
        departmentValues.put("code",code);
        departmentValues.put("name","N/A");
        deparment = DepartmentFactory
                .createOwnerType(departmentValues);
        //Test object in Memory
        Assert.assertEquals(code, deparment.getCode());
        repository.save(deparment);
        id = deparment.getId();
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        Department read = repository.findOne(id);
        Assert.assertEquals(code, read.getCode());
        Assert.assertNotNull(read);
    }
    @Test(dependsOnMethods = "read")
    public void update() throws Exception{
        Department read = repository.findOne(id);
        Department updated = new Department
                .Builder("D2")
                .copy(read)
                .id(read.getId())
                .name("Sales")
                .build();
        repository.save(updated);

        Department newDepartment = repository.findOne(id);
        Assert.assertEquals("Sales", newDepartment.getName());
    }
    @Test(dependsOnMethods = "update")
    public void delete () throws Exception{
        repository.delete(id);
        Department deleted = repository.findOne(id);
        Assert.assertNull(deleted);
    }

}
