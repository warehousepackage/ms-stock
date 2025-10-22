package com.spring.stock.controller;

import com.spring.stock.dto.request.ItemCreateRequest;
import com.spring.stock.dto.response.ItemCreateResponse;
import com.spring.stock.entity.Item;
import com.spring.stock.mapper.ItemMapper;
import com.spring.stock.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/register")
    public ResponseEntity<ItemCreateResponse> createItem(@RequestBody ItemCreateRequest request){
        Item item = itemService.createItem(ItemMapper.ItemResquestToItem(request));
        ItemCreateResponse itemCreateResponse = ItemMapper.ItemToItemResponse(item);
        return ResponseEntity.status(201).body(itemCreateResponse);
    }
}
