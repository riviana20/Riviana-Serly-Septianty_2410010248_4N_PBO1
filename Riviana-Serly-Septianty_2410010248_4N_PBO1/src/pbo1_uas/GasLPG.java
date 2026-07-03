package pbo1_uas;

// +1: ABSTRACT CLASS (Konsep OOP Lanjut)
// 1 & 7: CLASS & ENCAPSULATION
public abstract class GasLPG {
    private String idTabung;
    private double berat; 

    // 4: CONSTRUCTOR
    public GasLPG(String idTabung, double berat) {
        this.idTabung = idTabung;
        this.berat = berat;
    }

    // 6: ACCESSOR / GETTER
    public String getIdTabung() {
        return idTabung;
    }

    // 5: MUTATOR / SETTER
    public void setIdTabung(String idTabung) {
        this.idTabung = idTabung;
    }

    public double getBerat() {
        return berat;
    }

    // +2: ABSTRACT METHOD
    public abstract void tampilkanDetail();
}