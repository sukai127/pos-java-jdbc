package com.thoughtworks.iamcoach.pos;

import java.util.List;

public class Product {

    private String barcode;
    private String name;
    private String unit;
    private double price;
    private List<Integer> promotionTypes;

    public Product() {

    }

    public Product(String barcode, String name, String unit, double price, List<Integer> promotionTypes) {
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.promotionTypes = promotionTypes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPromotionTypes() {
        return promotionTypes;
    }

    public void setPromotionTypes(List<Integer> promotionTypes) {
        this.promotionTypes = promotionTypes;
    }
}
