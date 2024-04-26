import java.util.Date;

public final class PosPantauHujan extends Pos {
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
        System.out.println("ID Pos : " + this.idPos);
        System.out.println("Lokasi Pos : " + this.lokasi);
        System.out.println("Jumlah Alat Pos : " + this.jumlahAlat);
        System.out.println("Hasil Pantauan Hujan : " + this.HPH);
    }

    public final void tampil(boolean check) {
        System.out.println("ID Pos : " + this.idPos);
        System.out.println("Lokasi Pos : " + this.lokasi);
        System.out.println("Jumlah Alat Pos : " + this.jumlahAlat);
        System.out.println("Hasil Pantauan Kelembapan : " + this.HPH);
        if (check == true) {
            System.out.println("Tanggal Pos Diinputkan : " + this.tanggal);
        }
    }
}
