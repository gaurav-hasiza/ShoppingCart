package com.online.shopping.cart.services;

import com.online.shopping.cart.entity.CartItem;
import com.online.shopping.cart.repositories.ProductRepo;
import com.online.shopping.cart.repositories.ShoppingCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    private ProductRepo productRepo;
    private ShoppingCartRepo shoppingCartRepository;

    @Autowired
    public ShoppingCartService(ProductRepo productRepo, ShoppingCartRepo shoppingCartRepository) {
        this.productRepo = productRepo;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public List<CartItem> getCartItemsForUser(String userId) {
        return shoppingCartRepository.getCartItemsForUser(userId);
    }

    public void addToCart(String userId, CartItem cartItem) {
        if (productRepo.isProductValid(cartItem.getProductId())) {
            shoppingCartRepository.addToCart(userId, cartItem);
        }
        throw new RuntimeException("Product Id invalid");
    }

    public void removeFromCart(String userId, CartItem cartItem) {
        // add logic to remove some quantity of items.
        shoppingCartRepository.removeFromCart(userId, cartItem);
    }

    public void clearCart(String userId) {
        shoppingCartRepository.clearCart(userId);
    }
}
