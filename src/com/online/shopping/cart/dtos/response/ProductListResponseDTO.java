package com.online.shopping.cart.dtos.response;

import com.online.shopping.cart.entity.Product;
import lombok.Builder;

import java.util.List;

@Builder
public class ProductListResponseDTO {
    List<Product> productList;
}
