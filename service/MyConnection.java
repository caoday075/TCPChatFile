/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author SE130531
 */
public class MyConnection {
    public static Connection getMyConnection() throws Exception {      
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");       
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=ItemDB","sa", "sa123456");
        return conn;
    }
}
