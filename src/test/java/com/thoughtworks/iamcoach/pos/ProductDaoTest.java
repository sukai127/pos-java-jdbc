package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.dao.ProductDao;
import com.thoughtworks.iamcoach.pos.model.Product;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductDaoTest {
    @Test
    public void should_return_productList() throws SQLException {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1,"ITEM000001","可乐","瓶",3.00,null,null));
        products.add(new Product(2,"ITEM000002","雪碧","瓶",3.00,null,null));
        products.add(new Product(3,"ITEM000003","苹果","斤",3.00,null,null));
        products.add(new Product(4,"ITEM000004","荔枝","斤",3.00,null,null));

        ProductDao productDao = mock(ProductDao.class);
        when(productDao.getProductList()).thenReturn(products);

        List<Product> productList = productDao.getProductList();

        assertThat(productList.size()).isEqualTo(4);
        assertThat(productList.get(1).getName()).isEqualTo("雪碧");
    }
}
