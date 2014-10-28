package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import javax.print.attribute.IntegerSyntax;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class PromotionHelperTest {
    @Test
    public void should_return_12_when_input_cartItem(){

        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);

        Product product = new Product("ITEM000001","可乐","瓶",3.00,list);
        CartItem cartItem = new CartItem(product,6);
        PromotionHelper  promotionHelper = new PromotionHelper();

        double money = promotionHelper.calculateMoney(cartItem);

        assertThat(money).isEqualTo(12);
    }

}
