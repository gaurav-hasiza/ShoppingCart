package com.online.shopping.cart.repositories;

import com.online.shopping.cart.entity.CartItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ShoppingCartRepo {
    protected static Map<String, List<CartItem>> cartItemsByUserId = new HashMap<>();

    public List<CartItem> getCartItemsForUser(String userId) {
        return cartItemsByUserId.getOrDefault(userId, new ArrayList<>());
    }

    public void addToCart(String userId, CartItem cartItem) {
        List<CartItem> cartItems = cartItemsByUserId.getOrDefault(userId, new ArrayList<>());
        cartItems.add(cartItem);
        cartItemsByUserId.put(userId, cartItems);
    }

    public void removeFromCart(String userId, CartItem cartItem) {
        List<CartItem> cartItems = cartItemsByUserId.getOrDefault(userId, new ArrayList<>());

        cartItems.remove(cartItem);
        cartItemsByUserId.remove(userId);
    }

    public void clearCart(String userId) {
        cartItemsByUserId.remove(userId);
    }
}
