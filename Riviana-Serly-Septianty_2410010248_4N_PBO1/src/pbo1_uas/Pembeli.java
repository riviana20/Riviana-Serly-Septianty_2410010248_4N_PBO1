package pbo1_uas;

// 1, 3, & 7: CLASS, ATRIBUT, & ENCAPSULATION
public class Pembeli {
    private String nik;
    private String nama;
    private boolean layakSubsidi;

    public Pembeli(String nik, String nama, boolean layakSubsidi) {
        this.nik = nik;
        this.nama = nama;
        this.layakSubsidi = layakSubsidi;
    }

    public String getNik() { return nik; }
    public String getNama() { return nama; }
    public boolean isLayakSubsidi() { return layakSubsidi; }
}