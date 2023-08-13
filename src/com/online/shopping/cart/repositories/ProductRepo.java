package com.online.shopping.cart.repositories;

import com.online.shopping.cart.entity.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class ProductRepo implements IProductRepo {
    private static final Map<String, Product> products = new HashMap<>();
    @Override
    public Product addProduct(Product product) {
        Product product1 = getProductByName(product.getName());
        if (product1 != null){
            product1.setStockQuantity(product1.getStockQuantity() + product.getStockQuantity());
            product1.setUpdatedAt(LocalDateTime.now());
            products.put(product1.getId(), product1);
            return product1;
        }
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
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

    public boolean isProductValid(String productId){
        return products.containsKey(productId);
    }

    public Product getProductByName(String productName) {
        for(Product product: products.values()){
            if (product.getName().equals(productName)){
                return product;
            }
        }
        return null;
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