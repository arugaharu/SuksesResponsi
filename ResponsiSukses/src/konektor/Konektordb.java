/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konektor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lab Informatika
 */
public class Konektordb {
    Connection cn;
     public static Connection BukaKoneksi(){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/db_lomba", "root", "");
           return cn;
       } catch (ClassNotFoundException | SQLException e) {
           JOptionPane.showMessageDialog(null, e);
           return null;
       }
   }
}
