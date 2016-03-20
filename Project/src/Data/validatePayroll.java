/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Kavinda
 */
public class validatePayroll {
        public boolean validateDays(String dates){
        
        if(dates.length()==0 || Integer.parseInt(dates)<32){
            return true;
        }
        
        else{
        return false;
        }
    }


    public boolean validateOtHours(String ot) {
        try {
            Integer.parseInt(ot);
            return true;
        } catch (NumberFormatException nfe) {}
        return false;
    }
    
     public boolean validateBasicSalary(String bsal) {

        if (bsal == null || bsal.length() == 0)
            return false;
        
        for (int i = 0; i < bsal.length(); i++) {

            if (!Character.isDigit(bsal.charAt(i)))
                return false;
        }
        
        return true;
    }
    
     public boolean validateBonus(String bonus) {
        if (bonus == null || bonus.length() == 0)
            return false;
        
        for (int i = 0; i < bonus.length(); i++) {
 
            if (!Character.isDigit(bonus.charAt(i)))
                return false;
        }
        
        return true;
    }
     
     public boolean validateHourlyRate(String rate) {
        if (rate == null || rate.length() == 0)
            return false;
        
        for (int i = 0; i < rate.length(); i++) {
 
            if (!Character.isDigit(rate.charAt(i)))
                return false;
        }
        
        return true;
    }
     
     public boolean validateHourlyRateOt(String rateot) {

        if (rateot == null || rateot.length() == 0)
            return false;
        
        for (int i = 0; i < rateot.length(); i++) {
 

            if (!Character.isDigit(rateot.charAt(i)))
                return false;
        }
        
        return true;
    }
     
          public boolean validateloans(String loan) {

        if (loan == null || loan.length() == 0)
            return false;
        
        for (int i = 0; i < loan.length(); i++) {
 

            if (!Character.isDigit(loan.charAt(i)))
                return false;
        }
        
        return true;
    }
          
            public boolean validateetf(String etf) {

        if (etf == null || etf.length() == 0)
            return false;
        
        for (int i = 0; i < etf.length(); i++) {
 

            if (!Character.isDigit(etf.charAt(i)))
                return false;
        }
        
        return true;
    }
            public boolean validatemisc(String etf) {

        if (etf == null || etf.length() == 0)
            return false;
        
        for (int i = 0; i < etf.length(); i++) {
            if (!Character.isDigit(etf.charAt(i)))
                return false;
        }
        
        return true;
    }
            

        
}