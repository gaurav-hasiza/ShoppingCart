package com.online.shopping.cart.repositories;

public interface BaseRepo <T>{
    T save(T entity);
    T findById(Long id);
    T update(T entity);
    void delete(Long id);
}
