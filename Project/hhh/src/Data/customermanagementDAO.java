/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Database.DBConnManager;
import GUI.CustomerMan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author gal sajja
 */
public class customermanagementDAO {
    
    private DBConnManager dbConnManager = null;
    
    public customermanagementDAO() {
        dbConnManager = new DBConnManager();
    }

    public boolean addRecord(customermanagement cust) {
         boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            
            String query = "insert into `airconditionmanagementsystem`.`customer`(`customer`.`custID`,`customer`.`fname`,`customer`.`lname`,`customer`.`address`,`customer`.`email` ,`customer`.`contact`) values('"+cust.getCustId()+"' , '"+cust.getfname()+"' , '"+cust.getlname()+"' , '"+cust.getaddress()+"' , '"+cust.getemail()+"' , '"+cust.getcontactno()+"')";
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);
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
     public boolean deleteRecord(customermanagement cust){
        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


            String query = "delete from `airconditionmanagementsystem`.`customer`  where `customer`.`custID` = '"+cust.getCustId()+"' ";
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);
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

   public boolean updateRecord(customermanagement cust){
        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


            
            String query = "update `airconditionmanagementsystem`.`customer`  set `customer`.`fname` = '"+cust.getfname()+"',`customer`.`lname` = '"+cust.getlname()+"',`customer`.`address` = '"+cust.getaddress()+"',`customer`.`email` = '"+cust.getemail()+"',`customer`.`contact` = '"+cust.getcontactno()+"' where `customer`.`custID` = '"+cust.getCustId()+"'";
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);
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
    
    public ResultSet searchRecord(customermanagement cust){
        
	Connection dbConn = null;
        ResultSet val = null;
        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

   
            String query = "select `customer`.`custID`,`customer`.`fname`,`customer`.`lname`,`customer`.`address`,`customer`.`email`,`customer`.`contact` from `airconditionmanagementsystem`.`customer`  where `customer`.`custID` = '"+cust.getCustId()+"'";
            
            System.out.println(query);

            val = stmt.executeQuery(query);
           
                       

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Insert query failed");

        }finally{
            //dbConnManager.con_close(dbConn);
        }
        System.out.println("hhhhh");
        return val;

        
    }
    public boolean createBill(customermanagement cust) {
         boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            
            String query = "insert into `airconditionmanagementsystem`.`bill`(`bill`.`billNo`,`bill`.`custID`,`bill`.`address`) values('"+cust.getCustId()+"' , '"+cust.getfname()+"' , '"+cust.getlname()+"' , '"+cust.getaddress()+"' , '"+cust.getemail()+"' , '"+cust.getcontactno()+"')";
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);
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
    

     public Vector custDetails() {

        Vector<Vector<String>> custDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT `customer`.`custID`,`customer`.`fname`,`customer`.`lname`,`customer`.`address`,`customer`.`contact`,`customer`.`email`"+
                    "FROM `airconditionmanagementsystem`.`customer`";

            ResultSet rs = stmt.executeQuery(query);
            custDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> custData = new Vector<String>();
                custData.add(rs.getString(1)); 
                custData.add(rs.getString(2)); 
                custData.add(rs.getString(3));
                custData.add(rs.getString(4));
                custData.add(rs.getString(5));
                custData.add(rs.getString(6));
                custDetailsVector.add(custData);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return custDetailsVector;
    }

    
    

    public Vector<Vector<String>> searchcustdetails(String search) {
           
        Vector<Vector<String>> custdetailsvector = null;
	Connection dbConn = null;

        dbConn = dbConnManager.connect();
        try {
            
            String sql = "select * from `airconditionmanagementsystem`.`customer` where `customer`.`custID` = ?";
            PreparedStatement pst = dbConn.prepareStatement(sql);
            pst.setString(1, search);
            ResultSet rs = pst.executeQuery();
            custdetailsvector = new Vector<Vector<String>>();
            
            while (rs.next()) {
                System.out.println("0000");
                Vector<String> custData = new Vector<String>();
                custData.add(rs.getString(1)); 
                custData.add(rs.getString(2));
                custData.add(rs.getString(3));
                custData.add(rs.getString(4));
                custData.add(rs.getString(5));
                //custData.add(rs.getString(6));
                custdetailsvector.add(custData);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        }
        
        try {
            
            String sql = "select * from `airconditionmanagementsystem`.`customer` where `customer`.`fname` = ?";
            PreparedStatement pst = dbConn.prepareStatement(sql);
            pst.setString(1, search);
            ResultSet rs = pst.executeQuery();
            custdetailsvector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> custData = new Vector<String>();
                custData.add(rs.getString(1)); 
                custData.add(rs.getString(2)); 
                custData.add(rs.getString(3));
                custData.add(rs.getString(4));
                custData.add(rs.getString(5));
                //custData.add(rs.getString(6));
                
                custdetailsvector.add(custData);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } 
        
//        try {
//            
//            String sql = "select * from `airconditionmanagementsystem`.`customer` where `customer`.`lname` = ?";
//            PreparedStatement pst = dbConn.prepareStatement(sql);
//            pst.setString(1, search);
//            ResultSet rs = pst.executeQuery();
//            custdetailsvector = new Vector<Vector<String>>();
//
//            while (rs.next()) {
//                Vector<String> custData = new Vector<String>();
//                custData.add(rs.getString(1)); 
//                custData.add(rs.getString(2)); 
//                custData.add(rs.getString(3));
//                custData.add(rs.getString(4));
//                custData.add(rs.getString(5));
//                custData.add(rs.getString(6));
//                custdetailsvector.add(custData);
//            }
//
//        } catch (SQLException sQLException) {
//            System.out.println(sQLException + "-----------Select query failed");
//        } 
//        
//        try {          
//
//            String sql = "select * from `airconditionmanagementsystem`.`customer` where `customer`.`address` = ?";
//            PreparedStatement pst = dbConn.prepareStatement(sql);
//            pst.setString(1, search);
//            ResultSet rs = pst.executeQuery();
//            custdetailsvector = new Vector<Vector<String>>();
//
//            while (rs.next()) {
//                Vector<String> custData = new Vector<String>();
//                custData.add(rs.getString(1)); 
//                custData.add(rs.getString(2)); 
//                custData.add(rs.getString(3));
//                custData.add(rs.getString(4));
//                custData.add(rs.getString(5));
//                custData.add(rs.getString(6));
//                custdetailsvector.add(custData);
//            }
//
//        } catch (SQLException sQLException) {
//            System.out.println(sQLException + "-----------Select query failed");
//        } 
//        try {
//            
//           String sql = "select * from `airconditionmanagementsystem`.`customer` where `customer`.`contact` = ?";
//            PreparedStatement pst = dbConn.prepareStatement(sql);
//            pst.setString(1, search);
//            ResultSet rs = pst.executeQuery();
//            custdetailsvector = new Vector<Vector<String>>();
//
//            while (rs.next()) {
//                Vector<String> custData = new Vector<String>();
//                custData.add(rs.getString(1)); 
//                custData.add(rs.getString(2)); 
//                custData.add(rs.getString(3));
//                custData.add(rs.getString(4));
//                custData.add(rs.getString(5));
//                custData.add(rs.getString(6));
//                custdetailsvector.add(custData);
//            }
//
//        } catch (SQLException sQLException) {
//            System.out.println(sQLException + "-----------Select query failed");
//        } 
//         try {
//            
//           String sql = "select * from `airconditionmanagementsystem`.`customer` where `customer`.`email` = ?";
//            PreparedStatement pst = dbConn.prepareStatement(sql);
//            pst.setString(1, search);
//            ResultSet rs = pst.executeQuery();
//            custdetailsvector = new Vector<Vector<String>>();
//
//            while (rs.next()) {
//                Vector<String> custData = new Vector<String>();
//                custData.add(rs.getString(1)); 
//                custData.add(rs.getString(2)); 
//                custData.add(rs.getString(3));
//                custData.add(rs.getString(4));
//                custData.add(rs.getString(5));
//                custData.add(rs.getString(6));
//                custdetailsvector.add(custData);
//            }
//
//        } catch (SQLException sQLException) {
//            System.out.println(sQLException + "-----------Select query failed");
//        } 
         
        finally {
            dbConnManager.con_close(dbConn);
        }
        return custdetailsvector;
    }
    
    public Connection tableToTextField(){
        Connection dbConn = null;
        CustomerMan cust = new CustomerMan();
        dbConn = dbConnManager.connect();
        return dbConn;
    }

    private static class cust {

        public cust() {
        }
    }
    
}
