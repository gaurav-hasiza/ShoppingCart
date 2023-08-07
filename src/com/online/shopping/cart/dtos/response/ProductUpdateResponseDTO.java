package com.online.shopping.cart.dtos.response;

import com.online.shopping.cart.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductUpdateResponseDTO {
    private String id;
    private String name;
    private String Description;
    private ProductStatus status;
    private double price;
    private int stockQuantity;
}
