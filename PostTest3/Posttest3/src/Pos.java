public class Pos {
    private int idPos;
    private String lokasi;
    private int jumlahAlat;

    public Pos(int idPos, String lokasi, int jumlahAlat, double hasilPantauan) {
        this.idPos = idPos;
        this.lokasi = lokasi;
        this.jumlahAlat = jumlahAlat;
    }

    public int getId() {
        return idPos;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public void setJumlah(int jumlahAlat) {
        this.jumlahAlat = jumlahAlat;
    }

    public void tampil() {
        System.out.println("ID Pos : " + this.idPos);
        System.out.println("Lokasi Pos : " + this.lokasi);
        System.out.println("Jumlah Alat Pos : " + this.jumlahAlat);
    }
}
