package com.online.shopping.cart.services;

import com.online.shopping.cart.dtos.request.ProductCreateRequest;
import com.online.shopping.cart.dtos.request.ProductUpdateRequest;
import com.online.shopping.cart.dtos.response.ProductCreateResponse;
import com.online.shopping.cart.dtos.response.ProductListResponseDTO;
import com.online.shopping.cart.dtos.response.ProductUpdateResponseDTO;
import com.online.shopping.cart.entity.Product;
import com.online.shopping.cart.mappers.ProductMapper;
import com.online.shopping.cart.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class ProductService {
    private final ProductRepo productRepo;
    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    /**
     * Add the product after validating the session, only admins can do it.
     * @param productCreateRequest
     * @return ProductCreateResponse
     */
    public ProductCreateResponse add(ProductCreateRequest productCreateRequest) {
        Product product = ProductMapper.toProduct(productCreateRequest);
        product = productRepo.addProduct(product);
        return ProductMapper.toProductCreateResponse(product);
    }

    /**
     * update the item details
     * @param productRequest
     * @return
     */
    public ProductUpdateResponseDTO update(ProductUpdateRequest productRequest) {
        if (productRequest.getId() == null) {
            throw new IllegalArgumentException(com.online.shopping.cart.errors.Product.ID_NOT_PRESENT);
        }
        Product product = ProductMapper.toProduct(productRequest);
        Product updatedProduct = productRepo.update(product);
        ProductUpdateResponseDTO productUpdateResponseDTO = ProductMapper.toProductUpdateResponse(updatedProduct);
        return productUpdateResponseDTO;
    }

    /**
     * get the available items to user
     * @return
     */
    public ProductListResponseDTO listProduct() {
        List<Product> products = productRepo.getAllAvailableProducts();

        return ProductListResponseDTO.builder()
                .productList(products)
                .build();
    }
}
