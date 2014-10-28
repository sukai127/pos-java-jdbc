package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class BuyTwoGetOnePromotionTest {

    @Test
    public void should_return_12_when_input_cartItem(){

        Product product = new Product("ITEM000000","可乐","瓶",3.00,null);
        CartItem cartItem = new CartItem(product,5);
        BuyTwoGetOnePromotion buyTwoGetOnePromotion = new BuyTwoGetOnePromotion();

        double money = buyTwoGetOnePromotion.getMoney(cartItem);

        assertThat(money).isEqualTo(12);
    }
}
