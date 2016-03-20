/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author gal sajja
 */
public class validateCustomerMan {
    
    
    /**
     *
     * @param id
     * @return
     */
    public boolean validatecustId(String id) {
        if(id.length() == 5 && id.charAt(0)== 'j'){
            return true;
        }
        
        else{
        return false;
        }
    }

    public boolean validateFname(String fname) {
        if(fname.equals("")){
            return false;
        }
        
        else{
        return true;
        }
    }

    public boolean validateLname(String lname) {
        if(lname.equals("")){
            return false;
        }
        
        else{
        return true;
        }
    }

    public boolean validateAddress(String address) {
        if(address.equals("")){
            return false;
        }
        
        else{
        return true;
        }
    }

    public boolean validatecontact(String contact) {
        
        if(contact.length() == 10 ){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean validateemail(String email) {
        
        if(email.contains("@") && email.contains(".")){
            
        int at = email.indexOf("@");
        
        int dot = email.lastIndexOf(".");
        String s = email.substring(dot+1);
        
            if(dot > at && s.equals("com")){
                return true;
            }
            else{
                return false;
            }
        }else{
            return false;
        }
    }
    
}
