package com.online.shopping.cart.repositories;

import com.online.shopping.cart.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepo implements IProductRepo {
    private static List<Product> productList = new ArrayList<>();
    private Map<String, Product> products;
    public ProductRepo() {
        products = new HashMap<>();
    }
    @Override
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product getProductById(String productId) {
        return products.get(productId);
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }
}