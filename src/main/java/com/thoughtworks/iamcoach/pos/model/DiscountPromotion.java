package com.thoughtworks.iamcoach.pos.model;

import com.thoughtworks.iamcoach.pos.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class DiscountPromotion extends Promotion{

    @Override
    public double getMoney(CartItem cartItem) {

        int discount = this.getDiscount(cartItem.getProduct().getBarcode());
        double money = cartItem.getProduct().getPrice() * cartItem.getCount() * discount / 100.0;
        return money;

    }

    private int getDiscount(String barcode){
        List<String> list;
        int discount = 100;

        try {
            list = FileUtils.get("discount_promotion.txt");

            for(String str : list){
                if(str.contains(barcode)){
                    discount = Integer.parseInt(str.split(":")[1]);
                }
            }
        } catch (IOException e) {
        }
        return discount;
    }
}
