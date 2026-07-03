package pbo1_uas;

// 8: INHERITANCE (Anak Kelas yang mewarisi GasLPG)
public class GasLPG3KgSubsidi extends GasLPG {
    private double harga;
    private double subsidi;

    public GasLPG3KgSubsidi(String idTabung, double harga, double subsidi) {
        // +3: KEYWORD 'super' untuk memicu constructor induk
        super(idTabung, 3.0); 
        this.harga = harga;
        this.subsidi = subsidi;
    }

    public double getHargaNetto() {
        return harga - subsidi;
    }

    // 9: POLYMORPHISM (Method Overriding)
    @Override
    public void tampilkanDetail() {
        System.out.println("Jenis Gas      : LPG 3 KG (Subsidi)");
        System.out.println("ID Tabung      : " + getIdTabung());
        System.out.println("Berat          : " + getBerat() + " Kg");
        System.out.println("Harga HET      : Rp " + harga);
        System.out.println("Subsidi        : Rp " + subsidi);
        System.out.println("Harga Tebus    : Rp " + getHargaNetto());
    }
}