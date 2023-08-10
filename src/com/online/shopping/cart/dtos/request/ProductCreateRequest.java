package com.online.shopping.cart.dtos.request;


import com.online.shopping.cart.enums.ProductStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCreateRequest {
    private String name;
    private String Description;
    //    private List<ProductVariation> productVariationList;
    private ProductStatus status;
    //    private String sellerId;
    private double price;
    private int stockQuantity;
}
