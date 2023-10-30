/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KomponenSwing2;

/**
 *
 * @author acer
 */


// Wildan Fauzan
// 213040025


import java.awt.event.*;
import javax.swing.*;

public class RadioButton extends JFrame {
    public RadioButton() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Perintah untuk menutup JavaGUI ketikatombol X ditekan
        
        JLabel labelInput = new JLabel("Input Nama : "); //Membuat objek Nama berupa Inputan
        labelInput.setBounds(15,40,350,10);
        
        JTextField textField = new JTextField(); //Membuat objek TextField untuk inputan Nama
        textField.setBounds(15,60,350,30);
        
        JLabel labelRadio = new JLabel("Jenis Member : "); //Membuat RadioButton yang tidak dipilih dan tanpa teks, memiliki 3 JRadioButton
        labelRadio.setBounds(15,100,350,10);
        
        JRadioButton radioButton1 = new JRadioButton("Silver",true); //Bagian dari RadioButton ke-1
        radioButton1.setBounds(15,115,350,10);
        
        JRadioButton radioButton2 = new JRadioButton("Gold"); //Bagian dari RadioButton ke-2
        radioButton2.setBounds(15,145,350,10);
        
        JRadioButton radioButton3 = new JRadioButton("Platinum"); //Bagian dari RadioButton ke-3
        radioButton3.setBounds(15,175,350,10);
        
        ButtonGroup bg = new ButtonGroup(); //Membuat objek ButtonGroup
        bg.add(radioButton1); //Menambahkan JRadioButton bernama radioButton1
        bg.add(radioButton2); //Menambahkan JRadioButton bernama radioButton2
        bg.add(radioButton3); //Menambahkan JRadioButton bernama radioButton3
        
        JButton button = new JButton("Simpan"); //Membuat objek button untuk tombol simpan
        button.setBounds(15,205,100,40);
        
        JTextArea txtOutput = new JTextArea(""); //Membuat objek untuk menampilkan output berupa TextArea
        txtOutput.setBounds(15,250,350,100);
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jenisMember = ""; //Mendeklarasikan variabel String bernama jenisMember
                if(radioButton1.isSelected()) {
                    jenisMember = radioButton1.getText(); //Mendapatkan teks dari radioButton1
                }
                if(radioButton2.isSelected()) {
                    jenisMember = radioButton2.getText(); //Mendapatkan teks dari radioButton2 dan disimpan dalam variabel jenisMember
                }
                if(radioButton3.isSelected()) {
                    jenisMember = radioButton3.getText(); //Mendapatkan teks dari radioButton2 dan disimpan dalam variabel jenisMember
                }
                
                String nama = textField.getText(); //Inputan Nama disimpan ke dalam variabel nama
                txtOutput.append("Hello "+nama+"\n"); //Menambahkan komponen teks nama pada textOutput 
                txtOutput.append("Anda adalah member " +jenisMember+"\n"); //Menambahkan komponen jenis Member pada textOutput
                textField.setText("");  // Mengembalikan ke kondisi awal untuk Teks Output
            }
        });
        
        //Memasukkan elemen pada frame
        this.add(button);
        this.add(textField);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(radioButton3);
        this.add(labelInput);
        this.add(txtOutput);
        
        //Mengatur frame yang dibuat
        this.setSize(400,500);
        this.setLayout(null);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RadioButton h = new RadioButton();  //Instansiasi objek Class
                h.setVisible(true);  //Menampilkan objek Class tersebut ke dalam Frame
            }
        });
    }
}
