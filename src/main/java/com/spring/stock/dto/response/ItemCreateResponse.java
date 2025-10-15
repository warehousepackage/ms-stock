package com.spring.stock.dto.response;

import jakarta.validation.constraints.NotBlank;

public class ItemCreateResponse {
    private String name;

    public ItemCreateResponse() {
    }

    public ItemCreateResponse(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
