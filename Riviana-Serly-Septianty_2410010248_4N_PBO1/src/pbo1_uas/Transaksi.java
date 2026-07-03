package pbo1_uas;

// 1, 3, & 7: CLASS, ATRIBUT, & ENCAPSULATION
public class Transaksi {
    private Pembeli pembeli;
    private GasLPG3KgSubsidi gas;
    private int jumlahBeli;

    public Transaksi(Pembeli pembeli, GasLPG3KgSubsidi gas, int jumlahBeli) {
        this.pembeli = pembeli;
        this.gas = gas;
        this.jumlahBeli = jumlahBeli;
    }

    public double totalBayar() {
        return gas.getHargaNetto() * jumlahBeli;
    }

    public void cetakTransaksi() {
        System.out.println("----------------------------------------");
        System.out.println("Pembeli   : " + pembeli.getNama() + " (" + pembeli.getNik() + ")");
        System.out.println("Barang    : " + jumlahBeli + " Tabung LPG 3kg");
        System.out.println("Total     : Rp " + totalBayar());
        System.out.println("----------------------------------------");
    }

    public String formatLog() {
        return pembeli.getNik() + "," + pembeli.getNama() + "," + jumlahBeli + "," + totalBayar();
    }
}