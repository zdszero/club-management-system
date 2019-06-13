/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 13359
 */
public class TableFunction {

    public static void fillPostTable(JTable jTable, String valueToSearch) {
        Connection conn = MyConnection.getConncetion();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT `ANHost`, `ANTitle`, `ANContent`, `ANDate` FROM `announcement` WHERE concat(`ANHost`, `ANTitle`, `ANContent`, `ANDate`)LIKE ?"); //这里不能写成'?'
            ps.setString(1, "%" + valueToSearch + "%");

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();

            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getString(1); //rs的下标从1开始，getXXX or setXXX
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getDate(4);
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TableFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void fillActivityTable(JTable jTable, String valueToSearch) {
        Connection conn = MyConnection.getConncetion();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT `AName`, `AHost`, `ATime`, `Address`, `AContent`, `Range`, `Max_num`, `AStatus` FROM `activity`"
                     + " WHERE concat(`AName`, `AHost`, `ATime`, `Address`, `AContent`, `Range`, `Max_num`, `AStatus`)LIKE ?"); 
            ps.setString(1, "%" + valueToSearch + "%");

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();

            while (rs.next()) {
                Object[] row = new Object[8];
                row[0] = rs.getString(1); //rs的下标从1开始，getXXX or setXXX
                row[1] = rs.getString(2);
                row[2] = rs.getDate(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getInt(7);
                row[7] = rs.getInt(8);
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TableFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void fillClubTable(JTable jTable, String valueToSearch) {
        Connection conn = MyConnection.getConncetion();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT `CName`, `COwner`, `CStart_date`, `CMember_num`, `CActivity_num`, `CAnnoucement_num`, `CContact`, `CDescription`, `CStatus`, `CPassword` FROM `club` WHERE concat( `CName`, `COwner`, `CStart_date`, `CMember_num`, `CActivity_num`, `CAnnoucement_num`, `CContact`, `CDescription`, `CStatus`, `CPassword`)LIKE ?"); //这里不能写成'?'
            ps.setString(1, "%" + valueToSearch + "%");

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();

            while (rs.next()) {
                Object[] row = new Object[10];
                row[0] = rs.getString(1); //rs的下标从1开始，getXXX or setXXX
                row[1] = rs.getString(2); //rowk恶意表示为任何类型
                row[2] = rs.getDate(3);
                row[3] = rs.getInt(4);
                row[4] = rs.getInt(5);
                row[5] = rs.getInt(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                row[8] = rs.getInt(9);
                row[9] = rs.getString(10);
                
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TableFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void fillBrowseClubTable(JTable jTable, String valueToSearch) {
        Connection conn = MyConnection.getConncetion();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT CName,COwner,CStart_date,CContact,CDescription FROM club WHERE concat(CName,COwner,CStart_date,CContact,CDescription)LIKE ?"); //这里不能写成'?'
            ps.setString(1, "%" + valueToSearch + "%");

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();

            while (rs.next()) {
                Object[] row = new Object[5];
                row[0] = rs.getString(1); 
                row[1] = rs.getString(2);
                row[2] = rs.getDate(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TableFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void fillConfirmTable(JTable jTable, String clubName) {
        Connection conn = MyConnection.getConncetion();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT `SName`, `SNo`, `Sex` FROM member WHERE `CName` = ?"); //这里不能写成'?'
            ps.setString(1, clubName);

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();

            while (rs.next()) {
                Object[] row = new Object[3];
                row[0] = rs.getString(1); 
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TableFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void fillStudentTable1(JTable jTable, String valueToSearch) {
        Connection conn = MyConnection.getConncetion();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT `AName`, `AHost` FROM `activity` WHERE concat(`AName`, `AHost`)LIKE ?"); //这里不能写成'?'
            ps.setString(1, "%" + valueToSearch + "%");

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();

            while (rs.next()) {
                Object[] row = new Object[2];
                row[0] = rs.getString(1); //rs的下标从1开始，getXXX or setXXX
                row[1] = rs.getString(2);
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TableFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void fillStudentTable2(JTable jTable, String valueToSearch) {
        Connection conn = MyConnection.getConncetion();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT `ANTitle`, `ANHost` FROM `announcement` WHERE concat(`ANTitle`, `ANHost`)LIKE ?"); //这里不能写成'?'
            ps.setString(1, "%" + valueToSearch + "%");

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();

            while (rs.next()) {
                Object[] row = new Object[2];
                row[0] = rs.getString(1); //rs的下标从1开始，getXXX or setXXX
                row[1] = rs.getString(2);
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TableFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void fillClubTable1(JTable jTable,String cname){
        Connection conn = MyConnection.getConncetion();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT `AName`, `ATime`, `Address`, `Range`, `Max_num` FROM `activity` WHERE `AHost` = ?"); //这里不能写成'?'
            ps.setString(1,cname);

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();

            while (rs.next()) {
                Object[] row = new Object[5];
                row[0] = rs.getString(1); //rs的下标从1开始，getXXX or setXXX
                row[1] = rs.getDate(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getInt(5);
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TableFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void fillClubTable2(JTable jTable,String cname){
        Connection conn = MyConnection.getConncetion();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT `ANTitle`, `ANContent`, `ANDate` FROM `announcement` WHERE `ANHost` = ?"); //这里不能写成'?'
            ps.setString(1,cname);

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();

            while (rs.next()) {
                Object[] row = new Object[3];
                row[0] = rs.getString(1); 
                row[1] = rs.getString(2);
                row[2] = rs.getDate(3);
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TableFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void fillCSTable(JTable jTable,String cname){
        Connection conn = MyConnection.getConncetion();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT  `SName`, `SNo`,`Sex`,`In_Time` FROM `cs` WHERE `Cname` = ?"); 
            ps.setString(1,cname);

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();

            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getString(1); 
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getDate(4);
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TableFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void fillCSTable2(JTable jTable,String valueToSearch){
        Connection conn = MyConnection.getConncetion();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT  `CName`, `SName`, `SNo`, `Sex`,`In_Time`, `CSFlag` FROM `cs` WHERE concat(`CName`, `SName`, `SNo`, `Sex`,`In_Time`, `CSFlag`) LIKE ?"); 
            ps.setString(1,"%" + valueToSearch + "%");

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();

            while (rs.next()) {
                Object[] row = new Object[6];
                row[0] = rs.getString(1); 
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getDate(5);
                row[5] = rs.getInt(6);
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TableFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void fillExpenditureTable(JTable jTable){
        Connection conn = MyConnection.getConncetion();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT `EHost`, `EAmount`, `EDescription`, `ETime`, `EStatus` FROM `expenditure` WHERE 1"); 

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();

            while (rs.next()) {
                Object[] row = new Object[5];
                row[0] = rs.getString(1); 
                row[1] = rs.getDouble(2);
                row[2] = rs.getString(3);
                row[3] = rs.getDate(4);
                row[4] = rs.getInt(5);
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TableFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
