package com.online.shopping.cart.dtos.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public
class ShoppingCartRemoveFromCartRequest {
    private final String productId;
    private final int quantity;
}
