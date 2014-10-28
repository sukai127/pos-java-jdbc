package com.thoughtworks.iamcoach.pos.model;

import com.thoughtworks.iamcoach.pos.CartItem;

public class BuyTwoGetOnePromotion extends Promotion{
    @Override
    public double getMoney(CartItem cartItem) {

        int promotionCount = (int)(cartItem.getCount()/3.0);
        double count = cartItem.getCount() - promotionCount;
        double money = cartItem.getProduct().getPrice() * count;

        return money;
    }
}
