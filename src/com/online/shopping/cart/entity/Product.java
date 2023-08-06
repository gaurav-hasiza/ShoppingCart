package com.online.shopping.cart.entity;


import com.online.shopping.cart.enums.ProductStatus;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public
class Product extends BaseEntity{
    private String name;
    private String Description;
//    private List<ProductVariation> productVariationList;
    private ProductStatus status;
}
