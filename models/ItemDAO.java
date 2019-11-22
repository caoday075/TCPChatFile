/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import service.MyConnection;

/**
 *
 * @author SE130531
 */
public class ItemDAO {

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public ItemDAO() {
    }

    public List<ItemDTO> getAllItem() throws Exception {
        List<ItemDTO> list = null;
        String itemCode = null;
        String name = null;
        String suppCode;
        SupplierDTO suppDTO = null;
        String unit = null;
        int price = 0;
        boolean supplying = false;
        ItemDTO dto = null;

        try {
            conn = MyConnection.getMyConnection();
            String sql = "SELECT * From Items";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                itemCode = rs.getString("itemCode");
                name = rs.getString("itemName");
                suppCode = rs.getString("supCode");     
                        
                unit = rs.getString("unit");
                price = rs.getInt("price");
                supplying = rs.getBoolean("supplying");
                dto = new ItemDTO(itemCode, name, suppCode, unit, price, supplying);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean addNewItem(String code, String name, String supCode, String unit, int price, boolean supplying) throws Exception {
        boolean flag = true;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "INSERT into Items Values(?, ?, ?, ?, ?, ?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, code);
            preStm.setString(2, name);
            preStm.setString(3, supCode);
            preStm.setString(4, unit);
            preStm.setInt(5, price);
            preStm.setBoolean(6, supplying);
            flag = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return flag;
    }
    
    public boolean updateItem(String code, String name, String supCode, String unit, int price, boolean supplying) throws Exception {
        boolean flag = true;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "UPDATE Items SET itemName = ?, supCode = ?, unit = ?, price = ?, supplying = ? WHERE itemCode = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, name);
            preStm.setString(2, supCode);
            preStm.setString(3, unit);
            preStm.setInt(4, price);
            preStm.setBoolean(5, supplying);
            preStm.setString(6, code);
            flag = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return flag;
    }
    
    public boolean deleteItem(String code) throws Exception {
        boolean flag = true;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "DELETE From Items Where itemCode = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, code);
            flag = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return flag;        
    }
    
//    public boolean isCodeDuplicate(String code) throws Exception {
//        String sql = "Select code From Suppliers Where Code = ?";
//        try {
//            conn = MyConnection.getMyConnection();
//            preStm = conn.prepareStatement(sql);
//            preStm.setString(1, code);
//            rs = preStm.executeQuery();
//            return rs.next();                    
//        } finally {
//            closeConnection();
//        }
//    }
    
    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
