/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.customermanagement;
import Data.customermanagementDAO;
import Data.employeeManagementDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import Data.payroll;
import Data.payrollDAO;
import Data.validatePayroll;
import Database.DBConnManager;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gal sajja
 */
public class Payroll extends javax.swing.JInternalFrame {

    
    private Vector<Vector<String>> data; 
    private Vector<String> header; 
    private Vector<Vector<String>> data2; 
    private Vector<String> header2;
     private Vector<Vector<String>> data3; 
    private Vector<String> header3;
    ResultSet result;
    ResultSet result2;
    ResultSet result3;
    private DBConnManager dbConnManager = null;
    /**
     * Creates new form Payroll
     */
    public Payroll(){
        initComponents();
        jtxt_id.requestFocusInWindow();
        
        
        header = new Vector<String>();
        header.add("Employee ID");
        header.add("Time In");
        header.add("Time Out");
        
        header2 = new Vector<String>();
        
        header2.add("Salary No");
        header2.add("Employee ID");
        header2.add("Date");
        header2.add("Worked Days");
        header2.add("OT Hours");
        header2.add("Basic Salary");
        header2.add("Bonus");
        header2.add("Loans");
        header2.add("ETF");
        header2.add("Misc.");
        header2.add("Net. Basic Salary");
        header2.add("Net. Salary");
        
        header3 = new Vector<String>();
        
        header3.add("Salary No");
        header3.add("Employee ID");
        header3.add("First Name");
        header3.add("Last Name");
        header3.add("Amount");
        header3.add("Balance");
        
        Date d = new Date();
        jXDatePicker1.setDate(d);
        
        jtxt_lname.disable();
        jtxt_fname.disable();
        jtxt_reg.disable();
        jtxt_address.disable();
        jtxt_timein.disable();
        jtxt_timeout.disable();
        jtxt_date.disable();
        loadTable();
        loadCMB();
        loadSalaryTable();
        loadloanTable();
        loadLoanCMB();

            addWindowListener( new WindowAdapter() {
            public void windowOpened( WindowEvent e ){
            jtxt_id.requestFocus();
            }
            } );
        
    }
    
    public void loadTable(){
        

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();

//        String dates = sdf.format(cal.getTime().toString());
          String dates = sdf.format(cal.getTime());

        payrollDAO dao = new payrollDAO();
        try {
            data = dao.empAttendance(dates);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(data, header));
    }
    
    public void loadCMB(){
         DBConnManager dbConnManager = null;
        dbConnManager = new DBConnManager();
        Connection dbConn = null;
                try {
                
                dbConn = dbConnManager.connect();
                Statement stmt = dbConn.createStatement();
                String query = " select DISTINCT empID from employee ";
                System.out.println(query); 
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {

                    String id = rs.getString(1);
                    jcmb_id.addItem(id);
                    jcmb_ID.addItem(id);
                    
                }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } 
            finally {
            dbConnManager.con_close(dbConn);
        }
    }
    
        public void loadLoanCMB(){
         DBConnManager dbConnManager = null;
        dbConnManager = new DBConnManager();
        Connection dbConn = null;
                try {
                
                dbConn = dbConnManager.connect();
                Statement stmt = dbConn.createStatement();
                String query = " select DISTINCT empID from loan ";
                System.out.println(query); 
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {

                    String id = rs.getString(1);
                    jcmb_lID.addItem(id);
                    
                }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } 
            finally {
            dbConnManager.con_close(dbConn);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtxt_id = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxt_fname = new javax.swing.JTextField();
        jtxt_address = new javax.swing.JTextField();
        jtxt_reg = new javax.swing.JTextField();
        jtxt_lname = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxt_timein = new javax.swing.JTextField();
        jtxt_timeout = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxt_date = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jcmb_id = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jtxt_worked_days = new javax.swing.JTextField();
        jtxt_ot = new javax.swing.JTextField();
        jtxt_basicsal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jtxt_loans = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jtxt_etf = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jtxt_misc = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jtxt_ntbasicsal = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jtxt_deduct = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jtxt_ntpay = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel25 = new javax.swing.JLabel();
        jtxt_bonus = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jtxt_rate_ot = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jtxt_lamount = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jtxt_llname = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jtxt_lfname = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jcmb_ID = new javax.swing.JComboBox();
        jPanel13 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jcmb_lID = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        jcmb_lno = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        jtxt_lamount1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Payroll");
        setPreferredSize(new java.awt.Dimension(1085, 571));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Attendance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 24), new java.awt.Color(51, 51, 255))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Employee ID", "Time In", "Time Out"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Employee ID ");

        jtxt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_idActionPerformed(evt);
            }
        });
        jtxt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxt_idKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxt_idKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtxt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Name");

        jLabel3.setText("Address");

        jLabel4.setText("Reg Date");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtxt_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxt_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtxt_address, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtxt_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxt_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxt_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxt_reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel5.setText("Time In");

        jLabel6.setText("Time Out");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxt_timein, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(jtxt_timeout)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxt_timein, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxt_timeout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel8.setText("Date");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Today's Attendance");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 156, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 156, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtxt_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Mark Attendance", jPanel1);

        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setText("Employee ID");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel11.setText("First Name");

        jLabel12.setText("Last Name");

        jcmb_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcmb_idMouseClicked(evt);
            }
        });
        jcmb_id.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcmb_idPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jcmb_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmb_idActionPerformed(evt);
            }
        });

        jLabel13.setText("Worked Days");

        jtxt_worked_days.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxt_worked_daysFocusLost(evt);
            }
        });

        jtxt_ot.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxt_otFocusLost(evt);
            }
        });

        jtxt_basicsal.setText("0");
        jtxt_basicsal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxt_basicsalFocusLost(evt);
            }
        });

        jLabel14.setText("OT Hours");

        jLabel15.setText("Basic Salary         Rs.");

        jLabel17.setText("Hourly Rate(OT)");

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Deductions"));

        jLabel18.setText("Loans                  Rs.");

        jtxt_loans.setText("0");
        jtxt_loans.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxt_loansFocusLost(evt);
            }
        });

        jLabel19.setText("ETF                     Rs.");

        jtxt_etf.setText("0");

        jLabel21.setText("Misc.                   Rs.");

        jtxt_misc.setText("0");
        jtxt_misc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxt_miscFocusLost(evt);
            }
        });

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel21)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxt_etf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxt_loans, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxt_misc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_loans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxt_etf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_misc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2))
        );

        jLabel20.setText("Bonus            Rs.");

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Net Pay"));

        jLabel22.setText("Basic Salary   Rs.");

        jtxt_ntbasicsal.setText("0");
        jtxt_ntbasicsal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_ntbasicsalActionPerformed(evt);
            }
        });

        jLabel23.setText("Deductions    Rs.");

        jtxt_deduct.setText("0");

        jLabel24.setText("Net Pay         Rs.");

        jButton7.setText("Calculate");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtxt_ntbasicsal, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addComponent(jtxt_deduct))
                            .addComponent(jButton7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxt_ntpay, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(33, Short.MAX_VALUE))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jtxt_ntbasicsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jtxt_deduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_ntpay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insert.png"))); // NOI18N
        jButton9.setText("Insert   ");
        jButton9.setActionCommand("         Insert   ");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        jButton10.setText("Edit");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        jButton11.setText("Delete");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("OK");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel25.setText("Date                           ");

        jtxt_bonus.setText("0");
        jtxt_bonus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxt_bonusFocusLost(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clean.png"))); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        jButton5.setText("Print ");

        jtxt_rate_ot.setText("0");
        jtxt_rate_ot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_rate_otActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search.png"))); // NOI18N
        jButton8.setText("Info");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(jLabel25)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addComponent(jtxt_basicsal)
                        .addComponent(jTextField3)
                        .addComponent(jcmb_id, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxt_ot)
                        .addComponent(jtxt_worked_days, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtxt_bonus, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(jtxt_rate_ot))))
                        .addGap(18, 18, 18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtxt_bonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(jtxt_rate_ot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addComponent(jButton12)
                                .addGap(1, 1, 1)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jcmb_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtxt_worked_days, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtxt_ot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxt_basicsal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton11)
                                .addComponent(jButton10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8)))))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Calculate Salary", jPanel2);

        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Loan"));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtxt_lamount.setText("0");
        jtxt_lamount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxt_lamountFocusLost(evt);
            }
        });

        jLabel29.setText("Amount     Rs.");

        jLabel27.setText("Last Name");

        jLabel28.setText("First Name");

        jLabel26.setText("Employee ID");

        jcmb_ID.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcmb_IDPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcmb_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxt_lfname)
                            .addComponent(jtxt_llname)
                            .addComponent(jtxt_lamount, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcmb_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jtxt_lfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jtxt_llname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jtxt_lamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Deduct Loan"));

        jLabel31.setText("Employee ID");

        jcmb_lID.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcmb_lIDPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel32.setText("Loan No.");

        jcmb_lno.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcmb_lnoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel33.setText("Amount       Rs.");

        jtxt_lamount1.setText("0");
        jtxt_lamount1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxt_lamount1FocusLost(evt);
            }
        });

        jButton4.setText("Deduct");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcmb_lno, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcmb_lID, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxt_lamount1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcmb_lID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(14, 14, 14)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jcmb_lno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jtxt_lamount1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton6)))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(jLabel30))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Loans", jPanel11);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jcmb_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmb_idActionPerformed
    

    
    


    
    }//GEN-LAST:event_jcmb_idActionPerformed

    private void jcmb_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmb_idMouseClicked
//            String fname = null;
//            String lname = null;
//            String num = null;
//            
//            
//            String id = jcmb_id.getSelectedItem().toString();
//                payroll p = new payroll(id);
//                
//                payrollDAO dao = new payrollDAO();
//                result = dao.salary_employee_info(p);
//                payrollDAO dao2 = new payrollDAO();
//                result2 =dao2.getWorkedDays(id);
//        try {
//            while(result.next()){
//                fname = result.getString("fname");
//                lname = result.getString("lname");
//                num=result2.toString();
//                System.out.println(num);
//                
//                        jTextField2.setText(fname);
//                        jTextField3.setText(lname);
//                        jtxt_worked_days.setText(num);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
    }//GEN-LAST:event_jcmb_idMouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        
        if (jcmb_id.getSelectedItem().toString().equals("")|| jtxt_basicsal.getText().equals("0") )
        {
            JOptionPane.showMessageDialog(this,"Please Fill Fields","Warning", 0);
        }
        else
        {
        int workd_days=Integer.parseInt(jtxt_worked_days.getText());
        int ot=Integer.parseInt(jtxt_ot.getText());
        float basicsal=Float.parseFloat(jtxt_basicsal.getText());
        float bonus= Float.parseFloat(jtxt_bonus.getText());
        float hourlyrate_ot=Float.parseFloat(jtxt_rate_ot.getText());
        
        float basicTotal = 0;
        float otCal=0;
        float basicFullTotal=0;
        otCal=ot*hourlyrate_ot;
        basicFullTotal =basicsal+otCal+bonus;
        float etf = (basicFullTotal*3)/100;
        String Basictotal=Float.toString(basicFullTotal);
        jtxt_ntbasicsal.setText(Basictotal);
        jtxt_etf.setText(Float.toString(etf));

      
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jtxt_ntbasicsalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_ntbasicsalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_ntbasicsalActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if (jtxt_loans.getText().equals("0") && jtxt_misc.getText().equals("0") )
        {
            int ans =JOptionPane.showConfirmDialog(this,"Loans & Miscellaneous Fields Are Empty Do you Wish to Proceed ");
            if(ans==0)
            {
                        int loans = 0;
                        float epf =0;
                        int misc=0;
                        loans=Integer.parseInt(jtxt_loans.getText());
                        epf= Float.parseFloat(jtxt_etf.getText());
                         misc=Integer.parseInt(jtxt_misc.getText());

                        float total= loans + epf + misc;

                        jtxt_deduct.setText(Float.toString(total));
            }
        }
        else
        {
        int loans = 0;
        float epf =0;
        int misc=0;
        loans=Integer.parseInt(jtxt_loans.getText());
        epf= Float.parseFloat(jtxt_etf.getText());
         misc=Integer.parseInt(jtxt_misc.getText());
        
        float total= loans + epf + misc;
        
        jtxt_deduct.setText(Float.toString(total));
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (jtxt_ntbasicsal.getText().equals("0") && jtxt_deduct.getText().equals("0") )
        {
            JOptionPane.showMessageDialog(this,"Pleace Fill Basic Salary info & Deductions !");
        }
        else
        {
        float total;
        float ntsal=Float.parseFloat(jtxt_ntbasicsal.getText());
        float deduct = Float.parseFloat(jtxt_deduct.getText());
        
        total=ntsal-deduct;
        jtxt_ntpay.setText(Float.toString(total));
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (jcmb_id.getSelectedItem().toString().equals("")|| jtxt_basicsal.getText().equals("0") )
        {
            JOptionPane.showMessageDialog(this,"Please Fill Fields","Warning", 0);
        }
        else {
        int ans = JOptionPane.showConfirmDialog(this,"Do You Want To Insert This Record ?");
        if(ans==0)
        {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        String salDate = date.format(jXDatePicker1.getDate());
        payroll pay = new payroll(jcmb_id.getSelectedItem().toString(),salDate,Integer.parseInt(jtxt_worked_days.getText()),Integer.parseInt(jtxt_ot.getText()),jtxt_basicsal.getText(),jtxt_bonus.getText(),jtxt_loans.getText(),jtxt_etf.getText(),jtxt_misc.getText(),jtxt_ntbasicsal.getText(),jtxt_ntpay.getText());
        payrollDAO pdao = new payrollDAO();
        boolean result = pdao.addSalary(pay);
        if(result == true){
            JOptionPane.showMessageDialog(this,"Succesfully Inserted !");
            loadSalaryTable();
        }
        }
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jtxt_worked_daysFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxt_worked_daysFocusLost
        validatePayroll val = new validatePayroll();
        boolean days= val.validateDays(jtxt_worked_days.getText());
        if(days==false){
            JOptionPane.showMessageDialog(this, "Pleace Fill Correctly & Dont leave it Blank");
        }
    }//GEN-LAST:event_jtxt_worked_daysFocusLost

    private void jtxt_otFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxt_otFocusLost

    }//GEN-LAST:event_jtxt_otFocusLost

    private void jtxt_basicsalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxt_basicsalFocusLost
        validatePayroll val = new validatePayroll();
        boolean days= val.validateBasicSalary(jtxt_basicsal.getText());
        if(days==false){
            jtxt_basicsal.setBackground(Color.red);
        }
        else {
            jtxt_basicsal.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_jtxt_basicsalFocusLost

    private void jtxt_loansFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxt_loansFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_loansFocusLost

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        employeeManagementDAO emp = new employeeManagementDAO();
        try{
            int row = jTable2.getSelectedRow();
            String tableClick = (jTable2.getModel().getValueAt(row, 0).toString());
            String sql = "select * from salary where salaryNo = '"+tableClick+"'";
            
            Connection db = emp.tableToTextField();
            PreparedStatement pst = db.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                String txt1 = rs.getString("empID");
                jcmb_id.setSelectedItem(txt1);
                String txt2 = rs.getString("worked_days");
                jtxt_worked_days.setText(txt2);
                String txt3 = rs.getString("ot");
                jtxt_ot.setText(txt3);
                String txt4 = rs.getString("basicSalary");
                jtxt_basicsal.setText(txt4);
                String txt5 = rs.getString("bonus");
                jtxt_bonus.setText(txt5);
                String txt6 = rs.getString("loans");
                jtxt_loans.setText(txt6);
                String txt7 = rs.getString("etf");
                jtxt_etf.setText(txt7);
                String txt8 = rs.getString("misc");
                jtxt_misc.setText(txt8);
                String txt9 = rs.getString("net_basicSalary");
                jtxt_ntbasicsal.setText(txt9);
                String txt10 = rs.getString("netSalary");
                jtxt_ntpay.setText(txt10);

            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (jcmb_id.getSelectedItem().toString().equals("")|| jtxt_basicsal.getText().equals("0") )
        {
            JOptionPane.showMessageDialog(this,"Please Select One To Edit","Warning", 0);
        }
        else{
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        String salDate = date.format(jXDatePicker1.getDate());
        payroll pay = new payroll(jcmb_id.getSelectedItem().toString(),salDate,Integer.parseInt(jtxt_worked_days.getText()),Integer.parseInt(jtxt_ot.getText()),jtxt_basicsal.getText(),jtxt_bonus.getText(),jtxt_loans.getText(),jtxt_etf.getText(),jtxt_misc.getText(),jtxt_ntbasicsal.getText(),jtxt_ntpay.getText());
        payrollDAO pdao = new payrollDAO();
        int row = jTable2.getSelectedRow();
        String tableClick = (jTable2.getModel().getValueAt(row, 0).toString());
        boolean result = pdao.updateRecord(pay , tableClick);
        if(result == true){
            JOptionPane.showMessageDialog(this,"Succesfully Edited !");
            loadSalaryTable();
        }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        if (jcmb_id.getSelectedItem().toString().equals("")|| jtxt_basicsal.getText().equals("0") )
        {
            JOptionPane.showMessageDialog(this,"Please Select Field To Delete","Warning", 0);
        }
        else{
        int ans =JOptionPane.showConfirmDialog(this,"Do You Wish TO Delete This Record ?");
        if(ans==0)
        {
        payroll pay = new payroll();
        payrollDAO pdao = new payrollDAO();
        int row = jTable2.getSelectedRow();
        String tableClick = (jTable2.getModel().getValueAt(row, 0).toString());
        boolean result = pdao.deleteRecord(pay , tableClick);
        if(result == true){
            JOptionPane.showMessageDialog(this,"Succesfully Deleted !");
            loadSalaryTable();
        }
        }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jtxt_miscFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxt_miscFocusLost
        validatePayroll val = new validatePayroll();
        boolean days= val.validatemisc(jtxt_rate_ot.getText());
        if(days==false){
            JOptionPane.showMessageDialog(this, "Pleace Fill Correctly & Dont leave it Blank");
        }
    }//GEN-LAST:event_jtxt_miscFocusLost

    private void jcmb_idPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcmb_idPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
            String fname = null;
            String lname = null;
            String num = null;
            
            
                String id = jcmb_id.getSelectedItem().toString();
                payroll p = new payroll(id);
                
                payrollDAO dao = new payrollDAO();
                result = dao.salary_employee_info(p);
                
                payrollDAO dao2 = new payrollDAO();
                String s = dao2.getWorkedDays(id);
                jtxt_worked_days.setText(s);
                
                payrollDAO dao3= new payrollDAO();
                String ot = dao3.getOT(id);
                jtxt_ot.setText(ot);
                          
        try {
            while(result.next()){
                fname = result.getString("fname");
                lname = result.getString("lname");
                System.out.println(num);
                
                        jTextField2.setText(fname);
                        jTextField3.setText(lname);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
//        payrollDAO dao3 = new payrollDAO();
//        result3 = dao3.getWorkedTime(p);
//        String timeIn=null;
//        String timeOut=null;
//        
//        try{
//            while(result3.next())
//                timeIn=result3.getString(timeIn);
//                timeOut=result3.getString(timeOut);  
//                System.out.println(timeIn);
//                System.out.println(timeOut);
//        }catch (SQLException ex) {
//            System.out.println(ex);
//        }
 
    }//GEN-LAST:event_jcmb_idPopupMenuWillBecomeInvisible

    private void jcmb_IDPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcmb_IDPopupMenuWillBecomeInvisible
                String fname = null;
                String lname = null;
                String id = jcmb_ID.getSelectedItem().toString();
                payroll p = new payroll(id);
                
                payrollDAO dao = new payrollDAO();
                result = dao.salary_employee_info(p);
                
                try {
                while(result.next()){
                fname = result.getString("fname");
                lname = result.getString("lname");
                
                        jtxt_lfname.setText(fname);
                        jtxt_llname.setText(lname);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jcmb_IDPopupMenuWillBecomeInvisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        validatePayroll val = new validatePayroll();
        boolean loan= val.validateBonus(jtxt_lamount.getText());
        if ( jcmb_ID.getSelectedIndex()==0|| jtxt_lamount.getText().equals("0") || loan==false )
        {
            JOptionPane.showMessageDialog(this,"Please Select ID & Fill Amount","Warning", 0);
        }
        else{
        int mval=JOptionPane.showConfirmDialog(this, "Do you Want to Insert this Loan");
        if(mval==0)
        {
        payroll pay = new payroll(jcmb_ID.getSelectedItem().toString(),jtxt_lfname.getText(),jtxt_llname.getText(),Integer.parseInt(jtxt_lamount.getText()),Integer.parseInt(jtxt_lamount.getText()));
        payrollDAO pdao = new payrollDAO();
        boolean result = pdao.addLoan(pay);
        if(result == true){
            JOptionPane.showMessageDialog(this,"Succesfully Inserted !");
            loadloanTable();
        }
        }
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jcmb_lIDPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcmb_lIDPopupMenuWillBecomeInvisible
                String loanNo=null;
                String id = jcmb_lID.getSelectedItem().toString();
                payroll p = new payroll(id);
                payrollDAO dao = new payrollDAO();
                result = dao.searchLoanNo(p);
                try {
                    
                while(result.next())
                 {
                     loanNo = result.getString("loanNO");
                     jcmb_lno.addItem(loanNo);
                }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                                
         
                try {
                    data3 = dao.employeeLoanInfo(p);

                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                jTable3.setModel(new javax.swing.table.DefaultTableModel(data3, header3));
    }//GEN-LAST:event_jcmb_lIDPopupMenuWillBecomeInvisible

    private void jcmb_lnoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcmb_lnoPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmb_lnoPopupMenuWillBecomeInvisible

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//       jcmb_lID.getSelectedItem().toString().equals("")|| jcmb_lno.getSelectedItem().toString().equals("")||
        validatePayroll val = new validatePayroll();
        boolean loan= val.validateBonus(jtxt_lamount1.getText());
        if (jcmb_lID.getSelectedItem().toString().equals("")|| jcmb_lno.getSelectedIndex()==0||jtxt_lamount1.getText().toString().equals("0")||loan==false)
        {
            JOptionPane.showMessageDialog(this,"Please Select ID, Loan No. & Fill Amount","Warning", 0);
        }
        else{
        String bal;
        int amount=Integer.parseInt(jtxt_lamount1.getText());
        System.out.println(amount);
        payrollDAO dao2= new payrollDAO();
        bal =dao2.loanBalance(jcmb_lno.getSelectedItem().toString());
        System.out.println("result is : "+bal);
        int balance =Integer.parseInt(bal.toString());
        int tot=balance-amount;
        if (tot<0) {
            JOptionPane.showConfirmDialog(this,"Pleace Enter A Deductable Value !");
            
        }
        else{
        System.out.println(tot);
        payroll p = new payroll(tot,jcmb_lno.getSelectedItem().toString());
        payrollDAO dao = new payrollDAO();
        boolean result = dao.deductLoan(p);
        if(result == true){
            JOptionPane.showMessageDialog(this,"Succesfully Deducted!");
            loadloanTable();
        }
        }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jcmb_lID.setSelectedItem(null);
        jcmb_lno.setSelectedItem(null);
        jtxt_lamount1.setText(" ");
        loadloanTable();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jtxt_bonusFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxt_bonusFocusLost
        validatePayroll val = new validatePayroll();
        boolean bonus= val.validateBonus(jtxt_bonus.getText());
        if(bonus==false){
            jtxt_bonus.setBackground(Color.red);
        }
        else {
            jtxt_bonus.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_jtxt_bonusFocusLost

    private void jtxt_rate_otActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_rate_otActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_rate_otActionPerformed

    private void jtxt_lamountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxt_lamountFocusLost
        validatePayroll val = new validatePayroll();
        boolean loan= val.validateBonus(jtxt_lamount.getText());
        if(loan==false){
            jtxt_lamount.setBackground(Color.red);
        }
        else {
            jtxt_lamount.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_jtxt_lamountFocusLost

    private void jtxt_lamount1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxt_lamount1FocusLost
         validatePayroll val = new validatePayroll();
        boolean loan= val.validateBonus(jtxt_lamount1.getText());
        if(loan==false){
            jtxt_lamount1.setBackground(Color.red);
        }
        else {
            jtxt_lamount1.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_jtxt_lamount1FocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jcmb_id.setSelectedIndex(0);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jtxt_worked_days.setText(null);
        jtxt_ot.setText(null);
        jtxt_basicsal.setText("0");
        jtxt_bonus.setText("0");
        jtxt_rate_ot.setText("0");
        jtxt_loans.setText("0");
        jtxt_etf.setText("0");
        jtxt_misc.setText("0");
        jtxt_ntbasicsal.setText(null);
        jtxt_deduct.setText(null);
        jtxt_ntpay.setText(null);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtxt_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_idKeyTyped
        String fname = null;
        String lname = null;
        String regdate = null;
        String address = null;

        jtxt_address.enable();
        jtxt_fname.enable();
        jtxt_lname.enable();
        jtxt_reg.enable();
        jtxt_date.enable();
        jtxt_timein.enable();

        String id = jtxt_id.getText();
        payroll p = new payroll(id);

        payrollDAO dao = new payrollDAO();
        result = dao.searchId(p);
        try {
            while(result.next()){
                fname = result.getString("fname");
                lname = result.getString("lname");
                address = result.getString("address");
                regdate = result.getString("regdate");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        jtxt_address.setText(address);
        jtxt_fname.setText(fname);
        jtxt_lname.setText(lname);
        jtxt_reg.setText(regdate);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        jtxt_timein.setText(sdf.format(cal.getTime()));
        jtxt_date.setText(sdf2.format(cal.getTime()));

        payroll pay2 = new payroll(jtxt_id.getText());
        payrollDAO pdao2 = new payrollDAO();
        boolean result2 =pdao2.searchAttendance(pay2);
        if(result2== true){
            System.out.println("it came here 2");
            jtxt_timeout.enable();
            jtxt_timeout.setText(sdf.format(cal.getTime()));
            String [] arr=jtxt_timeout.getText().split(":");
            String h=arr[0];
            String m=arr[1];
            int oth= Integer.parseInt(h)-16;
            int otm= Integer.parseInt(m);
            if (oth < 0)
            {
                oth=0;
            }
            System.out.println(oth);
            payroll pay = new payroll(jtxt_timeout.getText(),oth,jtxt_id.getText());
            payrollDAO pdao = new payrollDAO();
            boolean result = pdao.updateAttendance(pay);
            if(result == true){
                jLabel9.setText("DONE");
                loadTable();
                
            }
            else
            {
                jLabel9.setText("Error");
            }
        }
        else if(result2==false){
            int attendance=1;
            payroll pay = new payroll(jtxt_id.getText(),jtxt_date.getText(),jtxt_timein.getText(),jtxt_timeout.getText(),attendance);
            payrollDAO pdao = new payrollDAO();
            boolean result = pdao.addRecord(pay);
            if(result == true){
                jLabel9.setText("DONE");
                loadTable();
                
            }

        }

     
    }//GEN-LAST:event_jtxt_idKeyTyped

    private void jtxt_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_idKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_idKeyReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Salary_Info s = new Salary_Info();
        s.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jtxt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_idActionPerformed
    public void loadSalaryTable(){
        payrollDAO dao = new payrollDAO();
        try {
            data2 = dao.salaryInfo();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        jTable2.setModel(new javax.swing.table.DefaultTableModel(data2, header2));
    }
        public void loadloanTable(){
        payrollDAO dao = new payrollDAO();
        try {
            data3 = dao.loanInfo();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        jTable3.setModel(new javax.swing.table.DefaultTableModel(data3, header3));
    }
        
        public void loademployeeloanTable(){
        payrollDAO dao = new payrollDAO();
        try {
            data3 = dao.loanInfo();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        jTable3.setModel(new javax.swing.table.DefaultTableModel(data3, header3));
    }
//        public void clearfields()
//        {
//            for (int i = 0; i < 2000; i++) {
//                
//            }
//            jtxt_id.setText(null);
//            jtxt_fname.setText(null);
//            jtxt_lname.setText(null);
//            jtxt_address.setText(null);
//            jtxt_reg.setText(null);
//            jtxt_date.setText(null);
//            jtxt_timein.setText(null);
//            jtxt_timeout.setText(null);
//            jLabel9.setText(null);
//            
//        }
                
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JComboBox jcmb_ID;
    private javax.swing.JComboBox jcmb_id;
    private javax.swing.JComboBox jcmb_lID;
    private javax.swing.JComboBox jcmb_lno;
    private javax.swing.JTextField jtxt_address;
    private javax.swing.JTextField jtxt_basicsal;
    private javax.swing.JTextField jtxt_bonus;
    private javax.swing.JTextField jtxt_date;
    private javax.swing.JTextField jtxt_deduct;
    private javax.swing.JTextField jtxt_etf;
    private javax.swing.JTextField jtxt_fname;
    private javax.swing.JTextField jtxt_id;
    private javax.swing.JTextField jtxt_lamount;
    private javax.swing.JTextField jtxt_lamount1;
    private javax.swing.JTextField jtxt_lfname;
    private javax.swing.JTextField jtxt_llname;
    private javax.swing.JTextField jtxt_lname;
    private javax.swing.JTextField jtxt_loans;
    private javax.swing.JTextField jtxt_misc;
    private javax.swing.JTextField jtxt_ntbasicsal;
    private javax.swing.JTextField jtxt_ntpay;
    private javax.swing.JTextField jtxt_ot;
    private javax.swing.JTextField jtxt_rate_ot;
    private javax.swing.JTextField jtxt_reg;
    private javax.swing.JTextField jtxt_timein;
    private javax.swing.JTextField jtxt_timeout;
    private javax.swing.JTextField jtxt_worked_days;
    // End of variables declaration//GEN-END:variables

    private void windowOpened() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}