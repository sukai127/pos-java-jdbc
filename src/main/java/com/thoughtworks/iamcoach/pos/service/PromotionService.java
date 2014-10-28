package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.model.CartItem;
import com.thoughtworks.iamcoach.pos.model.Promotion;

import java.util.Arrays;
import java.util.List;

public class PromotionService {

    public double calculateMoney(CartItem cartItem) {

        List<Integer> list = cartItem.getProduct().getPromotionTypes();
        double result = cartItem.getProduct().getPrice() * cartItem.getCount();
        double money[] = new double[list.size()];
        Promotion promotion = null;

        for (int i = 0; i < list.size(); i++) {
            promotion = PromotionFactory.getInstance(list.get(i));
            double subTotal = promotion.getMoney(cartItem);
            money[i] = subTotal;
        }
        Arrays.sort(money);

        return money.length == 0 ? result : money[0];
    }


}
