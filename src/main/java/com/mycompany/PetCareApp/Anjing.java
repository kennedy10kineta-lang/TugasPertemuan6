package com.mycompany.PetCareApp;

public class Anjing extends Hewan {

    private String ras;

    public Anjing(int idHewan, String nama, int umur, String ras) {

        // SUPER
        super(idHewan, nama, umur);

        // THIS
        this.ras = ras;
    }

    public String getRas() {
        return this.ras;
    }

    public void setRas(String ras) {
        this.ras = ras;
    }

    // METHOD OVERRIDING
    @Override
    public void tampilkanInfo() {
        System.out.printf(
            "[Anjing] ID: %d | Nama: %-10s | Umur: %d tahun | Ras: %s%n",
            getIdHewan(),
            getNama(),
            getUmur(),
            ras
        );
    }
}
