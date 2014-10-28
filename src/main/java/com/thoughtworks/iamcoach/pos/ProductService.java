package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.model.Product;
import com.thoughtworks.iamcoach.pos.model.Promotion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private static List<String> buyTwoGetOneList;
    private static List<String> secondHalfPriceList;
    private static List<String> discountList;

    static{
        try {

            buyTwoGetOneList = FileHelper.get("buy_two_get_one_free_promotion.txt");
            secondHalfPriceList = FileHelper.get("second_half_price_promotion.txt");
            discountList = FileHelper.get("discount_promotion.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Product buildProduct(String productString) throws IOException {

        String []fields = productString.split(",");
        double price = Double.parseDouble(fields[3]);

        List<Integer> list = this.getPromotionTypeList(fields[0]);
        Product product = new Product(fields[0],fields[1],fields[2],price,list);
        return product;
    }

    public List<Product> getProductList() throws IOException {

        List<Product> productList = new ArrayList<Product>();
        List<String> productStringList = FileHelper.get("products.txt");

        for(String str : productStringList){
            Product product = this.buildProduct(str);
            productList.add(product);
        }

        return productList;
    }

    public List<Integer> getPromotionTypeList(String barcode) throws IOException {

        List<Integer> promotionList = new ArrayList<Integer>();

        if(buyTwoGetOneList.contains(barcode)){
            promotionList.add(Promotion.BUY_TWO_GET_ONE);
        }
        if(secondHalfPriceList.contains(barcode)){
            promotionList.add(Promotion.SECOND_HALF_PRICE);
        }
        if(isExist(discountList,barcode)){
            promotionList.add(Promotion.DISCOUNT);
        }
        return promotionList;
    }

    private boolean isExist(List<String> discountList, String barcode) {
        for(String str : discountList){
            if(str.contains(barcode)){
                return true;
            }
        }
        return false;
    }
}
