/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.sql.*;
//import com.mysql.jdbc.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Database2 implements Runnable {

    String myDriver = "com.mysql.cj.jdbc.Driver";
    String myUrl = "jdbc:mysql://localhost:3306/azdb";

    Connection conn;
    Statement stmt;

    @Override
    public void run() {

        try {
            System.out.println("aslaa");
            Class.forName(myDriver);
            conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Database2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addDatabase(String st) {
        try {

            String query1 = "insert into test(value) values ('" + st + "')";
            
            stmt.execute(query1);
           
            
        } catch (SQLException ex) {
            Logger.getLogger(Database2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("aldaa2");
            
        }
    }

}
