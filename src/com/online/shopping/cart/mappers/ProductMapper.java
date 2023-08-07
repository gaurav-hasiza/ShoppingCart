package com.online.shopping.cart.mappers;

import com.online.shopping.cart.dtos.request.ProductCreateRequest;
import com.online.shopping.cart.dtos.request.ProductUpdateRequest;
import com.online.shopping.cart.dtos.response.ProductCreateResponse;
import com.online.shopping.cart.dtos.response.ProductUpdateResponseDTO;
import com.online.shopping.cart.entity.Product;

public
class ProductMapper {
    public static Product toProduct(ProductCreateRequest productCreateRequest){
        return Product.builder().price(productCreateRequest.getPrice())
                .name(productCreateRequest.getName())
                .status(productCreateRequest.getStatus())
                .stockQuantity(productCreateRequest.getStockQuantity())
                .Description(productCreateRequest.getDescription())
                .build();
    }

    public static ProductCreateResponse toProductCreateResponse(Product product){
        return ProductCreateResponse.builder().price(product.getPrice())
                .name(product.getName())
                .status(product.getStatus())
                .Description(product.getDescription())
                .stockQuantity(product.getStockQuantity())
                .id(product.getId())
                .build();


    }

    public static Product toProduct(ProductUpdateRequest productCreateRequest){
        return Product.builder().price(productCreateRequest.getPrice())
                .name(productCreateRequest.getName())
                .status(productCreateRequest.getStatus())
                .stockQuantity(productCreateRequest.getStockQuantity())
                .Description(productCreateRequest.getDescription())
                .build();
    }

    public static ProductUpdateResponseDTO toProductUpdateResponse(Product product){
        return ProductUpdateResponseDTO.builder().price(product.getPrice())
                .name(product.getName())
                .status(product.getStatus())
                .Description(product.getDescription())
                .stockQuantity(product.getStockQuantity())
                .id(product.getId())
                .build();
    }
}
