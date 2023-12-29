import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kelas untuk merepresentasikan objek Mahasiswa.
 */
class Mahasiswa {
    private String nim;      // NIM mahasiswa
    private String nama;     // Nama mahasiswa
    private String jurusan;  // Jurusan mahasiswa

    /**
     * Konstruktor untuk menginisiasi objek Mahasiswa.
     * 
     * @param nim     NIM mahasiswa
     * @param nama    Nama mahasiswa
     * @param jurusan Jurusan mahasiswa
     */
    public Mahasiswa(String nim, String nama, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    // Getter untuk NIM
    public String getNim() {
        return nim;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Getter untuk jurusan
    public String getJurusan() {
        return jurusan;
    }

    // Metode untuk mengembalikan informasi mahasiswa dalam bentuk String
    @Override
    public String toString() {
        return "NIM: " + nim + ", Nama: " + nama + ", Jurusan: " + jurusan;
    }
}

/**
 * Kelas utama untuk mengelola data mahasiswa.
 */
public class DataMahasiswa {

    /**
     * Sequential Search untuk mencari mahasiswa berdasarkan NIM.
     * 
     * @param list      Daftar mahasiswa
     * @param nimTarget NIM yang dicari
     * @return Indeks mahasiswa jika ditemukan, atau -1 jika tidak ditemukan
     */
    public static int sequentialSearch(ArrayList<Mahasiswa> list, String nimTarget) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNim().equals(nimTarget)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Binary Search untuk mencari mahasiswa berdasarkan NIM.
     * (Mengasumsikan daftar mahasiswa sudah diurutkan berdasarkan NIM)
     * 
     * @param list      Daftar mahasiswa
     * @param nimTarget NIM yang dicari
     * @return Indeks mahasiswa jika ditemukan, atau -1 jika tidak ditemukan
     */
    public static int binarySearch(ArrayList<Mahasiswa> list, String nimTarget) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid).getNim().compareTo(nimTarget) < 0) {
                low = mid + 1;
            } else if (list.get(mid).getNim().compareTo(nimTarget) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Interpolation Search untuk mencari mahasiswa berdasarkan NIM.
     * (Mengasumsikan daftar mahasiswa sudah diurutkan berdasarkan NIM)
     * 
     * @param list      Daftar mahasiswa
     * @param nimTarget NIM yang dicari
     * @return Indeks mahasiswa jika ditemukan, atau -1 jika tidak ditemukan
     */
    public static int interpolationSearch(ArrayList<Mahasiswa> list, String nimTarget) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high && nimTarget.compareTo(list.get(low).getNim()) >= 0 && nimTarget.compareTo(list.get(high).getNim()) <= 0) {
            int position = low + (((int) (high - low) / (list.get(high).getNim().compareTo(list.get(low).getNim())))
                                * (nimTarget.compareTo(list.get(low).getNim()) - low));
            if (list.get(position).getNim().compareTo(nimTarget) < 0) {
                low = position + 1;
            } else if (list.get(position).getNim().compareTo(nimTarget) > 0) {
                high = position - 1;
            } else {
                return position;
            }
        }
        return -1;
    }

    /**
     * Menampilkan header untuk tabel data mahasiswa.
     */
    public static void tampilkanHeaderTabel() {
        System.out.printf("+--------------+---------------------+--------------------+%n");
        System.out.printf("|     NIM      |         Nama        |      Jurusan       |%n");
        System.out.printf("+--------------+---------------------+--------------------+%n");
    }

    /**
     * Metode utama untuk menjalankan aplikasi manajemen data mahasiswa.
     * Pengguna dapat:
     * 1. Menambahkan data mahasiswa
     * 2. Menampilkan semua data mahasiswa dalam bentuk tabel
     * 3. Menghapus data mahasiswa berdasarkan indeks
     * 4. Mencari mahasiswa berdasarkan NIM menggunakan Sequential Search
     * 5. Menc
