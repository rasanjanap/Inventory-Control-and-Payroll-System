/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Database.DBConnManager;
import GUI.Payroll;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Kavinda
 */
public class payrollDAO {
    
        private DBConnManager dbConnManager = null;
        
        public payrollDAO ()
        {
            dbConnManager = new DBConnManager();
        }
        
        public boolean addRecord(payroll pay) {
            boolean result = false;
            Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            
            String query = "insert into `airconditionmanagementsystem`.`attendance`(`attendance`.`empID`,`attendance`.`dates`,`attendance`.`timeIn`,`attendance`.`timeOut`,`attendance`.`attendance`,`attendance`.`othours`) values('"+pay.getEmpID()+"' , '"+pay.getDates()+"' , '"+pay.getTimeIn()+"' , '"+pay.getTimeOut()+"','"+1+"','"+pay.getOthours()+"')";
            
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
         public boolean updateRecord(payroll pay , String tk){
        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

//empID,dates,basicSalary,bonus,loans,etf,misc,net_basicSalary,netSalary            
            String query = "update salary  set empID='"+pay.getEmpID()+"' , dates='"+pay.getDates()+"' , basicSalary='"+pay.getBasicSalary()+"' , bonus='"+pay.getBonus()+"', loans='"+pay.getLoans()+"', etf='"+pay.getEtf()+"',misc='"+pay.getMisc()+"', net_basicSalary='"+pay.getNet_basicSalary()+"', netSalary='"+pay.getNetSalary()+"' where salaryNo='"+tk+"'";
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);
            if (val == 1) {
                result = true;
            } else {
                result = false;
            }           

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Update query failed");

            result = false;
        }finally{
            dbConnManager.con_close(dbConn);
        }        
        return result;

        
    }
        public boolean deleteRecord(payroll pay,String tk){
        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();            
            String query = "delete from salary  where salaryNo = '"+tk+"'";
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);
            if (val == 1) {
                result = true;
            } else {
                result = false;
            }           

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Delete query failed");

            result = false;
        }finally{
            dbConnManager.con_close(dbConn);
        }        
        return result;

        
    }
         
        
        
            public boolean addSalary(payroll pay) {
            boolean result = false;
            Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            
            String query = "INSERT INTO salary(empID,dates,worked_days,ot,basicSalary,bonus,loans,etf,misc,net_basicSalary,netSalary) values('"+pay.getEmpID()+"' , '"+pay.getDates()+"' ,'"+pay.getWorked_days()+"' ,'"+pay.getOt()+"' , '"+pay.getBasicSalary()+"' , '"+pay.getBonus()+"', '"+pay.getLoans()+"', '"+pay.getEtf()+"','"+pay.getMisc()+"', '"+pay.getNet_basicSalary()+"', '"+pay.getNetSalary()+"')";
            
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
        
        
        public boolean updateAttendance(payroll pay) {
            boolean result = false;
            Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            
            String query = "update attendance set timeOut='"+pay.getTimeOut()+"', othours='"+pay.getOthours()+"' where empID='"+pay.getEmpID()+"'";
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);
            if (val == 1) {
                result = true;
            } else {
                result = false;
            }           

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Update query failed");

            result = false;
        }finally{
            dbConnManager.con_close(dbConn);
        }        
        return result;

        
    }
        
       public boolean deleteSalary(payroll pay) {
            boolean result = false;
            Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            
            String query = "delete from employee where empID = '"+pay.getEmpID()+"'and dates='"+pay.getDates()+"'";
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);
            if (val == 1) {
                result = true;
            } else {
                result = false;
            }           

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Delete query failed");

            result = false;
        }finally{
            dbConnManager.con_close(dbConn);
        }        
        return result;

        
    }
        
        public ResultSet searchId(payroll pay) {
            ResultSet result = null;
            Connection dbConn = null;
        

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            
            String query = "select address , fname  , lname , regdate from `airconditionmanagementsystem`.`employee` where empID = '"+pay.getEmpID()+"';";
            
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            result = rs;

                     

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Insert query failed");

        
        }        
            return result;
          
        
    }
        
        
        public ResultSet searchLoanNo(payroll pay) {
            ResultSet result = null;
            Connection dbConn = null;
        

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            
            String query = "select loanNo from loan where empID = '"+pay.getEmpID()+"';";
            
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            result = rs;

                     

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------select query failed");

        
        }        
            return result;
          
        
    }
            public ResultSet getWorkedTime(payroll pay) {
            ResultSet result = null;
            Connection dbConn = null;
        

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            
            String query = "select timeIn,timeOut from attendance where empID ='"+pay.getEmpID()+"' and dates='"+pay.getDates()+"'";
            
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            result = rs;

                     

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Insert query failed");

        
        }        
            return result;
          
        
    }
        
        public Vector empAttendance(String dates) throws SQLException{

        Vector<Vector<String>> empAttendanceVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "select empID,timeIn,timeOut from attendance where dates='"+dates+"' ";

            ResultSet rs = stmt.executeQuery(query);
            empAttendanceVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> empAtte = new Vector<String>();
                empAtte.add(rs.getString(1)); 
                empAtte.add(rs.getString(2)); 
                empAtte.add(rs.getString(3));
                empAttendanceVector.add(empAtte);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return empAttendanceVector;
    }
            
            
        public Vector salaryInfo() throws SQLException{

        Vector<Vector<String>> empSalaryVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "select * from salary";

            ResultSet rs = stmt.executeQuery(query);
            empSalaryVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> empSal = new Vector<String>();
                empSal.add(rs.getString("salaryNo")); 
                empSal.add(rs.getString("empID")); 
                empSal.add(rs.getString("dates"));
                empSal.add(rs.getString("worked_days"));
                empSal.add(rs.getString("ot"));
                empSal.add(rs.getString("basicSalary")); 
                empSal.add(rs.getString("bonus")); 
                empSal.add(rs.getString("loans"));
                empSal.add(rs.getString("etf")); 
                empSal.add(rs.getString("misc")); 
                empSal.add(rs.getString("net_basicSalary"));
                empSal.add(rs.getString("netSalary"));
                empSalaryVector.add(empSal);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return empSalaryVector;
    }
        
        public Vector salaryInfobyID(payroll pay) throws SQLException{

        Vector<Vector<String>> empSalaryVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "select * from salary where empID='"+pay.getEmpID()+"' ";

            ResultSet rs = stmt.executeQuery(query);
            empSalaryVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> empSal = new Vector<String>();
                empSal.add(rs.getString("salaryNo")); 
                empSal.add(rs.getString("empID")); 
                empSal.add(rs.getString("dates"));
                empSal.add(rs.getString("worked_days"));
                empSal.add(rs.getString("ot"));
                empSal.add(rs.getString("basicSalary")); 
                empSal.add(rs.getString("bonus")); 
                empSal.add(rs.getString("loans"));
                empSal.add(rs.getString("etf")); 
                empSal.add(rs.getString("misc")); 
                empSal.add(rs.getString("net_basicSalary"));
                empSal.add(rs.getString("netSalary"));
                empSalaryVector.add(empSal);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return empSalaryVector;
    }
        
        public Vector salaryInfobyDate(payroll pay) throws SQLException{

        Vector<Vector<String>> empSalaryVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "select * from salary where dates='"+pay.getEmpID()+"' ";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            empSalaryVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> empSal = new Vector<String>();
                empSal.add(rs.getString("salaryNo")); 
                empSal.add(rs.getString("empID")); 
                empSal.add(rs.getString("dates"));
                empSal.add(rs.getString("worked_days"));
                empSal.add(rs.getString("ot"));
                empSal.add(rs.getString("basicSalary")); 
                empSal.add(rs.getString("bonus")); 
                empSal.add(rs.getString("loans"));
                empSal.add(rs.getString("etf")); 
                empSal.add(rs.getString("misc")); 
                empSal.add(rs.getString("net_basicSalary"));
                empSal.add(rs.getString("netSalary"));
                empSalaryVector.add(empSal);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return empSalaryVector;
    }
            
            public ResultSet salary_employee_info(payroll pay) {
            ResultSet result = null;
            Connection dbConn = null;
        

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            
            String query = "select fname  , lname  from `airconditionmanagementsystem`.`employee` where empID = '"+pay.getEmpID()+"';";
            
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            result = rs;

                     

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Insert query failed");

        
        }        
            return result;
          
        
    }
            
            public boolean searchAttendance(payroll pay) {
            boolean result = false;
            Connection dbConn = null;
        

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement(); 
            String query = "select empID from attendance where empID = '"+pay.getEmpID()+"' and timeOut =\"00:00:00\"";  
            ResultSet r = stmt.executeQuery(query);
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    return true;
            } return false;
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Insert query failed");

        
        }        
            return result;
          
        
    }
            
//            public boolean deleteSalary(payroll pay) {
//            boolean result = false;
//            Connection dbConn = null;
//
//        try {
//            dbConn = dbConnManager.connect();
//
//            Statement stmt = dbConn.createStatement();
//
//            
//            String query = "delete from employee where empID = '"+pay.getEmpID()+"'and dates='"+pay.getDates()+"'";
//            
//            System.out.println(query);
//
//            int val = stmt.executeUpdate(query);
//            if (val == 1) {
//                result = true;
//            } else {
//                result = false;
//            }           
//
//        } catch (SQLException sQLException) {
//            System.out.println(sQLException + "-----------Delete query failed");
//
//            result = false;
//        }finally{
//            dbConnManager.con_close(dbConn);
//        }        
//        return result;
//
//        
//    
        
        public String getWorkedDays(String ID) {
            String result = null;
            Connection dbConn = null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = Calendar.getInstance();
            Calendar c=new GregorianCalendar();
            c.set(Calendar.DAY_OF_MONTH, 1);
            String fdate=sdf.format(c.getTime());
            String ldate=sdf.format(cal.getTime());
        

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            
            String query = "select count(attendance) from attendance where attendance=1 and empID='"+ID+"' and dates between '"+fdate+"' and '"+ldate+"'";
            
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
            result = rs.getString(1);

            }         

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select queeeeeeery failed");

        
        }      
            System.out.println(result);
            return result;
          
        
    }
        
            public String getOT(String ID) {
            String result = null;
            Connection dbConn = null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = Calendar.getInstance();
            Calendar c=new GregorianCalendar();
            c.set(Calendar.DAY_OF_MONTH, 1);
            String fdate=sdf.format(c.getTime());
            String ldate=sdf.format(cal.getTime());
        

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            
            String query = "select SUM(othours) from attendance where attendance=1 and empID='"+ID+"' and dates between '"+fdate+"' and '"+ldate+"'";
            
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
            result = rs.getString(1);

            }         

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select queeeeeeery failed");

        
        }      
            System.out.println(result);
            return result;
          
        
    }
        
         public Vector loanInfo() throws SQLException{

        Vector<Vector<String>> empSalaryVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "select * from loan";

            ResultSet rs = stmt.executeQuery(query);
            empSalaryVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> loan = new Vector<String>();
                loan.add(rs.getString("loanNo")); 
                loan.add(rs.getString("empID")); 
                loan.add(rs.getString("fname"));
                loan.add(rs.getString("lname")); 
                loan.add(rs.getString("amount")); 
                loan.add(rs.getString("balance"));
                empSalaryVector.add(loan);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return empSalaryVector;
    }
         
        public Vector employeeLoanInfo(payroll pay) throws SQLException{

        Vector<Vector<String>> empSalaryVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "select * from loan where empID='"+pay.getEmpID()+"' ";

            ResultSet rs = stmt.executeQuery(query);
            empSalaryVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> loan = new Vector<String>();
                loan.add(rs.getString("loanNo")); 
                loan.add(rs.getString("empID")); 
                loan.add(rs.getString("fname"));
                loan.add(rs.getString("lname")); 
                loan.add(rs.getString("amount")); 
                loan.add(rs.getString("balance"));
                empSalaryVector.add(loan);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return empSalaryVector;
    }
        
        public boolean addLoan(payroll pay) {
            boolean result = false;
            Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            
            String query = "INSERT INTO loan(empID,fname,lname,amount,balance) values('"+pay.getEmpID()+"' , '"+pay.getFname()+"' , '"+pay.getLname()+"' , '"+pay.getAmount()+"','"+pay.getBalance()+"')";
            
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
        
            public boolean deductLoan(payroll pay) {
            boolean result = false;
            Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            
            String query = "update loan set balance='"+pay.getBalance()+"' where loanNo='"+pay.getLoanNo()+"'";
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);
            if (val == 1) {
                result = true;
            } else {
                result = false;
            }           

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Update query failed");

            result = false;
        }finally{
            dbConnManager.con_close(dbConn);
        }        
        return result;

        
    }
            
//            public ResultSet loanBalance(payroll pay) {
//            ResultSet result = null;
//            Connection dbConn = null;
//        
//
//        try {
//            dbConn = dbConnManager.connect();
//
//            Statement stmt = dbConn.createStatement();
//
//            
//            String query = "select balance from loan where loanNo = '"+pay.getLoanNo()+"';";
//            
//            System.out.println(query);
//            ResultSet rs = stmt.executeQuery(query);
//            result = rs;
//
//                     
//
//        } catch (SQLException sQLException) {
//            System.out.println(sQLException + "-----------Insert query failed");
//
//        
//        }        
//            return result;
//          
//        
//    }
//        
        
            public String loanBalance(String loanNo) {
            String result = null;
            Connection dbConn = null;
        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            
            String query = "select balance from loan where loanNo = '"+loanNo+"';";
            
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
            result = rs.getString(1);

            }         

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select queeeeeeery failed");

        
        }      
            System.out.println(result);
            return result;
          
        
    }
       

            
            
        public Connection tableToTextField(){
        Connection dbConn = null;
        Payroll pay = new Payroll();
        dbConn = dbConnManager.connect();
        return dbConn;
    }
            

}

       
       


