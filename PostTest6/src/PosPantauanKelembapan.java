import java.util.Date;

public final class PosPantauanKelembapan extends Pos {
    private double HPK;
    private Date tanggal;

    public void setHPK(double hPK) {
        this.HPK = hPK;
    }

    public PosPantauanKelembapan(int idPos, String lokasi, int jumlahAlat, double hPK, Date tanggal) {
        super(idPos, lokasi, jumlahAlat);
        this.HPK = hPK;
        this.tanggal = tanggal;
    }

    @Override
    public void tampil() {
        System.out.println("ID Pos : " + this.idPos);
        System.out.println("Lokasi Pos : " + this.lokasi);
        System.out.println("Jumlah Alat Pos : " + this.jumlahAlat);
        System.out.println("Hasil Pantauan Kelembapan : " + this.HPK);
    }

    public final void tampil(boolean check) {
        System.out.println("ID Pos : " + this.idPos);
        System.out.println("Lokasi Pos : " + this.lokasi);
        System.out.println("Jumlah Alat Pos : " + this.jumlahAlat);
        System.out.println("Hasil Pantauan Kelembapan : " + this.HPK);
        if (check == true) {
            System.out.println("Tanggal Pos Diinputkan : " + this.tanggal);
        }
    }
}
