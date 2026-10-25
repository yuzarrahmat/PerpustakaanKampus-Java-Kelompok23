<img width="1123" height="794" alt="Old School Library Corner Classroom Poster" src="https://github.com/user-attachments/assets/e772eeea-dfbf-4578-b506-7a998b500042" />



# Sistem Manajemen Perpustakaan Kampus
**Campus Library Management System — Java Console Application**

Program Java berbasis console yang dikembangkan untuk mengelola koleksi buku, lokasi penyimpanan, serta proses peminjaman pada perpustakaan kampus. Program ini merupakan proyek tugas kelompok yang mengimplementasikan enam konsep struktur data — Array 1 Dimensi, Array 2 Dimensi, Array 3 Dimensi, ArrayList, Stack, dan Queue — dalam satu program yang saling terintegrasi dengan menu interaktif menggunakan `Scanner`.

---

## Table of Contents

1. [About the Project](#about-the-project)
2. [Group Members](#group-members)
3. [Data Structures Implementation](#data-structures-implementation)
4. [Program Features](#program-features)
5. [How to Compile and Run](#how-to-compile-and-run)
6. [Project Structure](#project-structure)
7. [Screenshots](#screenshots)
8. [Testing Results](#testing-results)

---

## About the Project

### Deskripsi Studi Kasus

Sebuah perpustakaan kampus membutuhkan program sederhana untuk mengelola koleksi buku, lokasi penyimpanan, serta proses peminjaman. Pengelolaan manual dinilai kurang efisien karena petugas harus mencatat kategori buku, posisi rak penyimpanan, rekap peminjaman mingguan, riwayat transaksi, dan antrean mahasiswa secara terpisah. Oleh karena itu, dibuatlah **Sistem Manajemen Perpustakaan Kampus** berbasis console yang menyatukan seluruh proses tersebut dalam satu aplikasi Java dengan menu interaktif.

### Tujuan Pembuatan Program

1. Mengimplementasikan enam konsep struktur data (Array 1D, Array 2D, Array 3D, ArrayList, Stack, Queue) dalam satu program terintegrasi.
2. Melatih kemampuan pemodelan masalah dunia nyata ke dalam struktur data yang sesuai dengan karakteristiknya.
3. Menerapkan konsep pemrograman berorientasi objek (class, object, constructor, method, encapsulasi) melalui class `Buku`, `Mahasiswa`, dan `Transaksi`.
4. Membangun antarmuka menu interaktif berbasis `Scanner` yang mampu menangani input tidak valid.
5. Menunjukkan integrasi antarstruktur data, misalnya objek `Buku` yang sama digunakan pada ArrayList dan Array 3D.

---

## Group Members

| Nama | NIM |
|------------|--------|
| Yuzar Rahmat Rafi Alhaq | [2509116025] |
| Riaz Ramadhan Al Fattah | [2509116106] |
| Muhammad Ihsan Kamil | [2509116035] |
| Wahid Nur Hakim | [2509116016] |

### Informasi Kelompok

| Keterangan | Detail |
|------------|--------|
| Mata Kuliah | [Nama Mata Kuliah, mis. Struktur Data] |
| Dosen Pengampu | [Nama Dosen Pengampu] |
| Kelas / Praktikum | [Nama Kelas / Kelompok Lab] |
| Semester / Tahun | [Semester, Tahun Akademik] |

### Anggota dan Kontribusi

| No | Nama | NIM | Kontribusi |
|----|------|-----|------------|
| 1 | [Nama Anggota 1] | [NIM 1] | [mis. Perancangan program, implementasi Array 1D & 2D, penyusunan laporan] |
| 2 | [Nama Anggota 2] | [NIM 2] | [mis. Implementasi Array 3D & ArrayList, pengujian program] |
| 3 | [Nama Anggota 3] | [NIM 3] | [mis. Implementasi Stack & Queue, dokumentasi dan screenshot] |

> Seluruh anggota berkontribusi dan memahami keseluruhan program sesuai ketentuan pengerjaan tugas.

---

## Data Structures Implementation

Keenam struktur data diimplementasikan di dalam class `SistemPerpustakaan` dan masing-masing memiliki peran berbeda sesuai kebutuhan proses bisnis perpustakaan.

| No | Struktur Data | Variabel di Kode | Deklarasi | Fungsi dalam Program |
|----|---------------|------------------|-----------|----------------------|
| 1 | Array 1 Dimensi | `kategoriBuku` | `String[4]` | Menyimpan daftar kategori buku: Pemrograman, Matematika, Jaringan Komputer, dan Basis Data. |
| 2 | Array 2 Dimensi | `rekapPeminjaman` | `int[4][7]` | Merekap jumlah peminjaman buku per kategori (baris) dan per hari dalam satu minggu Senin–Minggu (kolom); mendukung penambahan data dengan validasi indeks. |
| 3 | Array 3 Dimensi | `lokasiBuku` | `Buku[2][3][4]` | Merepresentasikan lokasi fisik penyimpanan buku berdasarkan lantai (2), nomor rak (3), dan posisi slot buku (4); mendukung pengecekan isi slot dan penempatan buku. |
| 4 | ArrayList | `koleksiBuku` | `ArrayList<Buku>` | Mengelola daftar buku secara dinamis: menambahkan, menampilkan, dan menghapus buku tanpa batasan ukuran tetap. |
| 5 | Stack (LIFO) | `riwayatTransaksi` | `Stack<Transaksi>` | Menyimpan riwayat transaksi sehingga transaksi terakhir dapat dilihat (`peek`), dibatalkan/undo (`pop`), atau dicatat (`push`); ID transaksi dibuat otomatis (TX101, TX102, dan seterusnya). |
| 6 | Queue (FIFO) | `antreanMahasiswa` | `Queue<Mahasiswa>` (LinkedList) | Mengelola antrean mahasiswa peminjam berdasarkan urutan kedatangan: menambah antrean (`add`), melayani yang terdepan (`poll`), dan melihat yang terdepan (`peek`). |

---

## Program Features

### Menu Utama

| Menu | Fitur | Struktur Data yang Digunakan |
|------|-------|------------------------------|
| 1 | Lihat Kategori Buku | Array 1D |
| 2 | Rekap Peminjaman Mingguan | Array 2D |
| 3 | Pemetaan Lokasi Buku | Array 3D |
| 4 | Kelola Koleksi Buku | ArrayList |
| 5 | Riwayat Transaksi | Stack |
| 6 | Antrean Layanan | Queue |
| 7 | Keluar Program | — |

### Rincian Fitur per Menu

- **Menu 2 — Rekap Peminjaman Mingguan:** menampilkan matriks peminjaman 4 kategori × 7 hari dalam format tabel rata kolom, serta menambahkan data peminjaman pada indeks kategori (0–3) dan hari (0–6) tertentu.
- **Menu 3 — Pemetaan Lokasi Buku:** mengecek isi slot tertentu (lantai 0–1, rak 0–2, posisi 0–3, menampilkan `[KOSONG]` bila belum terisi) dan menempatkan objek `Buku` baru ke koordinat lokasi.
- **Menu 4 — Kelola Koleksi Buku:** menampilkan seluruh koleksi (dengan pengecekan koleksi kosong), menambah buku (ID dan judul), serta menghapus buku berdasarkan nomor urut.
- **Menu 5 — Riwayat Transaksi:** mencatat transaksi baru (`push`), membatalkan transaksi terakhir (`pop`), melihat transaksi teratas (`peek`), dan menampilkan seluruh riwayat dari urutan atas ke bawah.
- **Menu 6 — Antrean Layanan:** menambahkan mahasiswa (NIM dan nama) ke antrean, melayani mahasiswa terdepan, melihat mahasiswa urutan pertama, dan menampilkan seluruh antrean berurutan.

Program diawali dengan `inisialisasiDataAwal()` yang mengisi 3 buku contoh ke dalam `koleksiBuku` sekaligus menempatkannya pada koordinat `lokasiBuku` tertentu. Input menu yang bukan angka ditangani dengan pesan *"Input harus berupa angka!"* agar program tidak berhenti mendadak.

---

## How to Compile and Run

### Prasyarat

- JDK 8 atau versi lebih baru telah terpasang (cek dengan perintah `java -version` dan `javac -version`).
- Git (opsional, untuk melakukan clone repository).

### Langkah Menjalankan

```bash
# 1. Clone repository ini
git clone https://github.com/[username-github]/[nama-repository].git
cd [nama-repository]/src

# 2. Compile seluruh file Java
javac *.java

# 3. Jalankan program
java SistemPerpustakaan
```

Alternatif tanpa Git: unduh repository dalam format ZIP melalui tombol **Code > Download ZIP**, ekstrak file, buka terminal pada folder `src`, lalu lakukan langkah compile dan run seperti di atas.

### Catatan Penggunaan

- Seluruh file `.java` berada pada satu package (tanpa deklarasi `package`), sehingga compile dan run cukup dilakukan dari dalam folder `src`.
- Pemilihan menu dilakukan dengan memasukkan angka 1–7; input selain angka akan diminta ulang.
- Sub-menu pada menu 2, 3, 4, 5, dan 6 dipilih dengan memasukkan angka sesuai daftar yang tampil di layar.

---

## Project Structure

```
sistem-perpustakaan-kampus/
├── README.md
├── src/
│   ├── SistemPerpustakaan.java
│   ├── Buku.java
│   ├── Mahasiswa.java
│   └── Transaksi.java
├── screenshots/
│   ├── menu1-kategori.png
│   ├── menu2-rekap.png
│   ├── menu3-lokasi.png
│   ├── menu4-koleksi.png
│   ├── menu5-riwayat.png
│   └── menu6-antrean.png
└── docs/
    └── laporan-praktikum.pdf
```

### Deskripsi Berkas

| Berkas | Deskripsi |
|--------|-----------|
| `src/SistemPerpustakaan.java` | Class utama berisi method `main`, deklarasi keenam struktur data, menu interaktif berbasis `Scanner`, serta seluruh method operasional (`kelolaArray1D` hingga `kelolaQueue`) dan `inisialisasiDataAwal()`. |
| `src/Buku.java` | Class entitas buku dengan atribut `idBuku` dan `judul`, constructor, getter, serta override `toString()` untuk menampilkan buku dalam format `[id] judul`. |
| `src/Mahasiswa.java` | Class entitas mahasiswa dengan atribut `nim` dan `nama`, constructor, getter, serta override `toString()` untuk menampilkan mahasiswa dalam format `nama (NIM: xxx)`. |
| `src/Transaksi.java` | Class entitas transaksi dengan atribut `idTransaksi` dan `deskripsi`, constructor, getter, serta override `toString()` untuk menampilkan transaksi dalam format `ID [xxx] : deskripsi`. |
| `screenshots/` | Tempat menyimpan tangkapan layar hasil eksekusi setiap fitur program. |
| `docs/` | Tempat menyimpan laporan praktikum dalam format PDF. |

---

## Screenshots

Bagian ini diisi dengan tangkapan layar hasil eksekusi setiap fitur. Simpan file pada folder `screenshots/` dengan nama yang sesuai, lalu tautkan di bawah ini.

### Menu 1 — Lihat Kategori Buku (Array 1D)


<img width="338" height="320" alt="image" src="https://github.com/user-attachments/assets/c4b1f899-f3b9-4f01-8d1c-886777649e31" />


### Menu 2 — Rekap Peminjaman Mingguan (Array 2D)

<img width="613" height="407" alt="image" src="https://github.com/user-attachments/assets/fd7242b8-eccd-4083-9ddf-4b66ed11be5a" />


### Menu 3 — Pemetaan Lokasi Buku (Array 3D)

<img width="381" height="383" alt="image" src="https://github.com/user-attachments/assets/3f4b4c59-c18c-42c3-8264-4983ee3eecf5" />


### Menu 4 — Kelola Koleksi Buku (ArrayList)

<img width="395" height="385" alt="image" src="https://github.com/user-attachments/assets/ee91888b-9cd4-4493-950c-4b1d2393007d" />


### Menu 5 — Riwayat Transaksi (Stack)

<img width="396" height="325" alt="image" src="https://github.com/user-attachments/assets/4568a7a6-ddb1-487b-8a50-5702158ff44d" />


### Menu 6 — Antrean Layanan (Queue)

<img width="340" height="337" alt="image" src="https://github.com/user-attachments/assets/85f9f784-9f67-4945-867f-6b75dc6a5dc3" />


---

## Testing Results

Pengujian dilakukan secara fungsional terhadap setiap menu dengan skenario berikut.

| No | Skenario Pengujian | Hasil yang Diharapkan | Status |
|----|--------------------|------------------------|--------|
| 1 | Memilih menu 1 | Empat kategori buku tampil berurutan dengan indeksnya | [OK / Belum] |
| 2 | Menambah data peminjaman pada menu 2 dengan indeks valid | Nilai rekap pada kategori dan hari terkait bertambah | [OK / Belum] |
| 3 | Menambah data peminjaman dengan indeks di luar 0–3 / 0–6 | Muncul pesan indeks tidak valid, program tetap berjalan | [OK / Belum] |
| 4 | Mengecek slot kosong pada menu 3 | Muncul keterangan `[KOSONG]` | [OK / Belum] |
| 5 | Menempatkan buku pada koordinat valid lalu mengeceknya | Buku tampil pada lokasi tersebut | [OK / Belum] |
| 6 | Menambah lalu menghapus buku pada menu 4 | Buku terhapus dan daftar koleksi diperbarui | [OK / Belum] |
| 7 | Push dua transaksi lalu pop pada menu 5 | Transaksi terakhir dibatalkan, transaksi pertama tetap tersimpan | [OK / Belum] |
| 8 | Pop/peek saat riwayat kosong | Muncul pesan riwayat transaksi kosong | [OK / Belum] |
| 9 | Menambah 3 mahasiswa lalu melayani 1 kali pada menu 6 | Mahasiswa yang datang pertama dilayani lebih dulu (FIFO) | [OK / Belum] |
| 10 | Memasukkan huruf pada pemilihan menu | Muncul pesan "Input harus berupa angka!", program tidak berhenti | [OK / Belum] |

Analisis hasil pengujian: [tulis ringkasan hasil pengujian kelompok, mis. seluruh skenario berjalan sesuai harapan; input tidak valid tertangani dengan baik; satu-satunya keterbatasan program adalah ...]
