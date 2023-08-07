package com.online.shopping.cart.repositories;

import com.online.shopping.cart.entity.Product;

import java.util.*;

public class ProductRepo implements IProductRepo {
    private static final Map<String, Product> products = new HashMap<>();
    @Override
    public Product addProduct(Product product) {
        product.setId(generateSessionId());
        products.put(product.getId(), product);
        return product;
    }
    private String generateSessionId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public Product getProductById(String productId) {
        return products.get(productId);
    }

    @Override
    public Product update(Product product) {
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public List<Product> getAllAvailableProducts(){
        List<Product> productList = new ArrayList<>();
        for(Product product: products.values()){
            if (product.getStockQuantity() > 0){
                productList.add(product);
            }
        }
        return productList;

    }
}