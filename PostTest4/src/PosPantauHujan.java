import java.util.Date;

public class PosPantauHujan extends Pos {
    private double HPH;
    private Date tanggal;

    public void setHPH(double hPH) {
        this.HPH = hPH;
    }

    public PosPantauHujan(int idPos, String lokasi, int jumlahAlat, double hPH, Date tanggal) {
        super(idPos, lokasi, jumlahAlat);
        this.HPH = hPH;
        this.tanggal = tanggal;
    }

    @Override
    public void tampil() {
        super.tampil();
        System.out.println("Hasil Pantauan Hujan : " + this.HPH);
    }

    public void tampil(boolean check) {
        super.tampil();
        System.out.println("Hasil Pantauan Kelembapan : " + this.HPH);
        if (check == true) {
            System.out.println("Tanggal Pos Diinputkan : " + this.tanggal);
        }
    }
}
