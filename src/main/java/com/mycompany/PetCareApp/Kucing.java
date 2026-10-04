package com.mycompany.PetCareApp;

public class Kucing extends Hewan {

    private String jenisBulu;

    public Kucing(int idHewan, String nama, int umur, String jenisBulu) {

        // SUPER
        super(idHewan, nama, umur);

        // THIS
        this.jenisBulu = jenisBulu;
    }

    public String getJenisBulu() {
        return this.jenisBulu;
    }

    public void setJenisBulu(String jenisBulu) {
        this.jenisBulu = jenisBulu;
    }

    // METHOD OVERRIDING
    @Override
    public void tampilkanInfo() {
        System.out.printf(
            "[Kucing] ID: %d | Nama: %-10s | Umur: %d tahun | Jenis Bulu: %s%n",
            getIdHewan(),
            getNama(),
            getUmur(),
            jenisBulu
        );
    }
}