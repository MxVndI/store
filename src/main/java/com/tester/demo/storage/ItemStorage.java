package com.tester.demo.storage;

import com.tester.demo.model.Item;
import com.tester.demo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class ItemStorage {
    private final ItemRepository itemRepository;

    public Item getItemById(Integer itemId) {
        return itemRepository.findById(itemId).get();
    }

    public Item addItem(Item item) {
        itemRepository.save(item);
        return item;
    }

    public Collection<Item> getItems() {
        return itemRepository.findAll();
    }

    public void deleteItemById(Integer itemId) {
        itemRepository.deleteById(itemId);
    }
}
