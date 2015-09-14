package za.ac.cput.assets.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.assets.domain.ItemType;

/**
 * Created by student on 2015/08/08.
 */
public interface ItemTypeRepository extends CrudRepository<ItemType, Long> {
}
