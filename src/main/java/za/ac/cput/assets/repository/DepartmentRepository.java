package za.ac.cput.assets.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.assets.domain.Department;

/**
 * Created by student on 2015/08/03.
 */
public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
