public abstract class Pos {
    protected final int idPos;
    protected String lokasi;
    protected int jumlahAlat;

    public Pos(int idPos, String lokasi, int jumlahAlat) {
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

    public abstract void tampil();
}
