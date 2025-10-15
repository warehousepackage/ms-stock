package com.spring.stock.service;

import com.spring.stock.entity.Item;
import com.spring.stock.exception.ItemNameExceedsException;
import com.spring.stock.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Item createItem(Item item){
        if(item.getName().length() <= 45){
            return itemRepository.save(item);
        }
        throw new ItemNameExceedsException();
    }
}
