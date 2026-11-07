package RumahSakit;

public class Dokter extends TenagaMedis implements Berbayar, Pemulihan {
    private double tarif;

    public Dokter(String id, String nama) {
        this(id, nama, 150000);
    }

    public Dokter(String id, String nama, double tarif) {
        super(id, nama);
        this.tarif = tarif;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    @Override
    public String tangani(Pasien pasien) {
        if (getEnergi() < 15) {
            return "dr. " + getNama() + " kelelahan, harus istirahat dulu";
        }

        if (pasien.getKeparahan() >= 4) {
            if (getEnergi() >= 30) {
                kurangiEnergi(30);
                pasien.setStatus("Rawat Inap");
                tambahPasien();
                return "dr. " + getNama() + " merawat inap " + pasien.getNama();
            } else {
                pasien.setStatus("Dirujuk");
                return "dr. " + getNama() + " merujuk " + pasien.getNama();
            }
        } else {
            kurangiEnergi(15);
            pasien.setStatus("Rawat Jalan");
            tambahPasien();
            return "dr. " + getNama() + " memeriksa " + pasien.getNama() + " (rawat jalan)";
        }
    }

    @Override
    public String info() {
        return "Dokter  " + super.info() + ", tarif Rp" + (long) tarif;
    }

    @Override
    public double hitungBiaya() {
        if (getJumlahPasien() > 3) {
            return tarif * 1.2; // lembur
        }
        return tarif;
    }

    @Override
    public void istirahat() {
        setEnergi(ENERGI_MAKS);
        System.out.println("dr. " + getNama() + " istirahat, energi penuh lagi");
    }
}
