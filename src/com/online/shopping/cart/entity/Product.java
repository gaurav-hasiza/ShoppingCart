package com.online.shopping.cart.entity;


import com.online.shopping.cart.enums.ProductStatus;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@Builder
public
class Product extends BaseEntity{
    private String name;
    private String Description;
//    private List<ProductVariation> productVariationList;
    private ProductStatus status;
//    private String sellerId;
    private double price;
    private int stockQuantity;
}
