/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Database.DBConnManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author gal sajja
 */
public class inventoryConDAO {
    
    private DBConnManager dbConnManager = null;

    public inventoryConDAO() {
        dbConnManager = new DBConnManager();
    }
    public boolean addRecord(inventoryCon inv){
        boolean result = false;
	Connection dbConn = null;
        
 try {
            dbConn = dbConnManager.connect();

            Statement st = dbConn.createStatement();

            String query = "insert into `airconditionmanagementsystem`.`item` (itemNo,itemName,type,weight,price) values('"+inv.getItemNo()+"' , '"+inv.getItemName()+"' , '"+inv.getType()+"' , '"+inv.getWeight()+"' , '"+inv.getPrice()+"')";
            
            
            System.out.println(query);
              int val = st.executeUpdate(query);
            if (val == 1) {
                result = true;
            } else {
                result = false;
            }           

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "Insert query failed");

            result = false;
        }finally{
            dbConnManager.con_close(dbConn);
        }        
        return result;
}

    public Vector jTable1() {
        
        Vector<Vector<String>> jTable1Vector = null;
	Connection dbConn = null;
    
        
         try {
            dbConn = dbConnManager.connect();
            Statement st = dbConn.createStatement();            
             String query = "SELECT itemNo,itemName,type,weight,price FROM item";
              ResultSet rs = st.executeQuery(query);
             
              jTable1Vector = new Vector<Vector<String>>();
            
               while (rs.next()) {
                Vector<String> inventoryDetails = new Vector<String>();
                inventoryDetails.add(rs.getString(1)); 
                inventoryDetails.add(rs.getString(2)); 
                inventoryDetails.add(rs.getString(3));
                inventoryDetails.add(rs.getString(4));
                inventoryDetails.add(rs.getString(5));
              //  inventoryDetails.add(rs.getString(6));
                
                jTable1Vector.add(inventoryDetails);
               }
         }
         catch (SQLException sQLException) {
           
        } 
         finally {
            dbConnManager.con_close(dbConn);
         }
        return jTable1Vector;
         
    }
    
    
     public boolean deleteRecord(inventoryCon inv){
        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement st=dbConn.createStatement();

            
            String query = "delete from `airconditionmanagementsystem`.`item`   where `item`.`itemNo` = '"+inv.getItemNo()+"'";
            
            System.out.println(query);

            int val = st.executeUpdate(query);
            if (val == 1) {
                result = true;
            } 
            
            else {
                result = false;
            }           

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Insert query failed");

            result = false;
        }
        
        finally{
            dbConnManager.con_close(dbConn);
        }        
        return result;

     }

    public Connection tableToText() {
        Connection dbConn = null;
        dbConn = dbConnManager.connect();
        return dbConn;

    }

    

    public boolean updateRecord(inventoryCon inv) {

         boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement st=dbConn.createStatement();
    
            String query = "update `airconditionmanagementsystem`.`item`   set `item`.`itemName` = '"+inv.getItemName()+"',`item`.`type` = '"+inv.getType()+"',`item`.`weight` = '"+inv.getWeight()+"',`item`.`price` = '"+inv.getPrice()+"'   where `item`.`itemNo` = '"+inv.getItemNo()+"'";
            
             System.out.println(query);

            int val = st.executeUpdate(query);
            if (val == 1) {
                result = true;
            } else {
                result = false;
            }           

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "Insert query failed");

            result = false;
        }
        
        finally{
            dbConnManager.con_close(dbConn);
        }        
        return result;

        
    }
    
    
     public Vector searchItem(String search) throws SQLException {

        Vector<Vector<String>> itemDetailsVector = null;
	Connection dbConn = null;

        dbConn = dbConnManager.connect();
        try {
            
            String sql = "select * from `airconditionmanagementsystem`.`item`  where `item`.`itemNo` = '"+search+"' or `item`.`itemName` = '"+search+"' or `item`.`type` = '"+search+"' or `item`.`weight` = '"+search+"' or `item`.`price` = '"+search+"'";
           
            Statement st=dbConn.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            itemDetailsVector = new Vector<Vector<String>>();
            
            while (rs.next()) {
                Vector<String> itemDetails = new Vector<String>();
                itemDetails.add(rs.getString("itemNo")); 
                itemDetails.add(rs.getString("itemName"));
                itemDetails.add(rs.getString("type"));
                itemDetails.add(rs.getString("weight"));
                itemDetails.add(rs.getString("price"));
                
                itemDetailsVector.add(itemDetails);
            }

        } 
        
        catch (SQLException sQLException) {
            System.out.println(sQLException + "Select query failed");
        }
            return itemDetailsVector;
    }
    
}
