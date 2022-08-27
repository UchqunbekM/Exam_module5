package com.example.exam_module5.Product;

import com.example.exam_module5.Category.Category;
import com.example.exam_module5.Database.DbConnection;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProductDao {

    public static List<Product> getAllProducts() {
        try {
            ArrayList<Product> productList = new ArrayList<>();
            Connection connection = DbConnection.getConnection();
            String sql = "select b.id,\n" +
                    "       b.title,\n" +
                    "       b.salary,\n" +
                    "       b.\"imgUrl\",\n" +
                    "    json_build_object('id', c.id, 'name', c.name) as category\n" +
                    "from product b\n" +
                    "         join category c on c.id = b.category_id\n" +
                    "group by b.id, c.id, c.name, b.title\n";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long productid = resultSet.getLong("id");
                String name = resultSet.getString("title");
                Object categoryObj = resultSet.getObject("category");
                String imgUrl = resultSet.getString("imgUrl");
                Integer salary = resultSet.getInt("salary");
                Category category = new Gson().fromJson(categoryObj.toString(), Category.class);
                Product product = Product.builder()
                        .id(productid)
                        .name(name)
                        .category(category)
                        .imgUrl(imgUrl)
                        .salary(salary)
                        .build();
                productList.add(product);
            }
            return productList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean addProduct(Product product) {
        try {
            Connection connection = DbConnection.getConnection();
            String insertBook = "insert into product (title, salary, category_id, \"imgUrl\") VALUES " +
                    "(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertBook);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getSalary());
            preparedStatement.setLong(3, product.getCategoryId());
            preparedStatement.setString(4, product.getImgUrl());
            int executeUpdate1 = preparedStatement.executeUpdate();
            return executeUpdate1 == 1 ;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Boolean deleteProduct(int id) {
        int excute2 = 0;
        PreparedStatement ps = null;
        try (Connection connection = DbConnection.getConnection()){
            ps = connection.prepareStatement("delete from product where id = ?");
            ps.setInt(1,id);
            excute2=ps.executeUpdate();
            ps.close();
            return excute2 == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Product getProductInfo(int id) {
        try {
            Connection connection = DbConnection.getConnection();

            String sql = "select b.id,\n" +
                    "       b.title,\n" +
                    "       b.\"imgUrl\",\n" +
                    "       b.salary,\n" +
                    "    json_build_object('id', c.id, 'name', c.name) as category\n" +
                    "from product b\n" +
                    "         join category c on c.id = b.category_id where b.id = ?" +
                    "group by b.id, c.id, c.name, b.title\n";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long productid = resultSet.getLong("id");
                String name = resultSet.getString("title");
                Object categoryObj = resultSet.getObject("category");
                String imgUrl = resultSet.getString("imgUrl");
                Integer salary = resultSet.getInt("salary");
                Category category = new Gson().fromJson(categoryObj.toString(), Category.class);
                Product product = Product.builder()
                        .id(productid)
                        .name(name)
                        .category(category)
                        .imgUrl(imgUrl)
                        .salary(salary)
                        .build();
                return product;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static Boolean updateProduct(Product product) {
        try {
            Connection connection = DbConnection.getConnection();
            String updateBook = "update product set " +
                    "title=?, " +
                    "salary=?, " +
                    "category_id=?, " +
                    "\"imgUrl\"=?  where id= ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(updateBook);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getSalary());
            preparedStatement.setLong(3, product.getCategoryId());
            preparedStatement.setString(4, product.getImgUrl());
            preparedStatement.setLong(5, product.getId());
            int executeUpdate = preparedStatement.executeUpdate();;
            return executeUpdate == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
