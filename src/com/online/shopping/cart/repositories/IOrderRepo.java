package com.online.shopping.cart.repositories;

import com.online.shopping.cart.entity.Order;

import java.util.List;

public interface IOrderRepo {
    public void placeOrder(String userId, double totalAmount);
    public List<Order> getOrderHistory(String userId);

}
