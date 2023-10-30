/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layout1;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author acer
 */

//Aufaa Husniati
//213040018

public class HelloBorderLayout extends JFrame {
    
    public HelloBorderLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // perintah untuk menutup JAVAGUI ketika tombol close ditekan
        
        JLabel labelPertanyaan = new JLabel("Apakah ibukota Indonesia?"); // membuat objek Apakah ibukota Indonesia
        JLabel labelHasil = new JLabel("Jawab pertanyaan di atas"); //membuat objek Jawab pertanyaan di atas
        
        JButton buttonA = new JButton("Jakarta"); //membuat objek button Jakarta
        JButton buttonB = new JButton("Bandung"); // membuat objek button Bandung
        JButton buttonC = new JButton("Surabaya"); // membuat objek button surabaya
        
        buttonA.addActionListener(new ActionListener(){ // menambahkan action listener pada buttonA
            public void actionPerformed(ActionEvent e){
                labelHasil.setText("Jawaban anda benar");
            }
        });
        
        buttonB.addActionListener(new ActionListener(){ // menambahkan action listener pada buttonB
            public void actionPerformed(ActionEvent e){
                labelHasil.setText("Jawaban anda salah");
            }
        });
        
        buttonC.addActionListener(new ActionListener(){ // menambahkan action listener pada buttonC
            public void actionPerformed(ActionEvent e){
                labelHasil.setText("Jawaban anda salah");
            }
        });
        
        // Memasukkan elemen pada frame
        this.add(labelPertanyaan, BorderLayout.NORTH);
        this.add(labelHasil, BorderLayout.SOUTH);
        this.add(buttonA, BorderLayout.WEST);
        this.add(buttonB, BorderLayout.CENTER);
        this.add(buttonC, BorderLayout.EAST);
        
        this.setSize(400, 200);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                HelloBorderLayout h = new HelloBorderLayout(); //Instansiasi objek class
                h.setVisible(true); //menampilkan objek class ke dalam frame
            }
        });
    }
}
