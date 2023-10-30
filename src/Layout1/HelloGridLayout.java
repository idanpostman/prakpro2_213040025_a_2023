/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layout1;

/**
 *
 * @author acer
 */

// Aufaa Husniati
// 21040018

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloGridLayout extends JFrame implements ActionListener {
    
    // Membuat button untuk ButtonA-ButtonI
    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;
    private JButton buttonE;
    private JButton buttonF;
    private JButton buttonG;
    private JButton buttonH;
    private JButton buttonI;
    
    // membuat array button untuk menyimpan button yang telah di klik
    private JButton[] buttons;
    private boolean gameOver; // variabel untuk menunjukkan apakah permainan telah selesai atau tidak
    
    public HelloGridLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // perintah untuk menutup JAVAGUI ketika tombol close ditekan
        
        gameOver = false; // inisialisasi nilai false ke dalam variabel gameOver
        
        // inisialisasi semua button ke string kosong
        buttonA = new JButton("");
        buttonB = new JButton("");
        buttonC = new JButton("");
        buttonD = new JButton("");
        buttonE = new JButton("");
        buttonF = new JButton("");
        buttonG = new JButton("");
        buttonH = new JButton("");
        buttonI = new JButton("");
        
        //inisialisasi array dengan ukuran sebesar 9
        buttons = new JButton[9];
        
        // memasukkan semua button yang telah dibuat ke dalam array sesuai dengan indeks
        buttons[0] = buttonA;
        buttons[1] = buttonB;
        buttons[2] = buttonC;
        buttons[3] = buttonD;
        buttons[4] = buttonE;
        buttons[5] = buttonF;
        buttons[6] = buttonG;
        buttons[7] = buttonH;
        buttons[8] = buttonI;
        
        //menambahkan action listener pada buttonA-I
        buttonA.addActionListener(this);
        buttonB.addActionListener(this);
        buttonC.addActionListener(this);
        buttonD.addActionListener(this);
        buttonE.addActionListener(this);
        buttonF.addActionListener(this);
        buttonG.addActionListener(this);
        buttonH.addActionListener(this);
        buttonI.addActionListener(this);
        
        //mengatur layout frame
        this.setLayout(new GridLayout(3, 3));
        
        // memasukkan elemen pada frame 
        this.add(buttonA);
        this.add(buttonB);
        this.add(buttonC);
        this.add(buttonD);
        this.add(buttonE);
        this.add(buttonF);
        this.add(buttonG);
        this.add(buttonH);
        this.add(buttonI);
        
        // mengatur frame yang telah dibuat
        this.setSize(300, 300);
}
    public void actionPerformed(ActionEvent e) {
        if(!gameOver)// pengecekan jika permainan tidak berhenti
        {
            JButton button = (JButton) e.getSource();
            if (button.getText().isEmpty()) //jika button yang ditekan berupa String kosong
            {
                button.setText("0"); //maka set teksnya menjadi 0
                checkWinner(); //menjalankan method checkwinner
                if (!gameOver) // jika permainan tidak berhenti
                {
                    for (int i= 0; i < buttons.length; i++) //iterasi seluruh elemen array button
                    {
                        if (buttons[i].getText().isEmpty()) //jika ditemukan button dengan string kosong
                        {
                            buttons[i].setText("X"); //maka set teksnya menjadi X
                            break;
                        }
                    }
                    checkWinner(); //menjalankan kembali method check winner
                }
            }
        }         
    }
    
    //method checkwinner untuk menentukan pemenang
    private void checkWinner() 
    {
        String winner = ""; //variabel string winner disiapkan dengan nilai awal String kosong
        if (!buttonA.getText().isEmpty() //Jika button A,B dan C memiliki nilai,
            && buttonA.getText().equals(buttonB.getText())
            && buttonA.getText().equals(buttonC.getText()))
        {
            winner = buttonA.getText(); //maka variabel winnerdiberikan nilai teks yang dimiliki buttonA
            // ButtonA, B, C warnanya diatur menjadi merah 
            buttonA.setForeground(Color.RED);
            buttonB.setForeground(Color.RED);
            buttonC.setForeground(Color.RED);
        } else if (!buttonD.getText().isEmpty()
            && buttonD.getText().equals(buttonE.getText())
            && buttonD.getText().equals(buttonF.getText()))
        {
            winner = buttonD.getText();
            buttonD.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonF.setForeground(Color.RED);         
        } else if (!buttonG.getText().isEmpty()
            && buttonG.getText().equals(buttonH.getText())
            && buttonG.getText().equals(buttonI.getText()))
        {
            winner = buttonG.getText();
            buttonG.setForeground(Color.RED);
            buttonH.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        } else if(!buttonA.getText().isEmpty()
            && buttonA.getText().equals(buttonD.getText())
            && buttonA.getText().equals(buttonG.getText()))
        {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonD.setForeground(Color.RED);
            buttonG.setForeground(Color.RED);
        } else if(!buttonB.getText().isEmpty()
            && buttonB.getText().equals(buttonE.getText())
            && buttonB.getText().equals(buttonH.getText()))
        {    
            winner = buttonB.getText();
            buttonB.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonH.setForeground(Color.RED);    
        } else if(!buttonC.getText().isEmpty()
            && buttonC.getText().equals(buttonF.getText())
            && buttonC.getText().equals(buttonI.getText()))
        {
            winner = buttonC.getText();
            buttonC.setForeground(Color.RED);
            buttonF.setForeground(Color.RED);
            buttonI.setForeground(Color.RED); 
        } else if(!buttonA.getText().isEmpty()
            && buttonA.getText().equals(buttonE.getText())
            && buttonA.getText().equals(buttonI.getText()))
        {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        } else if(!buttonC.getText().isEmpty()
            && buttonC.getText().equals(buttonE.getText())
            && buttonC.getText().equals(buttonG.getText()))
        {
            winner = buttonC.getText();
            buttonC.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonG.setForeground(Color.RED);
        }
        // nilai gameOver = variabel winner apakah berisi nilai atau tidak
        gameOver = !winner.isEmpty(); 
    } 
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                HelloGridLayout h = new HelloGridLayout(); //instansiasi objek class
                h.setVisible(true); // menampilkan objek class tsb ke dalam frame
            }
        });
    }
}