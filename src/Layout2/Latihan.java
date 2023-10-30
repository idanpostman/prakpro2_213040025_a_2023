/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Layout2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author acer
 * 
 * 
 * WILDAN FAUZAN
 * 213040025
 */
public class Latihan extends JFrame {
    // variabel untuk menampung apakah checkbox telah diklik
    private boolean checkBoxSelected;

    public Latihan() {
        this.checkBoxSelected = false;
        // memberikan perintah bahwa ketika tombol window X ditekan, maka JavaGUI akan diclose
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        // mengatur ukuran panel 
        panel.setSize(300, 300);
        
        JPanel panel2 = new JPanel();
        panel2.setSize(100, 100);

        // instansiasi GridBagLayout
        GridBagLayout layout = new GridBagLayout();
        // Mengatur layout panel dengan objek GridBagLayout
        panel.setLayout(layout);
        // instansiasi GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();

        // membuat label untuk judul 
        JLabel headerLabel = new JLabel("Form Biodata", JLabel.CENTER);

        // membuat label untuk input nama
        JLabel labelNama = new JLabel("Nama: ");

        // membuat textfield untuk input nama
        JTextField textFieldNama = new JTextField();

        // membuat label untuk input telepon
        JLabel labelTelepon = new JLabel("Nomor HP: ");

        // membuat textfield untuk input nama
        JTextField textFieldTelepon = new JTextField();

        // membuat label untuk input radio button
        JLabel labelRadio = new JLabel("Jenis Kelamin:");

        // membuat radio button dengan nilai laki-laki dan true
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);

        // membuat radio button dengan nilai perempuan
        JRadioButton radioButton2 = new JRadioButton("Perempuan");

        // instansiasi ButtonGroup dengan nama bg
        ButtonGroup bg = new ButtonGroup();
        // memasukan semua radio button ke bg
        bg.add(radioButton1);
        bg.add(radioButton2);

        // membuat checkbox untuk verifikasi WNA
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");

        // membuat button untuk simpan data
        JButton button = new JButton("Simpan");

        // membuat textarea untuk output data
        JTextArea textArea = new JTextArea("");
        // mengatur ukuran dan letak textarea
        textArea.setBounds(15, 350, 350, 100);

        // Mengatur ukuran objek GridBagConstraints menjadi memenuhi panjang horizontal
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // mengatur letak objek GridBagConstraints
        gbc.gridx = 0;
        // mengatur letak objek GridBagConstraints 
        gbc.gridy = 0;

        panel.add(labelNama, gbc);

        // mengatur letak objek GridBagConstraints 
        gbc.gridx = 0;
        // mengatur letak objek GridBagConstraints 
        gbc.gridy = 1;
        
        panel.add(textFieldNama, gbc);

        // mengatur letak objek GridBagConstraints 
        gbc.gridx = 0;
        // mengatur letak objek GridBagConstraints ke 
        gbc.gridy = 2;
       
        panel.add(labelTelepon, gbc);

        // mengatur letak objek GridBagConstraints 
        gbc.gridx = 0;
        // mengatur letak objek GridBagConstraints ke posisi y = 0
        gbc.gridy = 3;
       
        panel.add(textFieldTelepon, gbc);

        // mengatur ukuran objek GridBagConstraints menjadi memenuhi panjang horizontal
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // mengatur letak objek GridBagConstraints 
        gbc.gridx = 1;
        // mengatur letak objek GridBagConstraints 
        gbc.gridy = 0;

        panel.add(labelRadio, gbc);

        // mengatur letak objek GridBagConstraints 
        gbc.gridx = 1;
        // megnatur letak objek GridBagConstraints 
        gbc.gridy = 1;
        
        panel.add(radioButton1, gbc);

        // mengatur letak objek GridBagConstraints 
        gbc.gridx = 1;
        // mengatur letak objek GridBagConstraints 
        gbc.gridy = 2;
       
        panel.add(radioButton2, gbc);

        // mengatur letak objek GridBagConstraints 
        gbc.gridx = 1;
        // megnatur letak objek GridBagConstraints 
        gbc.gridy = 3;
     
        panel.add(checkBox, gbc);

        // mengatur ukuran objek GridBagConstraints menjadi memenuhi panjang vertical
        gbc.fill = GridBagConstraints.VERTICAL;
        // mengatur letak objek GridBagConstraints 
        gbc.gridx = 1;
        // mengatur letak objek GridBagConstraints 
        gbc.gridy = 4;
      
        panel2.add(button);

        // memberikan action listener kepada checkbox
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == 1;
            }
        });

        // memberikan action listener kepada button simpan
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // membuat variabel jenisKelamin untuk menampung nilai dari radio button 
                String jenisKelamin = "";

                // jika Laki-Laki diklik,
                if (radioButton1.isSelected()) {
                    // maka jenisKelamin akan bernilai Laki-Laki
                    jenisKelamin = radioButton1.getText();
                    // kembalikan radio button ke kondisi semula
                    radioButton1.setSelected(false);
                }
                // jika Perempuan diklik,
                if (radioButton2.isSelected()) {
                    // maka jenisKelamin akan bernilai Perempuan
                    jenisKelamin = radioButton2.getText();
                    // kembalikan radio button ke kondisi semula
                    radioButton2.setSelected(false);
                }

                // isi dari textfield (input user) disimpan ke variable nama
                String nama = textFieldNama.getText();
                // variable nama dimasukan kedalam textarea
                textArea.append("Nama\t: " + nama + "\n");
                // isi dari textfield (input user) disimpan ke variable nama
                String telepon = textFieldTelepon.getText();
                // variable telepon dimasukan kedalam textarea
                textArea.append("Nomor HP\t: " + telepon + "\n");
                // variable jenisKelamin dimasukan kedalam textarea
                textArea.append("Jenis Kelamin\t: " + jenisKelamin + "\n");

                // jika checkBoxSelected bernilai true,
                if (checkBoxSelected) {
                    // string WNA: Ya dimasukan ke textarea
                    textArea.append("WNA\t: " + "Ya\n");
                }
                // jika checkBoxSelected bernilai false,
                else {
                    // string WNA: Bukan dimasukan ke textarea
                    textArea.append("WNA\t: " + "Bukan\n");
                }
                // garis pembatas
                textArea.append("==================================\n");
                // kembalikan textfield nama dan telepon ke kondisi awal
                textFieldNama.setText("");
                textFieldTelepon.setText("");
                // kembalikan checkbox ke kondisi awal
                checkBox.setSelected(false);
            }
        });

        // masukan panel dan panel2 ke controlPanel
        controlPanel.add(panel);
        controlPanel.add(panel2);

        // mengatur layout frame menjadi GridLayou
        this.setLayout(new GridLayout(4, 1));
        // meamsukan semua komponen 
        this.add(headerLabel);
        this.add(controlPanel);
        this.add(panel2);
        this.add(textArea);
        // membuat frame 
        this.setSize(500, 500);
    }

   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // instansiasi 
                Latihan l = new Latihan();
                // objek tersebut ditampilkan ke frame
                l.setVisible(true);
            }
        });
    }
}