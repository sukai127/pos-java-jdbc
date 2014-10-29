package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.Category;
import com.thoughtworks.iamcoach.pos.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends DbUtils{

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public List<Category> getCategoryList() throws SQLException {

        List<Category> categoryList = new ArrayList<Category>();
        String sql = "select * from category";

        connection = getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Category category = new Category(resultSet.getInt("id"),resultSet.getString("name"));
            categoryList.add(category);
        }
        return categoryList;
    }

    public Category getCategory(int id) throws SQLException {

        String sql = "select * from category where id=?";

        connection = getConnection();
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();

        resultSet.next();
        Category category = new Category(resultSet.getInt("id"),resultSet.getString("name"));
        return category;
    }
}
