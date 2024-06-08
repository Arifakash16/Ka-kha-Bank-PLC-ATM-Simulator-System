/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ka.kha.bank.plc.atm.simulator.system;

/**
 *
 * @author ARIFAKASH
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
    String cardNumber, pinNumber;
    JButton back;
    MiniStatement(String cardNumber,String pinNumber)
    {
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
        
        setTitle("Mini Statement");
        
        setLayout(null);
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(0,0,900,900);
//        add(image);
        
        JLabel text = new JLabel();
        add(text);
        
        JLabel bank = new JLabel("Ka-Kha Bank PLC");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        
        try
        {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where cardNumber = '"+cardNumber+"' and pin = '"+pinNumber+"'");
            while(rs.next())
            {
                card.setText("Card Number: "+ rs.getString("cardNumber"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        JLabel mini = new JLabel();
        mini.setBounds(20,80,300,20);
        add(mini);
        
        
        
        try
        {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where card_number = '"+cardNumber+"' and pin_number = '"+pinNumber+"'");
            while(rs.next())
            {
                mini.setText(mini.getText()+"<html>"+ rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        mini.setBounds(20,140,400,200);
        
        back = new JButton("Back");
        back.setBounds(360,520,140,30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
        setSize(600,600);
        setLocation(400,30);
        getContentPane().setBackground(Color.WHITE);
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
        new MiniStatement("","");
    }
}
