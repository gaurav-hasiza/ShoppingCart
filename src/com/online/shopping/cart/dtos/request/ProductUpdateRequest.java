package com.online.shopping.cart.dtos.request;

import com.online.shopping.cart.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductUpdateRequest {
    private String id;
    private String name;
    private String Description;
    //    private List<ProductVariation> productVariationList;
    private ProductStatus status;
    //    private String sellerId;
    private double price;
    private int stockQuantity;
}
