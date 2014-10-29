package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.model.*;
import com.thoughtworks.iamcoach.pos.service.PromotionService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class PromotionServiceTest {
    @Test
    public void should_return_12_when_input_cartItem(){

        List<Promotion> list = new ArrayList<Promotion>();
        list.add(new BuyTwoGetOnePromotion());
        list.add(new SecondHalfPricePromotion());
        list.add(new DiscountPromotion());

        Product product = new Product("ITEM000001","可乐","瓶",3.00,list);
        CartItem cartItem = new CartItem(product,6);
        PromotionService promotionService = new PromotionService();

        double money = promotionService.calculateMoney(cartItem);

        assertThat(money).isEqualTo(12);
    }

}
