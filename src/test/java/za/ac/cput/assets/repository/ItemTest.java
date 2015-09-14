package za.ac.cput.assets.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.assets.App;
import za.ac.cput.assets.domain.Item;
import za.ac.cput.assets.domain.ItemDetail;

/**
 * Created by student on 2015/08/08.
 */
@SpringApplicationConfiguration(classes=App.class)
@WebAppConfiguration
public class ItemTest extends AbstractTestNGSpringContextTests{
    private Long id;
    @Autowired
    private ItemRepository repository;
    private Item item;
    private ItemDetail detail;

}
