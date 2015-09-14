package za.ac.cput.assets.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.assets.domain.Item;

/**
 * Created by student on 2015/07/28.
 */
public interface ItemRepository extends CrudRepository<Item, Long>{
}
