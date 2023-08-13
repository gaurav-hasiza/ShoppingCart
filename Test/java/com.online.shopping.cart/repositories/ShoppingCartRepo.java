package com.online.shopping.cart.repositories;

import com.online.shopping.cart.entity.CartItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartRepoTest {

    private ShoppingCartRepo shoppingCartRepo;

    @BeforeEach
    void setUp() {
        shoppingCartRepo.cartItemsByUserId = new HashMap<>();
        shoppingCartRepo = new ShoppingCartRepo();
    }

    @Test
    void testAddToCart() {
        CartItem cartItem = new CartItem("item1", 2);
        shoppingCartRepo.addToCart("user123", cartItem);
        List<CartItem> cartItems = shoppingCartRepo.getCartItemsForUser("user123");

        assertEquals(1, cartItems.size());
        assertEquals("item1", cartItems.get(0).getProductId());
        assertEquals(2, cartItems.get(0).getQuantity());
    }

    @Test
    void testRemoveFromCart() {
        CartItem cartItem1 = new CartItem("item1", 2);
        CartItem cartItem2 = new CartItem("item2", 3);
        shoppingCartRepo.addToCart("user123", cartItem1);
        shoppingCartRepo.addToCart("user123", cartItem2);

        shoppingCartRepo.removeFromCart("user123", cartItem1);
        List<CartItem> cartItems = shoppingCartRepo.getCartItemsForUser("user123");

        assertEquals(1, cartItems.size());
        assertEquals("item2", cartItems.get(0).getProductId());
    }

    @Test
    void testClearCart() {
        CartItem cartItem = new CartItem("item1", 2);
        shoppingCartRepo.addToCart("user123", cartItem);

        shoppingCartRepo.clearCart("user123");
        List<CartItem> cartItems = shoppingCartRepo.getCartItemsForUser("user123");

        assertTrue(cartItems.isEmpty());
    }

    @Test
    void testGetCartItemsForUserWithNoItems() {
        List<CartItem> cartItems = shoppingCartRepo.getCartItemsForUser("user123");
        assertTrue(cartItems.isEmpty());
    }

    @Test
    void testGetCartItemsForUserWithItems() {
        CartItem cartItem1 = new CartItem("item1", 2);
        CartItem cartItem2 = new CartItem("item2", 3);
        shoppingCartRepo.addToCart("user123", cartItem1);
        shoppingCartRepo.addToCart("user123", cartItem2);

        List<CartItem> cartItems = shoppingCartRepo.getCartItemsForUser("user123");

        assertEquals(2, cartItems.size());
        assertEquals("item1", cartItems.get(0).getProductId());
        assertEquals("item2", cartItems.get(1).getProductId());
    }
}

