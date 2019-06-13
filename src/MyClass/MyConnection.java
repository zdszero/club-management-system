/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClass;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 13359
 */
public class MyConnection {
    public static Connection getConncetion(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull&serverTimezone=GMT","root","Dzf1512807741_");
            conn.setCatalog("league_mgdb");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}
