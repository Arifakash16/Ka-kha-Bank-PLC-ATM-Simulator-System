/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ka.kha.bank.plc.atm.simulator.system;

import java.sql.*;

/**
 *
 * @author ARIFAKASH
 */
public class Conn {

   Connection c;
   Statement s;
   Conn()
   {
       try {
//           Class.forName("com.mysql.cj.jdbc.Driver");
           c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","a43316311");
           s = c.createStatement();
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
   }
}
