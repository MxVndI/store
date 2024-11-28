package com.tester.demo.service;

import com.tester.demo.model.Category;
import com.tester.demo.model.Item;
import com.tester.demo.storage.ItemStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemStorage itemStorage;

    public Item getItemById(Integer id) {
        return itemStorage.getItemById(id);
    }

    public Item addItem(Item item) {
        return itemStorage.addItem(item);
    }

    public Collection<Item> getItems() {
        return itemStorage.getItems();
    }
}
