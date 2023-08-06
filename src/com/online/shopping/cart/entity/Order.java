package com.online.shopping.cart.entity;

import com.online.shopping.cart.enums.OrderStatus;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@ToString(callSuper = true)
@Getter
public class Order extends BaseEntity {
    private String userId;
    private Date orderDate;
    private double totalAmount;
    private OrderStatus orderStatus;
    // TODO ORDER Items can be stored based on the requirement

    public Order(String orderId, String userId, Date orderDate, double totalAmount, OrderStatus orderStatus) {
        this.setId(orderId);
        this.userId = userId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }
}
