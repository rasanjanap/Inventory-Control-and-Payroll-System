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
public class validateEmployeeMan {
    
    public boolean validateEmpId(String id){
        
        if(id.length() == 5 && id.charAt(0)=='c'){
            return true;
        }
        
        else{
        return false;
        }
    }
    
    public boolean validateFname(String fname){
        
        if(fname.equals("")){
            return false;
        }
        
        else{
        return true;
        }
    }
    
    public boolean validateLname(String lname){
        
        if(lname.equals("")){
            return false;
        }
        
        else{
        return true;
        }
    }
    
    public boolean validateAddress(String address){
        
        if(address.equals("")){
            return false;
        }
        
        else{
        return true;
        }
    }
    
    public boolean validateEmpType(String type){
        
        if(type.equals("admin") || type.equals("worker") || type.equals("secretary")){
            return true;
        }
        
        else{
        return false;
        }
    }
    
    public boolean validatePassword(String password){
        
        if(password.length() >= 7 && password.length() <= 15){
            return true;
        }
        
        else{
        return false;
        }
    }
    
    public boolean validateQualific(String qualific){
        
        if(qualific.equals("")){
            return false;
        }
        
        else{
        return true;
        }
    }
    
    public boolean validateBirthday(String bday){
        
        String[] s = bday.split("/");
        Date d = new Date();
        int day = d.getYear();
        System.out.println(day);
        
        if(Integer.parseInt(s[2]) <= 1900+day-20 && Integer.parseInt(s[2]) >= 1900+day-40){
            return true;
        }
        else{
        return false;
        }
        
    }
    
    public boolean validateRegno(String regNo){
        
        String[] s = regNo.split("/");
        Date d = new Date();
        int year = d.getYear();
        int month = d.getMonth();
        int day = d.getDate();
        
        if(Integer.parseInt(s[2]) <= 1990+year && Integer.parseInt(s[1]) <= month+1 && Integer.parseInt(s[0]) <= day ){
            return true;
        }
        else{
        return false;
        }
    }
}
