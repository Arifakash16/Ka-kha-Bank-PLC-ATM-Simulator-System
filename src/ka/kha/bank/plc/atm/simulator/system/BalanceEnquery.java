/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ka.kha.bank.plc.atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


/**
 *
 * @author ARIFAKASH
 */
public class BalanceEnquery extends JFrame implements ActionListener {

    String cardNumber, pinNumber;
    JButton back;
    int balance = 0;
    BalanceEnquery(String cardNumber,String pinNumber)
    {
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(370,520,140,30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);
        
        
        try
        {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where card_number = '"+cardNumber+"' and pin_number = '"+pinNumber+"'");
            balance = 0;
            while(rs.next())
            {
                if(rs.getString("type").equals("Deposit"))
                {
                    balance+= Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    balance-= Integer.parseInt(rs.getString("amount"));
                }
            }
          
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        JLabel text = new JLabel("Your current account balance is: " + balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        image.add(text);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
         
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(cardNumber,pinNumber).setVisible(true);
        }
        
           
       
    }
    public static void main(String args[]) {
        new BalanceEnquery("","");
    }
}
