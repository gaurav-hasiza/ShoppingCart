package com.online.shopping.cart.services;

import com.online.shopping.cart.entity.CartItem;

import java.util.List;

public interface IShoppingCartService {
    public void removeFromCart(String userId, CartItem cartItem);
    public void addToCart(String userId, CartItem cartItem);
    public List<CartItem> getCartItemsForUser(String userId);
}
