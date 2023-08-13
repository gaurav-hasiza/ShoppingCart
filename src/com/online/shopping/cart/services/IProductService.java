package com.online.shopping.cart.services;

import com.online.shopping.cart.dtos.request.ProductCreateRequest;
import com.online.shopping.cart.dtos.request.ProductUpdateRequest;
import com.online.shopping.cart.dtos.response.ProductCreateResponse;
import com.online.shopping.cart.dtos.response.ProductListResponseDTO;
import com.online.shopping.cart.dtos.response.ProductUpdateResponseDTO;

public interface IProductService {
    public ProductCreateResponse add(ProductCreateRequest productCreateRequest);
    public ProductUpdateResponseDTO update(ProductUpdateRequest productRequest);
    public ProductListResponseDTO listProduct();
}
