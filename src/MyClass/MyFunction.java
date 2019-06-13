/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClass;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author 13359
 */
public class MyFunction {

    public static boolean authentication(int status, String str1, String str2) {
        //Admin autentication
        if (status == 1) {
            try {
                Connection conn = MyConnection.getConncetion();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM `administrator` WHERE username = ? AND password = ?");
                ps.setString(1, str1);
                ps.setString(2, str2);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }

            } catch (SQLException ex) {
                Logger.getLogger(MyFunction.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Student authentication
        } else if (status == 2) {
            try {
                Connection conn = MyConnection.getConncetion();
                PreparedStatement ps = conn.prepareStatement("SELECT `Sname`, `Sno` FROM `student` WHERE Sname = ? AND Sno = ?");
                ps.setString(1, str1);
                ps.setString(2, str2);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }

            } catch (SQLException ex) {
                Logger.getLogger(MyFunction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (status == 3) {
            try {
                Connection conn = MyConnection.getConncetion();
                PreparedStatement ps = conn.prepareStatement("SELECT Cname,CPassword FROM club WHERE Cname = ? AND CPassword = ?");
                ps.setString(1, str1);
                ps.setString(2, str2);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }

            } catch (SQLException ex) {
                Logger.getLogger(MyFunction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public static ImageIcon zoomImage(JLabel jLabel, byte[] file) {
        ImageIcon icon1 = new ImageIcon(file);
        Image img1 = icon1.getImage();
        Image img2 = img1.getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(img2);
        return icon2;
    }

    public static int rowCount(String tableName) {
        Connection conn = MyConnection.getConncetion();
        Statement stmt = null;
        int count = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(ID) FROM " + tableName + " WHERE 1");
            if (rs.next()) {
                count = rs.getInt(1);
            } else {
                System.out.println("程序有错！");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    
    //这个就写得有点蠢了
    public static boolean if_student_is_in_club(String sname,String cname){
        try {
                Connection conn = MyConnection.getConncetion();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM `member` WHERE Sname = ? AND Cname = ?"); //为什么写成stmt + "" 会报错
                ps.setString(1, sname);
                ps.setString(2, cname);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }

            } catch (SQLException ex) {
                Logger.getLogger(MyFunction.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
    }
    
    public static boolean if_acticity_exist(String aname){
        try {
                Connection conn = MyConnection.getConncetion();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM activity WHERE AName = ?"); //为什么写成stmt + "" 会报错
                ps.setString(1, aname);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }

            } catch (SQLException ex) {
                Logger.getLogger(MyFunction.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
    }
    
    public static int getMemberNum(String cname){
        Connection conn = MyConnection.getConncetion();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT COUNT(*) FROM cs WHERE CName = ? AND CSFlag = '1'");
            ps.setString(1, cname);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static boolean if_is_in_table(String table,String column,String str){
        Connection conn = MyConnection.getConncetion();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM " + table + " WHERE " + column + " =  ?");
            ps.setString(1, str);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
