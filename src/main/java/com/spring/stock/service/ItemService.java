package com.spring.stock.service;

import com.spring.stock.entity.Item;
import com.spring.stock.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(Item item){

        if(item.getName() == null || item.getName().isBlank()){
            throw new IllegalArgumentException("Name item cannot be empty");
        }
        if(item.getName().length() > 45){
            throw new IllegalArgumentException("The item name must be no longer than 45 characters.");
        }
        if(item.getQuantity() <= 0){
            throw new IllegalArgumentException("The quantity field must contain some value");
        }

        return itemRepository.save(item);
    }

    public Item increaseQuantity(UUID id, Integer quantity, String operation){
            Item item = itemRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("This item does not exist"));

            if(operation.equals("INCREASE")){
                item.setQuantity(item.getQuantity() + quantity);
                return itemRepository.save(item);
            }

            if(operation.equals("DECREASE")){
                int quantityFinal = item.getQuantity() - quantity;

                if(quantityFinal < 0){
                    item.setQuantity(0);
                    return itemRepository.save(item);
                }

                item.setQuantity(quantityFinal);
                return itemRepository.save(item);
            }
            throw new IllegalArgumentException("The operation is not valid");
    }
}
