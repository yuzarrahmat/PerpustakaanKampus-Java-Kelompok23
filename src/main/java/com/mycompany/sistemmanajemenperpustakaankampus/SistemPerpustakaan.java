import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class SistemPerpustakaan {

        static String[] kategoriBuku = {"Pemrograman", "Matematika", "Jaringan Komputer", "Basis Data"};

    static String[] namaHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"};
    static int[][] rekapPeminjaman = new int[4][7];

    static Buku[][][] lokasiBuku = new Buku[2][3][4];

    static ArrayList<Buku> koleksiBuku = new ArrayList<>();

    static Stack<Transaksi> riwayatTransaksi = new Stack<>();

    static Queue<Mahasiswa> antreanMahasiswa = new LinkedList<>();

    static Scanner scanner = new Scanner(System.in);
    static int autoIncTx = 101;

    public static void main(String[] args) {
        inisialisasiDataAwal();
        int pilihan = 0;

        do {
            System.out.println("\n=======================================");
            System.out.println("   SISTEM MANAJEMEN PERPUSTAKAAN KAMPUS ");
            System.out.println("=========================================");
            System.out.println("1. Lihat Kategori Buku");
            System.out.println("2. Rekap Peminjaman Mingguan");
            System.out.println("3. Pemetaan Lokasi Buku");
            System.out.println("4. Kelola Koleksi Buku");
            System.out.println("5. Riwayat Transaksi");
            System.out.println("6. Antrean Layanan");
            System.out.println("7. Keluar Program");
            System.out.print("Pilih menu (1-7): ");

            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine();
                switch (pilihan) {
                    case 1: kelolaArray1D(); break;
                    case 2: kelolaArray2D(); break;
                    case 3: kelolaArray3D(); break;
                    case 4: kelolaArrayList(); break;
                    case 5: kelolaStack(); break;
                    case 6: kelolaQueue(); break;
                    case 7: System.out.println("Program selesai."); break;
                    default: System.out.println("Pilihan tidak valid!");
                }
            } else {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        } while (pilihan != 7);
    }

    static void inisialisasiDataAwal() {
        Buku b1 = new Buku("1", "Dasar-Dasar Pemrograman Java");
        Buku b2 = new Buku("2", "Struktur Data dan Algoritma");
        Buku b3 = new Buku("3", "Sistem Basis Data Ala Riaz");

        koleksiBuku.add(b1);
        koleksiBuku.add(b2);
        koleksiBuku.add(b3);

        lokasiBuku[0][0][0] = b1;
        lokasiBuku[0][1][2] = b2;
        lokasiBuku[1][0][1] = b3;
    }

    static void kelolaArray1D() {
        System.out.println("\n--- [1] DAFTAR KATEGORI BUKU ---");
        for (int i = 0; i < kategoriBuku.length; i++) {
            System.out.println("[" + i + "] : " + kategoriBuku[i]);
        }
    }

    static void kelolaArray2D() {
        System.out.println("\n--- [2] REKAP PEMINJAMAN MINGGUAN ---");
        System.out.println("1. Tampilkan Matriks Peminjaman");
        System.out.println("2. Tambah Data Peminjaman");
        System.out.print("Pilihan: ");
        int sub = scanner.nextInt();
        scanner.nextLine();

        if (sub == 1) {
            System.out.printf("%-20s", "Kategori");
            for (String h : namaHari) System.out.printf("%-8s", h);
            System.out.println();
            for (int i = 0; i < kategoriBuku.length; i++) {
                System.out.printf("%-20s", kategoriBuku[i]);
                for (int j = 0; j < namaHari.length; j++) {
                    System.out.printf("%-8d", rekapPeminjaman[i][j]);
                }
                System.out.println();
            }
        } else if (sub == 2) {
            System.out.println("Pilih Kategori (0-3):");
            for (int i = 0; i < kategoriBuku.length; i++) {
                System.out.println(i + ". " + kategoriBuku[i]);
            }
            int kat = scanner.nextInt();
            System.out.print("Pilih Hari (0-6, 0=Senin): ");
            int hr = scanner.nextInt();
            System.out.print("Masukkan Jumlah Peminjaman Tambahan: ");
            int jml = scanner.nextInt();
            scanner.nextLine();

            if (kat >= 0 && kat < 4 && hr >= 0 && hr < 7) {
                rekapPeminjaman[kat][hr] += jml;
                System.out.println("Data rekapitulasi berhasil diperbarui.");
            } else {
                System.out.println("Indeks kategori atau hari tidak valid.");
            }
        }
    }

    static void kelolaArray3D() {
        System.out.println("\n--- [3] LOKASI FISIK BUKU ---");
        System.out.println("1. Cek Isi Lokasi Spesifik");
        System.out.println("2. Tempatkan Buku ke Lokasi");
        System.out.print("Pilihan: ");
        int sub = scanner.nextInt();
        scanner.nextLine();

        if (sub == 1) {
            System.out.print("Masukkan Lantai (0-1): ");
            int l = scanner.nextInt();
            System.out.print("Masukkan Rak (0-2): ");
            int r = scanner.nextInt();
            System.out.print("Masukkan Posisi Slot (0-3): ");
            int p = scanner.nextInt();
            scanner.nextLine();

            if (l >= 0 && l < 2 && r >= 0 && r < 3 && p >= 0 && p < 4) {
                Buku b = lokasiBuku[l][r][p];
                System.out.println("Isi Lokasi [" + l + "][" + r + "][" + p + "]: " + 
                                   (b != null ? b.toString() : "[KOSONG]"));
            } else {
                System.out.println("Koordinat lokasi di luar jangkauan.");
            }
        } else if (sub == 2) {
            System.out.print("Masukkan ID Buku: ");
            String id = scanner.nextLine();
            System.out.print("Masukkan Judul Buku: ");
            String judul = scanner.nextLine();
            System.out.print("Masukkan Lantai (0-1): ");
            int l = scanner.nextInt();
            System.out.print("Masukkan Rak (0-2): ");
            int r = scanner.nextInt();
            System.out.print("Masukkan Posisi Slot (0-3): ");
            int p = scanner.nextInt();
            scanner.nextLine();

            if (l >= 0 && l < 2 && r >= 0 && r < 3 && p >= 0 && p < 4) {
                lokasiBuku[l][r][p] = new Buku(id, judul);
                System.out.println("Objek Buku berhasil ditempatkan pada lokasi tersebut.");
            } else {
                System.out.println("Koordinat lokasi tidak valid.");
            }
        }
    }

    static void kelolaArrayList() {
        System.out.println("\n--- [4] KOLEKSI BUKU DINAMIS ---");
        System.out.println("1. Tampilkan Semua Buku");
        System.out.println("2. Tambah Buku");
        System.out.println("3. Hapus Buku");
        System.out.print("Pilihan: ");
        int sub = scanner.nextInt();
        scanner.nextLine();

        if (sub == 1) {
            if (koleksiBuku.isEmpty()) {
                System.out.println("Koleksi buku kosong.");
            } else {
                for (int i = 0; i < koleksiBuku.size(); i++) {
                    System.out.println((i + 1) + ". " + koleksiBuku.get(i));
                }
            }
        } else if (sub == 2) {
            System.out.print("Masukkan ID Buku: ");
            String id = scanner.nextLine();
            System.out.print("Masukkan Judul Buku Baru: ");
            String judul = scanner.nextLine();
            koleksiBuku.add(new Buku(id, judul));
            System.out.println("Objek Buku berhasil ditambahkan.");
        } else if (sub == 3) {
            System.out.print("Masukkan Nomor Buku yang Ingin Dihapus: ");
            int idx = scanner.nextInt() - 1;
            scanner.nextLine();
            if (idx >= 0 && idx < koleksiBuku.size()) {
                Buku removed = koleksiBuku.remove(idx);
                System.out.println("Objek Buku " + removed + " berhasil dihapus.");
            } else {
                System.out.println("Nomor buku tidak ditemukan.");
            }
        }
    }

    static void kelolaStack() {
        System.out.println("\n--- [5] RIWAYAT TRANSAKSI ---");
        System.out.println("1. Catat Transaksi Baru (Push)");
        System.out.println("2. Batalkan/Undo Transaksi Terakhir (Pop)");
        System.out.println("3. Lihat Transaksi Terakhir (Peek)");
        System.out.println("4. Tampilkan Semua Riwayat Transaksi");
        System.out.print("Pilihan: ");
        int sub = scanner.nextInt();
        scanner.nextLine();

        if (sub == 1) {
            System.out.print("Masukkan Deskripsi Transaksi: ");
            String desk = scanner.nextLine();
            String idTx = "TX" + (autoIncTx++);
            riwayatTransaksi.push(new Transaksi(idTx, desk));
            System.out.println("Objek Transaksi [" + idTx + "] dicatat ke dalam Stack.");
        } else if (sub == 2) {
            if (!riwayatTransaksi.isEmpty()) {
                Transaksi popped = riwayatTransaksi.pop();
                System.out.println("Transaksi dibatalkan : " + popped);
            } else {
                System.out.println("Riwayat transaksi kosong.");
            }
        } else if (sub == 3) {
            if (!riwayatTransaksi.isEmpty()) {
                System.out.println("Transaksi Paling Atas : " + riwayatTransaksi.peek());
            } else {
                System.out.println("Riwayat transaksi kosong.");
            }
        } else if (sub == 4) {
            if (riwayatTransaksi.isEmpty()) {
                System.out.println("Riwayat transaksi kosong.");
            } else {
                System.out.println("Urutan Stack (Atas ke Bawah):");
                for (int i = riwayatTransaksi.size() - 1; i >= 0; i--) {
                    System.out.println("- " + riwayatTransaksi.get(i));
                }
            }
        }
    }

    static void kelolaQueue() {
        System.out.println("\n--- [6] ANTREAN MAHASISWA ---");
        System.out.println("1. Tambah Mahasiswa ke Antrean");
        System.out.println("2. Melayani Mahasiswa Terdepan");
        System.out.println("3. Lihat Mahasiswa Terdepan");
        System.out.println("4. Tampilkan Seluruh Antrean");
        System.out.print("Pilihan: ");
        int sub = scanner.nextInt();
        scanner.nextLine();

        if (sub == 1) {
            System.out.print("Masukkan NIM Mahasiswa: ");
            String nim = scanner.nextLine();
            System.out.print("Masukkan Nama Mahasiswa: ");
            String nama = scanner.nextLine();
            antreanMahasiswa.add(new Mahasiswa(nim, nama));
            System.out.println("Mahasiswa masuk ke antrean.");
        } else if (sub == 2) {
            if (!antreanMahasiswa.isEmpty()) {
                Mahasiswa served = antreanMahasiswa.poll();
                System.out.println("Mahasiswa telah dilayani dan keluar dari antrean: " + served);
            } else {
                System.out.println("Antrean kosong.");
            }
        } else if (sub == 3) {
            if (!antreanMahasiswa.isEmpty()) {
                System.out.println("Mahasiswa Urutan Pertama: " + antreanMahasiswa.peek());
            } else {
                System.out.println("Antrean kosong.");
            }
        } else if (sub == 4) {
            if (antreanMahasiswa.isEmpty()) {
                System.out.println("Antrean kosong.");
            } else {
                System.out.println("Daftar Antrean Saat Ini :");
                int no = 1;
                for (Mahasiswa mhs : antreanMahasiswa) {
                    System.out.println(no++ + ". " + mhs);
                }
            }
        }
    }
}
