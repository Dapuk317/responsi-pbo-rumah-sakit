package RumahSakit;

public abstract class TenagaMedis {
    public static final String NAMA_RS = "RS Unsoed Sehat";
    public static final int ENERGI_MAKS = 100;

    private final String id;
    private String nama;
    private int energi;
    private int jumlahPasien;

    public TenagaMedis(String id, String nama) {
        this(id, nama, ENERGI_MAKS);
    }

    public TenagaMedis(String id, String nama, int energi) {
        this.id = id;
        this.nama = nama;
        this.energi = energi;
        this.jumlahPasien = 0;
    }

    // wajib dibuat di subclass
    public abstract String tangani(Pasien pasien);

    public String info() {
        return id + " - " + nama + " (energi " + energi + ", pasien " + jumlahPasien + ")";
    }

    public boolean cukupEnergi(int butuh) {
        return energi >= butuh;
    }

    public void kurangiEnergi(int jumlah) {
        energi = energi - jumlah;
        if (energi < 0) {
            energi = 0;
        }
    }

    public void tambahPasien() {
        jumlahPasien++;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getEnergi() {
        return energi;
    }

    public void setEnergi(int energi) {
        if (energi > ENERGI_MAKS) {
            this.energi = ENERGI_MAKS;
        } else if (energi < 0) {
            this.energi = 0;
        } else {
            this.energi = energi;
        }
    }

    public int getJumlahPasien() {
        return jumlahPasien;
    }

    public void setJumlahPasien(int jumlahPasien) {
        this.jumlahPasien = jumlahPasien;
    }
}
