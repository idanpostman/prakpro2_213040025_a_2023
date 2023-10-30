/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudiKasus;

import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */

// Membuat class ModelTable yang mewarisi class AbstractTableModel untuk membuat tablemodel
public class BiodataTableModel extends AbstractTableModel {
    // Array columnNames untuk menyimpan nama-nama kolom
    private String[] columnNames = { "Nama", "Nomor HP", "Jenis Kelamin", "Alamat" };
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

    // Fungsi untuk menambah jumlah kolom
    public int getColumnCount() {
        return columnNames.length;
    }

    // Fungsi untuk menambah jumlah baris
    public int getRowCount() {
        return data.size();
    }

    public int getColCount(int col) {
        return data.get(col).size();
    }

    // Fungsi untuk mendapatkan nama dari kolom yang dipilih dari parameter
    public String getColumnName(int col) {
        return columnNames[col];
    }

    // Fungsi untuk mendapatkan nilai dari baris dan kolom tertentu
    public Object getValueAt(int row, int col) {
        // Menyimpan elemen dari ArrayList data dari baris yang dipilih ke List rowItem
        List<String> rowItem = data.get(row);
        return rowItem.get(col);
    }

    // Fungsi untuk mengatur apakah cell bisa diedit atau tidak
    public boolean isCellEditable(int row, int col) {
        return row >= 0 && col >= 0;
    }

    // Fungsi untuk mengubah nilai dari baris dan kolom tertentu
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Menyimpan elemen dari ArrayList data dari baris yang dipilih ke List rowItem
        List<String> rowItem = data.get(rowIndex);
        // Mengubah nilai dari elemen rowItem dengan index columnIndex dengan nilai
        // aValue
        rowItem.set(columnIndex, (String) aValue);
        // Memanggil fungsi fireTableCellUpdated untuk mengubah nilai dari baris dan
        // kolom
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    // Fungsi untuk menghapus nilai dari baris tertentu
    public void remove(int row) {
        // Menghapus elemen dari ArrayList data dengan index row
        data.remove(row);
        // Memanggil fungsi fireTableRowsDeleted untuk menghapus nilai dari baris dan
        // kolom
        fireTableRowsDeleted(row, row);
    }

    // Fungsi untuk mengatasi error saat menghapus baris
    void removeRow(int selectedRow) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Method untuk menambah nilai ke table
    public void add(ArrayList<String> value) {
        // Menambahkan input user ke ArrayList data
        data.add(value);
        // Menambahkan elemen-elemen ArrayList data ke table
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}