# Proyek Akhir Pemrograman Berbasis Objek 1



Proyek ini merupakan aplikasi Sistem Distribusi LPG 3Kg Bersubsidi yang dibuat menggunakan bahasa Java sebagai tugas akhir mata kuliah Pemrograman Berbasis Objek 1.



## Latar Belakang



Program ini dibuat berdasarkan hasil observasi dan pengumpulan data secara langsung di **Pangkalan LPG 3 Kg M ARBANI**. Dari hasil observasi diketahui bahwa proses distribusi LPG 3 Kg bersubsidi telah memanfaatkan sistem **Merchant Apps Pertamina (MAP)** untuk melakukan verifikasi pembeli, pencatatan transaksi, dan pembayaran.



Berdasarkan proses tersebut, penulis mengembangkan aplikasi berbasis Java sebagai bentuk implementasi konsep **Pemrograman Berbasis Objek (OOP)**. Aplikasi ini dirancang untuk mensimulasikan proses distribusi LPG 3 Kg bersubsidi, mulai dari pendataan pembeli, validasi kelayakan subsidi, pencatatan transaksi, perhitungan total pembayaran, hingga pembuatan laporan transaksi.



## Deskripsi



Aplikasi ini merupakan simulasi sistem distribusi LPG 3 Kg bersubsidi yang dikembangkan berdasarkan hasil observasi di **Pangkalan LPG 3 Kg M ARBANI**. Program menerima data pembeli berupa **NIK**, **Nama Pembeli**, **Status Kelayakan Subsidi**, serta **Jumlah Tabung** yang dibeli.



Sistem melakukan validasi kelayakan penerima subsidi, membatasi pembelian maksimal **2 tabung per NIK**, menghitung total pembayaran berdasarkan harga LPG bersubsidi, menyimpan riwayat transaksi, menampilkan statistik penjualan, serta mencetak laporan transaksi ke dalam file **Laporan_Distribusi_LPG.txt**.



Program ini dikembangkan menggunakan bahasa pemrograman Java dengan menerapkan konsep **Object Oriented Programming (OOP)** seperti **Class, Object, Attribute, Constructor, Mutator, Accessor, Encapsulation, Inheritance, Polymorphism, Seleksi, Perulangan, Input Output Sederhana, Array (ArrayList), Error Handling, Abstract Class**, dan **Interface**.



## Penjelasan Kode



Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:



1. **Class** adalah template atau blueprint dari object. Pada program ini terdapat beberapa class yaitu `GasLPG`, `GasLPG3KgSubsidi`, `Pembeli`, `Transaksi`, dan `AplikasiLPG3Kg`.



```java

public class Pembeli {

   private String nik;

   private String nama;

   private boolean layakSubsidi;

}



public class Transaksi {

   private Pembeli pembeli;

   private GasLPG3KgSubsidi gas;

   private int jumlah;

}



public class GasLPG3KgSubsidi extends GasLPG {

   private double harga;

   private double subsidi;

}

```



2. **Object** adalah instance dari class. Pada kode ini, object dibuat menggunakan kata kunci `new` saat data transaksi ditambahkan ke dalam sistem.



```java

GasLPG3KgSubsidi gasLpg = new GasLPG3KgSubsidi("LPG-101", 21750, 3250);

Pembeli pembeli = new Pembeli(nik, nama, layakSubsidi);

Transaksi t = new Transaksi(pembeli, gasLpg, jumlah);

```



3. **Attribute** adalah variabel yang dimiliki oleh class untuk menyimpan data atau keadaan dari object.



```java

private String nik;

private String nama;

private boolean layakSubsidi;

```



4. **Constructor** adalah method khusus yang pertama kali dijalankan pada saat pembuatan object untuk menginisialisasi nilai awal atribut.



```java

public Pembeli(String nik, String nama, boolean layakSubsidi){

   this.nik = nik;

   this.nama = nama;

   this.layakSubsidi = layakSubsidi;

}

```



5. **Mutator (Setter)** digunakan untuk mengubah atau mengatur nilai suatu atribut yang dienkapsulasi.



```java

public void setIdTabung(String idTabung){

   this.idTabung = idTabung;

}

```



6. **Accessor (Getter)** digunakan untuk mengambil atau membaca nilai dari suatu atribut.



```java

public String getNama(){

   return nama;

}



public String getNik(){

   return nik;

}

```



7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut bersifat private sehingga hanya dapat diakses melalui getter maupun setter.



```java

private String idTabung;

private double berat;

```



8. **Inheritance** adalah konsep pewarisan di mana sebuah class dapat mewarisi properti dan method dari class induknya. Pada program ini class `GasLPG3KgSubsidi` mewarisi class `GasLPG`.



```java

public class GasLPG3KgSubsidi extends GasLPG {

   // Mewarisi properti idTabung dan berat dari superclass

}

```



9. **Polymorphism** pada program ini menggunakan konsep Method Overriding, yaitu mengimplementasikan ulang secara spesifik method yang diturunkan dari abstract class induk.



```java

@Override

public void tampilkanDetail(){

   System.out.println("Jenis Gas      : LPG 3 KG (Subsidi)");

   System.out.println("ID Tabung      : " + getIdTabung());

   System.out.println("Berat Bersih   : " + getBerat() + " Kg");

}

```



10. **Seleksi** adalah statement kontrol keputusan untuk menentukan kelayakan subsidi pembeli serta membatasi kuota maksimal pembelian tabung.



```java

if(!layakSubsidi){

   System.out.println("Transaksi ditolak");

   return;

}



if(jumlah > 2){

   System.out.println("Pembelian maksimal 2 tabung");

}

```



11. **Perulangan** adalah statement kontrol untuk menjalankan blok kode berulang kali, digunakan pada menu utama aplikasi dan saat menampilkan seluruh riwayat transaksi.



```java

do {

   // Menampilkan menu utama aplikasi

} while(pilihan != 4);

```



```java

for(int i = 0; i < daftarTransaksi.size(); i++){

   daftarTransaksi.get(i).cetakTransaksi();

}

```



12. **Input Output Sederhana** digunakan untuk berinteraksi dengan pengguna melalui class `Scanner` dan mencetak berkas fisik laporan teks menggunakan `FileWriter`.



```java

Scanner scanner = new Scanner(System.in);



FileWriter writer = new FileWriter("Laporan\_Distribusi\_LPG.txt");

```



13. **Array** pada program ini menggunakan objek dinamis `ArrayList` untuk menyimpan dan menampung seluruh kumpulan data transaksi terstruktur.



```java

private static ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

```



14. **Error Handling** digunakan untuk menangani kesalahan atau eksepsi tipe input data pengguna menggunakan blok `try-catch`.



```java

try{

   pilihan = scanner.nextInt();

}catch(InputMismatchException e){

   System.out.println("Input harus berupa angka!");

}

```



15. **Abstract Class** digunakan sebagai class induk abstrak yang mendefinisikan kerangka dasar data tabung LPG namun tidak dapat diinstansiasi langsung menjadi object.



```java

public abstract class GasLPG {

   public abstract void tampilkanDetail();

}

```



16. **Interface** digunakan sebagai kontrak cetak laporan untuk mendefinisikan method abstrak tanpa tubuh yang wajib diimplementasikan oleh class utama aplikasi.



```java

public interface Laporan {

   void hitungTotalPenjualan();

}

```



```java

public class AplikasiLPG3Kg implements Laporan {



   @Override

   public void hitungTotalPenjualan() {



   }



}

```



## Usulan nilai



| No  | Materi         |  Nilai  |

| :-: | -------------- | :-----: |

|  1  | Class          |    5    |

|  2  | Object         |    5    |

|  3  | Atribut        |    5    |

|  4  | Constructor    |    5    |

|  5  | Mutator        |    5    |

|  6  | Accessor       |    5    |

|  7  | Encapsulation  |    5    |

|  8  | Inheritance    |    5    |

|  9  | Polymorphism   |   10    |

| 10  | Seleksi        |    5    |

| 11  | Perulangan     |    5    |

| 12  | IO Sederhana   |   10    |

| 13  | Array          |   15    |

| 14  | Error Handling |   15    |

|     | **TOTAL**      | **100** |



## Pembuat



Nama: Riviana Serly Septianty

NPM: 2410010248



