/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS TUF
 */
public class dbconnection {
    Connection conn;
    public dbconnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/csa_fppbo", "root", "");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
}
