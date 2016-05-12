/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hsbClasses;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author vignesh
 */
public class Functions {
    String Current_Time,Current_Date = null;
    
    public void hsbDateFormats()
{
    Calendar calendar = Calendar.getInstance();
     java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
     DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
     Current_Date = df.format(ourJavaDateObject);
     DateFormat tf = new SimpleDateFormat("hh:mm:ss");
     Current_Time = tf.format(ourJavaDateObject);
}
    
}
