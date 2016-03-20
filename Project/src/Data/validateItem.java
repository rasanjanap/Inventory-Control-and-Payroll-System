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
public class validateItem {
    
    public boolean validateItemNo(String itemNo){
        
        if(itemNo.length() == 5 && itemNo.charAt(0)=='m'){
            return true;
        }
        
        else{
        return false;
        }
     }
     
      public boolean validateItemName(String itemName){
        
        if(itemName.equals("")){
            return false;
        }
        
        else{
        return true;
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
          
          
            public boolean validateWeight(String weight){
        
        if(weight.equals("")){
            return false;
        }
        
        else{
        return true;
        }
            }
            
            
       public boolean validatePrice(String price){
        
        if(price.equals("")){
            return false;
        }
        
        else{
        return true;
        }
              }
    
}
