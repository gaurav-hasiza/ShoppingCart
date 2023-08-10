package com.online.shopping.cart.repositories;

import com.online.shopping.cart.enums.OrderStatus;
import com.online.shopping.cart.entity.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//TODO: Add validator layer
@Component
public class OrderRepo implements IOrderRepo{
    private static final List<Order> orders = new ArrayList<>();

    public void placeOrder(String userId, double totalAmount) {
        String orderId = generateOrderId();
        Date orderDate = new Date();
        OrderStatus orderStatus = OrderStatus.PLACED;
        Order order = new Order(orderId, userId, orderDate, totalAmount, orderStatus);
        orders.add(order);
    }
    private String generateOrderId() {
        return UUID.randomUUID().toString();
    }

    public List<Order> getOrderHistory(String userId) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getUserId().equals(userId)) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }
}

