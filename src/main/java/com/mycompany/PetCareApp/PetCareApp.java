package com.mycompany.PetCareApp;

import java.util.Scanner;

public class PetCareApp {

    // =========================================================
    // METHOD OVERLOADING
    // =========================================================

    // Pencarian berdasarkan nama
    public static void cariHewan(
            String nama,
            Hewan[] daftarHewan,
            int jumlahHewan) {

        System.out.println("\nMencari hewan dengan nama: " + nama);

        boolean ditemukan = false;

        for (int i = 0; i < jumlahHewan; i++) {

            if (daftarHewan[i].getNama().equalsIgnoreCase(nama)) {

                System.out.print("- Ditemukan: ");
                daftarHewan[i].tampilkanInfo();

                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Hewan tidak ditemukan.");
        }
    }

    // Pencarian berdasarkan ID
    public static void cariHewan(
            int idHewan,
            Hewan[] daftarHewan,
            int jumlahHewan) {

        System.out.println("\nMencari hewan dengan ID: " + idHewan);

        boolean ditemukan = false;

        for (int i = 0; i < jumlahHewan; i++) {

            if (daftarHewan[i].getIdHewan() == idHewan) {

                System.out.print("- Ditemukan: ");
                daftarHewan[i].tampilkanInfo();

                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Hewan tidak ditemukan.");
        }
    }

    // =========================================================
    // MAIN PROGRAM
    // =========================================================

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Array bertipe Superclass
        Hewan[] daftarHewan = new Hewan[10];

        int jumlahHewan = 0;

        boolean isRunning = true;

        System.out.println("========================================");
        System.out.println("       PET CARE MANAGEMENT SYSTEM       ");
        System.out.println("========================================");

        // =====================================================
        // MENU UTAMA
        // =====================================================

        while (isRunning) {

            System.out.println("\n========== MENU UTAMA ==========");
            System.out.println("1. Tambah Data Hewan");
            System.out.println("2. Tampilkan Semua Hewan");
            System.out.println("3. Cari Hewan");
            System.out.println("4. Lihat Total Hewan");
            System.out.println("5. Keluar");
            System.out.println("================================");

            System.out.print("Pilih menu (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {

                // =================================================
                // MENU 1 - TAMBAH DATA
                // =================================================

                case 1:

                    if (jumlahHewan < daftarHewan.length) {

                        System.out.println("\n--- Pilih Jenis Hewan ---");
                        System.out.println("1. Anjing");
                        System.out.println("2. Kucing");
                        System.out.print("Pilihan (1/2): ");

                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan ID Hewan: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Nama Hewan: ");
                        String nama = scanner.nextLine();

                        System.out.print("Masukkan Umur Hewan: ");
                        int umur = scanner.nextInt();
                        scanner.nextLine();

                        // -----------------------------------------
                        // Membuat object sesuai pilihan subclass
                        // -----------------------------------------

                        if (jenis == 1) {

                            System.out.print("Masukkan Ras Anjing: ");
                            String ras = scanner.nextLine();

                            daftarHewan[jumlahHewan] =
                                    new Anjing(id, nama, umur, ras);

                            jumlahHewan++;

                            System.out.println(
                                    "Sukses! Data anjing berhasil ditambahkan.");

                        } else if (jenis == 2) {

                            System.out.print("Masukkan Jenis Bulu Kucing: ");
                            String jenisBulu = scanner.nextLine();

                            daftarHewan[jumlahHewan] =
                                    new Kucing(id, nama, umur, jenisBulu);

                            jumlahHewan++;

                            System.out.println(
                                    "Sukses! Data kucing berhasil ditambahkan.");

                        } else {

                            System.out.println(
                                    "Jenis hewan tidak valid.");
                        }

                    } else {

                        System.out.println(
                                "Maaf, kapasitas data hewan sudah penuh.");
                    }

                    break;

                // =================================================
                // MENU 2 - TAMPILKAN SEMUA DATA
                // =================================================

                case 2:

                    System.out.println(
                            "\n------ DAFTAR HEWAN ------");

                    if (jumlahHewan == 0) {

                        System.out.println(
                                "Belum ada data hewan.");

                    } else {

                        for (int i = 0; i < jumlahHewan; i++) {

                            System.out.print((i + 1) + ". ");

                            // Memanggil method overriding
                            daftarHewan[i].tampilkanInfo();
                        }

                        System.out.println(
                                "\nTotal data dalam daftar: "
                                + jumlahHewan);
                    }

                    break;

                // =================================================
                // MENU 3 - PENCARIAN
                // =================================================

                case 3:

                    System.out.println("\n------ CARI HEWAN ------");
                    System.out.println("1. Cari berdasarkan Nama");
                    System.out.println("2. Cari berdasarkan ID");
                    System.out.print("Pilih (1/2): ");

                    int modeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (modeCari == 1) {

                        System.out.print("Masukkan Nama Hewan: ");

                        String kataKunci = scanner.nextLine();

                        // Memanggil overload String
                        cariHewan(
                                kataKunci,
                                daftarHewan,
                                jumlahHewan);

                    } else if (modeCari == 2) {

                        System.out.print("Masukkan ID Hewan: ");

                        int angkaKunci = scanner.nextInt();
                        scanner.nextLine();

                        // Memanggil overload int
                        cariHewan(
                                angkaKunci,
                                daftarHewan,
                                jumlahHewan);

                    } else {

                        System.out.println(
                                "Pilihan pencarian tidak valid.");
                    }

                    break;

                // =================================================
                // MENU 4 - TOTAL HEWAN
                // =================================================

                case 4:

                    System.out.println(
                            "\nTotal object hewan yang dibuat: "
                            + Hewan.totalHewan);

                    break;

                // =================================================
                // MENU 5 - KELUAR
                // =================================================

                case 5:

                    System.out.println(
                            "\nTerima kasih telah menggunakan "
                            + "Pet Care Management System!");

                    isRunning = false;

                    break;

                // =================================================
                // DEFAULT
                // =================================================

                default:

                    System.out.println(
                            "Pilihan tidak valid. "
                            + "Silakan pilih 1-5.");
            }
        }

        scanner.close();
    }
}
