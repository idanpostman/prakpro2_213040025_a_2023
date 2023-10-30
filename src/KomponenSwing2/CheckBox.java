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

public class CheckBox extends JFrame{
    private boolean checkBoxSelected;
    
    public CheckBox(){
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Perintah untuk menutup JavaGUI ketikatombol X ditekan
        
        JLabel labelInput = new JLabel("Input Nama : "); //Membuat objek Nama berupa Inputan
        labelInput.setBounds(15,40,350,10);
        
        JTextField textField = new JTextField(); //Membuat objek input Nama
        textField.setBounds(15,60,350,30);
        
        JCheckBox checkBox = new JCheckBox("Saya menyetujui syarat dan ketentuan berlaku"); //Membuat objek JCheckBox
        checkBox.setBounds(15,100,350,30);
        
        JButton button = new JButton("Simpan"); //Membuat objek button untuk tombol simpan
        button.setBounds(15, 150, 100, 40);
        
        JTextArea txtOutput = new JTextArea(""); //Membuat objek TextArea untuk menampilkan output
        txtOutput.setBounds(15,200,350,100);
        
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange()==1;
            }
        });
        
        button.addActionListener(new ActionListener(){ //Menambahkan Action Listener pada button
            public void actionPerformed(ActionEvent e) {
                if(checkBoxSelected) { //Pengecekkan checkBox, apabila bernilai true atau dicentang, maka
                    String nama = textField.getText(); //Inputan Nama disimpan ke dalam variabel nama
                    txtOutput.append("Hello "+nama+"\n"); //Menambahkan komponen teks nama pada textOutput
                    textField.setText(""); // Mengembalikan ke kondisi awal untuk Teks Output
                }else{ //apabila tidak, maka
                    txtOutput.append("Anda tidak mencentang kotak persetujuan\n"); //Menampilkan teks tersebut pada Output
                }
            }
        });
        
        //Memasukkan elemen pada frame
        this.add(button);
        this.add(textField);
        this.add(checkBox);
        this.add(labelInput);
        this.add(txtOutput);
        
         //Mengatur frame yang dibuat
        this.setSize(400,500);
        this.setLayout(null);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CheckBox h = new CheckBox();  //Instansiasi objek Class
                h.setVisible(true);  //Menampilkan objek Class tersebut ke dalam Frame
            }
        });
    }
}
