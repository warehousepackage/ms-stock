package com.spring.stock.dto.request;

import jakarta.validation.constraints.NotBlank;

public class ItemCreateRequest {
    @NotBlank(message = "name can´t be empty")
    public String name;

    public ItemCreateRequest(String name) {
        this.name = name;
    }

    public ItemCreateRequest() {
    }

    public String getName() {
        return name;
    }
}
