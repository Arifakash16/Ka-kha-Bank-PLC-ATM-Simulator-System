/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ka.kha.bank.plc.atm.simulator.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author ARIFAKASH
 */
public class SignupThree extends JFrame implements ActionListener {

    
    JRadioButton r1,r2,r3,r4;
    JCheckBox s1,s2,s3,s4,s5,s6,s7;
    JButton submit,cancel;
    String formno;

    SignupThree(String formno)
    {
        setLayout(null);
        this.formno = formno;
        
        JLabel personalDetails = new JLabel("Page 3: Accounts Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,30));
        personalDetails.setBounds(240,70,600,40);
        add(personalDetails);
        
        JLabel accountsType = new JLabel("Accounts Type:");
        accountsType.setFont(new Font("Raleway",Font.BOLD,20));
        accountsType.setBounds(140,120,600,40);
        add(accountsType);
        
        r1 = new JRadioButton("Saving Account");
        r1.setBounds(140,150,180,40);
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBounds(320,150,180,40);
        r2.setBackground(Color.WHITE);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setBounds(140,180,180,40);
        r3.setBackground(Color.WHITE);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(320,180,180,40);
        r4.setBackground(Color.WHITE);
        add(r4);
        
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(r1);
        accountGroup.add(r2);
        accountGroup.add(r3);
        accountGroup.add(r4);
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(140,230,600,40);
        add(card);
        
        JLabel number = new JLabel("xxxx-xxxx-xxxx-4286");
        number.setFont(new Font("Raleway",Font.BOLD,20));
        number.setBounds(300,230,600,40);
        add(number);
        
        JLabel cnum = new JLabel("Your 16 digit card number");
        cnum.setFont(new Font("Raleway",Font.BOLD,8));
        cnum.setBounds(140,250,600,40);
        add(cnum);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(140,270,600,40);
        add(pin);
        
        JLabel pass = new JLabel("Your 4 digit password");
        pass.setFont(new Font("Raleway",Font.BOLD,8));
        pass.setBounds(140,290,600,40);
        add(pass);
        
        JLabel pinnum = new JLabel("xxxx");
        pinnum.setFont(new Font("Raleway",Font.BOLD,20));
        pinnum.setBounds(300,270,600,40);
        add(pinnum);
        
        JLabel service = new JLabel("Services Required:");
        service.setFont(new Font("Raleway",Font.BOLD,20));
        service.setBounds(140,320,600,40);
        add(service);
        
        s1 = new JCheckBox("ATM Card");
        s1.setBounds(140,350,180,40);
        s1.setBackground(Color.WHITE);
        add(s1);
        
        s2 = new JCheckBox("Internet Banking");
        s2.setBounds(320,350,180,40);
        s2.setBackground(Color.WHITE);
        add(s2);
           
        s3 = new JCheckBox("Mobile Bangking");
        s3.setBounds(140,380,180,40);
        s3.setBackground(Color.WHITE);
        add(s3);
        
        s4 = new JCheckBox("SMS & Email alerts");
        s4.setBounds(320,380,180,40);
        s4.setBackground(Color.WHITE);
        add(s4);
        
        s5 = new JCheckBox("Cheque Book");
        s5.setBounds(140,410,180,40);
        s5.setBackground(Color.WHITE);
        add(s5);
        
        s6 = new JCheckBox("E-Statement");
        s6.setBounds(320,410,180,40);
        s6.setBackground(Color.WHITE);
        add(s6);
        
        s7 = new JCheckBox("I hereby declares that the avobe entered details are correct to the best of my knowledge");
        s7.setBounds(140,480,700,40);
        s7.setBackground(Color.WHITE);
        add(s7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,15));
        submit.setBounds(250,530,100,40);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,15));
        cancel.setBounds(380,530,100,40);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
       
         if(ae.getSource()==cancel)
         {
            setVisible(false);
            new Login().setVisible(true);
         }
         if(ae.getSource() == submit)
         {
             String accountType = "";
             if(r1.isSelected())
                 accountType = "Saving Account";
             else if(r2.isSelected())
                 accountType = "Fixed Deposit Account";
             else if(r3.isSelected())
                 accountType = "Current Account";
             else if(r4.isSelected())
                 accountType = "Recurring Deposit Account";  
             
             
             
             
             String facility = "";
              if(s1.isSelected())
                 facility = "ATM Card";
             else if(s2.isSelected())
                 facility = "Internet Banking";
             else if(s3.isSelected())
                 facility = "Mobile Banking";
             else if(s4.isSelected())
                 facility = "SMS & Email Alerts";  
              else if(s5.isSelected())
                 facility = "Cheque Book";
             else if(s6.isSelected())
                 facility = "E-Statement"; 
              
             String seven = "";
             if(s7.isSelected())
                 seven = "okay";
              
             
              try{
                  if(accountType.equals(""))
                      JOptionPane.showMessageDialog(null, "Account is required");
                  else if(facility.equals(""))
                      JOptionPane.showMessageDialog(null, "Please select which service would you want");
                  else if(seven.equals(""))
                      JOptionPane.showMessageDialog(null, "Please ensure your information is correct");
                  else
                  {
                    Random random = new Random();
             
                    String cardNumber = "" + (Math.abs(random.nextLong()%90000000L + 5040936000000000L));
             
                    String pin = "" + (Math.abs(random.nextLong()%9000L)+1000L);
                    
                    Conn c = new Conn();
                    String query = "insert into signupThree values('"+formno+"','"+cardNumber+"','"+pin+"','"+accountType+"','"+facility+"')";
                    c.s.executeUpdate(query);
                    String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pin+"')";
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber +"\n Pin: " + pin );
                    setVisible(false);
                    new Login().setVisible(true);
                  }

              }
              catch(Exception e)
              {
                  System.out.println(e);
              }
             
         }
         else if(ae.getSource() == cancel)
         {
             
         }
       
        
    }
    
    
    public static void main(String args[]) {
        new SignupThree("");
    }
}
