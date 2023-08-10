package com.online.shopping.cart.repositories;

import com.online.shopping.cart.entity.ProductVariation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Not in use. Added this for more functionality
@Component
public class ProductVariationRepo {
    private Map<String, List<ProductVariation>> productVariationsByProductId;

    public ProductVariationRepo() {
        productVariationsByProductId = new HashMap<>();
    }

    // Retrieve a specific product variation by its variationId
    public ProductVariation getProductVariationById(String variationId) {
        for (List<ProductVariation> variations : productVariationsByProductId.values()) {
            for (ProductVariation variation : variations) {
                if (variation.getId().equals(variationId)) {
                    return variation;
                }
            }
        }
        return null; // Return null if the product variation with the specified ID is not found
    }

    // Add a product variation to the repository
    public void addProductVariation(ProductVariation variation) {
        String productId = variation.getProductId();
        List<ProductVariation> variations = productVariationsByProductId.getOrDefault(productId, new ArrayList<>());
        variations.add(variation);
        productVariationsByProductId.put(productId, variations);
    }

    // Get all product variations for a specific product ID
    public List<ProductVariation> getProductVariationsByProductId(String productId) {
        return productVariationsByProductId.getOrDefault(productId, new ArrayList<>());
    }

    // Search for a product variation based on seller ID and product ID
    public ProductVariation getProductVariation(String productId, String sellerId) {
        List<ProductVariation> variations = productVariationsByProductId.getOrDefault(productId, new ArrayList<>());
        for (ProductVariation variation : variations) {
            if (variation.getSellerId().equals(sellerId)) {
                return variation;
            }
        }
        return null;
    }

    // You can implement more methods for fetching, updating, and deleting product variations if needed
}

