package com.online.shopping.cart.entity;

import lombok.Data;

@Data
public
class ProductVariation  extends BaseEntity{
    private String productId;
    private String sellerId;
    private double price;
    private int stockQuantity;
    public ProductVariation(String productId, String sellerId, String variationId , double price, int quantity) {
        this.productId = productId;
        this.setId(variationId);
        this.sellerId = sellerId;
        this.price = price;
        this.stockQuantity = quantity;
    }
}
