package com.online.shopping.cart.dtos.response;

import com.online.shopping.cart.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ProductListResponseDTO {
    List<Product> productList;
}
