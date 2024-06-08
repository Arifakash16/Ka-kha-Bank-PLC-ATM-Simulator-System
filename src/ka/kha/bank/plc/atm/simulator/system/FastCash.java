/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ka.kha.bank.plc.atm.simulator.system;

/**
 *
 * @author ARIFAKASH
 */

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    JButton deposit,cashWithdraw,fastCash,miniStatement,pinChange, balanceEnquery,exit;
    String cardNumber,pinNumber;
    FastCash(String cardNumber,String pinNumber) {
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        JLabel text = new JLabel("Please select your amount");
        text.setBounds(215,300,700,35);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        deposit = new JButton("100");
        deposit.setBounds(170,415,140,30);
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.addActionListener(this);
        image.add(deposit);
        
        cashWithdraw = new JButton("200");
        cashWithdraw.setBounds(370,415,140,30);
        cashWithdraw.setBackground(Color.WHITE);
        cashWithdraw.setForeground(Color.BLACK);
        cashWithdraw.addActionListener(this);
        image.add(cashWithdraw);
        
        fastCash = new JButton("500");
        fastCash.setBounds(170,450,140,30);
        fastCash.setBackground(Color.WHITE);
        fastCash.setForeground(Color.BLACK);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("1000");
        miniStatement.setBounds(370,450,140,30);
        miniStatement.setBackground(Color.WHITE);
        miniStatement.setForeground(Color.BLACK);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange = new JButton("2000");
        pinChange.setBounds(170,485,140,30);
        pinChange.setBackground(Color.WHITE);
        pinChange.setForeground(Color.BLACK);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquery = new JButton("5000");
        balanceEnquery.setBounds(370,485,140,30);
        balanceEnquery.setBackground(Color.WHITE);
        balanceEnquery.setForeground(Color.BLACK);
        balanceEnquery.addActionListener(this);
        image.add(balanceEnquery);
       
        exit = new JButton("Back");
        exit.setBounds(370,520,140,30);
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        

    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            setVisible(false);
            new Transactions(cardNumber,pinNumber).setVisible(true);
        }
        else 
        {
            Conn conn = new Conn();
            String taka = ((JButton)ae.getSource()).getText();
            Date date = new Date();
            
            try
            {
                ResultSet rs = conn.s.executeQuery("select * from bank where card_number = '"+cardNumber+"' and pin_number = '"+pinNumber+"'");
                int balance = 0;
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
                
                if(ae.getSource()!=exit && balance< Integer.parseInt(taka))
                {
                    JOptionPane.showMessageDialog(null, "Insufficent Balance");
                }
                else
                {
                    String query = "insert into bank values('"+cardNumber+"','"+pinNumber+"','"+date+"','Withdraw','"+taka+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "BDT "+taka+" withdrawed successfully");
                    return;
//                    setVisible(false);
//                    new Transactions(cardNumber,pinNumber).setVisible(true);
                }
                    
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
            
        }
       
    }

    public static void main(String args[]) {
        new FastCash("","");
    }
}
