package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.model.Product;
import com.thoughtworks.iamcoach.pos.model.Promotion;
import com.thoughtworks.iamcoach.pos.service.ProductService;
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
    public void should_return_a_product_list() throws IOException {

        List<Product> productList = productService.getProductList();

        assertThat(productList.size()).isEqualTo(6);
        assertThat(productList.get(0).getName()).isEqualTo("可乐");
        assertThat(productList.get(1).getPromotionTypes().size()).isEqualTo(3);
    }

    @Test
    public void should_return_promotion_list_when_input_barcode() throws IOException {

        List<Integer> list = productService.getPromotionTypeList("ITEM000001");

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(Promotion.BUY_TWO_GET_ONE);
    }
}
