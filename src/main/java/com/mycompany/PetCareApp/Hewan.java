package com.mycompany.PetCareApp;

public class Hewan {

    // ENCAPSULATION
    private int idHewan;
    private String nama;
    private int umur;

    // STATIC
    public static int totalHewan = 0;

    // CONSTRUCTOR + THIS
    public Hewan(int idHewan, String nama, int umur) {
        this.idHewan = idHewan;
        this.nama = nama;
        setUmur(umur);

        totalHewan++;
    }

    // GETTER
    public int getIdHewan() {
        return this.idHewan;
    }

    public String getNama() {
        return this.nama;
    }

    public int getUmur() {
        return this.umur;
    }

    // SETTER
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(int umur) {
        if (umur >= 0) {
            this.umur = umur;
        } else {
            System.out.println("Umur tidak boleh negatif!");
        }
    }

    // METHOD YANG NANTI DI-OVERRIDE
    public void tampilkanInfo() {
        System.out.printf(
            "ID: %d | Nama: %-10s | Umur: %d tahun%n",
            idHewan, nama, umur
        );
    }
}