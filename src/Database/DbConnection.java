/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author STUDENTS
 */

public class DbConnection {
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    public DbConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/matrimony_db","root","");
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setData(String query){
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public ResultSet getData(String query){
        try {
           rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    
    
    
}
