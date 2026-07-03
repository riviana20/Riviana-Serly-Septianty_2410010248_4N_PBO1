package pbo1_uas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AplikasiLPG3Kg implements Laporan {
    
    // 13: ARRAY (Menggunakan ArrayList dinamis)
    private static ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Implementasi Method dari Interface Tambahan
    @Override
    public void hitungTotalPenjualan() {
        double totalUang = 0;
        for (Transaksi t : daftarTransaksi) {
            totalUang += t.totalBayar();
        }
        System.out.println("\n=== STATISTIK PANGKALAN (FITUR BONUS) ===");
        System.out.println("Total Transaksi Tercatat : " + daftarTransaksi.size());
        System.out.println("Total Pendapatan         : Rp " + totalUang);
        System.out.println("=========================================\n");
    }

    public static void main(String[] args) {
        AplikasiLPG3Kg app = new AplikasiLPG3Kg();
        int pilihan = 0;

        System.out.println("========================================");
        System.out.println("   SISTEM DISTRIBUSI LPG 3KG SUBSIDI    ");
        System.out.println("========================================");

        // 11: PERULANGAN (Menu Utama do-while)
        do {
            System.out.println("1. Input Transaksi Baru");
            System.out.println("2. Lihat Riwayat Transaksi");
            System.out.println("3. Lihat Statistik & Cetak Laporan");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu: ");

            // 14: ERROR HANDLING (Try-Catch)
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        inputTransaksi();
                        break;
                    case 2:
                        lihatRiwayat();
                        break;
                    case 3:
                        app.hitungTotalPenjualan();
                        cetakKeFile();
                        break;
                    case 4:
                        System.out.println("Terima kasih! Program selesai.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid! Masukkan angka 1-4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] Input harus berupa angka/bilangan bulat!");
                scanner.nextLine();
                pilihan = 0;
            }
            System.out.println();
        } while (pilihan != 4);
    }

    // 12: IO SEDERHANA (Input data interaktif lewat Scanner)
    private static void inputTransaksi() {
        System.out.println("\n--- INPUT DATA TRANSAKSI ---");
        System.out.print("Masukkan NIK Pembeli : ");
        String nik = scanner.nextLine();
        System.out.print("Masukkan Nama Pembeli: ");
        String nama = scanner.nextLine();
        
        System.out.print("Apakah pembeli terdaftar UMKM/Miskin? (y/n): ");
        String status = scanner.nextLine();
        
        // 10: SELEKSI (Kondisi kelayakan subsidi)
        boolean layakSubsidi = status.equalsIgnoreCase("y");

        if (!layakSubsidi) {
            System.out.println("\n[PERINGATAN] Mohon maaf, LPG 3kg hanya untuk warga miskin/UMKM terdaftar!");
            System.out.println("Transaksi ditolak secara otomatis oleh sistem.");
            return;
        }

        System.out.print("Masukkan Jumlah Tabung yang dibeli: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();
        
        if (jumlah > 2) {
            System.out.println("[PERINGATAN] Pembelian maksimal barang bersubsidi adalah 2 tabung per NIK!");
            return;
        }

        // 2 & 4: INSTANSIASI OBJECT & CONSTRUCTOR CONTEXT
        // Menggunakan data riil Pangkalan M ARBANI (HET: 18500, Subsidi: 3250)
        GasLPG3KgSubsidi gasLpg = new GasLPG3KgSubsidi("LPG-" + (daftarTransaksi.size() + 101), 21750, 3250);
        Pembeli pembeli = new Pembeli(nik, nama, layakSubsidi);
        Transaksi t = new Transaksi(pembeli, gasLpg, jumlah);

        daftarTransaksi.add(t);
        System.out.println("\n[SUKSES] Transaksi Berhasil Disimpan!");
        t.cetakTransaksi();
    }

    private static void lihatRiwayat() {
        System.out.println("\n--- RIWAYAT TRANSAKSI PANGKALAN ---");
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada data transaksi.");
            return;
        }
        
        // 11: PERULANGAN (Membaca isi data Array)
        for (int i = 0; i < daftarTransaksi.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarTransaksi.get(i).cetakTransaksi();
        }
    }

    // 12: IO SEDERHANA (Output menulis berkas .txt)
    private static void cetakKeFile() {
        try (FileWriter writer = new FileWriter("Laporan_Distribusi_LPG.txt")) {
            writer.write("========================================================================\n");
            writer.write("                LAPORAN RESMI TRANSAKSI DISTRIBUSI LPG 3KG              \n");
            writer.write("                           PANGKALAN RIVIANA                            \n");
            writer.write("========================================================================\n");
            
            // Format judul kolom tabel agar rata dan sejajar presisi
            writer.write(String.format("| %-3s | %-16s | %-20s | %-9s | %-12s |\n", 
                    "No", "NIK", "Nama Pembeli", "Jumlah", "Total Bayar"));
            writer.write("------------------------------------------------------------------------\n");
            
            // Perulangan menulis baris data transaksi
            for (int i = 0; i < daftarTransaksi.size(); i++) {
                Transaksi t = daftarTransaksi.get(i);
                
                // Memecah format data string bawaan (CSV) untuk ditata ulang ke dalam tabel teks
                String[] data = t.formatLog().split(","); 
                String nik = data[0];
                String nama = data[1];
                String jumlah = data[2] + " Tabung";
                String total = "Rp " + data[3];

                writer.write(String.format("| %-3d | %-16s | %-20s | %-9s | %-12s |\n", 
                        (i + 1), nik, nama, jumlah, total));
            }
            
            writer.write("========================================================================\n");
            System.out.println("[IO SUKSES] Laporan berhasil diekspor ke file 'Laporan_Distribusi_LPG.txt'");
        } catch (IOException e) {
            System.out.println("[ERROR IO] Gagal mencetak laporan ke file: " + e.getMessage());
        }
    }
}