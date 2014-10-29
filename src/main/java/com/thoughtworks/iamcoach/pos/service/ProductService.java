package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.ProductDao;
import com.thoughtworks.iamcoach.pos.utils.FileUtils;
import com.thoughtworks.iamcoach.pos.model.Product;
import com.thoughtworks.iamcoach.pos.model.Promotion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private static List<String> buyTwoGetOneList;
    private static List<String> secondHalfPriceList;
    private static List<String> discountList;
    private ProductDao productDao = new ProductDao();

    static{
        try {

            buyTwoGetOneList = FileUtils.get("buy_two_get_one_free_promotion.txt");
            secondHalfPriceList = FileUtils.get("second_half_price_promotion.txt");
            discountList = FileUtils.get("discount_promotion.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Product buildProduct(String productString) throws IOException {

        String []fields = productString.split(",");
        double price = Double.parseDouble(fields[3]);

        List<Promotion> list = this.getPromotions(fields[0]);
        Product product = new Product(0,fields[0],fields[1],fields[2],price,null,list);
        return product;
    }

    public List<Product> getProductList() throws SQLException, IOException {

        List<Product> productList = productDao.getProductList();

        for(Product str : productList){
            Product product = this.buildProduct("");
            productList.add(product);
        }

        return productList;
    }

    public List<Promotion> getPromotions(String barcode) throws IOException {

        List<Promotion> promotionList = new ArrayList<Promotion>();

        if(buyTwoGetOneList.contains(barcode)){
            promotionList.add(PromotionFactory.getInstance(PromotionFactory.BUY_TWO_GET_ONE));
        }
        if(secondHalfPriceList.contains(barcode)){
            promotionList.add(PromotionFactory.getInstance(PromotionFactory.SECOND_HALF_PRICE));
        }
        if(isExist(discountList,barcode)){
            promotionList.add(PromotionFactory.getInstance(PromotionFactory.DISCOUNT));
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
