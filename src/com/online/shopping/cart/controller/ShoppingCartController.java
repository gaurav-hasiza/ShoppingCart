package com.online.shopping.cart.controller;

import com.online.shopping.cart.dtos.request.ShoppingCartAddToCartRequest;
import com.online.shopping.cart.dtos.request.ShoppingCartRemoveFromCartRequest;
import com.online.shopping.cart.entity.CartItem;
import com.online.shopping.cart.entity.User;
import com.online.shopping.cart.mappers.ShoppingCartMapper;
import com.online.shopping.cart.services.SessionManagementService;
import com.online.shopping.cart.services.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v0/shopping")
public class ShoppingCartController {

    ShoppingCartService shoppingCartService;
    SessionManagementService sessionManagementService;
    /**
     * Add the given product id to the cart
     * @param cookieHeader
     * @param shoppingCartAddToCartRequest
     * @return
     */
    @PostMapping(value = "/addToCart")
    public ResponseEntity addProductToCart(@RequestHeader("Cookie") String cookieHeader,
                                     @RequestBody ShoppingCartAddToCartRequest shoppingCartAddToCartRequest) {
        try {
            User currentUser = sessionManagementService.getUserBySessionId(cookieHeader);
            CartItem cartItem = ShoppingCartMapper.mapToCartItem(shoppingCartAddToCartRequest);
            shoppingCartService.addToCart(currentUser.getId(), cartItem);
            return new ResponseEntity(HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * remove the given product id from the cart
     * @param cookieHeader
     * @param shoppingCartRemoveFromCartRequest
     * @return
     */
    @PostMapping(value = "/removeFromCart")
    public ResponseEntity removeProduct(@RequestHeader("Cookie") String cookieHeader,
                                        @RequestBody ShoppingCartRemoveFromCartRequest shoppingCartRemoveFromCartRequest) {
        try {
            sessionManagementService.validateSession(cookieHeader);
            User currentUser = sessionManagementService.getUserBySessionId(cookieHeader);
            CartItem cartItem = ShoppingCartMapper.mapToCartItem(shoppingCartRemoveFromCartRequest);
            shoppingCartService.removeFromCart(currentUser.getId(), cartItem);
            return new ResponseEntity(HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
