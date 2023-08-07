package com.online.shopping.cart.services;

import com.online.shopping.cart.entity.CartItem;
import com.online.shopping.cart.repositories.ShoppingCartRepo;

import java.util.List;

public class ShoppingCartService {
    private ShoppingCartRepo shoppingCartRepository;

    public ShoppingCartService(ShoppingCartRepo shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public List<CartItem> getCartItemsForUser(String userId) {
        return shoppingCartRepository.getCartItemsForUser(userId);
    }

    public void addToCart(String userId, CartItem cartItem) {
        // add validation if that variation item is already present or not
        shoppingCartRepository.addToCart(userId, cartItem);
    }

    public void removeFromCart(String userId, CartItem cartItem) {
        // add logic to remove some quantity of items.
        shoppingCartRepository.removeFromCart(userId, cartItem);
    }

    public void clearCart(String userId) {
        shoppingCartRepository.clearCart(userId);
    }
}
