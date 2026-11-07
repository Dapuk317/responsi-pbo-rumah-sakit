package RumahSakit;

public class Perawat extends TenagaMedis implements Pemulihan {
    private String shift;

    public Perawat(String id, String nama) {
        this(id, nama, "Pagi");
    }

    public Perawat(String id, String nama, String shift) {
        super(id, nama);
        this.shift = shift;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    @Override
    public String tangani(Pasien pasien) {
        if (getEnergi() < 10) {
            return "Perawat " + getNama() + " kelelahan, butuh pengganti";
        }

        if (pasien.getKeparahan() >= 3) {
            kurangiEnergi(20);
            pasien.setStatus("Dipantau Intensif");
        } else {
            kurangiEnergi(10);
            pasien.setStatus("Perawatan Dasar");
        }
        tambahPasien();
        return "Perawat " + getNama() + " merawat " + pasien.getNama()
                + " (" + pasien.getStatus() + ")";
    }

    @Override
    public String info() {
        return "Perawat " + super.info() + ", shift " + shift;
    }

    @Override
    public void istirahat() {
        setEnergi(getEnergi() + 40);
        System.out.println("Perawat " + getNama() + " istirahat sebentar, energi jadi " + getEnergi());
    }
}
