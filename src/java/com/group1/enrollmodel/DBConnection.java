/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group1.enrollmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kushal
 */
public class DBConnection {
    private static Connection conn = null;
    public static Connection connection(){
        String url = "jdbc:sqlite:C:\\Users\\Kushal\\Documents\\NetBeansProjects\\EnrollmentApp\\enrollment.db";
//        try {
//            Class.forName("org.sqlite.JDBC");
//            conn = DriverManager.getConnection(url);
//            System.out.println("Connected");
//            
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return conn;

        
        if(conn == null){
            try {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection(url);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
       
    
    
    }
}
