/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Date;

/**
 *
 * @author gal sajja
 */
public class employeeManagement {
    private String empID;
    private String fname;
    private String lname;
    private String address;
    private String dateOfBirth;
    private String empType;
    private String password;
    private String regDate;
    private String qualification;
    
    

    public employeeManagement(String id, String fname, String lname, String address,String bDate, String type, String pwd, String regDate , String quali) {
        
        this.empID = id;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.dateOfBirth = bDate;
        this.empType = type;
        this.password = pwd;
        this.regDate = regDate;
        this.qualification = quali;
    }

    public employeeManagement(String id){
        
        this.empID = id;
    }



    public String getEmpID() {
        return empID;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getEmpType() {
        return empType;
    }

    public String getPassword() {
        return password;
    }

    public String getQualification() {
        return qualification;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
    
    

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    
    
    
}
