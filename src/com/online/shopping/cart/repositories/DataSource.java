package com.online.shopping.cart.repositories;

import com.online.shopping.cart.entity.CartItem;
import com.online.shopping.cart.entity.Order;
import com.online.shopping.cart.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSource {
    private static final Map<String, List<CartItem>> userCarts = new HashMap<>();
    private static final List<Order> orders = new ArrayList<>();
    private static final List<Product> productList = new ArrayList<>();

}
