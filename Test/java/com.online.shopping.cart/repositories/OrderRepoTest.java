package com.online.shopping.cart.repositories;

import com.online.shopping.cart.entity.Order;
import com.online.shopping.cart.enums.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {

    private OrderRepo orderRepo;

    @BeforeEach
    void setUp() {
        orderRepo = new OrderRepo();
        orderRepo.orders = new ArrayList<>();
    }

    @Test
    void testPlaceOrder() {
        orderRepo.placeOrder("user123", 50.0);
        List<Order> orders = orderRepo.getOrderHistory("user123");

        assertEquals(1, orders.size());
        assertEquals("user123", orders.get(0).getUserId());
        assertEquals(OrderStatus.PLACED, orders.get(0).getOrderStatus());
    }

    @Test
    void testGenerateOrderId() {
        String orderId = orderRepo.generateOrderId();
        assertNotNull(orderId);
    }

    @Test
    void testGetOrderHistoryForUserWithOrders() {
        orderRepo.placeOrder("user123", 50.0);
        orderRepo.placeOrder("user123", 75.0);
        List<Order> userOrders = orderRepo.getOrderHistory("user123");

        assertEquals(2, userOrders.size());
        assertEquals("user123", userOrders.get(0).getUserId());
        assertEquals("user123", userOrders.get(1).getUserId());
    }

    @Test
    void testGetOrderHistoryForUserWithoutOrders() {
        List<Order> userOrders = orderRepo.getOrderHistory("user456");
        assertTrue(userOrders.isEmpty());
    }

    @Test
    void testPlacingOrdersForDifferentUsers() {
        orderRepo.placeOrder("user123", 50.0);
        orderRepo.placeOrder("user456", 75.0);
        List<Order> user123Orders = orderRepo.getOrderHistory("user123");
        List<Order> user456Orders = orderRepo.getOrderHistory("user456");

        assertEquals(1, user123Orders.size());
        assertEquals(1, user456Orders.size());
        assertEquals("user123", user123Orders.get(0).getUserId());
        assertEquals("user456", user456Orders.get(0).getUserId());
    }

    @Test
    void testMultipleOrdersForSameUser() {
        orderRepo.placeOrder("user123", 50.0);
        orderRepo.placeOrder("user123", 75.0);
        List<Order> userOrders = orderRepo.getOrderHistory("user123");

        assertEquals(2, userOrders.size());
        assertEquals("user123", userOrders.get(0).getUserId());
        assertEquals("user123", userOrders.get(1).getUserId());
    }

    @Test
    void testPlaceOrderWithInvalidInputs() {
        assertThrows(NullPointerException.class, () -> orderRepo.placeOrder(null, 50.0));
        assertThrows(IllegalArgumentException.class, () -> orderRepo.placeOrder("user123", -50.0));
    }

    @Test
    void testGetOrderHistoryWithInvalidInput() {
        assertThrows(NullPointerException.class, () -> orderRepo.getOrderHistory(null));
    }
}
