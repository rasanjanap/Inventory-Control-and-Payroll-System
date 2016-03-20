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
public class calculations {
    public float calc(customermanagement details){
        
        int q1= details.getQ1();
        int q2= details.getQ2();
        int q3= details.getQ3();
        int q4= details.getQ4();
        int q5= details.getQ5();
        int q6= details.getQ6();
        int q7= details.getQ7();
        
        float price1= details.getPrice1();
        float price2= details.getPrice2();
        float price3= details.getPrice3();
        float price4= details.getPrice4();
        float price5= details.getPrice5();
        float price6= details.getPrice6();
        float price7= details.getPrice7();
        
        float amount1 = q1*price1;
        float amount2 = q2*price2;
        float amount3 = q3*price3;
        float amount4 = q4*price4;
        float amount5 = q5*price5;
        float amount6 = q6*price6;
        float amount7 = q7*price7;
        
        float total = amount1 + amount2 + amount3 + amount4 + amount5 + amount6 + amount7;
        
        return total;
        
    }
}
