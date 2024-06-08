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

public class Transactions extends JFrame implements ActionListener{
    JButton deposit,cashWithdraw,fastCash,miniStatement,pinChangee, balanceEnquery,exit;
    String cardNumber,pinNumber;
    Transactions(String cardNumber,String pinNumber) {
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        JLabel text = new JLabel("Please select your transactions");
        text.setBounds(215,300,700,35);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,140,30);
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.addActionListener(this);
        image.add(deposit);
        
        cashWithdraw = new JButton("Cash Withdrawl");
        cashWithdraw.setBounds(370,415,140,30);
        cashWithdraw.setBackground(Color.WHITE);
        cashWithdraw.setForeground(Color.BLACK);
        cashWithdraw.addActionListener(this);
        image.add(cashWithdraw);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170,450,140,30);
        fastCash.setBackground(Color.WHITE);
        fastCash.setForeground(Color.BLACK);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(370,450,140,30);
        miniStatement.setBackground(Color.WHITE);
        miniStatement.setForeground(Color.BLACK);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChangee = new JButton("Pin Change");
        pinChangee.setBounds(170,485,140,30);
        pinChangee.setBackground(Color.WHITE);
        pinChangee.setForeground(Color.BLACK);
        pinChangee.addActionListener(this);
        image.add(pinChangee);
        
        balanceEnquery = new JButton("Balance Enquery");
        balanceEnquery.setBounds(370,485,140,30);
        balanceEnquery.setBackground(Color.WHITE);
        balanceEnquery.setForeground(Color.BLACK);
        balanceEnquery.addActionListener(this);
        image.add(balanceEnquery);
       
        exit = new JButton("Exit");
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
            System.exit(0);
        }
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(cardNumber,pinNumber).setVisible(true);
        }
        else if(ae.getSource()==cashWithdraw)
        {
            setVisible(false);
            new Withdraw(cardNumber,pinNumber).setVisible(true);
        }
        else if(ae.getSource()== fastCash)
        {
            setVisible(false);
            new FastCash(cardNumber,pinNumber).setVisible(true);
        }
        else if(ae.getSource()==balanceEnquery)
        {
            setVisible(false);
            new BalanceEnquery(cardNumber,pinNumber).setVisible(true);
        }
        else if(ae.getSource()== pinChangee)
        {
            setVisible(false);
            new PinChange(cardNumber,pinNumber).setVisible(true);
        }
        else if(ae.getSource()==miniStatement)
        {
            setVisible(false);
            new MiniStatement(cardNumber,pinNumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Transactions("","");
    }
}
