/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ka.kha.bank.plc.atm.simulator.system;



import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;


/**
 *
 * @author ARIFAKASH
 */
public class Withdraw extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw,back;
    String cardNumber,pinNumber;
    Withdraw(String cardNumber,String pinNumber)
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
        
        
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(200,300,700,35);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(215, 350, 230, 24);
        amount.setFont(new Font("Arial",Font.BOLD,14));
        image.add(amount);
        
        
        withdraw = new JButton("Wtihdraw");
        withdraw.setBounds(340,385,105,24);
        withdraw.setBackground(Color.BLACK);
        withdraw.setForeground(Color.WHITE);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(215,385,105,24);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);
        
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
        else if(ae.getSource()==withdraw)
        {
            String taka = amount.getText();
            Date date = new Date();
            String day = date.toString();
            
            if(taka.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }
            else
            {
                try
                {
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+cardNumber+"','"+pinNumber+"','"+day+"','Withdraw','"+taka+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "BDT "+taka+" withdrawed successfully");
                    setVisible(false);
                    new Transactions(cardNumber,pinNumber).setVisible(true);
                    
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                
            }
        }
        
    }
    
    public static void main(String args[]) {
       new Withdraw("","");
    }
}
