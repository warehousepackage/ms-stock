package com.spring.stock.mapper;

import com.spring.stock.dto.request.ItemCreateRequest;
import com.spring.stock.dto.response.ItemCreateResponse;
import com.spring.stock.entity.Item;

public class ItemMapper {

    public static Item ItemResquestToItem(ItemCreateRequest itemCreateRequest){
        Item item = new Item();
        item.setName(itemCreateRequest.getName());
        return item;
    }

    public static ItemCreateResponse ItemToItemResponse(Item item){
        ItemCreateResponse itemCreateResponse = new ItemCreateResponse();
        itemCreateResponse.setName(item.getName());
        return itemCreateResponse;
    }


}
