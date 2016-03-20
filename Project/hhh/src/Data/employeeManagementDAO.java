/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Database.DBConnManager;
import GUI.employeeMan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author gal sajja
 */
public class employeeManagementDAO {
    private DBConnManager dbConnManager = null;

    public employeeManagementDAO() {
        dbConnManager = new DBConnManager();
    }

    public boolean addRecord(employeeManagement emp){
        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

//            String query = "insert into `airconditionmanagementsystem`.`employee` values('"+emp.getEmpID()+"' , '"+emp.getFname()+"' , '"+emp.getLname()+"' , '"+emp.getDateOfBirth()+"' , '"+emp.getAddress()+"' , '"+emp.getEmpType()+"' , '"+emp.getPassword()+"' , '"+emp.getQualification()+"')";
//            
            String query = "insert into `airconditionmanagementsystem`.`employee`(`employee`.`empID`,`employee`.`fname`,`employee`.`lname`,`employee`.`address`,`employee`.`dateOfBirth`,`employee`.`type`,`employee`.`password`,`employee`.`qualific`,`employee`.`regDate`) values('"+emp.getEmpID()+"' , '"+emp.getFname()+"' , '"+emp.getLname()+"' , '"+emp.getAddress()+"' , '"+emp.getDateOfBirth()+"' , '"+emp.getEmpType()+"' , '"+emp.getPassword()+"' , '"+emp.getQualification()+"' , '"+emp.getRegDate()+"')";
            
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
    
    
    public boolean deleteRecord(employeeManagement emp){
        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

//            String query = "insert into `airconditionmanagementsystem`.`employee` values('"+emp.getEmpID()+"' , '"+emp.getFname()+"' , '"+emp.getLname()+"' , '"+emp.getDateOfBirth()+"' , '"+emp.getAddress()+"' , '"+emp.getEmpType()+"' , '"+emp.getPassword()+"' , '"+emp.getQualification()+"')";
//            
            String query = "delete from `airconditionmanagementsystem`.`employee`  where `employee`.`empID` = '"+emp.getEmpID()+"'";
            
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
    
    
    public boolean updateRecord(employeeManagement emp){
        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

//            String query = "insert into `airconditionmanagementsystem`.`employee` values('"+emp.getEmpID()+"' , '"+emp.getFname()+"' , '"+emp.getLname()+"' , '"+emp.getDateOfBirth()+"' , '"+emp.getAddress()+"' , '"+emp.getEmpType()+"' , '"+emp.getPassword()+"' , '"+emp.getQualification()+"')";
//            
            String query = "update `airconditionmanagementsystem`.`employee`  set `employee`.`fname` = '"+emp.getFname()+"',`employee`.`lname` = '"+emp.getLname()+"',`employee`.`address` = '"+emp.getAddress()+"',`employee`.`dateOfBirth` = '"+emp.getDateOfBirth()+"' ,`employee`.`type` = '"+emp.getEmpType()+"',`employee`.`password` = '"+emp.getPassword()+"',`employee`.`regDate` = '"+emp.getRegDate()+"' , `employee`.`qualific` = '"+emp.getQualification()+"'   where `employee`.`empID` = '"+emp.getEmpID()+"'";
            
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
    
//    public ResultSet searchRecord(employeeManagement emp){
//        
//	Connection dbConn = null;
//        ResultSet val = null;
//        try {
//            dbConn = dbConnManager.connect();
//
//            Statement stmt = dbConn.createStatement();
//
////            String query = "insert into `airconditionmanagementsystem`.`employee` values('"+emp.getEmpID()+"' , '"+emp.getFname()+"' , '"+emp.getLname()+"' , '"+emp.getDateOfBirth()+"' , '"+emp.getAddress()+"' , '"+emp.getEmpType()+"' , '"+emp.getPassword()+"' , '"+emp.getQualification()+"')";
////            
//            String query = "select `employee`.`empID`,`employee`.`fname`,`employee`.`lname`,`employee`.`address`,`employee`.`type`,`employee`.`password`,`employee`.`qualific` from `airconditionmanagementsystem`.`employee`  where `employee`.`empID` = '"+emp.getEmpID()+"'";
//            
//            System.out.println(query);
//
//            val = stmt.executeQuery(query);
//           
//                       
//
//        } catch (SQLException sQLException) {
//            System.out.println(sQLException + "-----------Insert query failed");
//
//        }finally{
//            //dbConnManager.con_close(dbConn);
//        }
//        return val;
//
//        
//    }
    
    public void checkHistory(employeeManagement emp){
        
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();
            
            String fname = emp.getFname();
            String lname = emp.getLname();
            String address = emp.getAddress();
            String birth = emp.getDateOfBirth();
            String empType = emp.getEmpType();
            String regDate = emp.getRegDate();
            String qualific = emp.getQualification();
            
            String description = "Inserting a new employee Details : " + fname + " " + lname +" " + address + " "+ birth +" " + empType +" " + regDate + " " + qualific;
            
            String query = "insert into `airconditionmanagementsystem`.`history` values('"+emp.getEmpID()+"' , '"+description+"')";
            
            System.out.println(query);

            stmt.executeUpdate(query);
                     

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------History query failed");

        }finally{
            dbConnManager.con_close(dbConn);
        }        

        
    }
    
    public void checkUpdateHistory(employeeManagement emp){
        
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();
            
            String fname = emp.getFname();
            String lname = emp.getLname();
            String address = emp.getAddress();
            String birth = emp.getDateOfBirth();
            String empType = emp.getEmpType();
            String regDate = emp.getRegDate();
            String qualific = emp.getQualification();
            
            String description = "Updating employee Details : " + fname + " " + lname +" " + address + " "+ birth +" " + empType +" " + regDate + " " + qualific;
            String query = "insert into `airconditionmanagementsystem`.`history` values('"+emp.getEmpID()+"' , '"+description+"' )";
            
            System.out.println(query);

            stmt.executeUpdate(query);
                     

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------History query failed");

        }finally{
            dbConnManager.con_close(dbConn);
        }        

        
    }
    
     public void checkDeletekHistory(employeeManagement emp){
        
	Connection dbConn = null;

        String name = null;
        String birth = null;
        String address = null;
        String type = null;
        String qualific = null;
        String regDate = null;
        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();
            
            String query1 = "select * from `airconditionmanagementsystem`.`employee` where `employee`.`empID`= '"+emp.getEmpID()+"'";
            Statement stmnt = dbConn.createStatement();
            ResultSet rs = stmnt.executeQuery(query1);
            while(rs.next()){
                name = rs.getString("fname");
                birth = rs.getString("dateOfBirth");
                address = rs.getString("address");
                type = rs.getString("type");
                qualific = rs.getString("qualific");
                regDate = rs.getString("regdate");
            }
            
            String description = "Deleting a record of employee Details :" + name + " " + birth + " " + address + " " + type + " " + qualific + " " + regDate;
            
            String query2 = "insert into `airconditionmanagementsystem`.`history` values('"+emp.getEmpID()+"' , '"+description+"' )";
            
            System.out.println(query2);

            stmt.executeUpdate(query2);
                     

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------History query failed");

        }finally{
            dbConnManager.con_close(dbConn);
        }        

        
    }
    
    
    
    public Vector empDetails() {

        Vector<Vector<String>> empDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT `employee`.`empID`,`employee`.`fname`,`employee`.`lname`,`employee`.`address`,`employee`.`dateOfBirth`,`employee`.`type`,`employee`.`qualific`,`employee`.`regDate`"+
                    "FROM `airconditionmanagementsystem`.`employee`";

            ResultSet rs = stmt.executeQuery(query);
            empDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> empData = new Vector<String>();
                empData.add(rs.getString(1)); 
                empData.add(rs.getString(2)); 
                empData.add(rs.getString(3));
                empData.add(rs.getString(4));
                empData.add(rs.getString(5));
                empData.add(rs.getString(6));
                empData.add(rs.getString(7));
                empData.add(rs.getString(8));
                empDetailsVector.add(empData);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return empDetailsVector;
    }
    
    public Vector historyDetails() {

        Vector<Vector<String>> historyDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * FROM `airconditionmanagementsystem`.`history`";

            ResultSet rs = stmt.executeQuery(query);
            historyDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> empData = new Vector<String>(); 
                empData.add(rs.getString("empID")); 
                empData.add(rs.getString("discription"));
                historyDetailsVector.add(empData);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------History query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return historyDetailsVector;
    }
    
    public Vector SearchempDetails(String search) throws SQLException {

        Vector<Vector<String>> empDetailsVector = null;
	Connection dbConn = null;

        dbConn = dbConnManager.connect();
        try {
            
            String sql = "select * from `airconditionmanagementsystem`.`employee` where `employee`.`empID` = '"+search+"' or `employee`.`fname` = '"+search+"' or `employee`.`lname` = '"+search+"' or `employee`.`type` = '"+search+"' or `employee`.`address` = '"+search+"'";
            //PreparedStatement pst = dbConn.prepareStatement(sql);
            Statement stmt = dbConn.createStatement();
            //pst.setString(1, search);
            //ResultSet rs = pst.executeQuery();
            ResultSet rs = stmt.executeQuery(sql);
            empDetailsVector = new Vector<Vector<String>>();
            
            while (rs.next()) {
                Vector<String> empData = new Vector<String>();
                empData.add(rs.getString(1)); 
                empData.add(rs.getString(2));
                empData.add(rs.getString(3));
                empData.add(rs.getString(5));
                empData.add(rs.getString(4));
                empData.add(rs.getString(6));
                empData.add(rs.getString(8));
                empData.add(rs.getString(9));
                empDetailsVector.add(empData);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        }
//        
//        try {
//            
//            String sql = "select * from `airconditionmanagementsystem`.`employee` where `employee`.`fname` = ?";
//            PreparedStatement pst = dbConn.prepareStatement(sql);
//            pst.setString(1, search);
//            ResultSet rs = pst.executeQuery();
//            empDetailsVector = new Vector<Vector<String>>();
//
//            while (rs.next()) {
//                Vector<String> empData = new Vector<String>();
//                empData.add(rs.getString(1)); 
//                empData.add(rs.getString(2)); 
//                empData.add(rs.getString(3));
//                empData.add(rs.getString(5));
//                empData.add(rs.getString(4));
//                empData.add(rs.getString(6));
//                empData.add(rs.getString(8));
//                empData.add(rs.getString(9));
//                empDetailsVector.add(empData);
//            }
//
//        } catch (SQLException sQLException) {
//            System.out.println(sQLException + "-----------Select query failed");
//        } 
//        
//        try {
//            
//            String sql = "select * from `airconditionmanagementsystem`.`employee` where `employee`.`lname` = ?";
//            PreparedStatement pst = dbConn.prepareStatement(sql);
//            pst.setString(1, search);
//            ResultSet rs = pst.executeQuery();
//            empDetailsVector = new Vector<Vector<String>>();
//
//            while (rs.next()) {
//                Vector<String> empData = new Vector<String>();
//                empData.add(rs.getString(1)); 
//                empData.add(rs.getString(2)); 
//                empData.add(rs.getString(3));
//                empData.add(rs.getString(5));
//                empData.add(rs.getString(4));
//                empData.add(rs.getString(6));
//                empData.add(rs.getString(8));
//                empData.add(rs.getString(9));
//                empDetailsVector.add(empData);
//            }
//
//        } catch (SQLException sQLException) {
//            System.out.println(sQLException + "-----------Select query failed");
//        } 
//        
//        try {          
//
//            String sql = "select * from `airconditionmanagementsystem`.`employee` where `employee`.`address` = ?";
//            PreparedStatement pst = dbConn.prepareStatement(sql);
//            pst.setString(1, search);
//            ResultSet rs = pst.executeQuery();
//            empDetailsVector = new Vector<Vector<String>>();
//
//            while (rs.next()) {
//                Vector<String> empData = new Vector<String>();
//                empData.add(rs.getString(1)); 
//                empData.add(rs.getString(2)); 
//                empData.add(rs.getString(3));
//                empData.add(rs.getString(5));
//                empData.add(rs.getString(4));
//                empData.add(rs.getString(6));
//                empData.add(rs.getString(8));
//                empData.add(rs.getString(9));
//                empDetailsVector.add(empData);
//            }
//
//        } catch (SQLException sQLException) {
//            System.out.println(sQLException + "-----------Select query failed");
//        } 
//        try {
//            
//           String sql = "select * from `airconditionmanagementsystem`.`employee` where `employee`.`type` = ?";
//            PreparedStatement pst = dbConn.prepareStatement(sql);
//            pst.setString(1, search);
//            ResultSet rs = pst.executeQuery();
//            empDetailsVector = new Vector<Vector<String>>();
//
//            while (rs.next()) {
//                Vector<String> empData = new Vector<String>();
//                empData.add(rs.getString(1)); 
//                empData.add(rs.getString(2)); 
//                empData.add(rs.getString(3));
//                empData.add(rs.getString(4));
//                empData.add(rs.getString(5));
//                empData.add(rs.getString(6));
//                empData.add(rs.getString(8));
//                empData.add(rs.getString(9));
//                empDetailsVector.add(empData);
//            }
//
//        } catch (SQLException sQLException) {
//            System.out.println(sQLException + "-----------Select query failed");
//        } 
        finally {
            dbConnManager.con_close(dbConn);
        }
        return empDetailsVector;
    }

    
    public Connection tableToTextField(){
        Connection dbConn = null;
        employeeMan emp = new employeeMan();
        dbConn = dbConnManager.connect();
        return dbConn;
    }

}
