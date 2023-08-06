package com.online.shopping.cart.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
@AllArgsConstructor
public class CartItem {
    private String productVariationId;
    private int quantity;
    // ... other relevant attributes and methods

    // Constructor
//    public CartItem(String productIdVariationId, ) {
//        this.quantity = quantity;
//    }
}
