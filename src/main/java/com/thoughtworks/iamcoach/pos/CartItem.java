package com.thoughtworks.iamcoach.pos;

public class CartItem {
    private Product product;
    private double count;
    private double money;

    public CartItem(){

    }

    public CartItem(Product product, double count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
