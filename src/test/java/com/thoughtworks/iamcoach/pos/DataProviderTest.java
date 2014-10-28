package com.thoughtworks.iamcoach.pos;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class DataProviderTest {

    public static DataProvider dataProvider;

    @BeforeClass
    public static void beforeClass(){
        dataProvider = new DataProvider();
    }

    @Test
    public void should_return_an_product_object() throws IOException {

        String str = "ITEM000005,方便面,袋,4.50";

        Product product = dataProvider.buildProduct(str);
        assertThat(product.getName()).isEqualTo("方便面");
    }

    @Test
    public void should_return_a_product_list() throws IOException {

        List<Product> productList = dataProvider.getProductList();

        assertThat(productList.size()).isEqualTo(6);
        assertThat(productList.get(0).getName()).isEqualTo("可乐");
        assertThat(productList.get(1).getPromotionTypes().size()).isEqualTo(3);
    }

    @Test
    public void should_return_promotion_list_when_input_barcode() throws IOException {

        List<Integer> list = dataProvider.getPromotionTypeList("ITEM000001");

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(Promotion.BUY_TWO_GET_ONE);
    }
}
