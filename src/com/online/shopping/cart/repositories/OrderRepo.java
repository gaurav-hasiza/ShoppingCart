package com.online.shopping.cart.repositories;

import com.online.shopping.cart.enums.OrderStatus;
import com.online.shopping.cart.entity.Order;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//TODO: Add validator layer
@Component
public class OrderRepo implements IOrderRepo{
    // add validation layer

//    @VisibleForTesting
    protected static List<Order> orders = new ArrayList<>();

    public void placeOrder(@NonNull String userId, double totalAmount) {
        if(totalAmount <= 0){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        String orderId = generateOrderId();
        Date orderDate = new Date();
        OrderStatus orderStatus = OrderStatus.PLACED;
        Order order = new Order(orderId, userId, orderDate, totalAmount, orderStatus);
        orders.add(order);
    }

    public String generateOrderId() {
        return UUID.randomUUID().toString();
    }

    public List<Order> getOrderHistory(@NonNull String userId) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getUserId().equals(userId)) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }
}

