package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.dao.ProductDao;
import com.thoughtworks.iamcoach.pos.dao.PromotionDao;
import com.thoughtworks.iamcoach.pos.model.Promotion;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class PromotionDaoTest {
    @Test
    public void should_return_promotionTypes() throws SQLException {

        PromotionDao promotionDao = new PromotionDao();
        List<Integer> list = promotionDao.getPromotionTypes();

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(0);
    }

    @Test
    public void should_return_types_when_input_productId(){

        PromotionDao promotionDao = new PromotionDao();
        List<Integer> list =  promotionDao.getPromotionTypes(1);

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(0);

    }
}

