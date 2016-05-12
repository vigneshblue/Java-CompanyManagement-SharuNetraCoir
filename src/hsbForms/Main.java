package hsbForms;


import hsbClasses.DbConnection;
import hsbClasses.Functions;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

public class Main extends javax.swing.JFrame {
DbConnection db = new DbConnection();
Connection con = db.AccessConnect();
Connection acc = db.Accounts();
Functions fn = new Functions();
PreparedStatement pst,pst0,pst1,pst2 = null;
ResultSet rs,rs0,rs1,rs2 = null;
Statement st,st1 = null;
String CurrentDate,Current_Time,Datee,timee,username,nuser,npwd = null;
DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
int count = 0,datinit;
float prodqty = 0;

private static String USER_NAME = "sharucoir@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "cmssms12"; // GMail password
    private static String RECIPIENT = "vigneshwarans@live.com";
    
    public Main() {
        initComponents();
        hsbDateFormats();
        FormLoad();
    }
    public void FormLoad()
{
        UpdateLabel(con,"Select * From PriceUpdate Where Product = 'Fibre'","Rate",lbFP_unit_rate);
        UpdateLabel(con,"Select * From PriceUpdate Where Product = 'Coir'","Rate",lbCS_unit_rate);
    
    
    
    ComboBox("Select * From People Where Type = 'Customer'","Name",cbCS_customer_name);
    ComboBox("Select * From People Where Type = 'Seller'","Name",cbFP_seller_name);
    ComboBox("Select * From People Where Type = 'Others'","Name",cbExp_person);
    ComboBox("Select * From People Where Type = 'Others'","Name",cbFP_person);    
    ComboBox("Select * From ExpenseType","Expense_Type",cbExp_expense_type);
    ComboBox("Select * From People Where Type = 'Company'","Name",cbExp_name);
    ComboBox("Select * From People","Name",cbBC_name);
    ComboBox("Select * From People Where Type = 'Others'","Name",cbAC_name);
    
    hsbTable(con,"Select rowid,Date,Product,Name,Quantity,Bundles,Total_Amount,Amount_Paid,Balance,Credit,Transportation From FibreCoir Where Transportation = 'Pending'", tablePT1);
    hsbTable(con,"Select * From FibreStock",tableSR1);
    hsbTable(con,"Select * From FibreStockB",tableSR2);
    hsbTable(con,"Select * From CoirStock",tableSR3);
    hsbTable(con,"Select * From CoirStockB",tableSR4);
    
    Calendar calendar = Calendar.getInstance();
     java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
    dcPT_date.setDate(ourJavaDateObject);
    dcSE_date.setDate(ourJavaDateObject);
    
    
    
   
//    try
//                  {
//                      String sel = "SELECT * FROM Backup";
//                      st1 = con.createStatement();
//                      rs1 = st1.executeQuery(sel);
//
//                      while(rs1.next())
//                      {
//                          USER_NAME = "sharucoir@gmail.com";
//                          RECIPIENT = "vigneshwarans@live.com";
//                          PASSWORD = "cmssms12";
//                      }
//                  }
//                  catch(Exception er)
//                  {
//                      JOptionPane.showMessageDialog(null,"Backup Email"+er); 
//                  }
//                  finally
//                 {
//                    try
//                   {
//
//                    st1.close();
//                    rs1.close();
//
//                    }catch(Exception er)
//                    {
//                     JOptionPane.showMessageDialog(null, er); 
//                    }
//                 }
    
//    
//    try
//    {
//       String sql = "Select * From People";
//       pst2 = con.prepareStatement(sql);
//       rs2 = pst2.executeQuery();
//       while(rs2.next())
//       {
//           String name = rs2.getString("Name");
////           System.out.println(name);
//           try
//           {          
//               String upd = "Update People Set Balance = ? Where Name = '"+name+"'";
//               pst1 = con.prepareStatement(upd);
//               pst1.setFloat(1, FieldSum(con,"Select * From FibreCoir Where Name = '"+name+"'","Balance"));
//               pst1.executeUpdate();
////               System.out.println(FieldSum(con,"Select * From FibreCoir Where Name = '"+name+"'","Balance"));
//       
//       
//            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "People Balance Update#"+er);}
//           try
//           {          
//               String upd = "Update People Set Credit = ? Where Name = '"+name+"'";
//               pst0 = con.prepareStatement(upd);
//               pst0.setFloat(1, FieldSum(con,"Select * From FibreCoir Where Name = '"+name+"'","Credit"));
//               pst0.executeUpdate();
////               fSystem.out.println(FieldSum(con,"Select * From FibreCoir Where Name = '"+name+"'","Credit"));
//       
//            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "People Credit Update#"+er);}           
//       }
//       
//    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "People Balance Update#"+er);}finally{try{pst2.close();rs2.close();}catch(Exception er){}}
//
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        PanelHome = new javax.swing.JPanel();
        PanelPlain = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablePT1 = new javax.swing.JTable();
        tfPT_finish = new javax.swing.JButton();
        dcPT_date = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        PanelSales = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbCS_balance = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCS_submit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tfCS_balance = new javax.swing.JTextField();
        tfCS_credit = new javax.swing.JTextField();
        cbCS_payment_type = new javax.swing.JComboBox();
        lbCS_credit = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        chkbCS_coir_sent = new javax.swing.JCheckBox();
        tfCS_amount_paid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbCS_customer_name = new javax.swing.JComboBox();
        lbCS_unit_rate = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnCS_cancel = new javax.swing.JButton();
        tfCS_quantity = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfCS_bundles = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfCS_total_amount = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbCS_payment_mode = new javax.swing.JComboBox();
        dcCS_date = new com.toedter.calendar.JDateChooser();
        btnCS_delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCS1 = new javax.swing.JTable();
        jLabel76 = new javax.swing.JLabel();
        PanelPurchase = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbFP_balance = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnFP_submit = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tfFP_Credit = new javax.swing.JTextField();
        tfFP_balance = new javax.swing.JTextField();
        cbFP_payment_type = new javax.swing.JComboBox();
        lbFP_credit = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        chkbFP_fibre_received = new javax.swing.JCheckBox();
        tfFP_amount_paid = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cbFP_seller_name = new javax.swing.JComboBox();
        lbFP_unit_rate = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnFP_cancel = new javax.swing.JButton();
        tfFP_quantity = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        tfFP_bundles = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        tfFP_total_amount = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        cbFP_payment_mode = new javax.swing.JComboBox();
        dcFP_date = new com.toedter.calendar.JDateChooser();
        jLabel82 = new javax.swing.JLabel();
        cbFP_person = new javax.swing.JComboBox();
        btnFP_delete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableFP1 = new javax.swing.JTable();
        jLabel97 = new javax.swing.JLabel();
        PanelExpenseIncome = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        tfExp_amount = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        btnExp_submit1 = new javax.swing.JButton();
        dcExp_date = new com.toedter.calendar.JDateChooser();
        cbExp_expense_type = new javax.swing.JComboBox();
        btnExp_cancel1 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableInc = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableExp = new javax.swing.JTable();
        cbExp_category = new javax.swing.JComboBox();
        cbExp_person = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        tfExp_amount_paid = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        tfExp_balance = new javax.swing.JTextField();
        tfExp_credit = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        cbExp_name = new javax.swing.JComboBox();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        PanelExp_expense_type = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tfExp_panel_expense_type = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        lbExp_credit = new javax.swing.JLabel();
        lbExp_balance = new javax.swing.JLabel();
        PanelExp_desc_qty = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        tfExp_description = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        tfExp_qty = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        tfExp_bdls = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        btnExp_delete1 = new javax.swing.JButton();
        PanelNewEntries = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableNP1 = new javax.swing.JTable();
        btnNP_delete = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        tfNP_contact_no = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        tfNP_email = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        tfNP_comments = new javax.swing.JTextField();
        cbNP_people_type = new javax.swing.JComboBox();
        tfNP_address = new javax.swing.JTextField();
        btnNP_submit = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        btnNP_cancel = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        tfNP_name = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        PanelBalanceCredit = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        tfBC_balance = new javax.swing.JTextField();
        cbBC_name = new javax.swing.JComboBox();
        lbBC_credit = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        tfBC_credit = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        btnBC_rcv = new javax.swing.JButton();
        lbBC_name = new javax.swing.JLabel();
        lbBC_balance = new javax.swing.JLabel();
        btnBC_pay = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        dcBC_date = new com.toedter.calendar.JDateChooser();
        jLabel98 = new javax.swing.JLabel();
        cbBC_payment_mode1 = new javax.swing.JComboBox();
        cbBC_payment_mode2 = new javax.swing.JComboBox();
        jScrollPane16 = new javax.swing.JScrollPane();
        tableBC = new javax.swing.JTable();
        lbBC_type = new javax.swing.JLabel();
        PanelAmountComparision = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableAC1 = new javax.swing.JTable();
        lbAC_name1 = new javax.swing.JLabel();
        lbAC_last_updated = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableAC2 = new javax.swing.JTable();
        jLabel73 = new javax.swing.JLabel();
        lbAC_name2 = new javax.swing.JLabel();
        cbAC_name = new javax.swing.JComboBox();
        lbAC_difference = new javax.swing.JLabel();
        lbAC_total2 = new javax.swing.JLabel();
        lbAC_total1 = new javax.swing.JLabel();
        lbAC_balance_credit = new javax.swing.JLabel();
        lbAC_last_updated1 = new javax.swing.JLabel();
        btnAC_seen = new javax.swing.JButton();
        PanelFibreStock = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableSR2 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableSR1 = new javax.swing.JTable();
        jLabel59 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        btnSE_fibre_enter = new javax.swing.JButton();
        dcSE_date = new com.toedter.calendar.JDateChooser();
        jLabel89 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        tfSE_fibre_production = new javax.swing.JTextField();
        tfSE_fibre_qty = new javax.swing.JTextField();
        PanelCoirStock = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tableSR4 = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        tableSR3 = new javax.swing.JTable();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        tfSE_coir_production_bundles = new javax.swing.JTextField();
        tfSE_coir_production_qty = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        tfSE_coir_windings = new javax.swing.JTextField();
        btnSE_yarn_enter = new javax.swing.JButton();
        dcSE_date1 = new com.toedter.calendar.JDateChooser();
        PanelAccountsRecord = new javax.swing.JPanel();
        PanelViewChoose = new javax.swing.JPanel();
        PanelDaily = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tableAR1 = new javax.swing.JTable();
        PanelBetween = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableAR2 = new javax.swing.JTable();
        dcAR_date1 = new com.toedter.calendar.JDateChooser();
        jLabel81 = new javax.swing.JLabel();
        dcAR_date2 = new com.toedter.calendar.JDateChooser();
        jLabel94 = new javax.swing.JLabel();
        btnAR_select = new javax.swing.JButton();
        ProdProfit = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        dcAR_date3 = new com.toedter.calendar.JDateChooser();
        jLabel96 = new javax.swing.JLabel();
        dcAR_date4 = new com.toedter.calendar.JDateChooser();
        btnAR_select1 = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        tableAR3 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sharu Netra Coir - HIGHSUNBLUE TECHNOLOGIES");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel58.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("SHARU NETRA COIRS");

        jLabel48.setBackground(java.awt.Color.pink);
        jLabel48.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLabel48.setText("HOME |");
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLabel49.setText("COIR SALES |");
        jLabel49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel49MouseClicked(evt);
            }
        });
        jLabel49.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel49KeyPressed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLabel50.setText("FIBRE PURCHASE |");
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLabel51.setText("EXPENSE INCOME |");
        jLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel51MouseClicked(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLabel52.setText("NEW PEOPLE |");
        jLabel52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel52MouseClicked(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLabel53.setText("BAL CREDIT |");
        jLabel53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel53MouseClicked(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLabel74.setText("TALLY |");
        jLabel74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel74MouseClicked(evt);
            }
        });

        jLabel78.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLabel78.setText("FIBRE STOCK |");
        jLabel78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel78MouseClicked(evt);
            }
        });

        jLabel86.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLabel86.setText("COIR STOCK |");
        jLabel86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel86MouseClicked(evt);
            }
        });

        jLabel79.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLabel79.setText("ACCOUNTS");
        jLabel79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel79MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        jPanel4.setBackground(new java.awt.Color(255, 153, 153));

        PanelHome.setLayout(new java.awt.CardLayout());

        PanelPlain.setBackground(new java.awt.Color(255, 153, 153));

        jLabel77.setFont(new java.awt.Font("Sakkal Majalla", 1, 24)); // NOI18N
        jLabel77.setText("Pending Transportation : ");

        tablePT1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablePT1.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePT1.setRowHeight(25);
        jScrollPane8.setViewportView(tablePT1);

        tfPT_finish.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfPT_finish.setText("Finish");
        tfPT_finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPT_finishActionPerformed(evt);
            }
        });

        dcPT_date.setDateFormatString("dd-MM-yyyy");
        dcPT_date.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        dcPT_date.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dcPT_date.setOpaque(false);

        jButton1.setText("Backup");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPlainLayout = new javax.swing.GroupLayout(PanelPlain);
        PanelPlain.setLayout(PanelPlainLayout);
        PanelPlainLayout.setHorizontalGroup(
            PanelPlainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPlainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPlainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPlainLayout.createSequentialGroup()
                        .addComponent(tfPT_finish)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelPlainLayout.createSequentialGroup()
                        .addGroup(PanelPlainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
                            .addGroup(PanelPlainLayout.createSequentialGroup()
                                .addComponent(jLabel77)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dcPT_date, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPlainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        PanelPlainLayout.setVerticalGroup(
            PanelPlainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPlainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPlainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77)
                    .addComponent(dcPT_date, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfPT_finish, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        PanelHome.add(PanelPlain, "cardplain");

        PanelSales.setBackground(new java.awt.Color(255, 153, 153));

        jPanel7.setBackground(new java.awt.Color(255, 153, 153));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Customer Name : ");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Payment Type : ");

        lbCS_balance.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbCS_balance.setForeground(new java.awt.Color(0, 153, 0));
        lbCS_balance.setText("0");

        jLabel6.setText("kgs");

        btnCS_submit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCS_submit.setText("Submit");
        btnCS_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCS_submitActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Bundles : ");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Amount Paid : ");

        jLabel17.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel17.setText("Unit Rate : ");

        tfCS_balance.setText("0");

        tfCS_credit.setText("0");
        tfCS_credit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCS_creditActionPerformed(evt);
            }
        });

        cbCS_payment_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Main", "Advance" }));
        cbCS_payment_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCS_payment_typeActionPerformed(evt);
            }
        });

        lbCS_credit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbCS_credit.setForeground(new java.awt.Color(255, 0, 0));
        lbCS_credit.setText("0");

        jLabel15.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel15.setText("Credit :");

        chkbCS_coir_sent.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkbCS_coir_sent.setText("Coir Sent");
        chkbCS_coir_sent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbCS_coir_sentActionPerformed(evt);
            }
        });

        tfCS_amount_paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCS_amount_paidActionPerformed(evt);
            }
        });
        tfCS_amount_paid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCS_amount_paidKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sakkal Majalla", 1, 24)); // NOI18N
        jLabel1.setText("Coir Sales : ");

        cbCS_customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCS_customer_nameActionPerformed(evt);
            }
        });

        lbCS_unit_rate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCS_unit_rate.setForeground(new java.awt.Color(153, 0, 0));
        lbCS_unit_rate.setText("####");
        lbCS_unit_rate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCS_unit_rateMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Credit : ");

        btnCS_cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCS_cancel.setText("Cancel");
        btnCS_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCS_cancelActionPerformed(evt);
            }
        });

        tfCS_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCS_quantityActionPerformed(evt);
            }
        });
        tfCS_quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCS_quantityKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel13.setText("Balance : ");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Total Amount : ");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Payment Mode : ");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Quantity : ");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Date : ");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Balance : ");

        cbCS_payment_mode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Transaction" }));

        dcCS_date.setDateFormatString("dd-MM-yyyy");
        dcCS_date.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        dcCS_date.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dcCS_date.setOpaque(false);

        btnCS_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCS_delete.setText("Delete");
        btnCS_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCS_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(534, 534, 534)
                        .addComponent(chkbCS_coir_sent)
                        .addContainerGap(170, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(tfCS_quantity, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfCS_amount_paid)
                                            .addComponent(dcCS_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel12)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel10))
                                                .addGap(20, 20, 20))
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(12, 12, 12)))
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbCS_customer_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfCS_bundles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfCS_balance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbCS_payment_mode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbCS_payment_type, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfCS_total_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfCS_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(btnCS_submit)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCS_cancel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCS_delete)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbCS_unit_rate)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbCS_credit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbCS_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(lbCS_unit_rate))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lbCS_balance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lbCS_credit))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcCS_date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbCS_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbCS_payment_type, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCS_quantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCS_bundles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCS_total_amount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCS_balance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCS_credit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfCS_amount_paid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCS_payment_mode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkbCS_coir_sent, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCS_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCS_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCS_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 153, 153));

        tableCS1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableCS1.setModel(new javax.swing.table.DefaultTableModel(
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
        tableCS1.setRowHeight(25);
        jScrollPane1.setViewportView(tableCS1);

        jLabel76.setText("Transactions");
        jLabel76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel76MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelSalesLayout = new javax.swing.GroupLayout(PanelSales);
        PanelSales.setLayout(PanelSalesLayout);
        PanelSalesLayout.setHorizontalGroup(
            PanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(PanelSalesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelSalesLayout.setVerticalGroup(
            PanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSalesLayout.createSequentialGroup()
                .addGroup(PanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelHome.add(PanelSales, "cardsales");

        PanelPurchase.setBackground(new java.awt.Color(255, 153, 153));

        jPanel9.setBackground(new java.awt.Color(255, 153, 153));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Seller Name :    ");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Payment Type : ");

        lbFP_balance.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbFP_balance.setForeground(new java.awt.Color(0, 102, 0));
        lbFP_balance.setText("0");

        jLabel18.setText("kgs");

        btnFP_submit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFP_submit.setText("Submit");
        btnFP_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFP_submitActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("Bundles : ");

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Amount Paid : ");

        jLabel21.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel21.setText("Unit Rate : ");

        tfFP_balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFP_balanceActionPerformed(evt);
            }
        });

        cbFP_payment_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Main", "Advance" }));
        cbFP_payment_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFP_payment_typeActionPerformed(evt);
            }
        });

        lbFP_credit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbFP_credit.setForeground(new java.awt.Color(255, 0, 0));
        lbFP_credit.setText("0");

        jLabel22.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel22.setText("Credit : ");

        chkbFP_fibre_received.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkbFP_fibre_received.setText("Fibre Received");
        chkbFP_fibre_received.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbFP_fibre_receivedActionPerformed(evt);
            }
        });

        tfFP_amount_paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFP_amount_paidActionPerformed(evt);
            }
        });
        tfFP_amount_paid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFP_amount_paidKeyReleased(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Sakkal Majalla", 1, 24)); // NOI18N
        jLabel23.setText("Fibre Purchase : ");

        cbFP_seller_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFP_seller_nameActionPerformed(evt);
            }
        });

        lbFP_unit_rate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbFP_unit_rate.setForeground(new java.awt.Color(102, 0, 0));
        lbFP_unit_rate.setText("####");
        lbFP_unit_rate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFP_unit_rateMouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setText("Balance : ");

        btnFP_cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFP_cancel.setText("Cancel");
        btnFP_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFP_cancelActionPerformed(evt);
            }
        });

        tfFP_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFP_quantityActionPerformed(evt);
            }
        });
        tfFP_quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFP_quantityKeyReleased(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel25.setText("Balance : ");

        jLabel26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel26.setText("Total Amount : ");

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setText("Payment Mode : ");

        jLabel28.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel28.setText("Quantity : ");

        jLabel29.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel29.setText("Date : ");

        jLabel30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel30.setText("Credit : ");

        cbFP_payment_mode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Transaction" }));

        dcFP_date.setDateFormatString("yyyy-MM-dd");
        dcFP_date.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        dcFP_date.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dcFP_date.setOpaque(false);

        jLabel82.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel82.setText("For : ");

        cbFP_person.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFP_personActionPerformed(evt);
            }
        });

        btnFP_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFP_delete.setText("Delete");
        btnFP_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFP_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dcFP_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfFP_quantity, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfFP_amount_paid, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbFP_unit_rate))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btnFP_submit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFP_cancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(btnFP_delete)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel19)
                            .addComponent(jLabel14)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbFP_payment_mode, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfFP_Credit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfFP_bundles, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFP_seller_name, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel82)
                        .addGap(18, 18, 18)
                        .addComponent(cbFP_person, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(chkbFP_fibre_received)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel26)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbFP_payment_type, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfFP_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfFP_total_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(12, 12, 12)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbFP_credit, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(lbFP_balance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel21)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(lbFP_unit_rate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(1, 1, 1))))
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbFP_person, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(lbFP_balance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(lbFP_credit))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFP_seller_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcFP_date, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfFP_bundles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfFP_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfFP_amount_paid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30)
                                    .addComponent(tfFP_Credit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addComponent(cbFP_payment_type, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(tfFP_total_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfFP_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFP_payment_mode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkbFP_fibre_received, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFP_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFP_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFP_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tableFP1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableFP1.setModel(new javax.swing.table.DefaultTableModel(
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
        tableFP1.setRowHeight(25);
        jScrollPane2.setViewportView(tableFP1);

        jLabel97.setText("Trans");
        jLabel97.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel97MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelPurchaseLayout = new javax.swing.GroupLayout(PanelPurchase);
        PanelPurchase.setLayout(PanelPurchaseLayout);
        PanelPurchaseLayout.setHorizontalGroup(
            PanelPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPurchaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(PanelPurchaseLayout.createSequentialGroup()
                        .addGap(0, 130, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(jLabel97)))
                .addContainerGap())
        );
        PanelPurchaseLayout.setVerticalGroup(
            PanelPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPurchaseLayout.createSequentialGroup()
                .addGroup(PanelPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelHome.add(PanelPurchase, "cardpurchase");

        PanelExpenseIncome.setBackground(new java.awt.Color(255, 153, 153));

        jPanel10.setBackground(new java.awt.Color(255, 153, 153));

        tfExp_amount.setText("0");

        jLabel31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel31.setText("Amount : ");

        jLabel32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel32.setText("Category : ");

        jLabel33.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel33.setText("Type : ");

        jLabel34.setFont(new java.awt.Font("Sakkal Majalla", 1, 24)); // NOI18N
        jLabel34.setText("Income/Expense : ");

        btnExp_submit1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExp_submit1.setText("Submit");
        btnExp_submit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExp_submit1ActionPerformed(evt);
            }
        });

        dcExp_date.setDateFormatString("yyyy-MM-dd");
        dcExp_date.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        dcExp_date.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dcExp_date.setOpaque(false);

        cbExp_expense_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExp_expense_typeActionPerformed(evt);
            }
        });

        btnExp_cancel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExp_cancel1.setText("Cancel");
        btnExp_cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExp_cancel1ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel35.setText("Date : ");

        tableInc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableInc.setModel(new javax.swing.table.DefaultTableModel(
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
        tableInc.setRowHeight(25);
        jScrollPane3.setViewportView(tableInc);

        tableExp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableExp.setModel(new javax.swing.table.DefaultTableModel(
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
        tableExp.setRowHeight(25);
        jScrollPane4.setViewportView(tableExp);

        cbExp_category.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Expense", "Income" }));
        cbExp_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExp_categoryActionPerformed(evt);
            }
        });

        cbExp_person.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExp_personActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel36.setText("For : ");

        jLabel39.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel39.setText("Balance : ");

        tfExp_amount_paid.setText("0");
        tfExp_amount_paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfExp_amount_paidActionPerformed(evt);
            }
        });
        tfExp_amount_paid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfExp_amount_paidKeyReleased(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel37.setText("Paid : ");

        tfExp_balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfExp_balanceActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setText("Credit : ");

        jLabel40.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel40.setText("Name : ");

        cbExp_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExp_nameActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Sakkal Majalla", 0, 18)); // NOI18N
        jLabel55.setText("Expense : ");
        jLabel55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel55MouseClicked(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Sakkal Majalla", 0, 18)); // NOI18N
        jLabel56.setText("Income : ");
        jLabel56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel56MouseClicked(evt);
            }
        });

        PanelExp_expense_type.setBackground(new java.awt.Color(255, 153, 153));
        PanelExp_expense_type.setLayout(new java.awt.CardLayout());

        jPanel6.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        PanelExp_expense_type.add(jPanel6, "card0");

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        tfExp_panel_expense_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfExp_panel_expense_typeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tfExp_panel_expense_type, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(tfExp_panel_expense_type, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelExp_expense_type.add(jPanel2, "card1");

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 153, 51));
        jLabel62.setText("+");
        jLabel62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel62MouseClicked(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 0, 0));
        jLabel63.setText("-");
        jLabel63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel63MouseClicked(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel65.setText("Balance : ");

        jLabel66.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel66.setText("Credit :");

        lbExp_credit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbExp_credit.setForeground(new java.awt.Color(255, 0, 0));
        lbExp_credit.setText("0");

        lbExp_balance.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbExp_balance.setForeground(new java.awt.Color(0, 153, 0));
        lbExp_balance.setText("0");

        PanelExp_desc_qty.setBackground(new java.awt.Color(255, 153, 153));
        PanelExp_desc_qty.setLayout(new java.awt.CardLayout());

        jPanel16.setBackground(new java.awt.Color(255, 153, 153));

        jLabel54.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel54.setText("Description:");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfExp_description, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfExp_description, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        PanelExp_desc_qty.add(jPanel16, "card1");

        jPanel17.setBackground(new java.awt.Color(255, 153, 153));

        jLabel60.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel60.setText("Qty:");

        jLabel84.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel84.setText("Bdls:");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfExp_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfExp_bdls, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfExp_bdls, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfExp_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        PanelExp_desc_qty.add(jPanel17, "card2");

        btnExp_delete1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExp_delete1.setText("Delete");
        btnExp_delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExp_delete1ActionPerformed(evt);
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
                        .addComponent(jLabel56)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel55)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel66)
                                .addGap(12, 12, 12))
                            .addComponent(jLabel65)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel40))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbExp_name, 0, 140, Short.MAX_VALUE)
                                    .addComponent(tfExp_credit)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dcExp_date, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbExp_category, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PanelExp_desc_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfExp_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbExp_person, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfExp_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnExp_submit1)
                        .addGap(18, 18, 18)
                        .addComponent(btnExp_cancel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbExp_expense_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfExp_amount_paid, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbExp_credit, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(lbExp_balance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelExp_expense_type, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel62)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExp_delete1)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(lbExp_balance)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbExp_credit))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel65)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel66))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelExp_expense_type, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel62)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(cbExp_person, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfExp_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbExp_category, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(11, 11, 11)
                                    .addComponent(PanelExp_desc_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfExp_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dcExp_date, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbExp_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(cbExp_expense_type, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(19, 19, 19)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfExp_amount_paid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfExp_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnExp_cancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExp_delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnExp_submit1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26))))
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelExpenseIncomeLayout = new javax.swing.GroupLayout(PanelExpenseIncome);
        PanelExpenseIncome.setLayout(PanelExpenseIncomeLayout);
        PanelExpenseIncomeLayout.setHorizontalGroup(
            PanelExpenseIncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelExpenseIncomeLayout.setVerticalGroup(
            PanelExpenseIncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PanelHome.add(PanelExpenseIncome, "cardexpenseincome");

        PanelNewEntries.setBackground(new java.awt.Color(255, 153, 153));

        jPanel11.setBackground(new java.awt.Color(255, 153, 153));

        tableNP1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableNP1.setModel(new javax.swing.table.DefaultTableModel(
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
        tableNP1.setRowHeight(25);
        jScrollPane5.setViewportView(tableNP1);

        btnNP_delete.setText("Delete");
        btnNP_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNP_deleteActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 153, 153));

        jLabel44.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel44.setText("Contact No : ");

        jLabel46.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel46.setText("Name : ");

        jLabel43.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel43.setText("Address : ");

        jLabel42.setFont(new java.awt.Font("Sakkal Majalla", 1, 24)); // NOI18N
        jLabel42.setText("New People : ");

        cbNP_people_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seller", "Customer", "Others", "Company", "Finance" }));
        cbNP_people_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNP_people_typeActionPerformed(evt);
            }
        });

        tfNP_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNP_addressActionPerformed(evt);
            }
        });

        btnNP_submit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNP_submit.setText("Submit");
        btnNP_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNP_submitActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel41.setText("People Type : ");

        jLabel47.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel47.setText("Comments : ");

        btnNP_cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNP_cancel.setText("Cancel");
        btnNP_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNP_cancelActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel45.setText("Email : ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(btnNP_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnNP_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfNP_contact_no, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbNP_people_type, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfNP_name)
                                .addComponent(tfNP_email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfNP_address, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfNP_comments, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(tfNP_address, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfNP_comments, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbNP_people_type, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfNP_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNP_contact_no, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNP_email, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNP_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNP_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNP_delete)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap(119, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNP_delete)
                .addGap(39, 39, 39))
        );

        jButton3.setText("Delete");

        javax.swing.GroupLayout PanelNewEntriesLayout = new javax.swing.GroupLayout(PanelNewEntries);
        PanelNewEntries.setLayout(PanelNewEntriesLayout);
        PanelNewEntriesLayout.setHorizontalGroup(
            PanelNewEntriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNewEntriesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNewEntriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNewEntriesLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(786, 786, 786))
                    .addGroup(PanelNewEntriesLayout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        PanelNewEntriesLayout.setVerticalGroup(
            PanelNewEntriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNewEntriesLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        PanelHome.add(PanelNewEntries, "cardnewentries");

        PanelBalanceCredit.setBackground(new java.awt.Color(255, 153, 153));

        jPanel20.setBackground(new java.awt.Color(255, 153, 153));

        tfBC_balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBC_balanceActionPerformed(evt);
            }
        });

        cbBC_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBC_nameActionPerformed(evt);
            }
        });

        lbBC_credit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbBC_credit.setForeground(new java.awt.Color(255, 0, 0));
        lbBC_credit.setText("0");

        jLabel85.setFont(new java.awt.Font("Sakkal Majalla", 1, 24)); // NOI18N
        jLabel85.setText("Balance Credit : ");

        jLabel64.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel64.setText("Name : ");

        btnBC_rcv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBC_rcv.setText("Rcv");
        btnBC_rcv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBC_rcvActionPerformed(evt);
            }
        });

        lbBC_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbBC_name.setForeground(new java.awt.Color(0, 0, 204));
        lbBC_name.setText("####");

        lbBC_balance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbBC_balance.setForeground(new java.awt.Color(0, 153, 0));
        lbBC_balance.setText("0");

        btnBC_pay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBC_pay.setText("Pay");
        btnBC_pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBC_payActionPerformed(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel68.setText("Balance : ");

        jLabel67.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel67.setText("Credit : ");

        dcBC_date.setDateFormatString("yyyy-MM-dd");
        dcBC_date.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        dcBC_date.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        dcBC_date.setOpaque(false);

        jLabel98.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel98.setText("Date : ");

        cbBC_payment_mode1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Transaction" }));

        cbBC_payment_mode2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Transaction" }));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel85)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel98)
                        .addGap(18, 18, 18)
                        .addComponent(dcBC_date, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel68)
                            .addComponent(jLabel64)
                            .addComponent(jLabel67))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbBC_name, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lbBC_balance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                .addComponent(lbBC_credit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfBC_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfBC_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbBC_name))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbBC_payment_mode1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbBC_payment_mode2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)))
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBC_pay)
                    .addComponent(btnBC_rcv))
                .addGap(24, 24, 24))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcBC_date, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel85)
                        .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBC_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBC_name))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBC_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBC_pay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBC_credit)
                    .addComponent(cbBC_payment_mode1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBC_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBC_rcv, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBC_balance)
                    .addComponent(cbBC_payment_mode2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tableBC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableBC.setModel(new javax.swing.table.DefaultTableModel(
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
        tableBC.setRowHeight(25);
        jScrollPane16.setViewportView(tableBC);

        lbBC_type.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbBC_type.setForeground(new java.awt.Color(102, 102, 255));
        lbBC_type.setText("#############");

        javax.swing.GroupLayout PanelBalanceCreditLayout = new javax.swing.GroupLayout(PanelBalanceCredit);
        PanelBalanceCredit.setLayout(PanelBalanceCreditLayout);
        PanelBalanceCreditLayout.setHorizontalGroup(
            PanelBalanceCreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBalanceCreditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBalanceCreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBalanceCreditLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(lbBC_type)
                        .addGap(39, 39, 39)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 205, Short.MAX_VALUE))
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        PanelBalanceCreditLayout.setVerticalGroup(
            PanelBalanceCreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBalanceCreditLayout.createSequentialGroup()
                .addGroup(PanelBalanceCreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBalanceCreditLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(lbBC_type))
                    .addGroup(PanelBalanceCreditLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelHome.add(PanelBalanceCredit, "cardbalancecredit");

        PanelAmountComparision.setBackground(new java.awt.Color(255, 153, 153));

        jPanel12.setBackground(new java.awt.Color(255, 153, 153));

        jLabel75.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel75.setText("Last Updated : ");

        jLabel70.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel70.setText("Your Invest : ");

        jLabel71.setFont(new java.awt.Font("Sakkal Majalla", 1, 24)); // NOI18N
        jLabel71.setText("Amount Flow Comparison with : ");

        tableAC1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableAC1.setModel(new javax.swing.table.DefaultTableModel(
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
        tableAC1.setRowHeight(25);
        jScrollPane7.setViewportView(tableAC1);

        lbAC_name1.setFont(new java.awt.Font("Sakkal Majalla", 3, 24)); // NOI18N
        lbAC_name1.setText("                                        ");

        lbAC_last_updated.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbAC_last_updated.setText("                       ");

        tableAC2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableAC2.setModel(new javax.swing.table.DefaultTableModel(
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
        tableAC2.setRowHeight(25);
        jScrollPane6.setViewportView(tableAC2);

        jLabel73.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel73.setText("Invest : ");

        lbAC_name2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbAC_name2.setText("                          ");

        cbAC_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAC_nameActionPerformed(evt);
            }
        });

        lbAC_difference.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbAC_difference.setForeground(java.awt.Color.blue);
        lbAC_difference.setText("######");

        lbAC_total2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbAC_total2.setText("######");

        lbAC_total1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbAC_total1.setText("######");

        lbAC_balance_credit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbAC_balance_credit.setText("@@@@@@@");

        lbAC_last_updated1.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lbAC_last_updated1.setForeground(new java.awt.Color(246, 1, 1));
        lbAC_last_updated1.setText("X");
        lbAC_last_updated1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAC_last_updated1MouseClicked(evt);
            }
        });
        lbAC_last_updated1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbAC_last_updated1KeyPressed(evt);
            }
        });

        btnAC_seen.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnAC_seen.setText("Seen");
        btnAC_seen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAC_seenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(btnAC_seen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbAC_total1))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(cbAC_name, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbAC_difference)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbAC_balance_credit))
                            .addComponent(jLabel70)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbAC_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel75)
                        .addGap(33, 33, 33)
                        .addComponent(lbAC_last_updated)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAC_last_updated1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(lbAC_name2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel73)
                        .addContainerGap(373, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(lbAC_total2)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel71)
                            .addComponent(lbAC_name1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbAC_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAC_difference)
                            .addComponent(lbAC_balance_credit)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(lbAC_last_updated)
                            .addComponent(lbAC_last_updated1))))
                .addGap(23, 23, 23)
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAC_seen)
                    .addComponent(lbAC_total2)
                    .addComponent(lbAC_total1))
                .addGap(82, 82, 82))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAC_name2)
                    .addComponent(jLabel73))
                .addGap(460, 460, 460))
        );

        javax.swing.GroupLayout PanelAmountComparisionLayout = new javax.swing.GroupLayout(PanelAmountComparision);
        PanelAmountComparision.setLayout(PanelAmountComparisionLayout);
        PanelAmountComparisionLayout.setHorizontalGroup(
            PanelAmountComparisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelAmountComparisionLayout.setVerticalGroup(
            PanelAmountComparisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAmountComparisionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelHome.add(PanelAmountComparision, "cardamountcomparision");

        PanelFibreStock.setBackground(new java.awt.Color(255, 153, 153));

        jPanel14.setBackground(new java.awt.Color(255, 153, 153));

        tableSR2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableSR2.setModel(new javax.swing.table.DefaultTableModel(
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
        tableSR2.setRowHeight(25);
        jScrollPane11.setViewportView(tableSR2);

        tableSR1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableSR1.setModel(new javax.swing.table.DefaultTableModel(
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
        tableSR1.setRowHeight(25);
        jScrollPane9.setViewportView(tableSR1);

        jLabel59.setText("Bundles : ");

        jLabel80.setText("Fibre Stock : ");

        jLabel90.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel90.setText("Quantity : ");

        btnSE_fibre_enter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSE_fibre_enter.setText("Enter");
        btnSE_fibre_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSE_fibre_enterActionPerformed(evt);
            }
        });

        dcSE_date.setDateFormatString("dd-MM-yyyy");
        dcSE_date.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        dcSE_date.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dcSE_date.setOpaque(false);

        jLabel89.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel89.setText("Bundles : ");

        jLabel83.setFont(new java.awt.Font("FreeSerif", 1, 18)); // NOI18N
        jLabel83.setText("Fibre Production :  ");

        tfSE_fibre_production.setText("0");
        tfSE_fibre_production.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSE_fibre_productionActionPerformed(evt);
            }
        });
        tfSE_fibre_production.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSE_fibre_productionKeyReleased(evt);
            }
        });

        tfSE_fibre_qty.setText("0");
        tfSE_fibre_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSE_fibre_qtyActionPerformed(evt);
            }
        });
        tfSE_fibre_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSE_fibre_qtyKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel83)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel89)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfSE_fibre_production)
                            .addComponent(tfSE_fibre_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSE_fibre_enter)
                    .addComponent(jLabel90)
                    .addComponent(dcSE_date, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane11)
                    .addComponent(jLabel80, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel80)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel83)
                        .addGap(21, 21, 21)
                        .addComponent(dcSE_date, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfSE_fibre_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tfSE_fibre_production, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSE_fibre_enter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout PanelFibreStockLayout = new javax.swing.GroupLayout(PanelFibreStock);
        PanelFibreStock.setLayout(PanelFibreStockLayout);
        PanelFibreStockLayout.setHorizontalGroup(
            PanelFibreStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelFibreStockLayout.setVerticalGroup(
            PanelFibreStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFibreStockLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelHome.add(PanelFibreStock, "cardstockrecord");

        PanelCoirStock.setBackground(new java.awt.Color(255, 153, 153));

        jPanel18.setBackground(new java.awt.Color(255, 153, 153));

        tableSR4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableSR4.setModel(new javax.swing.table.DefaultTableModel(
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
        tableSR4.setRowHeight(25);
        jScrollPane12.setViewportView(tableSR4);

        tableSR3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableSR3.setModel(new javax.swing.table.DefaultTableModel(
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
        tableSR3.setRowHeight(25);
        jScrollPane13.setViewportView(tableSR3);

        jLabel87.setText("Bundles : ");

        jLabel88.setText("Coir Stock : ");

        jLabel57.setFont(new java.awt.Font("FreeSerif", 1, 18)); // NOI18N
        jLabel57.setText("Coir Production : ");

        jLabel91.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel91.setText("Bundles : ");

        tfSE_coir_production_bundles.setText("0");
        tfSE_coir_production_bundles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSE_coir_production_bundlesActionPerformed(evt);
            }
        });
        tfSE_coir_production_bundles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSE_coir_production_bundlesKeyReleased(evt);
            }
        });

        tfSE_coir_production_qty.setText("0");
        tfSE_coir_production_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSE_coir_production_qtyActionPerformed(evt);
            }
        });
        tfSE_coir_production_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSE_coir_production_qtyKeyReleased(evt);
            }
        });

        jLabel92.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel92.setText("Quantity : ");

        jLabel93.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel93.setText("Windings:");

        tfSE_coir_windings.setText("0");
        tfSE_coir_windings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSE_coir_windingsActionPerformed(evt);
            }
        });
        tfSE_coir_windings.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSE_coir_windingsKeyReleased(evt);
            }
        });

        btnSE_yarn_enter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSE_yarn_enter.setText("Enter");
        btnSE_yarn_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSE_yarn_enterActionPerformed(evt);
            }
        });

        dcSE_date1.setDateFormatString("dd-MM-yyyy");
        dcSE_date1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        dcSE_date1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dcSE_date1.setOpaque(false);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSE_yarn_enter)
                    .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel91)
                            .addComponent(jLabel92)
                            .addComponent(jLabel93))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfSE_coir_production_bundles, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfSE_coir_windings, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                .addComponent(tfSE_coir_production_qty, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addComponent(dcSE_date1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane12)
                    .addComponent(jLabel88, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel87, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel88)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addGap(26, 26, 26)
                        .addComponent(dcSE_date1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSE_coir_production_bundles, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSE_coir_production_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSE_coir_windings, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(btnSE_yarn_enter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel87)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelCoirStockLayout = new javax.swing.GroupLayout(PanelCoirStock);
        PanelCoirStock.setLayout(PanelCoirStockLayout);
        PanelCoirStockLayout.setHorizontalGroup(
            PanelCoirStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelCoirStockLayout.setVerticalGroup(
            PanelCoirStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PanelHome.add(PanelCoirStock, "cardcoirstock");

        PanelAccountsRecord.setBackground(new java.awt.Color(255, 153, 153));

        PanelViewChoose.setBackground(new java.awt.Color(255, 153, 153));
        PanelViewChoose.setLayout(new java.awt.CardLayout());

        PanelDaily.setBackground(new java.awt.Color(255, 153, 153));

        tableAR1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableAR1.setModel(new javax.swing.table.DefaultTableModel(
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
        tableAR1.setRowHeight(25);
        jScrollPane14.setViewportView(tableAR1);

        javax.swing.GroupLayout PanelDailyLayout = new javax.swing.GroupLayout(PanelDaily);
        PanelDaily.setLayout(PanelDailyLayout);
        PanelDailyLayout.setHorizontalGroup(
            PanelDailyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDailyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelDailyLayout.setVerticalGroup(
            PanelDailyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDailyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelViewChoose.add(PanelDaily, "carddaily");

        PanelBetween.setBackground(new java.awt.Color(255, 153, 153));

        tableAR2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableAR2.setModel(new javax.swing.table.DefaultTableModel(
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
        tableAR2.setRowHeight(25);
        jScrollPane10.setViewportView(tableAR2);

        dcAR_date1.setDateFormatString("yyyy-MM-dd");
        dcAR_date1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        dcAR_date1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        dcAR_date1.setOpaque(false);

        jLabel81.setText("From : ");

        dcAR_date2.setDateFormatString("yyyy-MM-dd");
        dcAR_date2.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        dcAR_date2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        dcAR_date2.setOpaque(false);

        jLabel94.setText("To : ");

        btnAR_select.setText("SELECT");
        btnAR_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAR_selectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBetweenLayout = new javax.swing.GroupLayout(PanelBetween);
        PanelBetween.setLayout(PanelBetweenLayout);
        PanelBetweenLayout.setHorizontalGroup(
            PanelBetweenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBetweenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBetweenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10)
                    .addGroup(PanelBetweenLayout.createSequentialGroup()
                        .addComponent(jLabel81)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dcAR_date1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel94)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dcAR_date2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAR_select)
                        .addGap(0, 394, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelBetweenLayout.setVerticalGroup(
            PanelBetweenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBetweenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelBetweenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dcAR_date1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dcAR_date2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btnAR_select, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelViewChoose.add(PanelBetween, "cardbetween");

        jLabel95.setText("From : ");

        dcAR_date3.setDateFormatString("yyyy-MM-dd");
        dcAR_date3.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        dcAR_date3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        dcAR_date3.setOpaque(false);

        jLabel96.setText("To : ");

        dcAR_date4.setDateFormatString("yyyy-MM-dd");
        dcAR_date4.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        dcAR_date4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        dcAR_date4.setOpaque(false);

        btnAR_select1.setText("SELECT");
        btnAR_select1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAR_select1ActionPerformed(evt);
            }
        });

        tableAR3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableAR3.setModel(new javax.swing.table.DefaultTableModel(
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
        tableAR3.setRowHeight(25);
        jScrollPane15.setViewportView(tableAR3);

        javax.swing.GroupLayout ProdProfitLayout = new javax.swing.GroupLayout(ProdProfit);
        ProdProfit.setLayout(ProdProfitLayout);
        ProdProfitLayout.setHorizontalGroup(
            ProdProfitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProdProfitLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProdProfitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15)
                    .addGroup(ProdProfitLayout.createSequentialGroup()
                        .addComponent(jLabel95)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dcAR_date3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel96)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dcAR_date4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAR_select1)
                        .addGap(0, 394, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ProdProfitLayout.setVerticalGroup(
            ProdProfitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProdProfitLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ProdProfitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dcAR_date3, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dcAR_date4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btnAR_select1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelViewChoose.add(ProdProfit, "cardprodprofit");

        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLabel61.setText("daily record");
        jLabel61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel61MouseClicked(evt);
            }
        });
        jLabel61.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel61KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel61)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel13MouseClicked(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLabel69.setText("select range");
        jLabel69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel69MouseClicked(evt);
            }
        });
        jLabel69.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel69KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLabel72.setText("Production");
        jLabel72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel72MouseClicked(evt);
            }
        });
        jLabel72.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel72KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel72)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelAccountsRecordLayout = new javax.swing.GroupLayout(PanelAccountsRecord);
        PanelAccountsRecord.setLayout(PanelAccountsRecordLayout);
        PanelAccountsRecordLayout.setHorizontalGroup(
            PanelAccountsRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAccountsRecordLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAccountsRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addComponent(PanelViewChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelAccountsRecordLayout.setVerticalGroup(
            PanelAccountsRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAccountsRecordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(PanelViewChoose, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        PanelHome.add(PanelAccountsRecord, "cardaccountsrecord");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(PanelHome, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        CardLayout cl = (CardLayout)(PanelHome.getLayout());
        cl.show(PanelHome, "cardplain");
    }//GEN-LAST:event_jLabel48MouseClicked

    private void jLabel49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseClicked
        CardLayout cl = (CardLayout)(PanelHome.getLayout());
        cl.show(PanelHome, "cardsales");
        
        FormLoad();
    }//GEN-LAST:event_jLabel49MouseClicked

    private void jLabel49KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel49KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel49KeyPressed

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        CardLayout cl = (CardLayout)(PanelHome.getLayout());
        cl.show(PanelHome, "cardpurchase");
        
        FormLoad();
    }//GEN-LAST:event_jLabel50MouseClicked

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
        CardLayout cl = (CardLayout)(PanelHome.getLayout());
        cl.show(PanelHome, "cardexpenseincome");
        FormLoad();
    }//GEN-LAST:event_jLabel51MouseClicked

    private void jLabel52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel52MouseClicked
        CardLayout cl = (CardLayout)(PanelHome.getLayout());
        cl.show(PanelHome, "cardnewentries");
        FormLoad();
    }//GEN-LAST:event_jLabel52MouseClicked

    private void jLabel53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseClicked
        CardLayout cl = (CardLayout)(PanelHome.getLayout());
        cl.show(PanelHome, "cardbalancecredit");
        FormLoad();
    }//GEN-LAST:event_jLabel53MouseClicked

    private void btnCS_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCS_submitActionPerformed

        
        if(dcCS_date.getDate() == null)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select Date");
        }
        else if(cbCS_customer_name.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select Name");
        }
        else if(cbCS_payment_type.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select Payment Type");
        }
        else if(cbCS_payment_mode.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select Payment Mode");
        }
        else if(tfCS_quantity.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Quantity");
        }
        else if(tfCS_bundles.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Number Of Bundles");
        }
        else if(tfCS_total_amount.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Total Amount");
        }
        else if(tfCS_amount_paid.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Amount Paid");
        }        
        else
        {
            
            String prod = "Coir";
            Date d1 = dcCS_date.getDate();
            String dat = df.format(d1);
            int count1,count2 = 0;
               count1 = DateInit("ExpenseIncome",dat);
               count2 = DateInit("CoirStock",dat);
            if((count1==1)&&(count2==1))
            {
               String name = cbCS_customer_name.getSelectedItem().toString();
            String ptype = cbCS_payment_type.getSelectedItem().toString();
            String pmode = cbCS_payment_mode.getSelectedItem().toString();
            Float qty = Float.parseFloat(tfCS_quantity.getText());
            Float bdls = Float.parseFloat(tfCS_bundles.getText());
            Float tamt = Float.parseFloat(tfCS_total_amount.getText());
            Float paid = Float.parseFloat(tfCS_amount_paid.getText());
            Float bal = Float.parseFloat(tfCS_balance.getText());
            Float credit = Float.parseFloat(tfCS_credit.getText());
            Float ur = Float.parseFloat(lbCS_unit_rate.getText());
            String sent = "Pending";
            if(chkbCS_coir_sent.isSelected()==true)
            {
                sent = dat;
            }

            try
            {
                String sql = "Insert into FibreCoir(Date,Product,Name,Payment_Type,"
                + "Quantity,Bundles,Total_Amount,Amount_Paid,Balance,Credit,Payment_Mode,Transportation)"
                + "Values(?,?,?,?,?,?,?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, dat);
                pst.setString(2, prod);
                pst.setString(3, name);
                pst.setString(4, ptype);
                pst.setFloat(5, qty);
                pst.setFloat(6, bdls);
                pst.setFloat(7, tamt);
                pst.setFloat(8, paid);
                pst.setFloat(9, bal);
                pst.setFloat(10, credit);
                pst.setString(11, pmode);
                pst.setString(12, sent);
                pst.executeUpdate();

                cbCS_customer_name.setSelectedIndex(-1);
                cbCS_payment_type.setSelectedIndex(-1);
                cbCS_payment_mode.setSelectedIndex(-1);
                tfCS_quantity.setText("");
                tfCS_bundles.setText("");
                tfCS_total_amount.setText("");
                tfCS_amount_paid.setText("");
                tfCS_balance.setText("0");
                tfCS_credit.setText("0");
                chkbCS_coir_sent.setSelected(false);
                JOptionPane.showMessageDialog(rootPane, "Entry Success");

            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Database Error#"+er);}
            finally
            {
                try{pst.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close con error#" + er);}
            }
            
            //=====================select row id from above insertion==============
            int id = 0;
            try
                  {
                      String sel = "SELECT * FROM FibreCoir Order By S_No DESC LIMIT 1";
                      st1 = con.createStatement();
                      rs1 = st1.executeQuery(sel);

                      while(rs1.next())
                      {
                          id = rs1.getInt("S_No");                          
                      }
                  }
                  catch(Exception er)
                  {
                      JOptionPane.showMessageDialog(null, "aaaa5"+er); 
                  }
                  finally
                 {
                    try
                   {

                    st1.close();
                    rs1.close();

                    }catch(Exception er)
                    {
                     JOptionPane.showMessageDialog(null, er); 
                    }

                  }
            
            //==============Insert Into ExpenseIncome===============
            try
            {
                String catg = "Income";
                String etype = "Coir Sales";
                String sql = "Insert into ExpenseIncome(Date,Category,Person,Expense_Type,Name,Description,Amount,Amount_Paid,Balance,Credit,Reference_Id)"
                + "Values(?,?,?,?,?,?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, dat);
                pst.setString(2, catg);
                pst.setString(3, "Self");
                pst.setString(4, etype);
                pst.setString(5, name);
                pst.setString(6, Float.toString(qty));
                pst.setFloat(7, tamt);
                pst.setFloat(8, paid);
                pst.setFloat(9, bal);
                pst.setFloat(10, credit);
                pst.setInt(11, id);

                pst.executeUpdate();
            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Database Error#"+er);}
            finally
            {
                try{pst.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close con error#" + er);}
            }
            //-----------Stock Entry and Update-----------------------------//
             CoirStock("CoirStock",dat,qty,ur);
             CoirStock("CoirStockB",dat,bdls,ur);
            BalanceCredit(name, bal, credit);
            Accounts("Income",dat,paid); 
            }
            else
            {                
             JOptionPane.showMessageDialog(null, "You cannot enter on this date");
            }
            
        }
    }//GEN-LAST:event_btnCS_submitActionPerformed

    private void tfCS_creditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCS_creditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCS_creditActionPerformed

    private void cbCS_payment_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCS_payment_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCS_payment_typeActionPerformed

    private void chkbCS_coir_sentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbCS_coir_sentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkbCS_coir_sentActionPerformed

    private void tfCS_amount_paidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCS_amount_paidActionPerformed
        float a = Float.parseFloat(tfCS_total_amount.getText());
        float b = Float.parseFloat(tfCS_amount_paid.getText());
        if(a>b)
        {
            tfCS_balance.setText(Float.toString(a-b));
            tfCS_credit.setText("0");
        }
        else
        {
            tfCS_credit.setText(Float.toString(b-a));
            tfCS_balance.setText("0");
        }
    }//GEN-LAST:event_tfCS_amount_paidActionPerformed

    private void tfCS_amount_paidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCS_amount_paidKeyReleased
        float a = Float.parseFloat(tfCS_total_amount.getText());
        float b = Float.parseFloat(tfCS_amount_paid.getText());
        if(a>b)
        {
            tfCS_balance.setText(Float.toString(a-b));
            tfCS_credit.setText("0");
        }
        else
        {
            tfCS_credit.setText(Float.toString(b-a));
            tfCS_balance.setText("0");
        }
    }//GEN-LAST:event_tfCS_amount_paidKeyReleased

    private void cbCS_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCS_customer_nameActionPerformed
        if(cbCS_customer_name.getSelectedIndex() == -1)
        {
            hsbTable(con,"Select S_No,Date,Name,Payment_Type,Quantity,Bundles,Total_Amount,Amount_Paid,Balance,Credit,Payment_Mode,Transportation From FibreCoir Where Product = 'Coir'",tableCS1);
            
        }
        else
        {
            String name = cbCS_customer_name.getSelectedItem().toString();
            hsbTable(con,"Select S_No,Date,Name,Payment_Type,Quantity,Bundles,Total_Amount,Amount_Paid,Balance,Credit,Payment_Mode,Transportation From FibreCoir Where Product = 'Coir' AND Name = '"+name+"'",tableCS1);
            UpdateLabel(con,"Select * From People Where Name = '"+name+"'","Balance",lbCS_balance);
            UpdateLabel(con,"Select * From People Where Name = '"+name+"'","Credit",lbCS_credit);
            float bal1 = Float.parseFloat(lbCS_balance.getText());
            float credit1 = Float.parseFloat(lbCS_credit.getText());
            float diff;
            if(bal1 > credit1)
            {
                diff = bal1 - credit1;
                lbCS_balance.setText(Float.toString(diff));
                lbCS_credit.setText("0");
            }
            else if(credit1 > bal1)
            {
                diff = credit1 - bal1;
                lbCS_credit.setText(Float.toString(diff));
                lbCS_balance.setText("0");
            }
        }
         btnCS_delete.setVisible(true);
    }//GEN-LAST:event_cbCS_customer_nameActionPerformed

    private void lbCS_unit_rateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCS_unit_rateMouseClicked
        PriceUpdate n = new PriceUpdate();
        n.setVisible(true);
    }//GEN-LAST:event_lbCS_unit_rateMouseClicked

    private void btnCS_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCS_cancelActionPerformed
         btnCS_delete.setVisible(true);
        cbCS_customer_name.setSelectedIndex(-1);
        cbCS_payment_type.setSelectedIndex(-1);
        cbCS_payment_mode.setSelectedIndex(-1);
        tfCS_quantity.setText("");
        tfCS_bundles.setText("");
        tfCS_total_amount.setText("");
        tfCS_amount_paid.setText("");
        tfCS_balance.setText("0");
        tfCS_credit.setText("0");
        chkbCS_coir_sent.setSelected(false);
    }//GEN-LAST:event_btnCS_cancelActionPerformed

    private void tfCS_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCS_quantityActionPerformed
        if(tfCS_quantity.getText().isEmpty())
        {}
        else{
            tfCS_total_amount.setText(Float.toString(DualMultiply(Float.parseFloat(lbCS_unit_rate.getText()), Float.parseFloat(tfCS_quantity.getText()))));
        }
    }//GEN-LAST:event_tfCS_quantityActionPerformed

    private void tfCS_quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCS_quantityKeyReleased
        if(tfCS_quantity.getText().isEmpty())
        {}
        else{
            tfCS_total_amount.setText(Float.toString(DualMultiply(Float.parseFloat(lbCS_unit_rate.getText()), Float.parseFloat(tfCS_quantity.getText()))));
        }
    }//GEN-LAST:event_tfCS_quantityKeyReleased

    private void btnFP_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFP_submitActionPerformed

        if(dcFP_date.getDate() == null)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select Date");
        }
        else if(cbFP_person.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select for person");
        }
        else if(cbFP_seller_name.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select Name");
        }
        else if(cbFP_payment_type.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select Payment Type");
        }
        else if(cbFP_payment_mode.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select Payment Mode");
        }
        else if(tfFP_quantity.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Quantity");
        }
        else if(tfFP_bundles.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Number Of Bundles");
        }
        else if(tfFP_total_amount.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Total Amount");
        }
        else if(tfFP_amount_paid.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Amount Paid");
        }
        else
        {
            String prod = "Fibre";
            Date d1 = dcFP_date.getDate();
            String dat = df.format(d1); 
            int count1,count2 = 0;
               count1 = DateInit("ExpenseIncome",dat);
               count2 = DateInit("FibreStock",dat);
            if((count1==1)&&(count2==1))
            {
                String name = cbFP_seller_name.getSelectedItem().toString();
            String ptype = cbFP_payment_type.getSelectedItem().toString();
            String pmode = cbFP_payment_mode.getSelectedItem().toString();
            Float qty = Float.parseFloat(tfFP_quantity.getText());
            Float bdls = Float.parseFloat(tfFP_bundles.getText());
            Float tamt = Float.parseFloat(tfFP_total_amount.getText());
            Float paid = Float.parseFloat(tfFP_amount_paid.getText());
            Float credit = Float.parseFloat(tfFP_Credit.getText());
            Float bal = Float.parseFloat(tfFP_balance.getText());
            Float ur = Float.parseFloat(lbFP_unit_rate.getText());
            String sent = "Pending";
            String person = cbFP_person.getSelectedItem().toString();
            if(chkbFP_fibre_received.isSelected()==true)
            {
                sent = dat;
            }

            try
            {
                String sql = "Insert into FibreCoir(Date,Product,Name,Payment_Type,"
                + "Quantity,Bundles,Total_Amount,Amount_Paid,Balance,Credit,Payment_Mode,Transportation)"
                + "Values(?,?,?,?,?,?,?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, dat);
                pst.setString(2, prod);
                pst.setString(3, name);
                pst.setString(4, ptype);
                pst.setFloat(5, qty);
                pst.setFloat(6, bdls);
                pst.setFloat(7, tamt);
                pst.setFloat(8, paid);
                pst.setFloat(9, bal);
                pst.setFloat(10, credit);
                pst.setString(11, pmode);
                pst.setString(12, sent);
                pst.executeUpdate();

                cbFP_seller_name.setSelectedIndex(-1);
                cbFP_payment_type.setSelectedIndex(-1);
                cbFP_payment_mode.setSelectedIndex(-1);
                tfFP_quantity.setText("");
                tfFP_bundles.setText("");
                tfFP_total_amount.setText("");
                tfFP_amount_paid.setText("");
                tfFP_Credit.setText("0");
                tfFP_balance.setText("0");
                chkbFP_fibre_received.setSelected(false);
                JOptionPane.showMessageDialog(rootPane, "Entry Success");

            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Database Error#"+er);}
            finally
            {
                try{pst.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close con error#" + er);}
            }
            //========================select sno of previous entry===================
            int id = 0;
            try
                  {
                      String sel = "SELECT * FROM FibreCoir Order By S_No DESC LIMIT 1";
                      st1 = con.createStatement();
                      rs1 = st1.executeQuery(sel);

                      while(rs1.next())
                      {
                          id = rs1.getInt("S_No");                          
                      }
                  }
                  catch(Exception er)
                  {
                      JOptionPane.showMessageDialog(null, "aaaa5"+er); 
                  }
                  finally
                 {
                    try
                   {

                    st1.close();
                    rs1.close();

                    }catch(Exception er)
                    {
                     JOptionPane.showMessageDialog(null, er); 
                    }

                  }
            //==============Insert Into ExpenseIncome===============
            String catg = null;
            try
            {
                
                if(person.equals("self"))
                {
                  catg = "Expense";  
                }
                else
                {
                    catg = "Income";
                }
                
                String etype = "Fibre Purchase";
                String sql = "Insert into ExpenseIncome(Date,Category,Person,Expense_Type,Name,Description,Amount,Amount_Paid,Balance,Credit,Reference_Id)"
                + "Values(?,?,?,?,?,?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, dat);
                pst.setString(2, catg);
                pst.setString(3, person);
                pst.setString(4, etype);
                pst.setString(5, name);
                pst.setString(6, Float.toString(qty));
                pst.setFloat(7, tamt);
                pst.setFloat(8, paid);
                pst.setFloat(9, bal);
                pst.setFloat(10, credit);
                pst.setInt(11,id);
                pst.executeUpdate();
            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Database Error#"+er);}
            finally
            {
                try{pst.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close con error#" + er);}
            }
            
            //-----------Stock Entry and Update-----------------------------//
            FibreStock("FibreStock",dat,qty,ur); 
            FibreStock("FibreStockB",dat,bdls,ur); 
            BalanceCredit(name, bal, credit);
            Accounts(catg,dat,paid);
            Accounts1(catg,dat,paid);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You cannot enter on this date");
            }
            
            
        }
    }//GEN-LAST:event_btnFP_submitActionPerformed

    private void tfFP_balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFP_balanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFP_balanceActionPerformed

    private void cbFP_payment_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFP_payment_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFP_payment_typeActionPerformed

    private void chkbFP_fibre_receivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbFP_fibre_receivedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkbFP_fibre_receivedActionPerformed

    private void tfFP_amount_paidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFP_amount_paidActionPerformed
        float a = Float.parseFloat(tfFP_total_amount.getText());
        float b = Float.parseFloat(tfFP_amount_paid.getText());
        if(a>b)
        {
            tfFP_Credit.setText(Float.toString(a-b));
            tfFP_balance.setText("0");
        }
        else
        {
            tfFP_balance.setText(Float.toString(b-a));
            tfFP_Credit.setText("0");
        }
    }//GEN-LAST:event_tfFP_amount_paidActionPerformed

    private void tfFP_amount_paidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFP_amount_paidKeyReleased
        float a = Float.parseFloat(tfFP_total_amount.getText());
        float b = Float.parseFloat(tfFP_amount_paid.getText());
        if(a>b)
        {
            tfFP_Credit.setText(Float.toString(a-b));
            tfFP_balance.setText("0");
        }
        else
        {
            tfFP_balance.setText(Float.toString(b-a));
            tfFP_Credit.setText("0");
        }
    }//GEN-LAST:event_tfFP_amount_paidKeyReleased

    private void cbFP_seller_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFP_seller_nameActionPerformed
        if(cbFP_seller_name.getSelectedIndex() == -1)
        {
            hsbTable(con,"Select S_No,Date,Name,Payment_Type,Quantity,Bundles,Total_Amount,Amount_Paid,Balance,Credit,Payment_Mode,Transportation From FibreCoir Where Product = 'Fibre'",tableFP1);
        }
        else
        {
            String name = cbFP_seller_name.getSelectedItem().toString();
            hsbTable(con,"Select S_No,Date,Name,Payment_Type,Quantity,Bundles,Total_Amount,Amount_Paid,Balance,Credit,Payment_Mode,Transportation From FibreCoir Where Product = 'Fibre' AND Name = '"+name+"'",tableFP1);
            UpdateLabel(con,"Select * From People Where Name = '"+name+"'","Balance",lbFP_balance);
            UpdateLabel(con,"Select * From People Where Name = '"+name+"'","Credit",lbFP_credit);
            float bal1 = Float.parseFloat(lbFP_balance.getText());
            float credit1 = Float.parseFloat(lbFP_credit.getText());
            float diff;
            if(bal1 > credit1)
            {
                diff = bal1 - credit1;
                lbFP_balance.setText(Float.toString(diff));
                lbFP_credit.setText("0");
            }
            else if(credit1 > bal1)
            {
                diff = credit1 - bal1;
                lbFP_credit.setText(Float.toString(diff));
                lbFP_balance.setText("0");
            }

        }
        btnFP_delete.setVisible(true);
    }//GEN-LAST:event_cbFP_seller_nameActionPerformed

    private void lbFP_unit_rateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFP_unit_rateMouseClicked
        PriceUpdate n = new PriceUpdate();
        n.setVisible(true);
    }//GEN-LAST:event_lbFP_unit_rateMouseClicked

    private void btnFP_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFP_cancelActionPerformed
        btnFP_delete.setVisible(true);
        cbFP_seller_name.setSelectedIndex(-1);
        cbFP_payment_type.setSelectedIndex(-1);
        cbFP_payment_mode.setSelectedIndex(-1);
        tfFP_quantity.setText("");
        tfFP_bundles.setText("");
        tfFP_total_amount.setText("");
        tfFP_amount_paid.setText("");
        tfFP_Credit.setText("0");
        tfFP_balance.setText("0");
        chkbFP_fibre_received.setSelected(false);
    }//GEN-LAST:event_btnFP_cancelActionPerformed

    private void tfFP_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFP_quantityActionPerformed
        if(tfFP_quantity.getText().isEmpty())
        {}
        else{
            tfFP_total_amount.setText(Float.toString(DualMultiply(Float.parseFloat(lbFP_unit_rate.getText()), Float.parseFloat(tfFP_quantity.getText()))));
        }
    }//GEN-LAST:event_tfFP_quantityActionPerformed

    private void tfFP_quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFP_quantityKeyReleased
        if(tfFP_quantity.getText().isEmpty())
        {}
        else{
            tfFP_total_amount.setText(Float.toString(DualMultiply(Float.parseFloat(lbFP_unit_rate.getText()), Float.parseFloat(tfFP_quantity.getText()))));
        }
    }//GEN-LAST:event_tfFP_quantityKeyReleased

    private void btnExp_submit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExp_submit1ActionPerformed
        if(dcExp_date.getDate() == null)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select Date");
        }
        else if(cbExp_category.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select Category");
        }
        else if(cbExp_person.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select Person");
        }
        else if(cbExp_expense_type.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select Expense Type");
        }
        else if(tfExp_amount.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Total Amount");
        }
        else if(tfExp_amount_paid.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Amount Paid");
        }
        else if(cbExp_expense_type.getSelectedItem().toString().equals("Fibre Sales")&&tfExp_qty.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Quantity");
        }
        else if(cbExp_expense_type.getSelectedItem().toString().equals("Fibre Sales")&&tfExp_bdls.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Bundles");
        }
        else if(cbExp_expense_type.getSelectedItem().toString().equals("Finance"))
        {
            
            Date d1 = dcExp_date.getDate();
            String dat = df.format(d1);
             String name = cbExp_person.getSelectedItem().toString();
             String catg = "Finance";
            String etype = cbExp_expense_type.getSelectedItem().toString();
            String comp = cbExp_name.getSelectedItem().toString();
            String desc = tfExp_description.getText();
            Float tamt = Float.parseFloat(tfExp_amount.getText());
            Float paid = Float.parseFloat(tfExp_amount_paid.getText());
            Float bal = Float.parseFloat(tfExp_balance.getText());
            Float credit = Float.parseFloat(tfExp_credit.getText());
            try
            {
                String sql = "Insert into ExpenseIncome(Date,Category,Person,Expense_Type,Name,Description,Amount,Amount_Paid,Balance,Credit)"
                + "Values(?,?,?,?,?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, dat);
                pst.setString(2, catg);
                pst.setString(3, name);
                pst.setString(4, etype);
                pst.setString(5, comp);
                pst.setString(6, desc);
                pst.setFloat(7, tamt);
                pst.setFloat(8, paid);
                pst.setFloat(9, bal);
                pst.setFloat(10, credit);

                pst.executeUpdate();

                cbExp_category.setSelectedIndex(-1);
                cbExp_person.setSelectedIndex(-1);
                cbExp_name.setSelectedIndex(-1);
                cbExp_expense_type.setSelectedIndex(-1);
                tfExp_amount.setText("");
                tfExp_description.setText("0");
                tfExp_amount_paid.setText("0");
                tfExp_balance.setText("");
                tfExp_credit.setText("");
                BalanceCredit(comp, bal, credit);
                
                JOptionPane.showMessageDialog(rootPane, "Finance Entry Success");

            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Database Error Finance#"+er);}
            finally
            {
                try{pst.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close con error#" + er);}
            }
        }
        else
        {
                String catg = cbExp_category.getSelectedItem().toString();;
            Date d1 = dcExp_date.getDate();
            String dat = df.format(d1);
            String name = cbExp_person.getSelectedItem().toString();
            String etype = cbExp_expense_type.getSelectedItem().toString();
             int count1,count2,count3 = 0;
               count1 = DateInit("ExpenseIncome",dat);
               count2 = DateInit("CoirStock",dat);
               count3 = DateInit("FibreStock",dat);
            if((count1==1)&&(count2==1)&&(count3==1))
            {
              String comp = cbExp_name.getSelectedItem().toString();
            String desc = tfExp_description.getText();
            Float tamt = Float.parseFloat(tfExp_amount.getText());
            Float paid = Float.parseFloat(tfExp_amount_paid.getText());
            Float bal = Float.parseFloat(tfExp_balance.getText());
            Float credit = Float.parseFloat(tfExp_credit.getText());
            Float ur = Float.parseFloat(lbFP_unit_rate.getText());
            Float qty = null;
            Float bdls = null;
            if(cbExp_expense_type.getSelectedItem().toString().equals("Fibre Sales"))
            {
                qty = Float.parseFloat(tfExp_qty.getText());
                bdls = Float.parseFloat(tfExp_bdls.getText());
                desc = qty + " Kgs & " + bdls + "";
                BalanceCredit(comp, bal, credit);
                
            }
            
            try
            {
                String sql = "Insert into ExpenseIncome(Date,Category,Person,Expense_Type,Name,Description,Amount,Amount_Paid,Balance,Credit)"
                + "Values(?,?,?,?,?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, dat);
                pst.setString(2, catg);
                pst.setString(3, name);
                pst.setString(4, etype);
                pst.setString(5, comp);
                pst.setString(6, desc);
                pst.setFloat(7, tamt);
                pst.setFloat(8, paid);
                pst.setFloat(9, bal);
                pst.setFloat(10, credit);

                pst.executeUpdate();

                cbExp_category.setSelectedIndex(-1);
                cbExp_person.setSelectedIndex(-1);
                cbExp_name.setSelectedIndex(-1);
                cbExp_expense_type.setSelectedIndex(-1);
                tfExp_amount.setText("");
                tfExp_description.setText("0");
                tfExp_amount_paid.setText("0");
                tfExp_balance.setText("");
                tfExp_credit.setText("");
                CardLayout cl = (CardLayout)(PanelExp_desc_qty.getLayout());
                cl.show(PanelExp_desc_qty, "card1");
                
                JOptionPane.showMessageDialog(rootPane, "Entry Success");

            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Database Error#"+er);}
            finally
            {
                try{pst.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close con error#" + er);}
            }
            
            if(etype.equals("Fibre Sales"))
            {        //-----------Stock Entry and Update-----------------------------//
             
             FibreStock2("FibreStock",dat,qty,ur);
             
             FibreStock2("FibreStockB",dat,bdls,ur);
            }
                BalanceCredit(comp, bal, credit);
                if(catg.equals("Expense"))
                {
                    Accounts("Expense",dat,paid);
                     Accounts1("Expense",dat,paid);
                }
                else
                {
                    Accounts("Income",dat,paid);
                }  
            }else
            {
                JOptionPane.showMessageDialog(null, "You cannot enter on this date");
            }
            
        }
        
    }//GEN-LAST:event_btnExp_submit1ActionPerformed

    private void cbExp_expense_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExp_expense_typeActionPerformed
        //        if(cbExp_person.getSelectedIndex() == -1)
        //        {
//                        if(cbExp_expense_type.getSelectedIndex() == -1)
//                        {
//                                hsbTable(con,"Select Date,Person,Expense_Type,Amount From ExpenseIncome Where Category = 'Expense'",tableExp1);
//                            }
//                        else
//                        {
//                            String exp = cbExp_expense_type.getSelectedItem().toString();
//                            hsbTable(con,"Select Date,Person,Expense_Type,Amount From ExpenseIncome Where Category = 'Expense' AND Expense_Type = '"+exp+"'",tableExp1);
//                            }
            //        }
        //
        //        else
        //        {
            //        String name = cbExp_person.getSelectedItem().toString();
            //        String exp = cbExp_expense_type.getSelectedItem().toString();
            //        hsbTable(con,"Select Date,Person,Expense_Type,Amount From ExpenseIncome Where Category = 'Expense' AND Person = '"+name+"' AND Expense_Type = '"+exp+"'",tableExp1);
            //        }
        if(cbExp_expense_type.getSelectedItem() == null)
        {
           
        }
        else if(cbExp_expense_type.getSelectedItem().toString().equals("Fibre Sales"))
        {
            CardLayout cl = (CardLayout)(PanelExp_desc_qty.getLayout());
            cl.show(PanelExp_desc_qty, "card2");
        }
        else if(cbExp_expense_type.getSelectedItem().toString().equals("Finance"))
        {
             cbExp_name.removeAllItems();
            ComboBox("Select * From People Where Type = 'Finance'","Name",cbExp_name);
            CardLayout cl = (CardLayout)(PanelExp_desc_qty.getLayout());
            cl.show(PanelExp_desc_qty, "card1");
            cbExp_category.setSelectedItem("Income");
        }
        else
        {
            CardLayout cl = (CardLayout)(PanelExp_desc_qty.getLayout());
            cl.show(PanelExp_desc_qty, "card1");
        }
    }//GEN-LAST:event_cbExp_expense_typeActionPerformed

    private void btnExp_cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExp_cancel1ActionPerformed
        cbExp_category.setSelectedIndex(-1);
        cbExp_name.setSelectedIndex(-1);
        cbExp_expense_type.setSelectedIndex(-1);
        tfExp_amount.setText("");
        CardLayout cl = (CardLayout)(PanelExp_desc_qty.getLayout());
            cl.show(PanelExp_desc_qty, "card1");
    }//GEN-LAST:event_btnExp_cancel1ActionPerformed

    private void cbExp_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExp_categoryActionPerformed
        
        if(cbExp_category.getSelectedItem().toString().equals("Finance"))
        {
           
                cbExp_expense_type.setSelectedItem("Finance");
                cbExp_person.setEnabled(false);
                cbExp_expense_type.setEnabled(false);
                
        }else{cbExp_person.setEnabled(true);
                cbExp_expense_type.setEnabled(true);}
    }//GEN-LAST:event_cbExp_categoryActionPerformed

    private void cbExp_personActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExp_personActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbExp_personActionPerformed

    private void tfExp_amount_paidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfExp_amount_paidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfExp_amount_paidActionPerformed

    private void tfExp_amount_paidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfExp_amount_paidKeyReleased
        if(tfExp_amount == null || tfExp_amount_paid == null)
        {}
        else if(cbExp_category.getSelectedItem().toString().equals("Income")||cbExp_category.getSelectedItem().toString().equals("Finance"))
        {float a = Float.parseFloat(tfExp_amount.getText());
            float b = Float.parseFloat(tfExp_amount_paid.getText());
            if(a>b)
            {
                tfExp_balance.setText(Float.toString(a-b));
                tfExp_credit.setText("0");
            }
            else
            {
                tfExp_credit.setText(Float.toString(b-a));
                tfExp_balance.setText("0");
            }
        }
        else if(cbExp_category.getSelectedItem().toString().equals("Expense"))
        {float a = Float.parseFloat(tfExp_amount.getText());
            float b = Float.parseFloat(tfExp_amount_paid.getText());
            if(a>b)
            {
                tfExp_credit.setText(Float.toString(a-b));
                tfExp_balance.setText("0");
            }
            else
            {
                tfExp_balance.setText(Float.toString(b-a));
                tfExp_credit.setText("0");
            }
        }
    }//GEN-LAST:event_tfExp_amount_paidKeyReleased

    private void tfExp_balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfExp_balanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfExp_balanceActionPerformed

    private void cbExp_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExp_nameActionPerformed
         if(cbExp_name.getSelectedIndex() == -1)
        {
            hsbTable(con,"Select S_No,Date,Person,Expense_Type,Name,Description,Amount,Amount_Paid,Balance,Credit From ExpenseIncome Where Category = 'Expense'",tableExp);
            hsbTable(con,"Select S_No,Date,Person,Expense_Type,Name,Description,Amount,Amount_Paid,Balance,Credit From ExpenseIncome Where Category = 'Income'",tableInc);
        }
        else
        {
            String name = cbExp_name.getSelectedItem().toString();
            hsbTable(con,"Select S_No,Date,Person,Expense_Type,Name,Description,Amount,Amount_Paid,Balance,Credit From ExpenseIncome Where Category = 'Income' AND Name = '"+name+"'" ,tableInc);
            hsbTable(con,"Select S_No,Date,Person,Expense_Type,Name,Description,Amount,Amount_Paid,Balance,Credit From ExpenseIncome Where Category = 'Expense' AND Name = '"+name+"'" ,tableExp);
            UpdateLabel(con,"Select * From People Where Name = '"+name+"'","Balance",lbExp_balance);
            UpdateLabel(con,"Select * From People Where Name = '"+name+"'","Credit",lbExp_credit);
            float bal1 = Float.parseFloat(lbExp_balance.getText());
            float credit1 = Float.parseFloat(lbExp_credit.getText());
            float diff;
            if(bal1 > credit1)
            {
                diff = bal1 - credit1;
                lbExp_balance.setText(Float.toString(diff));
                lbExp_credit.setText("0");
            }
            else if(credit1 > bal1)
            {
                diff = credit1 - bal1;
                lbExp_credit.setText(Float.toString(diff));
                lbExp_balance.setText("0");
            }
            
        }
    }//GEN-LAST:event_cbExp_nameActionPerformed

    private void btnNP_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNP_submitActionPerformed

        if(cbNP_people_type.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select People Type");
        }
        else if(tfNP_name.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Name");
        }
        //        else if(tfNP_address.getText().equals(""))
        //        {
            //            JOptionPane.showMessageDialog(rootPane, "Please Enter Total Amount");
            //        }
        //        else if(tfNP_contact_no.getText().equals(""))
        //        {
            //            JOptionPane.showMessageDialog(rootPane, "Please Enter Total Amount");
            //        }
        //        else if(tfNP_email.getText().equals(""))
        //        {
            //            JOptionPane.showMessageDialog(rootPane, "Please Enter Total Amount");
            //        }
        //        else if(tfNP_comments.getText().equals(""))
        //        {
            //            JOptionPane.showMessageDialog(rootPane, "Please Enter Total Amount");
            //        }
        else
        {
            String type = cbNP_people_type.getSelectedItem().toString();
            String name = tfNP_name.getText();
            String addr = tfNP_address.getText();
            String phn = tfNP_contact_no.getText();
            String email = tfNP_email.getText();
            String comm = tfNP_comments.getText();
            try
            {
                String sql = "Insert into People(Type,Name,Address,Contact_No,Email,Comments)"
                + "Values(?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, type);
                pst.setString(2, name);
                pst.setString(3, addr);
                pst.setString(4, phn);
                pst.setString(5, email);
                pst.setString(6, comm);
                pst.executeUpdate();

                cbNP_people_type.setSelectedIndex(-1);
                tfNP_name.setText("");
                tfNP_address.setText("");
                tfNP_contact_no.setText("");
                tfNP_email.setText("");
                tfNP_comments.setText("");
                JOptionPane.showMessageDialog(rootPane, "Entry Success");

            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Database Error#"+er);}
            finally
            {
                try{pst.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close con error#" + er);}
            }
        }
    }//GEN-LAST:event_btnNP_submitActionPerformed

    private void tfNP_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNP_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNP_addressActionPerformed

    private void cbNP_people_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNP_people_typeActionPerformed
        if(cbNP_people_type.getSelectedIndex() == -1)
        {
            hsbTable(con,"Select * From People",tableNP1);
        }
        else
        {
            String type = cbNP_people_type.getSelectedItem().toString();
            hsbTable(con,"Select Name,Address,Contact_No,Email,Comments From People Where Type = '"+type+"'",tableNP1);
        }
    }//GEN-LAST:event_cbNP_people_typeActionPerformed

    private void btnNP_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNP_cancelActionPerformed
        cbNP_people_type.setSelectedIndex(-1);
        tfNP_name.setText("");
        tfNP_address.setText("");
        tfNP_contact_no.setText("");
        tfNP_email.setText("");
        tfNP_comments.setText("");
    }//GEN-LAST:event_btnNP_cancelActionPerformed

    private void tfSE_fibre_productionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSE_fibre_productionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSE_fibre_productionActionPerformed

    private void tfSE_fibre_productionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSE_fibre_productionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSE_fibre_productionKeyReleased

    private void tfSE_coir_production_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSE_coir_production_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSE_coir_production_qtyActionPerformed

    private void tfSE_coir_production_qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSE_coir_production_qtyKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSE_coir_production_qtyKeyReleased

    private void tfSE_coir_windingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSE_coir_windingsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSE_coir_windingsActionPerformed

    private void tfSE_coir_windingsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSE_coir_windingsKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSE_coir_windingsKeyReleased

    private void btnSE_fibre_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSE_fibre_enterActionPerformed
        if(dcSE_date.getDate() == null)
        {
            JOptionPane.showMessageDialog(PanelHome, "Please select date!");
        }
        else
        {
        Date d1 = dcSE_date.getDate();
        String dat = df.format(d1);
        if(DateInit("FibreStock",dat) == 1)
            {
                float prod = Float.parseFloat(tfSE_fibre_production.getText());
        float prodqty = Float.parseFloat(tfSE_fibre_qty.getText());
        float ur = Float.parseFloat(lbFP_unit_rate.getText());
        float ur1 = Float.parseFloat(lbCS_unit_rate.getText());

            //-----------Stock Entry and Update-----------------------------//
             FibreStock1("FibreStock",dat,prodqty,ur);
             FibreStock1("FibreStockB",dat,prod,ur);
             FormLoad();
            }
        else
             {
                JOptionPane.showMessageDialog(null, "You cannot enter on this date");
             }
        
        }
            
            
    }//GEN-LAST:event_btnSE_fibre_enterActionPerformed

    private void btnSE_yarn_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSE_yarn_enterActionPerformed
        if(dcSE_date1.getDate() == null)
        {
            JOptionPane.showMessageDialog(PanelHome, "Please select date!");
        }
        else
        {      
        Date d1 = dcSE_date1.getDate();
        String dat = df.format(d1);
        if(DateInit("CoirStock",dat) == 1)
            {
               float prodb = Float.parseFloat(tfSE_coir_production_bundles.getText());
        prodqty = Float.parseFloat(tfSE_coir_production_qty.getText());
        float wind = Float.parseFloat(tfSE_coir_windings.getText());
        
       
        float ur = Float.parseFloat(lbCS_unit_rate.getText());

            //-----------Stock Entry and Update-----------------------------//
             CoirStock1("CoirStock", dat, prodqty,wind,ur);
             CoirStock1("CoirStockB", dat, prodb,wind,ur);
            JOptionPane.showMessageDialog(rootPane, "Entry Success");
            tfSE_coir_production_qty.setText("0");
            tfSE_coir_windings.setText("0");
            Accounts1("Income",dat,prodqty*ur);
            FormLoad();          
            }
        else
             {
                JOptionPane.showMessageDialog(null, "You cannot enter on this date");
             }
        
         
        }

    }//GEN-LAST:event_btnSE_yarn_enterActionPerformed

    private void tfExp_panel_expense_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfExp_panel_expense_typeActionPerformed
       String exp = tfExp_panel_expense_type.getText();
       try
        {
         String sql = "Insert into ExpenseType(Expense_Type) Values(?)";
         pst = con.prepareStatement(sql);
         pst.setString(1, exp);
         pst.executeUpdate();
         ComboBox("Select * From ExpenseType","Expense_Type",cbExp_expense_type);
        }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Expense_type error #"+er);}finally{try{}catch(Exception er){}}
       CardLayout cl = (CardLayout)(PanelExp_expense_type.getLayout());
        cl.show(PanelExp_expense_type, "card0");
        
    }//GEN-LAST:event_tfExp_panel_expense_typeActionPerformed

    private void jLabel62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel62MouseClicked
        CardLayout cl = (CardLayout)(PanelExp_expense_type.getLayout());
        cl.show(PanelExp_expense_type, "card1");
    }//GEN-LAST:event_jLabel62MouseClicked

    private void jLabel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseClicked
        String exp = cbExp_expense_type.getSelectedItem().toString();        
        try
        {
         String sql = "Delete From ExpenseType Where Expense_Type = ?";
         pst = con.prepareStatement(sql);
         pst.setString(1, exp);
         pst.executeUpdate();
        }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Expense_type error #"+er);}finally{try{}catch(Exception er){}}
        ComboBox("Select * From ExpenseType","Expense_Type",cbExp_expense_type);
        JOptionPane.showMessageDialog(rootPane, exp +" removed Successfully!");
    }//GEN-LAST:event_jLabel63MouseClicked

    private void cbBC_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBC_nameActionPerformed
        if(cbBC_name.getSelectedIndex() == -1)
        {
//            hsbTable(con,"Select Date,Name,Payment_Type,Quantity,Bundles,Total_Amount,Amount_Paid,Balance,Credit,Payment_Mode,Transportation From FibreCoir Where Product = 'Coir'",tableCS1);
        }
        else
        {
            String name = cbBC_name.getSelectedItem().toString();
           // hsbTable(con,"Select Date,Payment_Type,Quantity,Bundles,Total_Amount,Amount_Paid,Balance,Credit,Payment_Mode,Transportation From FibreCoir Where Product = 'Coir' AND Name = '"+name+"'",tableCS1);
            hsbTable(con,"Select S_No,Date,Category,Person,Expense_Type,Name,Description,Amount,Amount_Paid,Balance,Credit From ExpenseIncome Where Name ='"+name+"'",tableBC);
            UpdateLabel(con,"Select * From People Where Name = '"+name+"'","Balance",lbBC_balance);
            UpdateLabel(con,"Select * From People Where Name = '"+name+"'","Credit",lbBC_credit);
            //-----------
            float bal1 = Float.parseFloat(lbBC_balance.getText());
            float credit1 = Float.parseFloat(lbBC_credit.getText());
            float diff;
            if(bal1 > credit1)
            {
                diff = bal1 - credit1;
                lbBC_balance.setText(Float.toString(diff));
                lbBC_credit.setText("0");
            }
            else if(credit1 > bal1)
            {
                diff = credit1 - bal1;
                lbBC_credit.setText(Float.toString(diff));
                lbBC_balance.setText("0");
            }
            //---------------
             UpdateLabel(con,"Select * From People Where Name = '"+name+"'","Type",lbBC_type);
            tfBC_balance.setText(lbBC_balance.getText());
            tfBC_credit.setText(lbBC_credit.getText());
            lbBC_name.setText(name);
             
//            if(lbBC_type.getText().equals("Finance"))
//            {
//                tfBC_credit.setVisible(false);
//                btnBC_pay.setVisible(false);
//            }
//            else
//            {
//                tfBC_credit.setVisible(true);
//                btnBC_pay.setVisible(true);
//            }
        }
    }//GEN-LAST:event_cbBC_nameActionPerformed

    private void tfBC_balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBC_balanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBC_balanceActionPerformed

    private void btnBC_payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBC_payActionPerformed
       if(dcBC_date.getDate() == null)
       {
           JOptionPane.showMessageDialog(rootPane, "Please select date");
       }
       else
       {
        Date d1 = dcBC_date.getDate();
        String dat = df.format(d1);
        if(DateInit("ExpenseIncome",dat) == 1)
            {
            int n = cbBC_name.getSelectedIndex();
        String name = cbBC_name.getSelectedItem().toString();
        float bal = 0;
        float credit1 = Float.parseFloat(tfBC_credit.getText());
        float credit = credit1 - (2 * credit1);
        BalanceCredit(name, bal, credit);
        cbBC_name.setSelectedIndex(n);
        //==============Insert Into ExpenseIncome===============
            try
            {
                String catg = "Expense";
                String etype = "Credit Paid";
                String descrip = cbBC_payment_mode1.getSelectedItem().toString();
                String sql = "Insert into ExpenseIncome(Date,Category,Person,Expense_Type,Name,Description,Amount,Amount_Paid,Balance,Credit)"
                + "Values(?,?,?,?,?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, dat);
                pst.setString(2, catg);
                pst.setString(3, "Self");
                pst.setString(4, etype);
                pst.setString(5, name);
                pst.setString(6, descrip);
                pst.setFloat(7, credit1);
                pst.setFloat(8, 0);
                pst.setFloat(9, 0);
                pst.setFloat(10, 0);

                pst.executeUpdate();
                Accounts(catg,dat,credit1);
                Accounts1(catg,dat,credit1);
                btnBC_rcv.setEnabled(true);
                btnBC_pay.setEnabled(true);
            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Database Error#"+er);}
            finally
            {
                try{pst.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close con error#" + er);}
            }
            }else
             {
                JOptionPane.showMessageDialog(null, "You cannot enter on this date");
             }
        
       }
    }//GEN-LAST:event_btnBC_payActionPerformed

    private void btnBC_rcvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBC_rcvActionPerformed
       if(dcBC_date.getDate() == null)
       {
           JOptionPane.showMessageDialog(rootPane, "Please select date");
       }
       
       else
       {
        Date d1 = dcBC_date.getDate();
        String dat = df.format(d1);
        if(DateInit("ExpenseIncome",dat) == 1)
            {
                 int n = cbBC_name.getSelectedIndex();
        String name = cbBC_name.getSelectedItem().toString();
        float credit = 0;
        float bal1 = Float.parseFloat(tfBC_balance.getText());
        float bal = bal1 - (2 * bal1);
        BalanceCredit(name, bal, credit);
        cbBC_name.setSelectedIndex(n);
        //==============Insert Into ExpenseIncome===============
            try
            {
                String catg = null;
                if(lbBC_type.getText().equals("Finance"))
                {catg = "Finance"; 
                }else{catg = "Income";}
                String etype = "Balance Received";
                String descrip = cbBC_payment_mode2.getSelectedItem().toString();
                String sql = "Insert into ExpenseIncome(Date,Category,Person,Expense_Type,Name,Description,Amount,Amount_Paid,Balance,Credit)"
                + "Values(?,?,?,?,?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, dat);
                pst.setString(2, catg);
                pst.setString(3, "Self");
                pst.setString(4, etype);
                pst.setString(5, name);
                pst.setString(6, descrip);
                pst.setFloat(7, bal1);
                pst.setFloat(8, 0);
                pst.setFloat(9, 0);
                pst.setFloat(10, 0);
                pst.executeUpdate();
                btnBC_rcv.setEnabled(true);
                btnBC_pay.setEnabled(true);
                if(lbBC_type.getText().equals("Finance"))
                 {}else{Accounts("Income",dat,bal1);}
                
                
            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Database Error#"+er);}
            finally
            {
                try{pst.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close con error#" + er);}
            }
            }else{
            JOptionPane.showMessageDialog(null,"You cannot enter on this date");
        }
       
       }
    }//GEN-LAST:event_btnBC_rcvActionPerformed

    private void cbAC_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAC_nameActionPerformed
       if(cbAC_name.getSelectedIndex() == -1)
        {
//            hsbTable(con,"Select Date,Name,Payment_Type,Quantity,Bundles,Total_Amount,Amount_Paid,Balance,Credit,Payment_Mode,Transportation From FibreCoir Where Product = 'Coir'",tableCS1);
        }
        else
        {
            lbAC_last_updated.setText("");
            String name = cbAC_name.getSelectedItem().toString();
            UpdateLabel(con,"Select * From AmountComparision Where Person = '"+name+"' Order By Date DESC LIMIT 1","Date",lbAC_last_updated);
            String ldate = lbAC_last_updated.getText();
            hsbTable(con,"Select Date,Expense_Type,Name,Amount,Amount_Paid From ExpenseIncome Where Category = 'Expense' AND Person = '"+name+"' AND Date > '"+ldate+"'",tableAC1);
            hsbTable(con,"Select Date,Expense_Type,Name,Amount,Amount_Paid From ExpenseIncome Where Category = 'Income' AND Person = '"+name+ "'AND Date > '"+ldate+"'",tableAC2);
            float total1 = FieldSum(con,"Select * From ExpenseIncome Where Category = 'Expense' AND Person = '"+name+"' AND Date > '"+ldate+"'","Amount");
            float total2 = FieldSum(con,"Select * From ExpenseIncome Where Category = 'Income' AND Person = '"+name+"' AND Date > '"+ldate+"'","Amount");
            float totala = FieldSum(con,"Select * From ExpenseIncome Where Category = 'Expense' AND Person = '"+name+"'","Amount");
            float totalb = FieldSum(con,"Select * From ExpenseIncome Where Category = 'Income' AND Person = '"+name+"'","Amount");
            float diff = 0;
            if(totala > totalb)
            {
                lbAC_balance_credit.setText("Balance");
                diff = totala - totalb;
            }else{ diff = totalb - totala; lbAC_balance_credit.setText("Credit");}
            lbAC_difference.setText(Float.toString(diff));
            lbAC_total1.setText(Float.toString(total1));
            lbAC_total2.setText(Float.toString(total2));
            lbAC_name1.setText(name);
            lbAC_name2.setText(name);
        }
    }//GEN-LAST:event_cbAC_nameActionPerformed

    private void jLabel74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel74MouseClicked
         CardLayout cl = (CardLayout)(PanelHome.getLayout());
        cl.show(PanelHome, "cardamountcomparision");
        FormLoad();
    }//GEN-LAST:event_jLabel74MouseClicked

    private void tfPT_finishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPT_finishActionPerformed
        int row = tablePT1.getSelectedRow();
                  
         if(row == -1)
         {
             JOptionPane.showMessageDialog(rootPane, "Select a Row");
         }
         else
         {
         String acc = (tablePT1.getModel().getValueAt(row, 0).toString());
         Date d1 = dcPT_date.getDate();         
         String dat = df.format(d1);
         
//        //System.out.print(acc+""+dat);
        try
        {
           String sql = "UPDATE FibreCoir SET Transportation = ? WHERE rowid = ?";
           pst = con.prepareStatement(sql);
           pst.setString(1, dat);
           pst.setString(2, acc);
           pst.executeUpdate();
           
        }catch(Exception er){JOptionPane.showMessageDialog(rootPane,"BtnRemain@ "+er);}finally{try{pst.close();}catch(Exception er){}}
        FormLoad();
        JOptionPane.showMessageDialog(rootPane, "Date added Successfully");
         }
    }//GEN-LAST:event_tfPT_finishActionPerformed

    private void btnNP_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNP_deleteActionPerformed
        int row = tableNP1.getSelectedRow();
                  
         if(row == -1)
         {
             JOptionPane.showMessageDialog(rootPane, "Select a Row");
         }
         else
         {
         String acc = (tableNP1.getModel().getValueAt(row, 1).toString());
         
        try
        {
           String sql = "Delete From People WHERE Name = ?";
           pst = con.prepareStatement(sql);
           pst.setString(1, acc);           
           pst.executeUpdate();
           
        }catch(Exception er){JOptionPane.showMessageDialog(rootPane,"BtnDelete People error # "+er);}finally{try{pst.close();}catch(Exception er){}}
        FormLoad();
        JOptionPane.showMessageDialog(rootPane, "Deleted Successfully");
        hsbTable(con,"Select * From People",tableNP1);
         }
    }//GEN-LAST:event_btnNP_deleteActionPerformed

    private void jLabel78MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel78MouseClicked
        CardLayout cl = (CardLayout)(PanelHome.getLayout());
        cl.show(PanelHome, "cardstockrecord");
        FormLoad();
    }//GEN-LAST:event_jLabel78MouseClicked

    private void jLabel79MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel79MouseClicked
        CardLayout cl = (CardLayout)(PanelHome.getLayout());
        cl.show(PanelHome, "cardaccountsrecord");
        FormLoad();
    }//GEN-LAST:event_jLabel79MouseClicked

    private void cbFP_personActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFP_personActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFP_personActionPerformed

    private void tfSE_fibre_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSE_fibre_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSE_fibre_qtyActionPerformed

    private void tfSE_fibre_qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSE_fibre_qtyKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSE_fibre_qtyKeyReleased

    private void tfSE_coir_production_bundlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSE_coir_production_bundlesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSE_coir_production_bundlesActionPerformed

    private void tfSE_coir_production_bundlesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSE_coir_production_bundlesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSE_coir_production_bundlesKeyReleased

    private void jLabel86MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel86MouseClicked
       CardLayout cl = (CardLayout)(PanelHome.getLayout());
        cl.show(PanelHome, "cardcoirstock");
        FormLoad();
    }//GEN-LAST:event_jLabel86MouseClicked

    private void lbAC_last_updated1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbAC_last_updated1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAC_last_updated1KeyPressed

    private void lbAC_last_updated1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAC_last_updated1MouseClicked
        lbAC_last_updated.setText("");
            String name = cbAC_name.getSelectedItem().toString();
            hsbTable(con,"Select Date,Expense_Type,Name,Amount,Amount_Paid From ExpenseIncome Where Category = 'Expense' AND Person = '"+name+"'",tableAC1);
            hsbTable(con,"Select Date,Expense_Type,Name,Amount,Amount_Paid From ExpenseIncome Where Category = 'Income' AND Person = '"+name+ "'",tableAC2);
            float totala = FieldSum(con,"Select * From ExpenseIncome Where Category = 'Expense' AND Person = '"+name+"'","Amount");
            float totalb = FieldSum(con,"Select * From ExpenseIncome Where Category = 'Income' AND Person = '"+name+"'","Amount");
            float diff = 0;
            if(totala > totalb)
            {
                lbAC_balance_credit.setText("Balance");
                diff = totala - totalb;
            }else{ diff = totalb - totala; lbAC_balance_credit.setText("Credit");}
            lbAC_difference.setText(Float.toString(diff));
            lbAC_total1.setText(Float.toString(totala));
            lbAC_total2.setText(Float.toString(totalb));
    }//GEN-LAST:event_lbAC_last_updated1MouseClicked

    private void btnAC_seenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAC_seenActionPerformed
         String name = cbAC_name.getSelectedItem().toString();
        try
                    {
                    String sql2 = "Insert into AmountComparision(Date,Person)"
                    + "Values(?,?)";
                    pst1 = con.prepareStatement(sql2);
                    pst1.setString(1, CurrentDate);
                    pst1.setString(2, name);                    
                    pst1.executeUpdate();
                    JOptionPane.showMessageDialog(rootPane, "Updated Successfully");
                    cbAC_name.setSelectedIndex(-1);


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Amount Comparision Error#"+er);}
                    finally
                    {
                        try{pst1.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst1b error#" + er);}
                    }
    }//GEN-LAST:event_btnAC_seenActionPerformed

    private void jLabel61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseClicked
       CardLayout cl = (CardLayout)(PanelViewChoose.getLayout());
        cl.show(PanelViewChoose, "carddaily");
        hsbTable(acc,"Select * From DailyRecord",tableAR1);
    }//GEN-LAST:event_jLabel61MouseClicked

    private void jLabel61KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel61KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel61KeyPressed

    private void jLabel69MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel69MouseClicked
       CardLayout cl = (CardLayout)(PanelViewChoose.getLayout());
        cl.show(PanelViewChoose, "cardbetween");
    }//GEN-LAST:event_jLabel69MouseClicked

    private void jLabel69KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel69KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel69KeyPressed

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        CardLayout cl = (CardLayout)(PanelViewChoose.getLayout());
        cl.show(PanelViewChoose, "carddaily");
        hsbTable(acc,"Select * From DailyRecord",tableAR1);
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked
         CardLayout cl = (CardLayout)(PanelViewChoose.getLayout());
        cl.show(PanelViewChoose, "cardbetween");
    }//GEN-LAST:event_jPanel13MouseClicked

    private void btnAR_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAR_selectActionPerformed
        if(dcAR_date1.getDate() == null || dcAR_date2.getDate() == null)
        {
            JOptionPane.showMessageDialog(PanelHome, "Please select date!");
        }
        else
        {
            String d1 = df.format(dcAR_date1.getDate());
            String d2 = df.format(dcAR_date2.getDate());
            hsbTable(acc,"Select * From DailyRecord Where Date BETWEEN '"+d1+"' AND '"+d2+"'",tableAR2);
        }
    }//GEN-LAST:event_btnAR_selectActionPerformed

    private void jLabel55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel55MouseClicked
        Expense e = new Expense();
        e.setVisible(true);
    }//GEN-LAST:event_jLabel55MouseClicked

    private void jLabel56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel56MouseClicked
       Income i = new Income();
       i.setVisible(true);
    }//GEN-LAST:event_jLabel56MouseClicked

    private void btnCS_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCS_deleteActionPerformed

         int i = tableCS1.getSelectedRow();         
         if(i == -1)
         {
             JOptionPane.showMessageDialog(rootPane, "Select a Row");
         }
         else
         {
             int sno = Integer.parseInt(tableCS1.getModel().getValueAt(i, 0).toString());
             String dat = (tableCS1.getModel().getValueAt(i, 1).toString());
             String name = (tableCS1.getModel().getValueAt(i, 2).toString());
             float qty = Float.parseFloat(tableCS1.getModel().getValueAt(i, 4).toString());        
             float bdls = Float.parseFloat(tableCS1.getModel().getValueAt(i, 5).toString());
             float amt = Float.parseFloat(tableCS1.getModel().getValueAt(i, 7).toString());        
             float bal = Float.parseFloat(tableCS1.getModel().getValueAt(i, 8).toString());
             float cre = Float.parseFloat(tableCS1.getModel().getValueAt(i, 9).toString());
             float qty1 = qty - 2*qty;
             float bdls1 = bdls - 2*bdls;
             amt -= 2*amt;
             bal -= 2*bal;
             cre -= 2*cre;
             float ur = Float.parseFloat(lbCS_unit_rate.getText());
             Delete("Delete From FibreCoir Where S_No = ?",sno);
             Delete("Delete From ExpenseIncome Where Reference_Id = ?",sno);
             CoirStock("CoirStock",dat,qty1,ur); 
             CoirStock("CoirStockB",dat,bdls,ur); 
             BalanceCredit(name, bal, cre);
             Accounts("Income",dat,amt);
             StockRefresh("CoirStock",dat,qty1);   
             StockRefresh("CoirStockB",dat,bdls1);
             AccountRefresh("DailyRecord",dat,amt);
             JOptionPane.showMessageDialog(rootPane, "Deleted Successfully");
         }             
    }//GEN-LAST:event_btnCS_deleteActionPerformed

    private void btnFP_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFP_deleteActionPerformed
        
         int i = tableFP1.getSelectedRow();         
         if(i == -1)
         {
             JOptionPane.showMessageDialog(rootPane, "Select a Row");
         }
         else
         {
             int sno = Integer.parseInt(tableFP1.getModel().getValueAt(i, 0).toString());
             String dat = (tableFP1.getModel().getValueAt(i, 1).toString());
             String name = (tableFP1.getModel().getValueAt(i, 2).toString());
             float qty = Float.parseFloat(tableFP1.getModel().getValueAt(i, 4).toString());        
             float bdls = Float.parseFloat(tableFP1.getModel().getValueAt(i, 5).toString());
             float amt = Float.parseFloat(tableFP1.getModel().getValueAt(i, 7).toString());        
             float bal = Float.parseFloat(tableFP1.getModel().getValueAt(i, 8).toString());
             float cre = Float.parseFloat(tableFP1.getModel().getValueAt(i, 9).toString());
             float qty1 = qty - 2*qty;
             float bdls1 = bdls - 2*bdls;
             float amt1 = amt;
             amt -= 2*amt;
             bal -= 2*bal;
             cre -= 2*cre;
             float ur = Float.parseFloat(lbFP_unit_rate.getText());
             Delete("Delete From FibreCoir Where S_No = ?",sno);
             Delete("Delete From ExpenseIncome Where Reference_Id = ?",sno);
             FibreStock("FibreStock",dat,qty1,ur); 
             FibreStock("FibreStockB",dat,bdls1,ur); 
             BalanceCredit(name, bal, cre);
             Accounts("Expense",dat,amt);
             Accounts1("Expense",dat,amt);
             StockRefresh("FibreStock",dat,qty);   
             StockRefresh("FibreStockB",dat,bdls);
             AccountRefresh("DailyRecord",dat,amt1);
             AccountRefresh("DailyRecord1",dat,amt);
             JOptionPane.showMessageDialog(rootPane, "Deleted Successfully");
         } 
    }//GEN-LAST:event_btnFP_deleteActionPerformed

    private void btnExp_delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExp_delete1ActionPerformed
        
         int i = tableExp.getSelectedRow(); 
         int j = tableInc.getSelectedRow(); 
         if(i == -1 && j == -1)
         {
             JOptionPane.showMessageDialog(rootPane, "Select a Row");
         }
         else if(i > -1)
         {
             int sno = Integer.parseInt(tableExp.getModel().getValueAt(i, 0).toString());
             String dat = (tableExp.getModel().getValueAt(i, 1).toString());
//              String etype = (tableExp.getModel().getValueAt(i, 3).toString());
             String name = (tableExp.getModel().getValueAt(i, 4).toString());
//             String desc = (tableExp.getModel().getValueAt(i, 5).toString());
             float amt = Float.parseFloat(tableExp.getModel().getValueAt(i, 7).toString());        
             float bal = Float.parseFloat(tableExp.getModel().getValueAt(i, 8).toString());
             float cre = Float.parseFloat(tableExp.getModel().getValueAt(i, 9).toString());
//             float ur = Float.parseFloat(lbFP_unit_rate.getText());
             float amt1 = amt;
             amt -= 2*amt;
             bal -= 2*bal;
             cre -= 2*cre;
             
             Delete("Delete From ExpenseIncome Where S_No = ?",sno);
             
             BalanceCredit(name, bal, cre);
             Accounts("Expense",dat,amt);
              Accounts1("Expense",dat,amt);
             AccountRefresh("DailyRecord",dat,amt1);
             AccountRefresh("DailyRecord1",dat,amt);
             JOptionPane.showMessageDialog(rootPane, "Deleted Successfully");
         } 
         else if(j > -1)
         {
             int sno = Integer.parseInt(tableInc.getModel().getValueAt(j, 0).toString());
             String dat = (tableInc.getModel().getValueAt(j, 1).toString());
              String etype = (tableInc.getModel().getValueAt(j, 3).toString());
             String name = (tableInc.getModel().getValueAt(j, 4).toString());
             String desc = (tableInc.getModel().getValueAt(j, 5).toString());
             float amt = Float.parseFloat(tableInc.getModel().getValueAt(j, 6).toString());        
             float bal = Float.parseFloat(tableInc.getModel().getValueAt(j, 8).toString());
             float cre = Float.parseFloat(tableInc.getModel().getValueAt(j, 9).toString());
             float ur = Float.parseFloat(lbFP_unit_rate.getText());
             if(etype.equals("Fibre Sales"))
             {
//                //System.out.print(desc+ " <-desc ");
             int k = 0;
             String qtystr = "";
             String bdlstr = "";
                for(int l = 0;l<desc.length();l++)
                {
                    String a = desc.substring(l,l+1);
                    
                    
                if(a.equals(" "))
                {
                    k = l+7;
                    break;
                }
                    qtystr = qtystr.concat(a);
                    
                }
                
                for(int l = k;l<desc.length();l++)
                {
                    String a = desc.substring(l,l+1);
                    bdlstr = bdlstr.concat(a);
                }
//               //System.out.print(bdlstr + " bdls ");
                float qty1 = Float.parseFloat(qtystr);
                float bdls1 = Float.parseFloat(bdlstr);
             float qty = qty1 - 2*qty1;
             float bdls = bdls1 - 2*bdls1;
             FibreStock2("FibreStock",dat,qty,ur); 
             FibreStock2("FibreStockB",dat,bdls,ur); 
             StockRefresh("FibreStock",dat,qty1);   
             StockRefresh("FibreStockB",dat,bdls1);
             }
             amt -= 2*amt;
             bal -= 2*bal;
             cre -= 2*cre;
             
             Delete("Delete From ExpenseIncome Where S_No = ?",sno);
             
             BalanceCredit(name, bal, cre);
             Accounts("Income",dat,amt);
             AccountRefresh("DailyRecord",dat,amt);
             AccountRefresh("DailyRecord1",dat,amt);
             JOptionPane.showMessageDialog(rootPane, "Deleted Successfully");
         } 
    }//GEN-LAST:event_btnExp_delete1ActionPerformed

    private void jLabel72MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel72MouseClicked
        CardLayout cl = (CardLayout)(PanelViewChoose.getLayout());
        cl.show(PanelViewChoose, "cardprodprofit");
        hsbTable(acc,"Select * From DailyRecord1",tableAR3);
    }//GEN-LAST:event_jLabel72MouseClicked

    private void jLabel72KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel72KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel72KeyPressed

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseClicked

    private void btnAR_select1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAR_select1ActionPerformed
        if(dcAR_date3.getDate() == null || dcAR_date4.getDate() == null)
        {
            JOptionPane.showMessageDialog(PanelHome, "Please select date!");
        }
        else
        {
            String d1 = df.format(dcAR_date3.getDate());
            String d2 = df.format(dcAR_date4.getDate());
            hsbTable(acc,"Select * From DailyRecord1 Where Date BETWEEN '"+d1+"' AND '"+d2+"'",tableAR3);
        }
    }//GEN-LAST:event_btnAR_select1ActionPerformed

    private void jLabel76MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel76MouseClicked
        if(cbCS_customer_name.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(PanelHome, "Please choose name");
        }else{    
            String name = cbCS_customer_name.getSelectedItem().toString();
        hsbTable(con,"Select * From ExpenseIncome Where Name ='"+name+"'",tableCS1);
        btnCS_delete.setVisible(false);
        }
    }//GEN-LAST:event_jLabel76MouseClicked

    private void jLabel97MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel97MouseClicked
        if(cbFP_seller_name.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(PanelHome, "Please choose name");
        }else{    
            String name = cbFP_seller_name.getSelectedItem().toString();
        hsbTable(con,"Select * From ExpenseIncome Where Name ='"+name+"'",tableFP1);
         btnFP_delete.setVisible(false);
        }
    }//GEN-LAST:event_jLabel97MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  String from = USER_NAME;
        String pass = PASSWORD;
        System.out.print(pass);
        String[] to = { RECIPIENT }; // list of recipient email addresses
        String subject = "Backup "+CurrentDate;
        String body = "HighSunBlue Technologies";

        sendFromGMail(from, pass, to, subject, body, "hsbCoirManagement.sqlite");
        sendFromGMail(from, pass, to, subject, body, "hsbAccounts.sqlite");
        JOptionPane.showMessageDialog(null, "Backuped Successfully");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAccountsRecord;
    private javax.swing.JPanel PanelAmountComparision;
    private javax.swing.JPanel PanelBalanceCredit;
    private javax.swing.JPanel PanelBetween;
    private javax.swing.JPanel PanelCoirStock;
    private javax.swing.JPanel PanelDaily;
    private javax.swing.JPanel PanelExp_desc_qty;
    private javax.swing.JPanel PanelExp_expense_type;
    private javax.swing.JPanel PanelExpenseIncome;
    private javax.swing.JPanel PanelFibreStock;
    private javax.swing.JPanel PanelHome;
    private javax.swing.JPanel PanelNewEntries;
    private javax.swing.JPanel PanelPlain;
    private javax.swing.JPanel PanelPurchase;
    private javax.swing.JPanel PanelSales;
    private javax.swing.JPanel PanelViewChoose;
    private javax.swing.JPanel ProdProfit;
    private javax.swing.JButton btnAC_seen;
    private javax.swing.JButton btnAR_select;
    private javax.swing.JButton btnAR_select1;
    private javax.swing.JButton btnBC_pay;
    private javax.swing.JButton btnBC_rcv;
    private javax.swing.JButton btnCS_cancel;
    private javax.swing.JButton btnCS_delete;
    private javax.swing.JButton btnCS_submit;
    private javax.swing.JButton btnExp_cancel1;
    private javax.swing.JButton btnExp_delete1;
    private javax.swing.JButton btnExp_submit1;
    private javax.swing.JButton btnFP_cancel;
    private javax.swing.JButton btnFP_delete;
    private javax.swing.JButton btnFP_submit;
    private javax.swing.JButton btnNP_cancel;
    private javax.swing.JButton btnNP_delete;
    private javax.swing.JButton btnNP_submit;
    private javax.swing.JButton btnSE_fibre_enter;
    private javax.swing.JButton btnSE_yarn_enter;
    private javax.swing.JComboBox cbAC_name;
    private javax.swing.JComboBox cbBC_name;
    private javax.swing.JComboBox cbBC_payment_mode1;
    private javax.swing.JComboBox cbBC_payment_mode2;
    private javax.swing.JComboBox cbCS_customer_name;
    private javax.swing.JComboBox cbCS_payment_mode;
    private javax.swing.JComboBox cbCS_payment_type;
    private javax.swing.JComboBox cbExp_category;
    private javax.swing.JComboBox cbExp_expense_type;
    private javax.swing.JComboBox cbExp_name;
    private javax.swing.JComboBox cbExp_person;
    private javax.swing.JComboBox cbFP_payment_mode;
    private javax.swing.JComboBox cbFP_payment_type;
    private javax.swing.JComboBox cbFP_person;
    private javax.swing.JComboBox cbFP_seller_name;
    private javax.swing.JComboBox cbNP_people_type;
    private javax.swing.JCheckBox chkbCS_coir_sent;
    private javax.swing.JCheckBox chkbFP_fibre_received;
    private com.toedter.calendar.JDateChooser dcAR_date1;
    private com.toedter.calendar.JDateChooser dcAR_date2;
    private com.toedter.calendar.JDateChooser dcAR_date3;
    private com.toedter.calendar.JDateChooser dcAR_date4;
    private com.toedter.calendar.JDateChooser dcBC_date;
    private com.toedter.calendar.JDateChooser dcCS_date;
    private com.toedter.calendar.JDateChooser dcExp_date;
    private com.toedter.calendar.JDateChooser dcFP_date;
    private com.toedter.calendar.JDateChooser dcPT_date;
    private com.toedter.calendar.JDateChooser dcSE_date;
    private com.toedter.calendar.JDateChooser dcSE_date1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lbAC_balance_credit;
    private javax.swing.JLabel lbAC_difference;
    private javax.swing.JLabel lbAC_last_updated;
    private javax.swing.JLabel lbAC_last_updated1;
    private javax.swing.JLabel lbAC_name1;
    private javax.swing.JLabel lbAC_name2;
    private javax.swing.JLabel lbAC_total1;
    private javax.swing.JLabel lbAC_total2;
    private javax.swing.JLabel lbBC_balance;
    private javax.swing.JLabel lbBC_credit;
    private javax.swing.JLabel lbBC_name;
    private javax.swing.JLabel lbBC_type;
    private javax.swing.JLabel lbCS_balance;
    private javax.swing.JLabel lbCS_credit;
    private javax.swing.JLabel lbCS_unit_rate;
    private javax.swing.JLabel lbExp_balance;
    private javax.swing.JLabel lbExp_credit;
    private javax.swing.JLabel lbFP_balance;
    private javax.swing.JLabel lbFP_credit;
    private javax.swing.JLabel lbFP_unit_rate;
    private javax.swing.JTable tableAC1;
    private javax.swing.JTable tableAC2;
    private javax.swing.JTable tableAR1;
    private javax.swing.JTable tableAR2;
    private javax.swing.JTable tableAR3;
    private javax.swing.JTable tableBC;
    private javax.swing.JTable tableCS1;
    private javax.swing.JTable tableExp;
    private javax.swing.JTable tableFP1;
    private javax.swing.JTable tableInc;
    private javax.swing.JTable tableNP1;
    private javax.swing.JTable tablePT1;
    private javax.swing.JTable tableSR1;
    private javax.swing.JTable tableSR2;
    private javax.swing.JTable tableSR3;
    private javax.swing.JTable tableSR4;
    private javax.swing.JTextField tfBC_balance;
    private javax.swing.JTextField tfBC_credit;
    private javax.swing.JTextField tfCS_amount_paid;
    private javax.swing.JTextField tfCS_balance;
    private javax.swing.JTextField tfCS_bundles;
    private javax.swing.JTextField tfCS_credit;
    private javax.swing.JTextField tfCS_quantity;
    private javax.swing.JTextField tfCS_total_amount;
    private javax.swing.JTextField tfExp_amount;
    private javax.swing.JTextField tfExp_amount_paid;
    private javax.swing.JTextField tfExp_balance;
    private javax.swing.JTextField tfExp_bdls;
    private javax.swing.JTextField tfExp_credit;
    private javax.swing.JTextField tfExp_description;
    private javax.swing.JTextField tfExp_panel_expense_type;
    private javax.swing.JTextField tfExp_qty;
    private javax.swing.JTextField tfFP_Credit;
    private javax.swing.JTextField tfFP_amount_paid;
    private javax.swing.JTextField tfFP_balance;
    private javax.swing.JTextField tfFP_bundles;
    private javax.swing.JTextField tfFP_quantity;
    private javax.swing.JTextField tfFP_total_amount;
    private javax.swing.JTextField tfNP_address;
    private javax.swing.JTextField tfNP_comments;
    private javax.swing.JTextField tfNP_contact_no;
    private javax.swing.JTextField tfNP_email;
    private javax.swing.JTextField tfNP_name;
    private javax.swing.JButton tfPT_finish;
    private javax.swing.JTextField tfSE_coir_production_bundles;
    private javax.swing.JTextField tfSE_coir_production_qty;
    private javax.swing.JTextField tfSE_coir_windings;
    private javax.swing.JTextField tfSE_fibre_production;
    private javax.swing.JTextField tfSE_fibre_qty;
    // End of variables declaration//GEN-END:variables

public float DualMultiply(float a, float b)
{
    float c = a*b;
    return c;
}

public void hsbTable(Connection tcon1, String sql1, JTable tb1)
{
    Connection tcon = tcon1;
    try
        {
            
            String sql = sql1;
            pst=tcon.prepareStatement(sql);
            rs=pst.executeQuery();
            tb1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException er8)
        {
            JOptionPane.showMessageDialog(rootPane,"Table Load Error#"+er8);
        }
         finally
        {
            try
            {
               
                pst.close();
                rs.close();
                
            }catch(Exception erf){}
            
        }
}

public void UpdateLabel(Connection con1, String sql1, String field, JLabel lb1)
{
    try
         {
            pst = con1.prepareStatement(sql1);
            rs = pst.executeQuery();
            while(rs.next())
            {
                String r = rs.getString(field);
                lb1.setText(r);
            }
            
         }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Database Error#"+er);}
            finally
            {
                try{pst.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close con error#" + er);}
            }
}

public void ComboBox(String combocnct,String field,JComboBox cb1)
    {
        cb1.addItem("");
        cb1.addItem("");
        try
        {
            int cnt = cb1.getItemCount();//Getting number of items from name combo box
        
        
        int i = 0;
        //Using removeallitems() causes the combobox empty, leading to error due to combobox action to display number and rate.
        while(i<cnt-1)//Removing one by one value except last one
        {
            cb1.removeItemAt(0);
            i++;
        }         
            pst1 = con.prepareStatement(combocnct);
            rs1 = pst1.executeQuery();
            
            while(rs1.next())
            {
                String cont = rs1.getString(field);
                cb1.addItem(cont);
                
            }
            cb1.removeItemAt(0);
        }
        catch(SQLException er3)
        {
            JOptionPane.showMessageDialog(null, er3);
        }
        finally
        {
            try
            {              
                pst1.close();
                rs1.close();    
            }catch(Exception erf)
            {}            
        }
    }

private float FieldSum(Connection con1, String sql, String field)
{
    float total = 0;
    try
            {
                
                pst = con1.prepareStatement(sql);
                rs = pst.executeQuery();
                
                while(rs.next())
                {
                    Float value = Float.parseFloat(rs.getString(field));
                    total = total + value;
                    
                    
                }

            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Database Error#"+er);}
            finally
            {
                try{pst.close();rs.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close con error#" + er);}
            }
return total;
}
private void BalanceCredit(String name, float bal, float credit)
{
    float b = 0;
            float c = 0;
            
            try
            {
                String sql = "Select * From People Where Name = '"+name+"'";
                pst1 = con.prepareStatement(sql);
                rs1 = pst1.executeQuery();
                if(rs1.next())
                {
                    b = rs1.getFloat("Balance");
                    c = rs1.getFloat("Credit");                   
                }
                 b += bal;
                 c += credit;
                

            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Balance Credit Get#"+er);}
            finally
            {
                try{pst1.close();rs1.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close con error#" + er);}
            }
            
            try
            {
                
                String sql = "Update People Set Balance = ?, Credit = ? Where Name = ?";
                pst0 = con.prepareStatement(sql);
                pst0.setFloat(1, b);
                pst0.setFloat(2, c);
                pst0.setString(3, name);
                pst0.executeUpdate();
                    
            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Balance Credit Get#"+er);}
            finally
            {
                try{pst0.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close con error#" + er);}
            }
}
public void hsbDateFormats()
{
    Calendar calendar = Calendar.getInstance();
     java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
     DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
     CurrentDate = df.format(ourJavaDateObject);
     DateFormat tf = new SimpleDateFormat("hh:mm:ss");
     Current_Time = tf.format(ourJavaDateObject);
}

private void Accounts(String inex, String datee, float totamt)
{
    
    String dat = null;
//                int dateno = Integer.parseInt(datee.substring(0, 2));
//                int monthno = Integer.parseInt(datee.substring(3, 5));
//                int yearno = Integer.parseInt(datee.substring(6, 10));
                    int countacc = 0;
                  try
                  {
                      String sel = "SELECT * FROM DailyRecord";
                      st1 = acc.createStatement();
                      rs1 = st1.executeQuery(sel);

                      while(rs1.next())
                      {
                          dat = rs1.getString("Date");
                          if(dat.equals(datee))
                          {
                           countacc = 1;
                          }
                      }
                  }
                  catch(Exception er)
                  {
                      JOptionPane.showMessageDialog(null, "aaaa5"+er); 
                  }
                  finally
                 {
                    try
                   {

                    st1.close();
                    rs1.close();

                    }catch(Exception er)
                    {
                     JOptionPane.showMessageDialog(null, er); 
                    }

                  }
                  
              if(countacc == 1)
               {  
                float inc2 = 0;
                try
                {
                 String selec = "SELECT * FROM DailyRecord WHERE Date = '"+datee+"'";
                st1 = acc.createStatement();
                rs2 = st1.executeQuery(selec);
                rs2.next();
                inc2 = rs2.getFloat(inex);
                inc2 += totamt;
                
                }
                catch(Exception er)
                {
                JOptionPane.showMessageDialog(null, "aaaa6"+er); 
                }
                finally
             {
                try
                {
                    
                rs2.close();
                st1.close();           
                }catch(Exception er)
                {
                JOptionPane.showMessageDialog(null, er); 
                }
            
             }
                   
              try
              {
              String upd = "UPDATE DailyRecord SET "+inex+" = ? WHERE Date = ?";
              pst1 = acc.prepareStatement(upd);
              pst1.setFloat(1, inc2);
              pst1.setString(2, datee);
              pst1.executeUpdate();
              inc2 = 0;
              totamt = 0;
                      
                  
              }
              catch(Exception er)
              {
              JOptionPane.showMessageDialog(null, "aaaa7"+er); 
              }
              finally
             {
                try
               {
               
                pst1.close();
                           
                }catch(Exception er)
                {
                 JOptionPane.showMessageDialog(null, er); 
                }
            
              }
             }
              else
              {     
                  //------------getting previous standing amount---------------------
                  float o_samt = 0;
              try
                    {
                    String sqlprecstk = "Select * From DailyRecord ORDER BY Date DESC LIMIT 1";
                    pst0 = acc.prepareStatement(sqlprecstk);
                    rs0 = pst0.executeQuery();
                    if(rs0.next())
                    {
                       //System.out.print(" "+rs0.getString("Date")+" ");
                      o_samt = rs0.getFloat("Standing_Amount");
                        
                        
                    }
                    else
                    {
                        o_samt = 0;
                        JOptionPane.showMessageDialog(rootPane, "Contact Admin#");
                    }


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock DESC LIMIT Error#"+er);}
                    finally
                    {
                        try{pst0.close();rs0.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst0 error#" + er);}
                    }
                  try
                  {
                      String ins = "INSERT INTO DailyRecord (Date,"+inex+",Opening_Amount) VALUES(?,?,?)";
                      pst1 = acc.prepareStatement(ins);
                      pst1.setString(1, datee);
                      pst1.setFloat(2, totamt);
                      pst1.setFloat(3, o_samt);
                      pst1.executeUpdate();
                      totamt = 0;
                  }
                  catch(Exception er)
                  {
                      JOptionPane.showMessageDialog(null, "aaaa8"+er); 
                  }
                  finally
             {
                try
               {
               
                pst1.close();
                           
                }catch(Exception er)
                {
                 JOptionPane.showMessageDialog(null, er); 
                }
            
              }

                  
                  
//                 
//               
//               
//              }
//              //----------------------------------------------------
//              //Updating the Monthly Record
//              //Calculation to obtain month value
//              String mon = datee.substring(3, 5);
//               float inc3 = 0; 
//               try
//               {
//                   String selec = "SELECT * FROM MonthlyRecord"+yearno+" WHERE num = '"+mon+"'";
//                st10 = acc.createStatement();
//                rs32 = st10.executeQuery(selec);
////                rs3.next();
//                float inc4 = rs32.getFloat(inex);
//                inc3 = inc4 + tamt; 
//               }
//               catch(Exception er)
//               {
//                   JOptionPane.showMessageDialog(null, "aaaa9"+er);
//               }
//               finally
//               {
//                   try
//                   {
//                       st10.close();
//                       rs32.close();
//                       
//                   }
//                   catch(Exception er)
//                   {
//                   }
//                   
//               }
//               try
//               {
//               String upd2 = "UPDATE MonthlyRecord"+yearno+" SET "+inex+" = ? WHERE num = ?";
//              pst36 = acc.prepareStatement(upd2);
//              pst36.setFloat(1, inc3);
//              pst36.setString(2, mon);
//              pst36.executeUpdate();
//               }
//               catch(Exception er)
//               {
//                   JOptionPane.showMessageDialog(null, "aaaa10"+er);
//               }
//               finally
//               {
//                   try
//                   {
//                       pst36.close();
//                       
//                      
////                       
//                   }
//                   catch(Exception er)
//                   {}
//               }
//               //------------------------------------------Year-------------
//               String year = datee.substring(6, 10);
//               float inc7 = 0; 
//               try
//               {
//                   
//                   String selec = "SELECT * FROM YearlyRecord WHERE Year = '"+year+"'";
//                  
//                st9 = acc.createStatement();
//                rs31 = st9.executeQuery(selec);//                rs3.next();
//                float inc8 = rs31.getFloat(inex);System.out.print("3");
//                inc7 = inc8 + tamt; 
//               }
//               catch(Exception er)
//               {
//                   JOptionPane.showMessageDialog(null, "aaaa13"+er);
//               }
//               finally
//               {
//                   try
//                   {
//                       st9.close();
//                       rs31.close();
//                       
//                   }
//                   catch(Exception er)
//                   {
//                   }
//                   
//               }
//               try
//               {
//               String upd2 = "UPDATE YearlyRecord SET "+inex+" = ? WHERE Year = ?";
//              pst40 = acc.prepareStatement(upd2);
//              pst40.setFloat(1, inc7);
//              pst40.setString(2, year);
//              pst40.executeUpdate();
//               }
//               catch(Exception er)
//               {
//                   JOptionPane.showMessageDialog(null, "aaaa14"+er);
//               }
//               finally
//               {
//                   try
//                   {
//                       pst40.close();
//                       
//                       
//                   }
//                   catch(Exception er)
//                   {}
               }
//              -------------------Standing amount update-----------------  

              float  samt = 0;
              
              
                  try
                {
                 String selec = "SELECT * FROM DailyRecord WHERE Date = '"+datee+"'";
                st1 = acc.createStatement();
                rs2 = st1.executeQuery(selec);
                rs2.next();
                float income = rs2.getFloat("Income");
                float expense = rs2.getFloat("Expense");
                float oamt = rs2.getFloat("Opening_Amount");
                samt = oamt + income - expense;
               //System.out.print(samt + " **** ");
                                
                }
                catch(Exception er)
                {
                JOptionPane.showMessageDialog(null, "aaaa6"+er); 
                }
                finally
             {
                try
                {
                    
                rs2.close();
                st1.close();           
                }catch(Exception er)
                {
                JOptionPane.showMessageDialog(null, er); 
                }
            
             }
//                  -------------------------------------------------
                  try
                  {
                      String upd = "UPDATE DailyRecord SET Standing_Amount = ? WHERE Date = ?";
              pst1 = acc.prepareStatement(upd);
              pst1.setFloat(1, samt);
              pst1.setString(2, datee);
              pst1.executeUpdate();
                  }
                  catch(Exception er)
                  {
                      JOptionPane.showMessageDialog(null, "aaaa8"+er); 
                  }
                  finally
             {
                try
               {
               
                pst1.close();
                           
                }catch(Exception er)
                {
                 JOptionPane.showMessageDialog(null, er); 
                }
            
              }
}

private void FibreStock(String table, String dat, float bdls, float ur)
{
    float cstk = 0;
             float ostk = 0;
                    
             //Checking for Date entry
            try
            {
                String sql = "Select * From "+table+" Where Date = '"+dat+"'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs.next())//If date present
                {
                    try
                    {
                    String sqlpur = "Select * From "+table+" Where Date = '"+dat+"'";
                    pst2 = con.prepareStatement(sqlpur);
                    rs2 = pst2.executeQuery();
                    if(rs2.next())
                    {
                        Float pur = rs2.getFloat("Purchase");
                        ostk = rs2.getFloat("Opening_Stock");
                        Float sale = rs2.getFloat("Sales");
                        Float prodc = rs2.getFloat("Production");
                        bdls += pur;
                        cstk = ostk + bdls - sale - prodc;
                        
                    }


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock Retrieve Purchase and O_StockError#"+er);}
                    finally
                    {
                        try{pst2.close();rs2.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst2 error#" + er);}
                    }
                     try
                    {
                    String sql1 = "Update "+table+" Set Purchase = ?, Closing_Stock = ? Where Date = '"+dat+"'";
                    pst1 = con.prepareStatement(sql1);
                    pst1.setFloat(1, bdls);
                    pst1.setFloat(2, cstk);
                    pst1.executeUpdate();


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock Update after first Error#"+er);}
                    finally
                    {
                        try{pst1.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst1 error#" + er);}
                    }
                }
                else//Date Not present
                {
                    try
                    {
                    String sqlprecstk = "Select * From "+table+" ORDER BY Date DESC LIMIT 1";
                    pst0 = con.prepareStatement(sqlprecstk);
                    rs0 = pst0.executeQuery();
                    if(rs0.next())
                    {
                        float cstk0 = rs0.getFloat("Closing_Stock");
                        ostk = cstk0;
                        cstk = ostk + bdls;
                    }
                    else
                    {
                        cstk = bdls;
                        JOptionPane.showMessageDialog(rootPane, "Contact Admin#");
                    }


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock DESC LIMIT Error#"+er);}
                    finally
                    {
                        try{pst0.close();rs0.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst0 error#" + er);}
                    }
                    try
                    {
                    String sql2 = "Insert into "+table+"(Date,Opening_Stock,Purchase,Sales,Production,Closing_Stock,Unit_Rate)"
                    + "Values(?,?,?,?,?,?,?)";
                    pst1 = con.prepareStatement(sql2);
                    pst1.setString(1, dat);
                    pst1.setFloat(2, ostk);
                    pst1.setFloat(3, bdls);
                    pst1.setFloat(4, 0);
                    pst1.setFloat(5, 0);
                    pst1.setFloat(6, cstk);
                    pst1.setFloat(7, ur);
                    pst1.executeUpdate();


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock First Insertion Error#"+er);}
                    finally
                    {
                        try{pst1.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst1b error#" + er);}
                    }
    
                }

            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Database Error#"+er);}
            finally
            {
                try{pst.close();rs.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst error#" + er);}
            }
    
}
private void CoirStock(String table, String dat, Float qty, Float ur)
{
    float cstk = 0;
             float ostk = 0;
             String datlast = null;       
             
             //--------------getting the last date----------------
//             try
//                    {
//                    String sqlprecstk = "Select * From "+table+" ORDER BY Date DESC LIMIT 1";
//                    pst0 = con.prepareStatement(sqlprecstk);
//                    rs0 = pst0.executeQuery();
//                    if(rs0.next())
//                    {
//                        datlast = rs0.getString("Date");
//                    }
//                    else
//                    {
//                        JOptionPane.showMessageDialog(rootPane, "Contact Admin Date not present and would have been added#");
//                    }
//
//
//                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Date DESC LIMIT Error#"+er);}
//                    finally
//                    {
//                        try{pst0.close();rs0.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst0 error#" + er);}
//                    }
             //Checking for Date entry
            try
            {
                String sql = "Select * From "+table+" Where Date = '"+dat+"'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs.next())//If date present
                {
                    try
                    {
                    String sqlsals = "Select * From "+table+" Where Date = '"+dat+"'";
                    pst2 = con.prepareStatement(sqlsals);
                    rs2 = pst2.executeQuery();
                    if(rs2.next())
                    {
                        Float sals = rs2.getFloat("Dispatch");
                        ostk = rs2.getFloat("Opening_Stock");
                        Float prod1 = rs2.getFloat("Production");
                        qty += sals;
                        cstk = ostk + prod1 - qty;
                        
                    }


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock Retrieve Dispatch and O_StockError#"+er);}
                    finally
                    {
                        try{pst2.close();rs2.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst2 error#" + er);}
                    }
                     try
                    {
                    String sql1 = "Update "+table+" Set Dispatch = ?, Closing_Stock = ? Where Date = '"+dat+"'";
                    pst1 = con.prepareStatement(sql1);
                    pst1.setFloat(1, qty);
                    pst1.setFloat(2, cstk);
                    pst1.executeUpdate();


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock Update after first Error#"+er);}
                    finally
                    {
                        try{pst1.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst1 error#" + er);}
                    }
                }
                else//Date Not present
                {
                    try
                    {
                    String sqlprecstk = "Select * From "+table+" ORDER BY Date DESC LIMIT 1";
                    pst0 = con.prepareStatement(sqlprecstk);
                    rs0 = pst0.executeQuery();
                    if(rs0.next())
                    {
                        float cstk0 = rs0.getFloat("Closing_Stock");
                        ostk = cstk0;
                        cstk = ostk - qty;
                    }
                    else
                    {
                        cstk = 0-qty;
                        JOptionPane.showMessageDialog(rootPane, "Contact Admin#");
                    }


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock DESC LIMIT Error#"+er);}
                    finally
                    {
                        try{pst0.close();rs0.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst0 error#" + er);}
                    }
                    try
                    {
                    String sql2 = "Insert into "+table+"(Date,Opening_Stock,Production,Windings,Dispatch,Closing_Stock,Unit_Rate)"
                    + "Values(?,?,?,?,?,?,?)";
                    pst1 = con.prepareStatement(sql2);
                    pst1.setString(1, dat);
                    pst1.setFloat(2, ostk);
                    pst1.setFloat(3, 0);
                    pst1.setFloat(4, 0);
                    pst1.setFloat(5, qty);
                    pst1.setFloat(6, cstk);
                    pst1.setFloat(7, ur);                   
                    pst1.executeUpdate();


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock First Insertion Error#"+er);}
                    finally
                    {
                        try{pst1.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst1b error#" + er);}
                    }
    
                }

            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Database Error#"+er);}
            finally
            {
                try{pst.close();rs.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst error#" + er);}
            }
}

private void FibreStock1(String table, String dat,float prod,float ur)
{
    float cstk = 0;
             float ostk = 0;
                    
             //Checking for Date entry
            try
            {
                String sql = "Select * From "+table+" Where Date = '"+dat+"'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs.next())//If date present
                {
                    try
                    {
                    String sqlpur = "Select * From "+table+" Where Date = '"+dat+"'";
                    pst2 = con.prepareStatement(sqlpur);
                    rs2 = pst2.executeQuery();
                    if(rs2.next())
                    {
                        Float prod1 = rs2.getFloat("Production");
                        ostk = rs2.getFloat("Opening_Stock");
                        prod += prod1;                      
                        Float bdls = rs2.getFloat("Purchase");
                        Float sale = rs2.getFloat("Sales");                                         
                        cstk = ostk + bdls - sale - prod;
                        
                    }


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Fibre Stock Retrieve Production, Adjustments and O_StockError#"+er);}
                    finally
                    {
                        try{pst2.close();rs2.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst2 error#" + er);}
                    }
                     try
                    {
                    String sql1 = "Update "+table+" Set Production = ?, Closing_Stock = ? Where Date = '"+dat+"'";
                    pst1 = con.prepareStatement(sql1);
                    pst1.setFloat(1, prod);
                    pst1.setFloat(2, cstk);                    
                    pst1.executeUpdate();


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Fibre Stock Update after first Error#"+er);}
                    finally
                    {
                        try{pst1.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst1 error#" + er);}
                    }
                }
                else//Date Not present
                {
                    try
                    {
                    String sqlprecstk = "Select * From "+table+" ORDER BY Date DESC LIMIT 1";
                    pst0 = con.prepareStatement(sqlprecstk);
                    rs0 = pst0.executeQuery();
                    if(rs0.next())
                    {
                        float cstk0 = rs0.getFloat("Closing_Stock");
                        ostk = cstk0;
                        cstk = ostk - prod;
                    }
                    else
                    {
                        cstk = 0-prod;
                        JOptionPane.showMessageDialog(rootPane, "Contact Admin#");
                    }


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Fibre Stock DESC LIMIT Error#"+er);}
                    finally
                    {
                        try{pst0.close();rs0.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst0 error#" + er);}
                    }
                    try
                    {
                    String sql2 = "Insert into "+table+"(Date,Opening_Stock,Purchase,Sales,Production,Closing_Stock,Unit_Rate)"
                    + "Values(?,?,?,?,?,?,?)";
                    pst1 = con.prepareStatement(sql2);
                    pst1.setString(1, dat);
                    pst1.setFloat(2, ostk);
                    pst1.setFloat(3, 0);
                    pst1.setFloat(4, 0);
                    pst1.setFloat(5, prod);
                    pst1.setFloat(6, cstk);
                    pst1.setFloat(7, ur);
                    pst1.executeUpdate();


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Fibre Stock First Insertion Error#"+er);}
                    finally
                    {
                        try{pst1.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst1b error#" + er);}
                    }
    
                }

            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Database Error#"+er);}
            finally
            {
                try{pst.close();rs.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst error#" + er);}
            }
}

private void CoirStock1(String table,String dat,Float prod,Float wind,Float ur)
{
    float cstk = 0;
             float ostk = 0;
//             float tamt = prodqty * ur;
                    
             //Checking for Date entry
            try
            {
                String sql = "Select * From "+table+" Where Date = '"+dat+"'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs.next())//If date present
                {
                    try
                    {
                    String sqlpur = "Select * From "+table+" Where Date = '"+dat+"'";
                    pst2 = con.prepareStatement(sqlpur);
                    rs2 = pst2.executeQuery();
                    if(rs2.next())
                    {
                        Float wind1 = rs2.getFloat("Windings");                        
                        ostk = rs2.getFloat("Opening_Stock");
                        Float prod1 = rs2.getFloat("Production");
                        Float disp = rs2.getFloat("Dispatch");
                        wind += wind1;
                        prod += prod1;
                        cstk = ostk + prod - disp;
                        
                    }


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Coir Stock Retrieve Windings, Adjustments and O_StockError#"+er);}
                    finally
                    {
                        try{pst2.close();rs2.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst2 error#" + er);}
                    }
                     try
                    {
                    String sql1 = "Update "+table+" Set Production = ?, Windings = ?, Closing_Stock = ? Where Date = '"+dat+"'";
                    pst1 = con.prepareStatement(sql1);
                    pst1.setFloat(1, prod);
                    pst1.setFloat(2, wind);                    
                    pst1.setFloat(3, cstk);
                    pst1.executeUpdate();


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Coir Stock Update after first Error#"+er);}
                    finally
                    {
                        try{pst1.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst1 error#" + er);}
                    }
                }
                else//Date Not present
                {
                    try
                    {
                    String sqlprecstk = "Select * From "+table+" ORDER BY Date DESC LIMIT 1";
                    pst0 = con.prepareStatement(sqlprecstk);
                    rs0 = pst0.executeQuery();
                    if(rs0.next())
                    {
                        float cstk0 = rs0.getFloat("Closing_Stock");
                        ostk = cstk0;
                        cstk = ostk + prod;
                    }
                    else
                    {
                        cstk = prod;
                        JOptionPane.showMessageDialog(rootPane, "Contact Admin#");
                    }


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Coir Stock DESC LIMIT Error#"+er);}
                    finally
                    {
                        try{pst0.close();rs0.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst0 error#" + er);}
                    }
                    try
                    {
                    String sql2 = "Insert into "+table+"(Date,Opening_Stock,Production,Windings,Dispatch,Closing_Stock,Unit_Rate)"
                    + "Values(?,?,?,?,?,?,?)";
                    pst1 = con.prepareStatement(sql2);
                    pst1.setString(1, dat);
                    pst1.setFloat(2, ostk);
                    pst1.setFloat(3, prod);
                    pst1.setFloat(4, wind);
                    pst1.setFloat(5, 0);
                    pst1.setFloat(6, cstk);
                    pst1.setFloat(7, ur);
                    pst1.executeUpdate();
                   //System.out.printf(dat);


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Coir Stock First Insertion Error#"+er);}
                    finally
                    {
                        try{pst1.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst1b error#" + er);}
                    }
    
                }

            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Database Error#"+er);}
            finally
            {
                try{pst.close();rs.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst error#" + er);}
            }
    
}

private void FibreStock2(String table, String dat, Float desc, Float ur)
{
    float cstk = 0;
             float ostk = 0;
            
            
                    
             //Checking for Date entry
            try
            {
                String sql = "Select * From "+table+" Where Date = '"+dat+"'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs.next())//If date present
                {
                    try
                    {
                    String sqlpur = "Select * From "+table+" Where Date = '"+dat+"'";
                    pst2 = con.prepareStatement(sqlpur);
                    rs2 = pst2.executeQuery();
                    if(rs2.next())
                    {
                        Float sale = rs2.getFloat("Sales");
                        ostk = rs2.getFloat("Opening_Stock");
                        Float pur = rs2.getFloat("Purchase");
                        Float prodc = rs2.getFloat("Production");
                        desc += sale;
                        cstk = ostk + pur - desc - prodc;
                        
                    }


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock Retrieve Purchase and O_StockError#"+er);}
                    finally
                    {
                        try{pst2.close();rs2.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst2 error#" + er);}
                    }
                     try
                    {
                    String sql1 = "Update "+table+" Set Sales = ?, Closing_Stock = ? Where Date = '"+dat+"'";
                    pst1 = con.prepareStatement(sql1);
                    pst1.setFloat(1, desc);
                    pst1.setFloat(2, cstk);
                    pst1.executeUpdate();


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock Update after first Error#"+er);}
                    finally
                    {
                        try{pst1.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst1 error#" + er);}
                    }
                }
                else//Date Not present
                {
                    try
                    {
                    String sqlprecstk = "Select * From "+table+" ORDER BY Date DESC LIMIT 1";
                    pst0 = con.prepareStatement(sqlprecstk);
                    rs0 = pst0.executeQuery();
                    if(rs0.next())
                    {
                        float cstk0 = rs0.getFloat("Closing_Stock");
                        ostk = cstk0;
                        cstk = ostk - desc;
                    }
                    else
                    {
                        cstk = 0-desc;
                        JOptionPane.showMessageDialog(rootPane, "Contact Admin#");
                    }


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock DESC LIMIT Error#"+er);}
                    finally
                    {
                        try{pst0.close();rs0.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst0 error#" + er);}
                    }
                    try
                    {
                    String sql2 = "Insert into "+table+"(Date,Opening_Stock,Purchase,Sales,Production,Closing_Stock,Unit_Rate)"
                    + "Values(?,?,?,?,?,?,?)";
                    pst1 = con.prepareStatement(sql2);
                    pst1.setString(1, dat);
                    pst1.setFloat(2, ostk);
                    pst1.setFloat(3, 0);
                    pst1.setFloat(4, desc);
                    pst1.setFloat(5, 0);
                    pst1.setFloat(6, cstk);
                    pst1.setFloat(7, ur);
                    pst1.executeUpdate();


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock First Insertion Error#"+er);}
                    finally
                    {
                        try{pst1.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst1b error#" + er);}
                    }
    
                }

            }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Database Error#"+er);}
            finally
            {
                try{pst.close();rs.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst error#" + er);}
            }
}

private void Delete(String sql1, int sno)
{
     try
        {
           String sql = sql1;
           pst = con.prepareStatement(sql);
           pst.setInt(1, sno);           
           pst.executeUpdate();
           
        }catch(Exception er){JOptionPane.showMessageDialog(rootPane,"BtnDelete action error # "+er);}finally{try{pst.close();}catch(Exception er){}}
        FormLoad();
        
}
private void StockRefresh(String table, String dat, Float qty)
{
                    try
                    {
                    String sqlsals = "Select * From "+table+" Where Date > '"+dat+"'";
                    pst2 = con.prepareStatement(sqlsals);
                    rs2 = pst2.executeQuery();
                    
                    while(rs2.next())
                    {   
                        String dat1 = rs2.getString("Date");
                        Float ostk = rs2.getFloat("Opening_Stock");
                        Float cstk = rs2.getFloat("Closing_Stock");
                       //System.out.print(" =>ostk " + ostk + " =>cstk " + cstk);
                        Float ostk1 = ostk - qty;
                        Float cstk1 = cstk - qty;
                        //System.out.print(" =>ostk1 " + ostk1 + " =>cstk1 " + cstk1);
                        RefreshUpdate(table,dat1,ostk1,cstk1);
                        
                        
                        
                        
                        
                        
//                        try
//                        {
//                            
//                        }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock refresh second retrieval and O_StockError#"+er);}
//                        finally
//                        {
//                        try{pst2.close();rs2.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst2 error#" + er);}
//                        }
                        
                    }


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock Retrieve Dispatch and O_StockError#"+er);}
                    finally
                    {
                        try{pst2.close();rs2.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst2 error#" + er);}
                    }
                     
}
private void RefreshUpdate(String table, String dat1, Float ostk, Float cstk)
{
    try
                        {
                        String sql1 = "Update "+table+" Set Opening_Stock = ?, Closing_Stock = ? Where Date = '"+dat1+"'";
                        pst1 = con.prepareStatement(sql1);
                        pst1.setFloat(1, ostk);
                        pst1.setFloat(2, cstk);
                        pst1.executeUpdate();
                        }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock Update after first Error#"+er);}
                        finally
                        {
                        try{pst1.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst1 error#" + er);}
                        }
}
private void AccountRefresh(String table, String dat, Float amt)
{
     try
                    {
                    String sqlsals = "Select * From "+table+" Where Date > '"+dat+"'";
                    pst2 = acc.prepareStatement(sqlsals);
                    rs2 = pst2.executeQuery();
                    
                    while(rs2.next())
                    {   
                        String dat1 = rs2.getString("Date");
                        Float oamt = rs2.getFloat("Opening_Amount");
                        Float camt = rs2.getFloat("Standing_Amount");
                        Float oamt1 = oamt + amt;
                        Float camt1 = camt + amt; 
                        try
                        {
                        String sql1 = "Update "+table+" Set Opening_Amount = ?, Standing_Amount = ? Where Date = '"+dat1+"'";
                        pst1 = acc.prepareStatement(sql1);
                        pst1.setFloat(1, oamt1);
                        pst1.setFloat(2, camt1);
                        pst1.executeUpdate();
                        }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock Update after first Error#"+er);}
                        finally
                        {
                        try{pst1.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst1 error#" + er);}
                        }                   
                    }


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock Retrieve Dispatch and O_StockError#"+er);}
                    finally
                    {
                        try{pst2.close();rs2.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst2 error#" + er);}
                    }
}
private void Accounts1(String inex,String datee,float totamt)
{
      String dat = null;
      int countacc = 0;
                  try
                  {
                      String sel = "SELECT * FROM DailyRecord1";
                      st1 = acc.createStatement();
                      rs1 = st1.executeQuery(sel);

                      while(rs1.next())
                      {
                          dat = rs1.getString("Date");
                          if(dat.equals(datee))
                          {
                           countacc = 1;
                          }
                      }
                  }
                  catch(Exception er)
                  {
                      JOptionPane.showMessageDialog(null, "aaaa5"+er); 
                  }
                  finally
                 {
                    try
                   {st1.close();
                    rs1.close();
                    }catch(Exception er)
                    {
                     JOptionPane.showMessageDialog(null, er); 
                    }

                  }
                  
              if(countacc == 1)
               {  
                float inc2 = 0;
                try
                {
                 String selec = "SELECT * FROM DailyRecord1 WHERE Date = '"+datee+"'";
                st1 = acc.createStatement();
                rs2 = st1.executeQuery(selec);
                rs2.next();
                inc2 = rs2.getFloat(inex);
                inc2 += totamt;
                
                }
                catch(Exception er)
                {
                JOptionPane.showMessageDialog(null, "aaaa6"+er); 
                }
                finally
             {
                try
                {
                    
                rs2.close();
                st1.close();           
                }catch(Exception er)
                {
                JOptionPane.showMessageDialog(null, er); 
                }
            
             }
                   
              try
              {
              String upd = "UPDATE DailyRecord1 SET "+inex+" = ? WHERE Date = ?";
              pst1 = acc.prepareStatement(upd);
              pst1.setFloat(1, inc2);
              pst1.setString(2, datee);
              pst1.executeUpdate();
              inc2 = 0;
              totamt = 0;
                      
                  
              }
              catch(Exception er)
              {
              JOptionPane.showMessageDialog(null, "aaaa7"+er); 
              }
              finally
             {
                try
               {
               
                pst1.close();
                           
                }catch(Exception er)
                {
                 JOptionPane.showMessageDialog(null, er); 
                }
            
              }
             }
              else
              {     
                  //------------getting previous standing amount---------------------
                  float o_samt = 0;
              try
                    {
                    String sqlprecstk = "Select * From DailyRecord1 ORDER BY Date DESC LIMIT 1";
                    pst0 = acc.prepareStatement(sqlprecstk);
                    rs0 = pst0.executeQuery();
                    if(rs0.next())
                    {
                       //System.out.print(" "+rs0.getString("Date")+" ");
                      o_samt = rs0.getFloat("Standing_Amount");
                        
                        
                    }
                    else
                    {
                        o_samt = 0;
                        JOptionPane.showMessageDialog(rootPane, "Contact Admin#");
                    }


                    }catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Stock DESC LIMIT Error#"+er);}
                    finally
                    {
                        try{pst0.close();rs0.close();}catch(Exception er){JOptionPane.showMessageDialog(rootPane, "Close pst0 error#" + er);}
                    }
                  try
                  {
                      String ins = "INSERT INTO DailyRecord1 (Date,"+inex+",Opening_Amount) VALUES(?,?,?)";
                      pst1 = acc.prepareStatement(ins);
                      pst1.setString(1, datee);
                      pst1.setFloat(2, totamt);
                      pst1.setFloat(3, o_samt);
                      pst1.executeUpdate();
                      totamt = 0;
                  }
                  catch(Exception er)
                  {
                      JOptionPane.showMessageDialog(null, "aaaa8"+er); 
                  }
                  finally
             {
                try
               {
               
                pst1.close();
                           
                }catch(Exception er)
                {
                 JOptionPane.showMessageDialog(null, er); 
                }
            
              }
               }
//              -------------------Standing amount update-----------------  

              float  samt = 0;
              
              
                  try
                {
                 String selec = "SELECT * FROM DailyRecord1 WHERE Date = '"+datee+"'";
                st1 = acc.createStatement();
                rs2 = st1.executeQuery(selec);
                rs2.next();
                float income = rs2.getFloat("Income");
                float expense = rs2.getFloat("Expense");
                float oamt = rs2.getFloat("Opening_Amount");
                samt = oamt + income - expense;
               //System.out.print(samt + " **** ");
                                
                }
                catch(Exception er)
                {
                JOptionPane.showMessageDialog(null, "aaaa6"+er); 
                }
                finally
             {
                try
                {
                    
                rs2.close();
                st1.close();           
                }catch(Exception er)
                {
                JOptionPane.showMessageDialog(null, er); 
                }
            
             }
//                  -------------------------------------------------
                  try
                  {
                      String upd = "UPDATE DailyRecord1 SET Standing_Amount = ? WHERE Date = ?";
              pst1 = acc.prepareStatement(upd);
              pst1.setFloat(1, samt);
              pst1.setString(2, datee);
              pst1.executeUpdate();
                  }
                  catch(Exception er)
                  {
                      JOptionPane.showMessageDialog(null, "aaaa8"+er); 
                  }
                  finally
             {
                try
               {
               
                pst1.close();
                           
                }catch(Exception er)
                {
                 JOptionPane.showMessageDialog(null, er); 
                }
            
              }
}
private int DateInit(String table,String dat)
{
    int rount = 0;
    try
            {
                String sqdate = "Select * from "+table+" Where Date > '"+dat+"'";
                pst = con.prepareStatement(sqdate);
                rs = pst.executeQuery();
                if(rs.next())
                {
                    rount = 0;
                }
                else
                {
                    rount = 1;
                }
               
                
                
            }catch(Exception er){JOptionPane.showMessageDialog(null,"date fetch #" + er);}
    finally{
        try{
            pst.close();
            rs.close();
        }catch(Exception er){}
    }
     return rount;
}
 private static void sendFromGMail(String from, String pass, String[] to, String subject, String body, String filename) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            
            MimeBodyPart messagePart = new MimeBodyPart();      
            messagePart.setText(body);
            // Set the email attachment file

            MimeBodyPart attachmentPart = new MimeBodyPart();
            FileDataSource fileDataSource = new FileDataSource(filename) {
            @Override
                public String getContentType() {
            return "application/octet-stream";
               }
            };
            attachmentPart.setDataHandler(new DataHandler(fileDataSource));
            attachmentPart.setFileName(fileDataSource.getName());
            // Add all parts of the email to Multipart object
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messagePart);
            multipart.addBodyPart(attachmentPart);
            message.setContent(multipart);
            
//            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}
