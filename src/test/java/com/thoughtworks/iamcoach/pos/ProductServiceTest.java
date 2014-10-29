package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.model.Product;
import com.thoughtworks.iamcoach.pos.model.Promotion;
import com.thoughtworks.iamcoach.pos.service.ProductService;
import com.thoughtworks.iamcoach.pos.service.PromotionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class ProductServiceTest {

    public static ProductService productService;

    @BeforeClass
    public static void beforeClass(){
        productService = new ProductService();
    }

    @Test
    public void should_return_a_product_list() throws Exception {

        List<Product> productList = productService.getProductList();

        assertThat(productList.size()).isEqualTo(6);
        assertThat(productList.get(0).getCategory().getName()).isEqualTo("饮料");
        assertThat(productList.get(0).getName()).isEqualTo("可乐");
        assertThat(productList.get(1).getPromotions().size()).isEqualTo(3);
    }
}
