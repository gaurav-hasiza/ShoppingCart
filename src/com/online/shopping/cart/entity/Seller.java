package com.online.shopping.cart.entity;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public
class Seller extends BaseEntity{
    private String sellerName;

    public Seller(String sellerId, String sellerName) {
        this.setId(sellerId);
        this.sellerName = sellerName;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }
}
