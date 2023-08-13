package com.online.shopping.cart.mappers;

import com.online.shopping.cart.dtos.request.ShoppingCartAddToCartRequest;
import com.online.shopping.cart.dtos.request.ShoppingCartRemoveFromCartRequest;
import com.online.shopping.cart.entity.CartItem;

public
class ShoppingCartMapper {
//    String ProductVariationId,
    public static CartItem mapToCartItem(ShoppingCartAddToCartRequest shoppingCartAddToCartRequest){
        return CartItem.builder().productId(shoppingCartAddToCartRequest.getProductId())
                .quantity(shoppingCartAddToCartRequest.getQuantity()).build();
    }

    public static CartItem mapToCartItem(ShoppingCartRemoveFromCartRequest shoppingCartRemoveFromCartRequest){
        return CartItem.builder().productId(shoppingCartRemoveFromCartRequest.getProductId())
                .build();
    }
}
