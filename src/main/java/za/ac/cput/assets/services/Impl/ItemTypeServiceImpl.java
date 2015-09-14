package za.ac.cput.assets.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.assets.domain.ItemType;
import za.ac.cput.assets.repository.ItemTypeRepository;
import za.ac.cput.assets.services.ItemTypeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/09.
 */
@Service
public class ItemTypeServiceImpl implements ItemTypeService{
    @Autowired
    ItemTypeRepository repository;
    @Override
    public List<ItemType> getAllTypes(){
        List<ItemType> itemTypes = new ArrayList<>();

        Iterable<ItemType> values = repository.findAll();
        for (ItemType value : values) {
            itemTypes.add(value);
        }
        return itemTypes;
    }

    @Override
    public void createItemType(ItemType itemType) {
        repository.save(itemType);
    }

    @Override
    public ItemType find(Long id) {
        ItemType search = repository.findOne(id);
        return search;
    }
    @Override
    public void deleteItemType(Long id){
        repository.delete(id);
    }
}
