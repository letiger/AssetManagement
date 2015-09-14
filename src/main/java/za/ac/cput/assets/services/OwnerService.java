package za.ac.cput.assets.services;

import za.ac.cput.assets.domain.Owner;

import java.util.List;

/**
 * Created by student on 2015/09/14.
 */
public interface OwnerService {
    List<Owner> getAllTypes();
    Owner find(Long id);
    void createOwner(Owner owner);
    void deleteOwner(Long id);

}
