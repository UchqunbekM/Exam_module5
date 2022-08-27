package com.example.exam_module5.Category;

import com.example.exam_module5.Database.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {


    public static List<Category> getAllCategories() {
        try (Connection connection = DbConnection.getConnection();) {
            List<Category> categoryList = new ArrayList<>();
            String sql = "select * from category";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");

                Category category = Category.builder()
                        .id(id)
                        .name(name)
                        .build();
                categoryList.add(category);
            }
            return categoryList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
