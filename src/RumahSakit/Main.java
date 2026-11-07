package RumahSakit;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== 1. State dan Behavior ===");
        Dokter andi = new Dokter("D01", "Andi");
        System.out.println("Energi awal : " + andi.getEnergi());
        andi.kurangiEnergi(10);                       // method void
        System.out.println("Energi sekarang : " + andi.getEnergi());
        System.out.println("Cukup energi 50? " + andi.cukupEnergi(50)); // method return

        System.out.println("\n=== 2. Immutability ===");
        System.out.println("Konstanta NAMA_RS : " + TenagaMedis.NAMA_RS);
        System.out.println("Konstanta ENERGI_MAKS : " + TenagaMedis.ENERGI_MAKS);
        System.out.println("ID dokter (private final) : " + andi.getId());

        System.out.println("\n=== 3. Enkapsulasi dan Overloading ===");
        Dokter sari = new Dokter("D02", "Sari", 300000);   // konstruktor 2
        Perawat rina = new Perawat("P01", "Rina");         // konstruktor 1
        Perawat dewi = new Perawat("P02", "Dewi", "Malam"); // konstruktor 2
        System.out.println(andi.info());
        System.out.println(sari.info());
        andi.setNama("Andi Pratama");
        System.out.println("Setelah setNama : " + andi.getNama());

        System.out.println("\n=== 4. Inheritance ===");
        TenagaMedis[] semua = {andi, sari, rina, dewi};
        for (TenagaMedis t : semua) {
            System.out.println(t.info());
        }

        System.out.println("\n=== 5. Super Chaining ===");
        System.out.println("Konstruktor Dokter/Perawat memanggil super(id, nama)");
        System.out.println("info() subclass memanggil super.info():");
        System.out.println(dewi.info());

        System.out.println("\n=== 6. Method Overriding ===");
        Pasien uji = new Pasien("X01", "Uji", 4);
        System.out.println(new Dokter("D90", "Uji").tangani(uji));
        System.out.println(new Perawat("P90", "Uji").tangani(uji));

        System.out.println("\n=== 7 dan 8. Abstract Method dan Logika State ===");
        Pasien budi = new Pasien("PS1", "Budi", 2);
        Pasien citra = new Pasien("PS2", "Citra", 5);
        Pasien eko = new Pasien("PS3", "Eko");   // keparahan default 1
        System.out.println(andi.tangani(budi) + " | energi " + andi.getEnergi());
        System.out.println(andi.tangani(citra) + " | energi " + andi.getEnergi());
        System.out.println(andi.tangani(eko) + " | energi " + andi.getEnergi());
        System.out.println(andi.tangani(budi) + " | energi " + andi.getEnergi());

        System.out.println("\n=== 9. Polimorfisme Interface ===");
        Berbayar b1 = new Dokter("D03", "Fajar", 200000);
        Berbayar b2 = sari;
        System.out.println("Biaya b1 : Rp" + (long) b1.hitungBiaya());
        System.out.println("Biaya b2 : Rp" + (long) b2.hitungBiaya());
        Pemulihan p1 = rina;
        p1.istirahat();

        System.out.println("\n=== 10. Multiple Interface ===");
        System.out.println("Dokter implements Berbayar dan Pemulihan");
        Pemulihan p2 = andi;
        p2.istirahat();
        System.out.println("andi instanceof Berbayar : " + (andi instanceof Berbayar));
        System.out.println("andi instanceof Pemulihan : " + (andi instanceof Pemulihan));
        andi.setJumlahPasien(5);
        System.out.println("Biaya dokter setelah 5 pasien (lembur) : Rp" + (long) andi.hitungBiaya());
    }
}
