package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.dao.ProductDao;
import com.thoughtworks.iamcoach.pos.model.Product;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class ProductDaoTest {
    @Test
    public void should_return_productList() throws SQLException {
        ProductDao productDao = new ProductDao();
        List<Product> productList = productDao.getProductList();
        assertThat(productList.size()).isEqualTo(6);
        assertThat(productList.get(0).getCategory().getName()).isEqualTo("饮料");
        assertThat(productList.get(1).getPromotions().size()).isEqualTo(3);
    }
}
