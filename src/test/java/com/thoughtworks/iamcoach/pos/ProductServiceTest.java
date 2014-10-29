package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.dao.ProductDao;
import com.thoughtworks.iamcoach.pos.model.Product;
import com.thoughtworks.iamcoach.pos.model.Promotion;
import com.thoughtworks.iamcoach.pos.service.ProductService;
import com.thoughtworks.iamcoach.pos.service.PromotionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    public static ProductService productService;

    @BeforeClass
    public static void beforeClass(){
        productService = new ProductService();
    }

    @Test
    public void should_return_a_product_list() throws Exception {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1,"ITEM000001","可乐","瓶",3.00,null,null));
        products.add(new Product(2,"ITEM000002","雪碧","瓶",3.00,null,null));
        products.add(new Product(3,"ITEM000003","苹果","斤",3.00,null,null));
        products.add(new Product(4,"ITEM000004","荔枝","斤",3.00,null,null));

        ProductDao productDao = mock(ProductDao.class);
        when(productDao.getProductList()).thenReturn(products);
        List<Product> productList = productService.getProductList();

        assertThat(productList.size()).isEqualTo(6);
        assertThat(productList.get(0).getCategory().getName()).isEqualTo("饮料");
        assertThat(productList.get(0).getName()).isEqualTo("可乐");
        assertThat(productList.get(1).getPromotions().size()).isEqualTo(3);
    }
}
