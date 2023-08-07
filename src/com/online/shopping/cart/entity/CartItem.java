package com.online.shopping.cart.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CartItem {
    private String productVariationId;
    private int quantity;
}
