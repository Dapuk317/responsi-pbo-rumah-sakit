package RumahSakit;

public class Pasien {
    private final String id;
    private String nama;
    private int keparahan; // 1 sampai 5
    private String status;

    public Pasien(String id, String nama) {
        this(id, nama, 1);
    }

    public Pasien(String id, String nama, int keparahan) {
        this.id = id;
        this.nama = nama;
        this.keparahan = keparahan;
        this.status = "Menunggu";
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

    public int getKeparahan() {
        return keparahan;
    }

    public void setKeparahan(int keparahan) {
        this.keparahan = keparahan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
