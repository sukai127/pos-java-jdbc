package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.CategoryDao;
import com.thoughtworks.iamcoach.pos.dao.ProductDao;
import com.thoughtworks.iamcoach.pos.dao.PromotionDao;
import com.thoughtworks.iamcoach.pos.model.Category;
import com.thoughtworks.iamcoach.pos.utils.FileUtils;
import com.thoughtworks.iamcoach.pos.model.Product;
import com.thoughtworks.iamcoach.pos.model.Promotion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private ProductDao productDao = new ProductDao();
    private CategoryService categoryService = new CategoryService();
    private PromotionDao promotionDao = new PromotionDao();

    public List<Product> getProductList() throws SQLException {

        List<Product> productList = productDao.getProductList();

        for(Product product : productList){
            product.setCategory(categoryService.getCategory(product.getId()));
            product.setPromotions(this.getPromotionList(product.getId()));
        }

        return productList;
    }

    private List<Promotion> getPromotionList(int id) throws SQLException {

        List<Integer> promotionTypes = promotionDao.getPromotionTypes(id);
        List<Promotion> promotionList = new ArrayList<Promotion>();

        for(Integer type : promotionTypes){
            Promotion promotion = PromotionFactory.getInstance(type);
            promotionList.add(promotion);
        }

        return promotionList;
    }

}
