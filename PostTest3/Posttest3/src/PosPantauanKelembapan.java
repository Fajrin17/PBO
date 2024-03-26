public class PosPantauanKelembapan extends Pos {
    private double HPK;

    public void setHPK(double hPK) {
        this.HPK = hPK;
    }

    public PosPantauanKelembapan(int idPos, String lokasi, int jumlahAlat, double hasilPantauan, double hPK) {
        super(idPos, lokasi, jumlahAlat, hasilPantauan);
        HPK = hPK;
    }

    @Override
    public void tampil() {
        super.tampil();
        System.out.println("Hasil Pantauan Kelembapan : " + this.HPK);
    }
}
