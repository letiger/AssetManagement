package za.ac.cput.assets.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.assets.domain.OwnerRegion;

/**
 * Created by student on 2015/08/03.
 */
public interface RegionRepository extends CrudRepository<OwnerRegion,Long> {
}
