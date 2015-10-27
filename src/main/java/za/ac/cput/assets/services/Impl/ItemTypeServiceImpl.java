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
    @Autowired
    public ItemType search(Long id){
        ItemType match;
        Iterable<ItemType> values = repository.findAll();
        for (ItemType value : values) {
            if(value.getId().equals(id)) {
                match = value;
                return match;
            }
        }
        return null;
    }
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
    public boolean createItemType( ItemType itemType) {
        boolean trigger = false;
        Iterable<ItemType> itemTypes = repository.findAll();
        for (ItemType current : itemTypes) {
            if(current.getName() == itemType.getName())
            {
                trigger =  true;
                break;
            }
        }
        if (trigger)
        {
            repository.save(itemType);
            return trigger;
        }

        //A duplicate record exist
        return trigger;
    }
    @Override
    public ItemType readItemType ( ItemType itemType) {

        ItemType search = repository.findOne(itemType.getId());
        if(search == null)
            return search;
        //Record not fount
        return null;
    }
    @Override
    public boolean updateItemType( ItemType itemType) {
        boolean trigger = false;
        Iterable<ItemType> itemTypes = repository.findAll();
        for (ItemType current : itemTypes) {
            if (current.getName().equalsIgnoreCase(itemType.getName()))
            {
                trigger = true;
                break;
            }
        }
        if (trigger){
            repository.save(itemType);
            return trigger;
        }
        //No record exist
        return trigger;
    }
    @Override
    public boolean deleteItemType( ItemType itemType) {
        boolean trigger = false;
        Iterable<ItemType> itemTypes = repository.findAll();
        for (ItemType current : itemTypes) {
            if ( current.getName().equalsIgnoreCase(itemType.getName()) )
            {
                trigger = true;
                break;
            }
        }
        if (trigger)
        {
            repository.delete(itemType);
        }
        return trigger;
    }
}
