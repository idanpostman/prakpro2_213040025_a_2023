/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KomponenSwingDasar;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author acer
 */
public class Latihan extends JFrame {
    public Latihan() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel labelInput = new JLabel("Input Nama: ");
        labelInput.setBounds(50, 30, 100, 40);
        
        JTextField textField = new JTextField();
        textField.setBounds(50, 60, 100, 30);
        
        JLabel labelInput2 = new JLabel("No Telp: ");
        labelInput2.setBounds(210, 30, 100, 40);
        
        JTextField textField2 = new JTextField();
        textField2.setBounds(210, 60, 100, 30);
        
        JButton button = new JButton("SUBMIT");
        button.setBounds(130, 100, 100, 40);
        
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(130, 150, 100, 100);
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String nama = textField.getText();
                String notelp = textField2.getText();
                txtOutput.append(nama+ ": " + notelp + "\n-----\n");
                textField.setText("");
            }
        });
        
        this.add(button);
        this.add(textField);
        this.add(textField2);
        this.add(labelInput);
        this.add(labelInput2);
        this.add(txtOutput);
               
        this.setSize(400, 500);
        this.setLayout(null);
        
        //BATAS BUTTON
        // ====================================
        
        
        
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                Latihan h = new Latihan();
                h.setVisible(true);
            }
        });
    }

    
    
 }

