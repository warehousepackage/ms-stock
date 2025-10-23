package com.spring.stock.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ItemCreateRequest(String name, Integer quantity){}
