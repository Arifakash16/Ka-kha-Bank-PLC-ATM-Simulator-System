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
public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField occupationTextField,nidTextField;
    JButton next;
    JComboBox religion,eduQualification,income;
    String formno;

    SignupTwo(String formno)
    {
        setLayout(null);
        this.formno = formno;
        
        JLabel personalDetails = new JLabel("Page 2: Additional Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,30));
        personalDetails.setBounds(240,70,600,40);
        add(personalDetails);
        
        JLabel lreligion = new JLabel("Religion:");
        lreligion.setFont(new Font("Raleway",Font.BOLD,20));
        lreligion.setBounds(140,120,600,40);
        add(lreligion);
        
        String valReligion[]={"Muslim","Hindu","Christian","Buddist","Others"};
        religion = new JComboBox(valReligion);
        religion.setFont(new Font("Raleway",Font.BOLD,15));
        religion.setBounds(320,130,380,20);
        add(religion);
        
        JLabel lEduQualification = new JLabel("Educational:");
        lEduQualification.setFont(new Font("Raleway",Font.BOLD,20));
        lEduQualification.setBounds(140,170,600,40);
        add(lEduQualification);
        
        JLabel l2EduQualification = new JLabel("Qualification:");
        l2EduQualification.setFont(new Font("Raleway",Font.BOLD,20));
        l2EduQualification.setBounds(140,205,600,40);
        add(l2EduQualification);
        
        String valEduQualification[]={"MSc","MA","MBA","BSC","BSS","BBS","BA","HSC","SSC"};
        eduQualification = new JComboBox(valEduQualification);
        eduQualification.setBounds(320,215,380,20);
        eduQualification.setForeground(new Color(105,105,105));
        add(eduQualification);
        
        JLabel gender = new JLabel("Occupation:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(140,255,600,40);
        add(gender);
        
        occupationTextField= new JTextField();
        occupationTextField.setFont(new Font("Raleway",Font.BOLD,15));
        occupationTextField.setBounds(320,265,380,20);
        add(occupationTextField);
         
        JLabel lincome = new JLabel("Income:");
        lincome.setFont(new Font("Raleway",Font.BOLD,20));
        lincome.setBounds(140,305,600,40);
        add(lincome);
        
        String valIncome[]={"<10k","<30K","<50K","<100K","<200K",">200K"};
        income = new JComboBox(valIncome);
        income.setFont(new Font("Raleway",Font.BOLD,15));
        income.setBounds(320,315,380,20);
        add(income);
        
        JLabel maritalStatus = new JLabel("NID:");
        maritalStatus.setFont(new Font("Raleway",Font.BOLD,20));
        maritalStatus.setBounds(140,360,600,40);
        add(maritalStatus);
        
        nidTextField = new JTextField();
        nidTextField.setFont(new Font("Raleway",Font.BOLD,15));
        nidTextField.setBounds(320,370,380,20);
        add(nidTextField);
           
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBounds(620,420,80,40);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
       
       //String formno = ""+random;
       String sreligion = (String)religion.getSelectedItem();
       String seduQualification = (String)eduQualification.getSelectedItem();
       String sincome = (String)income.getSelectedItem();
       String soccupation = occupationTextField.getText();
       String snid = nidTextField.getText();
       
       try{
            if(sreligion.equals(""))
                JOptionPane.showMessageDialog(null, "Religion is required");
            else if(seduQualification.equals(""))
                JOptionPane.showMessageDialog(null, "Educational Qualification is required");
            else if(sincome.equals(""))
                JOptionPane.showMessageDialog(null, "Income is required");
            else if(soccupation.equals(""))
                JOptionPane.showMessageDialog(null, "Occupation is required");
            else if(snid.equals(""))
                JOptionPane.showMessageDialog(null, "NID number is required"); 
            else{
                Conn c = new Conn();
                String query = "insert into signupTwo values('"+formno+"','"+sreligion+"','"+seduQualification+"','"+sincome+"','"+soccupation+"','"+snid+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       
        
    }
    
    public static void main(String args[]) {
        new SignupTwo("");
    }
}
