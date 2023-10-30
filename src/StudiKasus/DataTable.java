/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package StudiKasus;


import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;
/**
 *
 * @author acer
 */

// Membuat class DataTable untuk menyimpan data sementara dari input
public class DataTable {
    // Membuat ArrayList dengan nama data yang berisi ArrayList dengan tipe String
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    
    
      public static void saveTableData(JTable table, String filePath) {
        try {
            // Membuat objek BufferedWriter untuk menulis ke file
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath));
            
            // Iterasi baris (i) dan kolom (j) pada JTable
            for (int i = 0; i < table.getRowCount(); i++) {
                for (int j = 0; j < table.getColumnCount(); j++) {
                    // Menulis nilai dari JTable ke dalam file dengan menambahkan tab sebagai pemisah
                    bWriter.write(table.getValueAt(i, j).toString() + "\t");
                }
                // Pindah ke baris baru setelah semua kolom ditulis
                bWriter.newLine();
            }
            
            // Pindah ke baris baru setelah semua kolom ditulis
            bWriter.close();
        } catch (IOException e) {
            // Menangani eksepsi jika terjadi kesalahan saat menulis ke file
            e.printStackTrace(); // Mencetak informasi kesalahan
        }
    }

    // Fungsi untuk menambahkan data ke ArrayList data
    public void setData(ArrayList<String> data) {
        // Menambahkan data ke ArrayList data
        this.data.add(data);
    }

    // Fungsi untuk menghapus data dari ArrayList data
    public void remove(int row) {
        // Menghapus data dari ArrayList data
        this.data.remove(row);
    }

    // Fungsi untuk mendapatkan data dari ArrayList data
    public String getData(int row, int col) {
        // Mengembalikan data dari ArrayList data
        return data.get(row).get(col);
    }

    // Fungsi untuk mendapatkan data dalam 1 baris dari ArrayList data
    public ArrayList<String> getDataRow(int row) {
        // Mengembalikan data dalam 1 baris dari ArrayList data
        return data.get(row);
    }

    // Fungsi untuk mengubah data dalam 1 baris dari ArrayList data
    public void setDataRow(int row, int col, String value) {
        // Mengubah data dalam 1 baris dari ArrayList data
        data.get(row).set(col, value);
    }

    // Fungsi untuk mendapatkan jumlah kolom dari ArrayList data
    public int getSize(int row) {
        // Mengembalikan jumlah kolom dari ArrayList data
        return data.get(row).size();
    }

    // Fungsi untuk mendapatkan jumlah baris dari ArrayList data
    public int getSizeAll() {
        // Mengembalikan jumlah baris dari ArrayList data
        return data.size();
    }
}