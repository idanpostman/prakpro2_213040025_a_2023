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

public class Latihan extends JFrame {
    private boolean checkBoxSelected; //Menyiapkan variabel untuk CheckBox
    public  Latihan() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Perintah untuk menutup JavaGUI ketikatombol X ditekan
        
        JLabel labelInput = new JLabel("Input Nama : "); //Membuat objek Nama berupa Inputan
        labelInput.setBounds(15,40,350,10); //Mengatur ukuran dan letak label objek
        
        JLabel labelHp = new JLabel("Input Nomor HP : "); //Membuat objek input Nomor HP
        labelHp.setBounds(15,100,350,10);
        
        JTextField textField = new JTextField(); //Membuat objek TextField untuk inputan Nama
        textField.setBounds(15,60,350,30);
        
        JTextField textHp = new JTextField(); //Membuat objek TextField untuk inputan Nomor HP
        textHp.setBounds(15,120,350,30);
        
        JLabel labelRadio = new JLabel("Jenis Member : "); //Membuat RadioButton yang tidak dipilih dan tanpa teks, memiliki 2 JRadioButton
        labelRadio.setBounds(15, 140,350,10);
        
        JRadioButton radioButton1 = new JRadioButton("Laki-laki",true); //Bagian dari RadioButton ke-1  //Harus ada true maksudnya defaultnya yaitu Laki-laki
        radioButton1.setBounds(15,165,350,15);
        
        JRadioButton radioButton2 = new JRadioButton("Perempuan"); //Bagian dari RadioButton ke-2
        radioButton2.setBounds(15,195,350,15);
        
        ButtonGroup bg = new ButtonGroup(); //Membuat objek ButtonGroup
        bg.add(radioButton1); //Menambahkan JRadioButton bernama radioButton1
        bg.add(radioButton2); //Menambahkan JRadioButton bernama radioButton1
        
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing"); //Membuat objek JCheckBox
        checkBox.setBounds(15,220,350,30);
        
        JButton button = new JButton("Simpan"); //Membuat objek button untuk tombol simpan
        button.setBounds(15,250,100,40);
        
        JTextArea txtOutput = new JTextArea(""); //Membuat objek untuk menampilkan output
        txtOutput.setBounds(15,300,350,100);
        
        checkBox.addItemListener(new ItemListener() { //Memberikan ItemListener kepada checkBox
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == 1; //Checkbox bernilai true jika event e bernilai 1
            }
        });
        
        button.addActionListener(new ActionListener() { //Menambahkan Action Listener pada button
            public void actionPerformed(ActionEvent e) {
                String jenisKelamin = ""; //Mendeklarasikan variabel String bernama jenisKelamin
                if(radioButton1.isSelected()) { //Mengecek apakah radioButton1 sudah dipilih atau belum
                    jenisKelamin = radioButton1.getText(); //Mendapatkan teks dari radioButton1 dan disimpan dalam variabel jenisKelamin
                }
                if(radioButton2.isSelected()) { //Mengecek apakah radioButton2 sudah dipilih atau belum
                    jenisKelamin = radioButton2.getText(); //Mendapatkan teks dari radioButton2 dan disimpan dalam variabel jenisKelamin
                }
                
                String nama = textField.getText(); //Inputan Nama disimpan ke dalam variabel nama
                String telp = textHp.getText();//Inputan Nomor HP disimpan ke dalam variabel telp
                txtOutput.append("Nama : "+nama+"\n"); //Menambahkan komponen teks nama pada textOutput 
                txtOutput.append("Nomor HP : "+telp+"\n"); //Menambahkan komponen teks nomor HP pada textOutput
                txtOutput.append("Jenis Kelamin : " +jenisKelamin+"\n"); //Menambahkan komponen jenis kelamin pada textOutput
                textField.setText(""); // Mengembalikan ke kondisi awal untuk Teks Output
                
                if(checkBoxSelected) { //Pengecekkan checkBox, apabila bernilai true atau dicentang,
                    txtOutput.append("WNA\t: " + "Ya\n"); //maka "Ya" akan dimasukkan ke dalam teks output
                }else{ //apabila tidak
                    txtOutput.append("WNA\t: " + "Bukan\n"); //maka "Bukan" akan dimasukkan ke dalam teks output
                }
                
                txtOutput.append("===================================\n");
                
                //Mengembalikan ke kondisi awal untuk Text Field Nomor HP dan CheckBox
                textHp.setText("");
                checkBox.setSelected(false);
            }
        });
        
        
        
        //Memasukkan elemen pada frame
        this.add(labelInput);
        this.add(labelHp);
        this.add(textField);
        this.add(textHp);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
        this.add(button);
        this.add(txtOutput);
        
        //Mengatur frame yang dibuat
        this.setSize(400,500);
        this.setLayout(null);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable () {
            public void run() {
                Latihan h = new Latihan(); //Instansiasi objek Class
                h.setVisible(true); //Menampilkan objek Class tersebut ke dalam Frame
            }
        });
    }
}
