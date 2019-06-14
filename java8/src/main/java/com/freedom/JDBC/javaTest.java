package com.freedom.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Allen Liu
 * @Description:
 * @Date: Created in 17:13 2018/2/23
 * @Modified By:
 **/
public class javaTest {
    public static void main(String[] args) {
        Connection conn = DBUtils.getConnection();
        String s = " " + "select * from menu";
//        PreparedStatement pst = null;
        try {
            PreparedStatement pst = conn.prepareStatement(s);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("id") + " " +
                        rs.getString("name"));
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
