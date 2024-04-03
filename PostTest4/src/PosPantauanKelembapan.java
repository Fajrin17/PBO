import java.util.Date;

public class PosPantauanKelembapan extends Pos {
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
        super.tampil();
        System.out.println("Hasil Pantauan Kelembapan : " + this.HPK);
    }

    public void tampil(boolean check) {
        super.tampil();
        System.out.println("Hasil Pantauan Kelembapan : " + this.HPK);
        if (check == true) {
            System.out.println("Tanggal Pos Diinputkan : " + this.tanggal);
        }
    }
}
