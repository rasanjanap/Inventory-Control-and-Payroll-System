/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gal sajja
 */
public class DBConnManager {
    private String sourceURL;
    public DBConnManager() {
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                sourceURL = new String("jdbc:mysql://localhost:3307/airconditionmanagementsystem");
        } catch (ClassNotFoundException classNotFoundException) {
                System.out.println(classNotFoundException + "-----------Unable to load database driver classes");
           }
       }
    
    public Connection connect(){
        Connection dbConn = null;
        
        try {
                dbConn = DriverManager.getConnection(sourceURL, "root","root");
                
        } catch (SQLException sQLException) {
                System.out.println(sQLException + "-----------DB connection failure");
            }
        
            return dbConn;
        }
    
    public void con_close(Connection dbConn) {
            
        try {
                dbConn.close();
        } catch (SQLException sQLException) {
                System.out.println(sQLException + "-----------DB connection closing failure");
            }
        }
}
