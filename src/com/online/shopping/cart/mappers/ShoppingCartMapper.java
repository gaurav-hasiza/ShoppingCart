package com.online.shopping.cart.mappers;

import com.online.shopping.cart.dtos.request.ShoppingCartAddToCartRequest;
import com.online.shopping.cart.dtos.request.ShoppingCartRemoveFromCartRequest;
import com.online.shopping.cart.entity.CartItem;

public
class ShoppingCartMapper {
//    String ProductVariationId,
    public static CartItem mapToCartItem(ShoppingCartAddToCartRequest shoppingCartAddToCartRequest){
        return CartItem.builder().productVariationId(shoppingCartAddToCartRequest.getProductVariationId())
                .quantity(shoppingCartAddToCartRequest.getQuantity()).build();
    }

    public static CartItem mapToCartItem(ShoppingCartRemoveFromCartRequest shoppingCartRemoveFromCartRequest){
        return CartItem.builder().productVariationId(shoppingCartRemoveFromCartRequest.getProductVariationId())
                .quantity(shoppingCartRemoveFromCartRequest.getQuantity()).build();
    }
}
