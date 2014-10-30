package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.dao.ProductDao;
import com.thoughtworks.iamcoach.pos.dao.PromotionDao;
import com.thoughtworks.iamcoach.pos.model.Product;
import com.thoughtworks.iamcoach.pos.model.Promotion;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PromotionDaoTest {
    @Test
    public void should_return_promotionTypes() throws SQLException {

        PromotionDao promotionDao = new PromotionDao();
        List<Integer> list = promotionDao.getPromotionTypes();

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(0);
    }

    @Test
    public void should_return_types_when_input_productId() throws SQLException {

        PromotionDao promotionDao = new PromotionDao();
        List<Integer> list =  promotionDao.getPromotionTypes(2);

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(0);

    }

    @Test
    public void should_return_75_when_input_productId() throws Exception{

        PromotionDao promotionDao = mock(PromotionDao.class);

        when(promotionDao.getDiscount(2)).thenReturn(75);

        int result = promotionDao.getDiscount(2);

        assertThat(result).isEqualTo(75);
    }
}

