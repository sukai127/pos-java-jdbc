package com.thoughtworks.iamcoach.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromotionDao extends DbUtils{

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public List<Integer> getPromotionTypes() throws SQLException {

        List<Integer> promotionTypes = new ArrayList<Integer>();
        String sql = "select * from promotion";

        connection = getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            int type = resultSet.getInt("type");
            promotionTypes.add(type);
        }

        return promotionTypes;
    }

    public List<Integer> getPromotionTypes(int id) {
        return null;
    }
}
