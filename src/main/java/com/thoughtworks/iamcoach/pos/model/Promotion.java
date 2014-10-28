package com.thoughtworks.iamcoach.pos.model;

public abstract class Promotion {

    public static final int BUY_TWO_GET_ONE = 0;
    public static final int SECOND_HALF_PRICE = 1;
    public static final int DISCOUNT = 2;

    public abstract double getMoney(CartItem cartItem);

    public static Promotion getPromotion(int type){
        Promotion promotion = null;
        switch (type) {
            case Promotion.BUY_TWO_GET_ONE:
                promotion = new BuyTwoGetOnePromotion();
                break;
            case Promotion.SECOND_HALF_PRICE:
                promotion = new SecondHalfPricePromotion();
                break;
            case Promotion.DISCOUNT:
                promotion = new DiscountPromotion();
                break;
            default:
                break;
        }

        return promotion;
    }

}
