package com.online.shopping.cart.dtos.request;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ShoppingCartAddToCartRequest {
    private final String productVariationId;
    private final int quantity;
}
