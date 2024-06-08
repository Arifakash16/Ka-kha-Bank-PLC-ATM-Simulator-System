/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ka.kha.bank.plc.atm.simulator.system;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author ARIFAKASH
 */
public class Login extends JFrame implements ActionListener {
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login()
    {
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null); // to set null in setLayout otherwise image will not set in the left corner of the frame
        
        //add icon and place it to the left corner of the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text = new JLabel("Welcome to Ka-Kha Bank ATM");
        text.setFont(new Font("osward",Font.BOLD,30));
        text.setBounds(185,40,500,40);
        add(text);
        
        //Implement card no input field
        JLabel cardno= new JLabel("Card No:");
        cardno.setFont(new Font("raleway",Font.BOLD,24));
        cardno.setBounds(125,140,150,40);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(240, 150, 230, 24);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        //Implement pin no input field
        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("raleway",Font.BOLD,24));
        pin.setBounds(125,200,500,40);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(240, 210, 230, 24);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        //Implement login button
        login = new JButton("SIGN IN ACC.");
        login.setBounds(240,280,105,24);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        //Implement clear button
        clear = new JButton("CLEAR");
        clear.setBounds(380,280,90,24);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        //Implement signup button
        signup = new JButton("REGISTER  ACCOUNT");
        signup.setBounds(240,330,230,24);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480); // define the frame size
        setVisible(true); // to show the frame as interface
        setLocation(350,200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == login)
        {
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardNumber+"' and pin = '"+pinNumber+"'";
            try
            {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(cardNumber,pinNumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                    
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Login();
    }
}
