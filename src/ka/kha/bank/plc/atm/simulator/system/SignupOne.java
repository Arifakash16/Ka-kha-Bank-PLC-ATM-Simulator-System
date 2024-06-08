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
public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,districtTextField,pinCodeTextField,divisionTextField;
    JButton next;
    JDateChooser dateChooser;
    JRadioButton male,female,married,unmarried,others;
    SignupOne()
    {
        setLayout(null);
        
        Random ran = new Random();
        random = (Math.abs(ran.nextLong()%9000L + 1000L));
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,30));
        personalDetails.setBounds(240,70,600,40);
        add(personalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(140,120,600,40);
        add(name);
        
        nameTextField= new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,15));
        nameTextField.setBounds(320,130,380,20);
        add(nameTextField);
        
        JLabel fatherName = new JLabel("Father's Name:");
        fatherName.setFont(new Font("Raleway",Font.BOLD,20));
        fatherName.setBounds(140,170,600,40);
        add(fatherName);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,15));
        fnameTextField.setBounds(320,180,380,20);
        add(fnameTextField);
        
        JLabel dateOfBirth = new JLabel("Date of Birth:");
        dateOfBirth.setFont(new Font("Raleway",Font.BOLD,20));
        dateOfBirth.setBounds(140,220,600,40);
        add(dateOfBirth);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(320,230,380,20);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(140,270,600,40);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(320,270,70,40);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(420,270,70,40);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(140,320,600,40);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,15));
        emailTextField.setBounds(320,330,380,20);
        add(emailTextField);
        
        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setFont(new Font("Raleway",Font.BOLD,20));
        maritalStatus.setBounds(140,370,600,40);
        add(maritalStatus);
        
        married = new JRadioButton("Married");
        married.setBounds(320,370,70,40);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(420,370,100,40);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        others = new JRadioButton("Others");
        others.setBounds(540,370,70,40);
        others.setBackground(Color.WHITE);
        add(others);
        
        ButtonGroup marriedGroup = new ButtonGroup();
        marriedGroup.add(married);
        marriedGroup.add(unmarried);
        marriedGroup.add(others);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(140,420,600,40);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,15));
        addressTextField.setBounds(320,430,380,20);
        add(addressTextField);
        
        JLabel district = new JLabel("District:");
        district.setFont(new Font("Raleway",Font.BOLD,20));
        district.setBounds(140,470,600,40);
        add(district);
        
        districtTextField= new JTextField();
        districtTextField.setFont(new Font("Raleway",Font.BOLD,15));
        districtTextField.setBounds(320,480,380,20);
        add(districtTextField);
        
        JLabel division = new JLabel("Division:");
        division.setFont(new Font("Raleway",Font.BOLD,20));
        division.setBounds(140,520,600,40);
        add(division);
        
        divisionTextField = new JTextField();
        divisionTextField.setFont(new Font("Raleway",Font.BOLD,15));
        divisionTextField.setBounds(320,530,380,20);
        add(divisionTextField);
        
        JLabel pinCode = new JLabel("Pin Code:");
        pinCode.setFont(new Font("Raleway",Font.BOLD,20));
        pinCode.setBounds(140,570,600,40);
        add(pinCode);
        
        pinCodeTextField = new JTextField();
        pinCodeTextField.setFont(new Font("Raleway",Font.BOLD,15));
        pinCodeTextField.setBounds(320,580,380,20);
        add(pinCodeTextField);
        
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBounds(620,620,80,40);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
    
     public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dateOfBirth = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = "";
        if(male.isSelected())
            gender = "Male";
        else if(female.isSelected())
            gender = "Female";
        String email = emailTextField.getText();
        String maritalStatus = "";
        if(married.isSelected())
            maritalStatus = "Married";
        else if(unmarried.isSelected())
            maritalStatus = "Unmarried";
        else if(others.isSelected())
            maritalStatus = "Other";
        
        String address = addressTextField.getText();
        String district = districtTextField.getText();
        String division = divisionTextField.getText();
        String pincode = pinCodeTextField.getText();
        
        try{
            if(name.equals(""))
                JOptionPane.showMessageDialog(null, "Name is required");
            else if(fname.equals(""))
                JOptionPane.showMessageDialog(null, "Father name is required");
            else if(dateOfBirth.equals(""))
                JOptionPane.showMessageDialog(null, "Date of birth is required");
            else if(gender.equals(""))
                JOptionPane.showMessageDialog(null, "Gender is required");
            else if(email.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Email is required");
            }
            else if (!email.equals("") && !isValidEmail(email)) 
            {
                JOptionPane.showMessageDialog(null, "invalid email");
            } 
            else if(maritalStatus.equals(""))
                JOptionPane.showMessageDialog(null, "Marital Status is required");
            else if(address.equals(""))
                JOptionPane.showMessageDialog(null, "Address is required");
            else if(district.equals(""))
                JOptionPane.showMessageDialog(null, "District is required");
            else if(division.equals(""))
                JOptionPane.showMessageDialog(null, "Division is required");
            else if(pincode.equals(""))
                JOptionPane.showMessageDialog(null, "Pin code is required");
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dateOfBirth+"','"+gender+"','"+email+"','"+maritalStatus+"','"+address+"','"+district+"','"+division+"','"+pincode+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    public static void main(String args[]) {
        new SignupOne();
    }
}
