package com.online.shopping.cart.services;

import com.online.shopping.cart.entity.ProductVariation;
import com.online.shopping.cart.repositories.ProductVariationRepo;

import java.util.List;

public class ProductVariationService {
    private ProductVariationRepo productVariationRepository;

    public ProductVariationService(ProductVariationRepo productVariationRepository) {
        this.productVariationRepository = productVariationRepository;
    }

    public void addProductVariation(ProductVariation variation) {
        productVariationRepository.addProductVariation(variation);
    }

    public ProductVariation getProductVariationById(String variationId) {
        return productVariationRepository.getProductVariationById(variationId);
    }

    public List<ProductVariation> getProductVariationsByProductId(String productId) {
        return productVariationRepository.getProductVariationsByProductId(productId);
    }

    // You can implement more methods here for additional business logic if needed
}
