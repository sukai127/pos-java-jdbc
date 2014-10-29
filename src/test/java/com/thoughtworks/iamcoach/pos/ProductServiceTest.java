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
    public void should_return_an_product_object() throws IOException {

        String str = "ITEM000005,方便面,袋,4.50";

        Product product = productService.buildProduct(str);
        assertThat(product.getName()).isEqualTo("方便面");
    }

    @Test
    public void should_return_a_product_list() throws Exception {

        List<Product> productList = productService.getProductList();

        assertThat(productList.size()).isEqualTo(6);
        assertThat(productList.get(0).getCategory().getName()).isEqualTo("饮料");
        assertThat(productList.get(0).getName()).isEqualTo("可乐");
        assertThat(productList.get(1).getPromotions().size()).isEqualTo(3);
    }

    @Test
    public void should_return_promotion_list_when_input_barcode() throws IOException {

        List<Promotion> list = productService.getPromotions("ITEM000001");

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0).getType()).isEqualTo(PromotionFactory.BUY_TWO_GET_ONE);
    }
}
