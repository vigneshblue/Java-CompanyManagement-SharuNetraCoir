/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
12 */
package hsbClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;

/**
 *
 * @author vignesh
 */
public class DbConnection {
    public Connection AccessConnect()
     {
         Connection con = null;
         
       
         try
        {
          
             Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:hsbCoirManagement.sqlite");
           
            return con;
        }   
        catch(Exception er)
        {
//            JOptionPane.showMessageDialog(null, "1"+er);
            System.out.println(er);
            return null;
        }

     }
    
    public Connection Accounts()
     {
         Connection con = null;
         
       
         try
        {
          
             Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:hsbAccounts.sqlite");
           
            return con;
        }   
        catch(Exception er)
        {
//            JOptionPane.showMessageDialog(null, "1"+er);
            System.out.println(er);
            return null;
        }

     }
    
}
