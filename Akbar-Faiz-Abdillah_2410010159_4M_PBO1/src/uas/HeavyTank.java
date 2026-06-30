package uas;

// Inheritance: HeavyTank mewarisi Tank
public class HeavyTank extends Tank {
    private int bonusArmorAngling;

    public HeavyTank(String nama, int armorKetebalan, int bonusArmorAngling) {
        super(nama, armorKetebalan); // Memanggil constructor induk
        this.bonusArmorAngling = bonusArmorAngling;
    }

    // Polymorphism (Overriding method infoMekanik)
    @Override
    public void infoMekanik() {
        System.out.println("Mekanik Heavy Tank: Memiliki ketebalan efektif tambahan saat melakukan Angling sebesar " + bonusArmorAngling + "mm.");
    }
    
    // Overloading / Custom perhitungan khusus Heavy Tank
    public int getTotalArmorEfektif() {
        return super.getArmorKetebalan() + bonusArmorAngling;
    }
}