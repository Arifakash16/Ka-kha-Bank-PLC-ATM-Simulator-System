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

public class PinChange extends JFrame implements ActionListener {
    String cardNumber, pinNumber;
    JTextField nPin,rnPin;
    JButton change,back;
    PinChange(String cardNumber,String pinNumber)
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
        
        JLabel text = new JLabel("Change your PIN");
        text.setBounds(250,280,500,35);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JLabel text1 = new JLabel("New PIN");
        text1.setBounds(165,320,180,25);
        text1.setFont(new Font("system",Font.BOLD,16));
        text1.setForeground(Color.WHITE);
        image.add(text1);
        
        nPin = new JPasswordField();
        nPin.setBounds(320, 320, 180, 25);
        nPin.setFont(new Font("Arial",Font.BOLD,14));
        image.add(nPin);
        
        JLabel text2 = new JLabel("Re-Enter New PIN");
        text2.setBounds(165,360,180,25);
        text2.setFont(new Font("system",Font.BOLD,16));
        text2.setForeground(Color.WHITE);
        image.add(text2);
        
        rnPin = new JPasswordField();
        rnPin.setBounds(320, 360, 180, 25);
        rnPin.setFont(new Font("Arial",Font.BOLD,14));
        image.add(rnPin);
        
        change = new JButton("Change");
        change.setBounds(370,420,140,30);
        change.setBackground(Color.WHITE);
        change.setForeground(Color.BLACK);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(190,420,140,30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource()==change)
        {
            try
            {
                String npin = nPin.getText();
                String rnpin = rnPin.getText();
                if(!npin.equals(rnpin))
                {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                if(npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter new PIN");
                    return;
                }
                
                if(rnpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Re-enter new PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String query = "update bank set pin_number = '"+npin+"' where card_number = '"+cardNumber+"' and pin_number = '"+pinNumber+"'";
                String query2 = "update login set pin = '"+npin+"' where cardNumber = '"+cardNumber+"' and pin = '"+pinNumber+"'";
                String query3 = "update signupThree set pin = '"+npin+"' where cardNumber = '"+cardNumber+"' and pin = '"+pinNumber+"'";
                
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(cardNumber,npin).setVisible(true);
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }    
        }
        else
        {
            setVisible(false);
            new Transactions(cardNumber,pinNumber).setVisible(true);
        }
        
    }
    public static void main(String args[]) {
        new PinChange("","");
    }
}
