package com.online.shopping.cart.repositories;

import com.online.shopping.cart.entity.Product;

import java.util.List;

public interface IProductRepo {
    public void addProduct(Product product);
    public Product getProductById(String id);
    public Product update(Product product);
    public List<Product> getAllProducts();
}
