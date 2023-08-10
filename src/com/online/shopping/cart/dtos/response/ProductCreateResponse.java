package com.online.shopping.cart.dtos.response;

import com.online.shopping.cart.enums.ProductStatus;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public
class ProductCreateResponse {
    private String id;
    private String name;
    private String Description;
    private ProductStatus status;
    private double price;
    private int stockQuantity;
}
