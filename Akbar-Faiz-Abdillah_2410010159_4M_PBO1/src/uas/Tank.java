package uas;

public class Tank {
    // Encapsulation: Atribut diset private
    private String nama;
    private int armorKetebalan; // dalam mm
    private double[] damageArray; // Array untuk menyimpan riwayat damage

    // Constructor
    public Tank(String nama, int armorKetebalan) {
        this.nama = nama;
        this.armorKetebalan = armorKetebalan;
        this.damageArray = new double[3]; // Array sederhana berukuran 3
    }

    // Mutator (Setter)
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Accessor (Getter)
    public String getNama() {
        return this.nama;
    }

    public int getArmorKetebalan() {
        return this.armorKetebalan;
    }

    public double[] getDamageArray() {
        return this.damageArray;
    }

    // Method yang akan di-override (Polymorphism)
    public void infoMekanik() {
        System.out.println("Mekanik Standar: Tank Medium/Ringan dengan mobilitas seimbang.");
    }

    // IO Sederhana & Seleksi: Kalkulasi Penetrasi Amunisi berdasarkan Jarak (Mekanik WT/WoTB)
    public void hitungPenetrasi(double basePenetration, double jarak) {
        double sisaPenetrasi = basePenetration;

        // Seleksi: Penetrasi amunisi berkurang seiring jarak (Khas War Thunder)
        if (jarak > 500 && jarak <= 1000) {
            sisaPenetrasi = basePenetration * 0.85; // Turun 15%
        } else if (jarak > 1000) {
            sisaPenetrasi = basePenetration * 0.70; // Turun 30%
        }

        System.out.println(">> Simulasi Tembakan ke " + nama + " dari jarak " + jarak + "m");
        System.out.println("Ketebalan Armor Target: " + armorKetebalan + "mm");
        System.out.println("Sisa Penetrasi Amunisi: " + sisaPenetrasi + "mm");

        if (sisaPenetrasi > armorKetebalan) {
            System.out.println("Hasil: PENETRASI! Armor musuh tembus.");
        } else {
            System.out.println("Hasil: BOUNCE / NO PENETRATION! Tembakan memantul.");
        }
    }
}