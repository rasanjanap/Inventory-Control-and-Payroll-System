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
public class validateService {
    
    public boolean validateserviceID(String serviceID){
        
        if(serviceID.length() == 5 && serviceID.charAt(0)=='s'){
            return true;
        }
        
        else{
        return false;
        }
     }
     
       
        
          public boolean validateType(String Type){
        
        if(Type.equals("")){
            return false;
        }
        
        else{
        return true;
        }
}
    
}
