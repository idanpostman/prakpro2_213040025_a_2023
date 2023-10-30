/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package JOptionPaneJScrollPaneJTable;

import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */

// Membuat class LatihanMyTableModel yang mewarisi class AbstractTableModel untuk membuat model tabel
public class LatihanMyTableModel extends AbstractTableModel {
    // Array columnNames untuk menyimpan nama-nama kolom
    private String[] columnNames = {"Nama", "Telepon", "Jenis Kelamin", "WNA"};
    // Membuat ArrayList dengan nama data yang berisi ArrayList dengan tipe String untuk menyimpan data dari input
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    
    // Fungsi untuk menambah jumlah kolom
    public int getColumnCount() {
        // Kembalikan panjang/ukuran dari array columnNames
        return columnNames.length;
    }
    
    // Fungsi untuk menambah jumlah baris
    public int getRowCount() {
        // Kembalikan jumlah data yang diterima/panjang dari ArrayList data
        return data.size();
    }
    
    // Fungsi untuk mendapatkan nama dari kolom yang dipilih dari parameter
    public String getColumnName(int col) {
        // Kembalikan elemen columnNames dengan index col
        return columnNames[col];
    }
    
    // Fungsi untuk mendapatkan nilai dari baris dan kolom tertentu
    public Object getValueAt(int row, int col) {
        // Menyimpan elemen dari ArrayList data dari baris yang dipilih ke List rowItem
        List<String> rowItem = data.get(row);
        // Kembalikan elemen rowItem dari index col
        return rowItem.get(col);
    }
    
    // Fungsi untuk mengatur apakah cell bisa diedit atau tidak
    public boolean isCellEditable(int row, int col) {
        // Kembalikan nilai false
        return false;
    }
    
    // Method untuk menambah nilai ke table
    public void add(ArrayList<String> value) {
        // Menambahkan input user ke ArrayList data
        data.add(value);
        // Menambahkan elemen-elemen ArrayList data ke table
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}