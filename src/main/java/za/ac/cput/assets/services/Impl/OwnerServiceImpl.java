package za.ac.cput.assets.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.assets.domain.Owner;
import za.ac.cput.assets.repository.OwnerRepository;
import za.ac.cput.assets.services.OwnerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/14.
 */
@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    OwnerRepository repository;

    @Override
    public List<Owner> getAllTypes() {
        List<Owner> owners = new ArrayList<>();

        Iterable<Owner> values = repository.findAll();
        for (Owner value: values){
            owners.add(value);
        }
        return owners;
    }

    @Override
    public Owner find(Long id) {
        Owner search = repository.findOne(id);
        return search;
    }

    @Override
    public void createOwner(Owner owner) {
        repository.save(owner);
    }

    @Override
    public void deleteOwner(Long id) {
        repository.delete(id);
    }
}
