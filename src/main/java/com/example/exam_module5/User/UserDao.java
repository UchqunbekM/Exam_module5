package com.example.exam_module5.User;

import com.example.exam_module5.Database.DbConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


    public static List<User> getAllUsers() {

       List<User> userList = new ArrayList<>();

        try ( Connection connection = DbConnection.getConnection()){

            PreparedStatement ps  = connection.prepareStatement("select * from users");

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                User user = new User();
               Long id = Long.valueOf(resultSet.getString("id"));
                String username = resultSet.getString("username");
                String pasword= resultSet.getString("password");
                String pasword1= resultSet.getString("email");
                user.setId(id);
                user.setUsername(username);
                user.setPassword(pasword);
                user.setEmail(pasword1);

           userList.add(user);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return userList;
    }
    public static List<User> getAllByIDUsers(int id) {
        List<User> userList = new ArrayList<>();
        try ( Connection connection = DbConnection.getConnection()){
            PreparedStatement ps  = connection.prepareStatement("select * from users where id=?");

            ps.setLong(1,id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                Long idd = Long.valueOf(resultSet.getString("id"));
                String username = resultSet.getString("username");
                String pasword= resultSet.getString("password");
                String pasword1= resultSet.getString("email");

                user.setId(idd);
                user.setUsername(username);
                user.setPassword(pasword);
                user.setEmail(pasword1);
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
    public static int save_user(User e){
        int status=0;
        try{
            Connection con=DbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "insert into users(username, password,email,role) values (?,?,?,?)");
            ps.setString(1,e.getUsername());
            ps.setString(2,e.getPassword());
            ps.setString(3,e.getEmail());
            ps.setString(4, e.getRole());
            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }
    public static int deleteuser(int id) {
        int status=0;
        Connection connection1=DbConnection.getConnection();
        try {
            PreparedStatement ps=connection1.prepareStatement("delete from users where id=?");
            ps.setInt(1,id);
            status=ps.executeUpdate();
            connection1.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return status;
    }
    public static boolean update(int id, String username, String passwvord, String email) {
        int status = 0;
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update users set username=?, password=?, email=? where id=?");
            ps.setString(1, username);
            ps.setString(2, passwvord);
            ps.setString(3, email);
            ps.setInt(4,id);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
return status>0;
    }

}
