package com.lgd.dao;

import com.lgd.pojo.User;
import java.sql.*;

public class UserDao {

    public User getUserById(String id) {
        User user = new User();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/javaweb-test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT",
                            "root", "1328910");
            String sql = "select * from user where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            ResultSet rset = preparedStatement.executeQuery();
            while (rset.next()){
                user.setId(rset.getString(1));
                user.setName(rset.getString(2));
                user.setPwd(rset.getString(3));
            }
            rset.close();
            preparedStatement.close();
            connection.close();}
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return user;
    }
}
