/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Kavinda
 */
public class payroll {
    
    private String empID;
    private String dates;
    private String timeIn;
    private String timeOut;
    private int attendance;
    private int othours;
    private String regdate;
    private String fname;
    private String lname;
    private String address;
    private String loanNo;
    private int amount;
    private int balance;
    private String salaryNo; 
    private int worked_days;
    private int ot;
    private String basicSalary;
    private String bonus ;
    private String loans;
    private String etf ;
    private String misc ;
    private String net_basicSalary ;
    private String netSalary ;

    public payroll(String empID, String dates,int worked_days,int ot, String basicSalary, String bonus, String loans, String etf, String misc, String net_basicSalary, String netSalary) {
        this.empID = empID;
        this.dates = dates;
        this.worked_days=worked_days;
        this.ot=ot;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.loans = loans;
        this.etf = etf;
        this.misc = misc;
        this.net_basicSalary = net_basicSalary;
        this.netSalary = netSalary;
    }

    public payroll(String empID, String fname, String lname, int amount,int balance ) {
        this.empID = empID;
        this.fname = fname;
        this.lname = lname;
        this.amount = amount;
        this.balance=balance;
    }

    public payroll(int balance,String loanNo) {
        this.loanNo = loanNo;
        this.balance = balance;
    }
    
    
    

    public String getSalaryNo() {
        return salaryNo;
    }

    public void setSalaryNo(String salaryNo) {
        this.salaryNo = salaryNo;
    }

    public String getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getLoans() {
        return loans;
    }

    public void setLoans(String loans) {
        this.loans = loans;
    }

    public String getEtf() {
        return etf;
    }

    public void setEtf(String etf) {
        this.etf = etf;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    public String getNet_basicSalary() {
        return net_basicSalary;
    }

    public void setNet_basicSalary(String net_basicSalary) {
        this.net_basicSalary = net_basicSalary;
    }

    public String getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(String netSalary) {
        this.netSalary = netSalary;
    }
    
    

    public payroll(String timeOut,String empID) {    
        this.timeOut = timeOut;
        this.empID = empID;
    }

    public payroll(String timeOut, int othours,String empID) {
        this.empID = empID;
        this.othours = othours;
        this.timeOut = timeOut;
    }

    public payroll(String empID, String dates, String timeIn, String timeOut,int attendance ) {
        this.empID = empID;
        this.dates = dates;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.attendance=attendance;

    }

    public payroll(String empID) {
        this.empID = empID;
    }
    
    


    public payroll() {
    }
    
    

    /**
     * @return the empID
     */
    public String getEmpID() {
        return empID;
    }

    /**
     * @param empID the empID to set
     */
    public void setEmpID(String empID) {
        this.empID = empID;
    }

    /**
     * @return the dates
     */
    public String getDates() {
        return dates;
    }

    /**
     * @param dates the dates to set
     */
    public void setDates(String dates) {
        this.dates = dates;
    }

    /**
     * @return the timeIn
     */
    public String getTimeIn() {
        return timeIn;
    }

    /**
     * @param timeIn the timeIn to set
     */
    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    /**
     * @return the timeOut
     */
    public String getTimeOut() {
        return timeOut;
    }

    /**
     * @param timeOut the timeOut to set
     */
    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    /**
     * @return the regdate
     */
    public String getRegdate() {
        return regdate;
    }

    /**
     * @param regdate the regdate to set
     */
    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getOthours() {
        return othours;
    }

    public void setOthours(int othours) {
        this.othours = othours;
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getWorked_days() {
        return worked_days;
    }

    public void setWorked_days(int worked_days) {
        this.worked_days = worked_days;
    }

    public int getOt() {
        return ot;
    }

    public void setOt(int ot) {
        this.ot = ot;
    }
    
    
}
