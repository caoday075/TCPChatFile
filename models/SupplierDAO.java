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
import service.MyConnection;

/**
 *
 * @author SE130531
 */
public class SupplierDAO {

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;   
  
    
    public SupplierDAO() {
    }

    public List<SupplierDTO> getAllSupp() throws Exception {
        List<SupplierDTO> list = null;
        String code = null;
        String name = null;
        String address = null;
        boolean collo = true;
        SupplierDTO dto = null;

        try {
            conn = MyConnection.getMyConnection();
            String sql = "SELECT * From Suppliers";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                code = rs.getString("SupCode");
                name = rs.getString("SupName");
                address = rs.getString("Address");
                collo = rs.getBoolean("colloborating");
                dto = new SupplierDTO(code, name, address, collo);
                list.add(dto);
            }                
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean addNewSupplier(String code, String name, String address, boolean collo) throws Exception {
        boolean flag = true;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Insert Into Suppliers Values(?, ?, ?, ?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, code);
            preStm.setString(2, name);
            preStm.setString(3, address);
            preStm.setBoolean(4, collo);
            flag = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return flag;
    }
    
    public boolean updateSupplier(String code, String name, String address, boolean collo) throws Exception {
        boolean flag = true;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "UPDATE Suppliers SET SupName = ?, Address = ?, colloborating = ? WHERE SupCode = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, name);
            preStm.setString(2, address);
            preStm.setBoolean(3, collo);
            preStm.setString(4, code);
            flag = preStm.executeUpdate() > 0;            
        } finally {
            closeConnection();
        }
        return flag;
    }    
    
    public boolean deleteSupplier(String code) throws Exception {
        boolean flag = true;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "DELETE from Suppliers WHERE supCode = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, code);
            flag = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return flag;
    }
    
    public boolean deleteSupplier2(String suppCode, String itemCode) throws Exception {
        boolean flag = true;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "DELETE from Suppliers WHERE supCode = ?"
                    + "DELETE from Items Where itemCode = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, suppCode);
            preStm.setString(2, itemCode);
            flag = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return flag;
    }
    
    public boolean isCodeDuplicate(String code, String table, String feild) throws Exception {
        String sql = "Select " + feild + " From " + table + " Where " + feild + " = ?";
        try {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, code);
            rs = preStm.executeQuery();
            return rs.next();                    
        } finally {
            closeConnection();
        }
    }
   
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
