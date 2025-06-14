/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uts.oop.c.pkg2301010293;

import java.util.Scanner;


/**
 *
 * @author Odilia
 */
public class UTSOOPC2301010293 {

    static class DataItem {
        private String nama;
        private int nilai;

        public DataItem(String nama, int nilai) {
            this.nama = nama;
            this.nilai = nilai;
        }

        // Overload constructor
        public DataItem(String nama) {
            this.nama = nama;
            this.nilai = 0;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public int getNilai() {
            return nilai;
        }

        public void setNilai(int nilai) {
            this.nilai = nilai;
        }

        @Override
        public String toString() {
            return "Nama: " + nama + ", Nilai: " + nilai;
        }
    }

    static DataItem[] data = new DataItem[100];
    static int jumlahData = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU APLIKASI ===");
            System.out.println("1. Input Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Ubah Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine(); // membersihkan buffer

            switch (pilihan) {
                case 1 -> inputData(sc);
                case 2 -> tampilkanData();
                case 3 -> ubahData(sc);
                case 4 -> hapusData(sc);
                case 5 -> System.out.println("Terima kasih telah menggunakan aplikasi!");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    static void inputData(Scanner sc) {
        System.out.print("Masukkan nama: ");
        String nama = sc.nextLine();
        System.out.print("Masukkan nilai: ");
        int nilai = sc.nextInt();
        data[jumlahData] = new DataItem(nama, nilai);
        jumlahData++;
        System.out.println("Data berhasil ditambahkan.");
    }

    static void tampilkanData() {
        if (jumlahData == 0) {
            System.out.println("Belum ada data.");
            return;
        }
        System.out.println("--- DATA ---");
        for (int i = 0; i < jumlahData; i++) {
            System.out.println((i + 1) + ". " + data[i]);
        }
    }

    static void ubahData(Scanner sc) {
        tampilkanData();
        System.out.print("Pilih nomor data yang ingin diubah: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();
        if (index >= 0 && index < jumlahData) {
            System.out.print("Masukkan nama baru: ");
            String nama = sc.nextLine();
            System.out.print("Masukkan nilai baru: ");
            int nilai = sc.nextInt();
            data[index].setNama(nama);
            data[index].setNilai(nilai);
            System.out.println("Data berhasil diubah.");
        } else {
            System.out.println("Index tidak valid.");
        }
    }

    static void hapusData(Scanner sc) {
        tampilkanData();
        System.out.print("Pilih nomor data yang ingin dihapus: ");
        int index = sc.nextInt() - 1;
        if (index >= 0 && index < jumlahData) {
            for (int i = index; i < jumlahData - 1; i++) {
                data[i] = data[i + 1];
            }
            jumlahData--;
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Index tidak valid.");
        }
    }
}

