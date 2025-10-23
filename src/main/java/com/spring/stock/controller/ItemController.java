package com.spring.stock.controller;

import com.spring.stock.dto.request.ItemCreateRequest;
import com.spring.stock.dto.request.ItemModifyQuantityRequest;
import com.spring.stock.dto.response.ItemResponse;
import com.spring.stock.entity.Item;
import com.spring.stock.mapper.ItemMapper;
import com.spring.stock.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/register")
    public ResponseEntity<ItemResponse> createItem(@RequestBody ItemCreateRequest request){
        Item item = itemService.createItem(ItemMapper.ItemResquestToItem(request));
        ItemResponse itemCreateResponse = ItemMapper.ItemToItemResponse(item);
        return ResponseEntity.status(201).body(itemCreateResponse);
    }


    @PostMapping("/{id}/quantity")
    public ResponseEntity<Item> increaseItem(@PathVariable UUID id, @RequestBody ItemModifyQuantityRequest request){
        Item item = itemService.increaseQuantity(id, request.quantity(), request.operation());
        return ResponseEntity.ok().body(item);
    }


}
