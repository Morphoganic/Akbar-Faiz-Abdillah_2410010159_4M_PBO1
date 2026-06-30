package uas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Object: Instansiasi objek tank musuh
        HeavyTank musuh = new HeavyTank("Tiger I", 100, 25);
        
        System.out.println("=== SIMULATOR MEKANIK WAR THUNDER / WoTB ===");
        System.out.println("Target Terdeteksi: " + musuh.getNama());
        musuh.infoMekanik();
        System.out.println("Total Armor Efektif Target: " + musuh.getTotalArmorEfektif() + "mm");
        System.out.println("==================================================\n");

        // IO Sederhana: Menggunakan Scanner standar agar menunggu input user di konsol
        Scanner input = new Scanner(System.in);
        
        // Error Handling & Array
        try {
            double[] riwayatTembakan = musuh.getDamageArray();
            
            // Perulangan: Input data tembakan sebanyak kapasitas Array (3 kali)
            for (int i = 0; i < riwayatTembakan.length; i++) {
                System.out.println("--- TEMBAKAN KE-" + (i + 1) + " ---");
                System.out.print("Masukkan Jarak Tembakan (meter): ");
                double jarak = input.nextDouble();
                
                System.out.print("Masukkan Base Penetrasi Amunisi (mm): ");
                double basePen = input.nextDouble();
                
                // Menjalankan mekanik seleksi penetrasi
                musuh.hitungPenetrasi(basePen, jarak);
                System.out.println("----------------------------------------\n");
            }
            
            // Selesai perulangan, baru kita picu Error Handling secara sengaja untuk pembuktian nilai UAS
            System.out.println("Mencoba mengakses log data sistem di luar jangkauan array...");
            // Mengakses indeks ke-5 padahal ukuran array hanya 3 (indeks 0, 1, 2)
            double dataError = riwayatTembakan[5]; 
            
        } catch (ArrayIndexOutOfBoundsException e) {
            // Menangkap error array melebihi batas
            System.out.println("\n[ERROR HANDLED] Terjadi kesalahan log: Indeks array tidak ditemukan! (" + e.getMessage() + ")");
        } catch (Exception e) {
            System.out.println("\n[ERROR HANDLED] Input validasi error (Pastikan memasukkan angka!).");
        } finally {
            System.out.println("\n=== Simulasi Selesai, Garasi Ditutup ===");
            input.close();
        }
    }
}