package za.ac.cput.assets.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.assets.domain.Item;
import za.ac.cput.assets.domain.ItemType;
import za.ac.cput.assets.domain.Owner;
import za.ac.cput.assets.repository.ItemRepository;
import za.ac.cput.assets.repository.ItemTypeRepository;
import za.ac.cput.assets.repository.OwnerRepository;
import za.ac.cput.assets.services.ItemService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/14.
 */
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemTypeRepository itemTypeRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public List<Item> getAllTypes() {
        List<Item> items = new ArrayList<>();

        Iterable<Item> values = itemRepository.findAll();
        for(Item value: values){
            items.add(value);
        }
        return items;
    }

    @Override
    public Item find(Long id) {
        Item search = itemRepository.findOne(id);
        return search;
    }

    @Override
    public void createItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<ItemType> displayAllItemTypes() {
        List<ItemType> itemTypes = new ArrayList<>();

        Iterable<ItemType> values = itemTypeRepository.findAll();
        for (ItemType value: values){
            itemTypes.add(value);
        }
        return itemTypes;
    }

    @Override
    public ItemType findType(Long id) {
        return itemTypeRepository.findOne(id);
    }

    @Override
    public List<Owner> displayAllOwners() {
        List<Owner> owners = new ArrayList<>();

        Iterable<Owner> values = ownerRepository.findAll();
        for (Owner value: values){
            owners.add(value);
        }
        return owners;
    }

    @Override
    public Owner findOwner(Long id) {
        Owner search = ownerRepository.findOne(id);
        return search;
    }

    @Override
    public void deleteItem(Long id) {
        ownerRepository.delete(id);
    }
}
