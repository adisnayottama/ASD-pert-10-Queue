package TugasJobsheet10;

public class AntrianKrs02 {

    Mhs02[] data;
    int front;
    int rear;
    int size;
    int max;

    int sudahKRS;
    int maxKRS;

    public AntrianKrs02(int max, int maxKRS) {
        this.max = max;
        this.maxKRS = maxKRS;

        data = new Mhs02[max];

        front = rear = -1;
        size = 0;
        sudahKRS = 0;
    }

    public boolean IsEmpty() {
        return size == 0;
    }

    public boolean IsFull() {
        return size == max;
    }

    public void clear() {
        front = rear = -1;
        size = 0;

        System.out.println("Antrian berhasil dikosongkan");
    }

    public void tambahAntrian(Mhs02 mhs) {

        if (IsFull()) {
            System.out.println("Antrian penuh");
            return;
        }

        if (IsEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % max;
        }

        data[rear] = mhs;
        size++;

        System.out.println(mhs.nama + " masuk ke antrian");
    }

    public void prosesKRS() {

        if (IsEmpty()) {
            System.out.println("Antrian kosong");
            return;
        }

        System.out.println("Mahasiswa dipanggil untuk proses KRS:");

        int jumlahDiproses = 0;

        while (!IsEmpty() && jumlahDiproses < 2 && sudahKRS < maxKRS) {

            Mhs02 mhs = data[front];
            mhs.tampilkanData();

            front = (front + 1) % max;
            size--;

            jumlahDiproses++;
            sudahKRS++;

            if (size == 0) {
                front = rear = -1;
            }
        }
    }

    public void tampilkanSemua() {

        if (IsEmpty()) {
            System.out.println("Antrian kosong");
            return;
        }

        System.out.println("Daftar Antrian:");

        for (int i = 0; i < size; i++) {

            int index = (front + i) % max;

            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public void lihat2Terdepan() {

        if (IsEmpty()) {
            System.out.println("Antrian kosong");
            return;
        }

        System.out.println("2 Antrian Terdepan:");

        int batas = Math.min(2, size);

        for (int i = 0; i < batas; i++) {

            int index = (front + i) % max;

            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public void lihatAkhir() {

        if (IsEmpty()) {
            System.out.println("Antrian kosong");
        } else {

            System.out.println("Antrian paling belakang:");
            data[rear].tampilkanData();
        }
    }

    public int getJumlahAntrian() {
        return size;
    }

    public int getSudahKRS() {
        return sudahKRS;
    }

    public int getBelumKRS() {
        return maxKRS - sudahKRS;
    }
}