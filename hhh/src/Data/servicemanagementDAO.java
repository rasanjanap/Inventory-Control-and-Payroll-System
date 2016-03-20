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
public class servicemanagementDAO {
    
    private DBConnManager dbConnManager = null;

    public servicemanagementDAO() {
        dbConnManager = new DBConnManager();
    }
    public boolean addRecord(servicemanagement sev){
        boolean result = false;
	Connection dbConn = null;
        
        try{
               dbConn = dbConnManager.connect();

            Statement st = dbConn.createStatement();
            
            String query = "insert into service (serviceID,type) values('"+sev.getServiceId()+"' , '"+sev.getType()+"')";
        
         System.out.println(query);
              int val = st.executeUpdate(query);
            if (val == 1) {
                result = true;
            } else {
                result = false;
            }           

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Insert query failed");

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
             String query = "SELECT serviceID , type from service";
              ResultSet rs = st.executeQuery(query);
             
              jTable1Vector = new Vector<Vector<String>>();
            
               while (rs.next()) {
                Vector<String> serviceDetails = new Vector<String>();
                serviceDetails.add(rs.getString("serviceID")); 
                serviceDetails.add(rs.getString("type")); 
              //  inventoryDetails.add(rs.getString(6));
                
                jTable1Vector.add(serviceDetails);
               }
         }
         catch (SQLException sQLException) {
           
        } 
         finally {
            dbConnManager.con_close(dbConn);
         }
        return jTable1Vector;
         
    }
    
        public boolean deleteRecord(servicemanagement sev){
        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement st=dbConn.createStatement();

            
            String query = "delete from service  where serviceID = '"+sev.getServiceId()+"'";
            
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
        public boolean updateRecord(servicemanagement sev) {

         boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement st=dbConn.createStatement();
    
            String query = "update `airconditionmanagementsystem`.`service`  set `service`.`type` = '"+sev.getType()+"' where `service`.`serviceID`='"+sev.getServiceId()+"';";
            
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

        Vector<Vector<String>> serviceDetailsVector = null;
	Connection dbConn = null;

        dbConn = dbConnManager.connect();
        try {
            
            String sql = "select * from `airconditionmanagementsystem`.`service` where `service`.`serviceID` = '"+search+"' or `service`.`type` = '"+search+"'";
           
            Statement st=dbConn.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            serviceDetailsVector = new Vector<Vector<String>>();
            
            while (rs.next()) {
                Vector<String> serviceDetails = new Vector<String>();
                serviceDetails.add(rs.getString("serviceID")); 
             
                serviceDetails.add(rs.getString("type"));
                
                
                
                serviceDetailsVector.add(serviceDetails);
            }

        } 
        
        catch (SQLException sQLException) {
            System.out.println(sQLException + "Select query failed");
        }
            return serviceDetailsVector;
    }
    
}
