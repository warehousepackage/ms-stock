package com.spring.stock.mapper;

import com.spring.stock.dto.request.ItemCreateRequest;
import com.spring.stock.dto.response.ItemResponse;
import com.spring.stock.entity.Item;

public class ItemMapper {

    public static Item ItemResquestToItem(ItemCreateRequest itemCreateRequest){
        return new Item(itemCreateRequest.name(), itemCreateRequest.quantity());
    }

    public static ItemResponse ItemToItemResponse(Item item){
        return new ItemResponse(item.getName(), item.getQuantity());
    }


}
