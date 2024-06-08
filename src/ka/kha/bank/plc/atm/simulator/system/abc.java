/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ka.kha.bank.plc.atm.simulator.system;

/**
 *
 * @author ARIFAKASH
 */


import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;


public class abc {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Date Chooser Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Create a JDateChooser
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
        dateChooser.setPreferredSize(new Dimension(200, 30));
        frame.add(dateChooser);

        // Add PropertyChangeListener to the JDateChooser
        dateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    // Date selection changed
                    Date selectedDate = (Date) evt.getNewValue();
                    // Perform your action here
                    System.out.println("Selected Date: " + selectedDate);
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}
