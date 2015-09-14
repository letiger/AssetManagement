package za.ac.cput.assets.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.assets.domain.Owner;

/**
 * Created by student on 2015/07/27.
 */
public interface OwnerRepository extends CrudRepository<Owner, Long>{
    //public Owner FindByCode(String code);
}
