public class PosPantauHujan extends Pos {
    private double HPH;

    public void setHPH(double hPH) {
        this.HPH = hPH;
    }

    public PosPantauHujan(int idPos, String lokasi, int jumlahAlat, double hasilPantauan, double hPH) {
        super(idPos, lokasi, jumlahAlat, hasilPantauan);
        HPH = hPH;
    }

    @Override
    public void tampil() {
        super.tampil();
        System.out.println("Hasil Pantauan Hujan : " + this.HPH);
    }
}
