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
public class customermanagement {
    
    private String custId;
    private String fname;
    private String lname;
    private String address;
    private int contact;
    private String email;
    
    private int q1;
    private int q2;
    private int q3;
    private int q4;
    private int q5;
    private int q6;
    private int q7;
    
    private float price1;
    private float price2;
    private float price3;
    private float price4;
    private float price5;
    private float price6;
    private float price7;
    

    public customermanagement(String id, String fname, String lname, String address, int contact, String email) {
        this.custId =id;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }
    public customermanagement(String id){
        
        this.custId = id;
    }

    public customermanagement(int q1, int q2, int q3, int q4, int q5, int q6, int q7, float price1, float price2, float price3, float price4, float price5, float price6, float price7) {
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
        this.q7 = q7;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
        this.price4 = price4;
        this.price5 = price5;
        this.price6 = price6;
        this.price7 = price7;
    }
    
    

    public String getCustId() {
        return custId;
    }

    public String getfname() {
        return fname;
    }

    public String getlname() {
        return lname;
    }

    public String getaddress() {
        return address;
    }
    
    public int getcontactno() {
        return contact;
    }

    public String getemail() {
        return email;
    }
    
    
    public void setcustId(String custId) {
        this.custId = custId;
    }

    public void setfname(String fname) {
        this.fname = fname;
    }

    public void setlname(String lname) {
        this.lname = lname;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public void setcontact(int contact) {
        this.contact = contact;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public int getQ1() {
        return q1;
    }

    public void setQ1(int q1) {
        this.q1 = q1;
    }

    public int getQ2() {
        return q2;
    }

    public void setQ2(int q2) {
        this.q2 = q2;
    }

    public int getQ3() {
        return q3;
    }

    public void setQ3(int q3) {
        this.q3 = q3;
    }

    public int getQ4() {
        return q4;
    }

    public void setQ4(int q4) {
        this.q4 = q4;
    }

    public int getQ5() {
        return q5;
    }

    public void setQ5(int q5) {
        this.q5 = q5;
    }

    public int getQ6() {
        return q6;
    }

    public void setQ6(int q6) {
        this.q6 = q6;
    }

    public int getQ7() {
        return q7;
    }

    public void setQ7(int q7) {
        this.q7 = q7;
    }

    public float getPrice1() {
        return price1;
    }

    public void setPrice1(float price1) {
        this.price1 = price1;
    }

    public float getPrice2() {
        return price2;
    }

    public void setPrice2(float price2) {
        this.price2 = price2;
    }

    public float getPrice3() {
        return price3;
    }

    public void setPrice3(float price3) {
        this.price3 = price3;
    }

    public float getPrice4() {
        return price4;
    }

    public void setPrice4(float price4) {
        this.price4 = price4;
    }

    public float getPrice5() {
        return price5;
    }

    public void setPrice5(float price5) {
        this.price5 = price5;
    }

    public float getPrice6() {
        return price6;
    }

    public void setPrice6(float price6) {
        this.price6 = price6;
    }

    public float getPrice7() {
        return price7;
    }

    public void setPrice7(float price7) {
        this.price7 = price7;
    }
    
}
