/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudiKasus;


import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.*;

/**
 *
 * @author acer
 */

// class StudiKasus mewarisi JFrame
public class aplBiodata extends JFrame {

    // Instansiasi DataTable dengan nama dt
    /*
     * dt ini sebagai data temporary, digunakan untuk menyimpan file  yang
     * belum disimpan ke data yang ada di ModelTable. 
     */
    private DataTable dt = new DataTable();

    public aplBiodata() {
        // Method untuk mencegah frame ketika tombol X ditekan
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Instansiasi JLabel dengan nama labelNama yang diberikan nilai "Form Biodata:"
        JLabel labelHeader = new JLabel("Form Biodata", JLabel.CENTER);
        labelHeader.setBounds(0, 20, 350, 10);

        // Instansiasi JLabel dengan nama labelNama yang diberikan nilai "Nama:"
        JLabel labelNama = new JLabel("Nama: ");
        labelNama.setBounds(15, 40, 350, 10);

        // Instansiasi JTextField dengan nama textFieldNama
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        // Instansiasi JLabel dengan nama labelTelepon yang diberikan nilai "Nomor Telepon:"
        JLabel labelHP = new JLabel("Nomor HP: ");
        labelHP.setBounds(15, 100, 350, 10);

        // Instansiasi JTextField dengan nama textFieldTelepon
        JTextField textFieldHP = new JTextField();
        textFieldHP.setBounds(15, 120, 350, 30);

        // Instansiasi JLabel dengan nama labelInput yang diberikan nilai "Jenis Kelamin:"
        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        labelRadio.setBounds(15, 160, 350, 10);

        // Instansiasi JRadioButton dengan nama radioButton1 dengan pesan "Laki-Laki"
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(15, 180, 350, 30);

        // Instansiasi JRadioButton dengan nama radioButton1 dengan pesan "Perempuan"
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15, 210, 350, 30);

        // Instansiasi ButtonGroup dengan nama bg
        ButtonGroup bg = new ButtonGroup();
        // Masukan radioButton1 ke objek bg
        bg.add(radioButton1);
        // Masukan radioButton2 ke objek bg
        bg.add(radioButton2);
        
        
        // Instansiasi JLabel dengan nama labelAlamat yang diberikan nilai "Alamat: "
        JLabel labelAlamat = new JLabel("Alamat: ");
        labelAlamat.setBounds(15, 240, 350, 30);

        // Instansiasi JCheckBox dengan nama checkBox dengan pesan "Warga Asing"
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 270, 350, 100);

        // Instansiasi JButton dengan nama button yang diberikan nilai "Simpan"
        JButton button = new JButton("Simpan");
        button.setBounds(15, 380, 100, 40);

        // Instansiasi JButton dengan nama button yang diberikan nilai "Edit"
        JButton buttonUbah = new JButton("Edit");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        buttonUbah.setBounds(125, 380, 100, 40);

        // Instansiasi JButton dengan nama button yang diberikan nilai "Hapus"
        JButton buttonHapus = new JButton("Hapus");
        buttonHapus.setBounds(235, 380, 100, 40);

        // Instansiasi JButton dengan nama button yang diberikan nilai "Simpan ke File"
        JButton buttonFile = new JButton("Simpan Ke File");
        buttonFile.setBounds(345, 380, 150, 40);

        // Instansiasi JTable dengan nama table
        JTable table = new JTable();
        // Instansiasi JScrollPane dengan nama scrollableTable yang diberikan ke objek table
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15,
                440,
                500,
                200);

        // Instansiasi ModelTable dengan nama tableModel
        BiodataTableModel tableModel = new BiodataTableModel();
        // Atur model dari table dengan objek tableModel
        table.setModel(tableModel);

        // Menambahkan action listener ke button
        button.addActionListener(new ActionListener() {
            // Method untuk menerima event
            public void actionPerformed(ActionEvent e) {
                // Variable jenisKelamin untuk menyimpan nilai radio button yang diklik (jenis kelamin)
                String jenisKelamin = "";

                // Jika radioButton1 diklik
                if (radioButton1.isSelected()) {
                    // Maka jenisKelamin akan bernilai Laki-Laki
                    jenisKelamin = radioButton1.getText();
                    // Kembalikan radio button ke kondisi semula
                    radioButton1.setSelected(false);
                }
                // Jika radioButton2 diklik
                if (radioButton2.isSelected()) {
                    // Maka jenisKelamin akan bernilai Perempuan
                    jenisKelamin = radioButton2.getText();
                    // Kembalikan radio button ke kondisi semula
                    radioButton2.setSelected(false);
                }

                // Variable nama untuk menyimpan nilai dari objek textFieldNama (nama)
                String nama = textFieldNama.getText();
                // Variable telepon untuk menyimpan nilai dari objek textFieldTelepon (telepon)
                String telepon = textFieldHP.getText();
                // Variable alamat untuk menyimpan nilai dari objek txtOutput (alamat)
                String alamat = txtOutput.getText();

                // Jika nama, telepon dan alamat bernilai kosong
                if (nama.equalsIgnoreCase("") && telepon.equalsIgnoreCase("") && alamat.equalsIgnoreCase("")) {
                    // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                    JOptionPane.showMessageDialog(aplBiodata.this, "Nama, telepon dan alamat belum terisi", "Perhatian",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    // Jika nama bernilai kosong
                    if (nama.equalsIgnoreCase("")) {
                        // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                         
                        JOptionPane.showMessageDialog(aplBiodata.this, "Nama belum terisi", "Perhatian",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    // Jika telepon bernilai kosong
                    if (telepon.equalsIgnoreCase("")) {
                        // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                        JOptionPane.showMessageDialog(aplBiodata.this, "Telepon belum terisi", "Perhatian",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    // Jika alamat bernilai kosong
                    if (alamat.equalsIgnoreCase("")) {
                        // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                        JOptionPane.showMessageDialog(aplBiodata.this, "Alamat belum terisi", "Perhatian",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }

                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
                int confirmation = JOptionPane.showConfirmDialog(aplBiodata.this,
                        "Apakah anda yakin ingin menyimpan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                // Jika confirmation berinilai opsi yes
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Tambahkan variable nama, telepon, jenisKelamin, dan wna ke objek ArrayList dan dikirim lagi ke objek tableModel dan dt melalui method add
                    tableModel.add(new ArrayList<>(Arrays.asList(nama, telepon, jenisKelamin, alamat)));
                    dt.setData(new ArrayList<>(Arrays.asList(nama, telepon, jenisKelamin, alamat)));
                    // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                    JOptionPane.showMessageDialog(aplBiodata.this, "Data tersimpan", "Perhatian",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                // Jika confirmation nilai opsi no
                else {
                    // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                    JOptionPane.showMessageDialog(aplBiodata.this, "Data tidak tersimpan", "Perhatian",
                            JOptionPane.ERROR_MESSAGE);
                }
                // Kembalikan isi textFieldNama ke kondisi kosong
                textFieldNama.setText("");
                // Kembalikan isi textFieldTelepon ke kondisi kosong
                textFieldHP.setText("");
                // Kembalikan isi textare ke kondisi kosong
                txtOutput.setText("");
            }
        });

        // Menambahkan action listener ke button ubah
        buttonUbah.addActionListener(new ActionListener() {
            // Method untuk menerima event
            public void actionPerformed(ActionEvent e) {
                // Jika table sedang diedit dan user mengklik button ubah
                if (table.isEditing()) {
                    // Hentikan editing pada table
                    table.getCellEditor().stopCellEditing();
                }

                // Variable row untuk menyimpan nilai baris yang dipilih
                int row = table.getSelectedRow();
                // Variable column untuk menyimpan nilai kolom yang dipilih
                int column = table.getSelectedColumn();
                // Variable newValue untuk menyimpan nilai dari table yang diedit
                String newValue = (String) table.getModel().getValueAt(row, column);

                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
                int confirmation = JOptionPane.showConfirmDialog(aplBiodata.this,
                        "Apakah anda yakin ingin mengubah data?",
                        "Form Biodata",
                        JOptionPane.YES_NO_OPTION);

                // Jika confirmation bernilai opsi yes
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Ubah nilai dari tableModel dan dt dengan nilai newValue pada baris dan kolom yang dipilih
                    tableModel.setValueAt(newValue, row, column);
                    dt.setDataRow(row, column, newValue);
                    // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada  parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                    JOptionPane.showMessageDialog(aplBiodata.this, "Data berhasil diubah", "Perhatian",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Jika batal diubah, kembalikan nilai dari tableModel dan dt ke kondisi semula
                    for (int i = 0; i < dt.getSize(row); i++) {
                        tableModel.setValueAt(dt.getData(row, i),
                                row,
                                i);
                    }
                }
            }
        });

        // Menambahkan action listener ke button hapus
        buttonHapus.addActionListener(new ActionListener() {
            // Method untuk menerima event
            public void actionPerformed(ActionEvent e) {
                // Variable row untuk menyimpan nilai baris yang dipilih
                int row = table.getSelectedRow();
                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
                int confirmation = JOptionPane.showConfirmDialog(aplBiodata.this,
                        "Apakah anda yakin ingin menghapus data?",
                        "Form Biodata",
                        JOptionPane.YES_NO_OPTION);

                // Jika confirmation bernilai opsi yes
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Hapus baris yang dipilih dari tableModel dan dt
                    tableModel.remove(row);
                    dt.remove(row);

                    // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                    JOptionPane.showMessageDialog(aplBiodata.this, "Data berhasil dihapus", "Perhatian",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

       buttonFile.addActionListener(new ActionListener() { // Mengatur aksi yang akan dijalankan saat tombol ditekan
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(); // Membuat objek JFileChooser untuk memilih lokasi penyimpanan file
                fileChooser.setDialogTitle("Tentukan directory file yang akan disimpan"); // Mengatur judul dialog (pesan) pemilihan file
                
                // Menampilkan dialog pemilihan lokasi penyimpanan file dan menyimpan responsnya dalam variabel userSelection
                int userSelection = fileChooser.showSaveDialog(aplBiodata.this);
                
                // Jika userSelection menunjukkan bahwa lokasi file telah dipilih untuk disimpan
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath(); // Mendapatkan alamat (path) lengkap file yang telah dipilih
                    // Memanggil method saveTableData dari kelas TableDataSaver untuk menyimpan data tabel ke dalam file dengan ekstensi .txt
                    DataTable.saveTableData(table, filePath + ".txt"); 
                    // Menampilkan pesan bahwa data berhasil disimpan ke dalam file
                    JOptionPane.showMessageDialog(aplBiodata.this, "Data berhasil disimpan ke file", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Menambahkan window listener ke frame
        this.addWindowListener(new WindowAdapter() {
            // Override method windowClosing dari WindowAdapter
            public void windowClosing(WindowEvent e) {
                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
                int confirmation = JOptionPane.showConfirmDialog(aplBiodata.this,
                        "Apakah anda yakin ingin keluar aplikasi?\nSemua data yang belum disimpan, tidak akan tersimpan.",
                        "Form Biodata",
                        JOptionPane.YES_NO_OPTION);

                // Jika confirmation bernilai opsi yes
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Dapatkan data dari baris tableModel
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        // Dapatkan data dari kolom tableModel
                        for (int j = 0; j < tableModel.getColCount(i); j++) {
                            // Tulis data dari tableModel dari dt
                            tableModel.setValueAt(dt.getData(i, j),
                                    i,
                                    j);
                        }
                    }
                    // Keluar dari aplikasi
                    System.exit(0);
                } else {
                    // Jika batal keluar, kembalikan frame ke kondisi semula
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

        // Menambahkan objek labelHeader ke frame
        this.add(labelHeader);
        // Menambahkan objek labelNama ke frame
        this.add(labelNama);
        // Menambahkan objek textFieldNama ke frame
        this.add(textFieldNama);
        // Menambahkan objek labelTelepon ke frame
        this.add(labelHP);
        // Menambahkan objek textFieldTelepon ke frame
        this.add(textFieldHP);
        // Menambahkan objek labelRadio ke frame
        this.add(labelRadio);
        // Menambahkan objek radioButton1 ke frame
        this.add(radioButton1);
        // Menambahkan objek radioButton2 ke frame
        this.add(radioButton2);
        // Menambahkan objek checkBox ke frame
        this.add(labelAlamat);
        // Menambahkan objek txtOutput ke frame
        this.add(txtOutput);
        // Menambahkan objek button ke frame
        this.add(button);
        // Menambahkan objek buttonUbah ke frame
        this.add(buttonUbah);
        // Menambahkan objek buttonHapus ke frame
        this.add(buttonHapus);
        // Menambahkan objek buttonFile ke frame
        this.add(buttonFile);
        // Menambahkan objek scrollableTable ke frame
        this.add(scrollableTable);

        // Atur ukuran frame menjadi 400 x 600
        this.setSize(550, 1000);
        // Atur layout frame menjadi null
        this.setLayout(null);
    }

    // Main program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            // Override method run dari Runnable
            public void run() {
                // Instansiasi aplBiodata dengan nama A
                aplBiodata A = new aplBiodata();
                // Tampilkan objek A dengan method setVisible dan parameternya true
                A.setVisible(true);
            }
        });
    }
}