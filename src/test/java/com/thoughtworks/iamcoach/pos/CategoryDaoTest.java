package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.dao.CategoryDao;
import com.thoughtworks.iamcoach.pos.model.Category;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class CategoryDaoTest {
    @Test
    public void should_return_categoryList() throws SQLException {
        CategoryDao categoryDao = new CategoryDao();
        List<Category> list = categoryDao.getCategoryList();
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(0).getName()).isEqualTo("饮料");
    }

    @Test
    public void should_return_category_when_input_id(){

        CategoryDao categoryDao = new CategoryDao();
        Category category = categoryDao.getCategory(1);
        assertThat(category.getName()).isEqualTo("饮料");

    }
}
