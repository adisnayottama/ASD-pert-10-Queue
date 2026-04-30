package TugasJobsheet10;

import java.util.Scanner;

public class PersetujuanKrs02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AntrianKrs02 antrian = new AntrianKrs02(10, 30);

        int pilih;

        do {

            System.out.println("\n=== ANTRIAN KRS DPA ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Proses KRS");
            System.out.println("3. Tampilkan Semua Antrian");
            System.out.println("4. Lihat 2 Antrian Terdepan");
            System.out.println("5. Lihat Antrian Paling Belakang");
            System.out.println("6. Jumlah Antrian");
            System.out.println("7. Jumlah Sudah Proses KRS");
            System.out.println("8. Jumlah Belum Proses KRS");
            System.out.println("9. Kosongkan Antrian");
            System.out.println("0. Keluar");

            System.out.print("Pilih menu: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {

                case 1:

                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();

                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();

                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();

                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();

                    Mhs02 mhs = new Mhs02(nim, nama, prodi, kelas);

                    antrian.tambahAntrian(mhs);

                    break;

                case 2:
                    antrian.prosesKRS();
                    break;

                case 3:
                    antrian.tampilkanSemua();
                    break;

                case 4:
                    antrian.lihat2Terdepan();
                    break;

                case 5:
                    antrian.lihatAkhir();
                    break;

                case 6:
                    System.out.println(
                            "Jumlah antrian: "
                                    + antrian.getJumlahAntrian());
                    break;

                case 7:
                    System.out.println(
                            "Jumlah sudah proses KRS: "
                                    + antrian.getSudahKRS());
                    break;

                case 8:
                    System.out.println(
                            "Jumlah belum proses KRS: "
                                    + antrian.getBelumKRS());
                    break;

                case 9:
                    antrian.clear();
                    break;

                case 0:
                    System.out.println("Program selesai");
                    break;

                default:
                    System.out.println("Menu tidak valid");
            }

        } while (pilih != 0);

        sc.close();
    }
}