import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {
    static int pilih;
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(isr);

    static ArrayList<Pos> listPos = new ArrayList();

    static boolean ulang = true;

    public static void main(String[] args) throws Exception {
        ulang = true;
        while (ulang == true) {
            System.out.println("Selamat Datang di Sistem Pendataan Curah Hujan!");
            System.out.println("================================================================");
            System.out.println("1. Lihat Hasil Pantauan");
            System.out.println("2. Tambah Data Pos Pantauan");
            System.out.println("3. Edit Data");
            System.out.println("4. Hapus Pos Pantauan");
            System.out.println("0. Exit Program");

            System.out.print("Menu Yang Dipilih > ");
            pilih = Integer.parseInt(input.readLine());

            switch (pilih) {
                case 1:
                    display();
                    break;
                case 2:
                    menuAdd();
                    break;
                case 3:
                    menuEdit();
                    break;
                case 4:
                    deletePos();
                    break;
                case 0:
                    System.out.println("Terima Kasih :)");
                    ulang = false;
                    break;

                default:
                    error();
                    break;
            }
        }
    }

    static void menuAdd() throws NumberFormatException, IOException {
        int pilih;
        boolean ulang1 = true;
        while (ulang1 == true) {
            System.out.println("Pilih Pos");
            System.out.println("================================================================");
            System.out.println("1. Pos Pantauan Hujan");
            System.out.println("2. Pos Pantauan Kelembapan");
            System.out.println("0. Exit Menu");

            System.out.print("Menu Yang Dipilih > ");
            pilih = Integer.parseInt(input.readLine());

            switch (pilih) {
                case 1:
                    addPosHujan();
                    break;
                case 2:
                    addPosKelembapan();
                    break;
                case 0:
                    ulang1 = false;
                    break;

                default:
                    error();
                    break;
            }
        }
    }

    static void display() {
        if (listPos.size() != 0) {
            System.out.println("Data Pos Pantauan");
            System.out.println("================================================================");
            int i = 1;
            for (Pos pos : listPos) {
                System.out.println("[" + i + "]");
                if (pos instanceof PosPantauHujan) {
                    ((PosPantauHujan) pos).tampil();
                } else if (pos instanceof PosPantauanKelembapan) {
                    ((PosPantauanKelembapan) pos).tampil();
                }
                i++;
            }
        } else {
            System.out.println("Pos Pantauan Belum Diinputkan!");
        }
    }

    static void addPosHujan() throws NumberFormatException, IOException {
        int idPos, jumlahAlat;
        String lokasi;
        Double hasilPantauan;

        System.out.println("Tambah Data Pos Pantauan");
        System.out.println("================================================================");

        while (true) {
            System.out.println("Masukkan ID Pos");
            System.out.print("> ");
            idPos = Integer.parseInt(input.readLine());
            if (listPos.size() != 0) {
                if (cekIDPos(idPos) == true) {
                    System.out.println("ID Pos Sudah Ada!");
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        System.out.println("Masukkan Alamat Pos Pantauan");
        System.out.print("> ");
        lokasi = input.readLine();

        System.out.println("Masukkan Jumlah Alat Pada Pos");
        System.out.print("> ");
        jumlahAlat = Integer.parseInt(input.readLine());

        System.out.println("Masukkan Hasil Pantauan Hujan Dalam Desimal");
        System.out.print("> ");
        hasilPantauan = Double.parseDouble(input.readLine());

        PosPantauHujan posHujan = new PosPantauHujan(idPos, lokasi, jumlahAlat, idPos, hasilPantauan);
        listPos.add(posHujan);
        System.out.println("Berhasil Input Data!");
    }

    static void addPosKelembapan() throws NumberFormatException, IOException {
        int idPos, jumlahAlat;
        String lokasi;
        Double hasilPantauan;

        System.out.println("Tambah Data Pos Pantauan");
        System.out.println("================================================================");

        while (true) {
            System.out.println("Masukkan ID Pos");
            System.out.print("> ");
            idPos = Integer.parseInt(input.readLine());
            if (listPos.size() != 0) {
                if (cekIDPos(idPos) == true) {
                    System.out.println("ID Pos Sudah Ada!");
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        System.out.println("Masukkan Alamat Pos Pantauan");
        System.out.print("> ");
        lokasi = input.readLine();

        System.out.println("Masukkan Jumlah Alat Pada Pos");
        System.out.print("> ");
        jumlahAlat = Integer.parseInt(input.readLine());

        System.out.println("Masukkan Hasil Pantauan Kelembapan Dalam Desimal");
        System.out.print("> ");
        hasilPantauan = Double.parseDouble(input.readLine());

        PosPantauanKelembapan posKelembapan = new PosPantauanKelembapan(idPos, lokasi, jumlahAlat, idPos,
                hasilPantauan);
        listPos.add(posKelembapan);
        System.out.println("Berhasil Input Data!");
    }

    static void menuEdit() throws NumberFormatException, IOException {
        int pilih;
        boolean ulang1 = true;
        while (ulang1 == true) {
            System.out.println("Menu Edit");
            System.out.println("================================================================");
            System.out.println("1. Edit Lokasi Pos");
            System.out.println("2. Edit Jumlah Alat");
            System.out.println("3. Edit Hasil Pantauan");
            System.out.println("0. Exit Menu");

            System.out.print("Menu Yang Dipilih > ");
            pilih = Integer.parseInt(input.readLine());

            switch (pilih) {
                case 1:
                    editLokasi();
                    break;
                case 2:
                    editJumlahAlat();
                    break;
                case 3:
                    editHasilPantauan();
                    break;
                case 0:
                    ulang1 = false;
                    break;

                default:
                    error();
                    break;
            }
        }
    }

    static void editLokasi() throws NumberFormatException, IOException {
        int IDEdit;
        String lokasi;
        if (listPos.size() != 0) {
            System.out.println("Data Pos Pantauan");
            System.out.println("================================================================");
            for (int i = 0; i < listPos.size(); i++) {
                System.out.println("[" + (i + 1) + "]");
                listPos.get(i).tampil();
            }

            System.out.println("Masukkan ID Pos Yang Ingin Diubah");
            System.out.print("> ");
            IDEdit = Integer.parseInt(input.readLine());

            for (int i = 0; i < listPos.size(); i++) {
                Pos pos = listPos.get(i);
                if (pos.getId() == IDEdit) {
                    System.out.print("Masukkan Lokasi Pos Yang Baru > ");
                    lokasi = input.readLine();

                    pos.setLokasi(lokasi);
                    System.out.println("Data Berhasil Diubah");
                    return;
                }
            }
        } else {
            System.out.println("Pos Pantauan Belum Diinputkan!");
        }
    }

    static void editJumlahAlat() throws NumberFormatException, IOException {
        int IDEdit, jumlahAlat;
        if (listPos.size() != 0) {
            System.out.println("Data Pos Pantauan");
            System.out.println("================================================================");
            for (int i = 0; i < listPos.size(); i++) {
                System.out.println("[" + (i + 1) + "]");
                listPos.get(i).tampil();
            }

            System.out.println("Masukkan ID Pos Yang Ingin Diubah");
            System.out.print("> ");
            IDEdit = Integer.parseInt(input.readLine());

            for (int i = 0; i < listPos.size(); i++) {
                Pos pos = listPos.get(i);
                if (pos.getId() == IDEdit) {
                    System.out.print("Masukkan Jumlah Alat Pos Yang Baru > ");
                    jumlahAlat = Integer.parseInt(input.readLine());

                    pos.setJumlah(jumlahAlat);
                    System.out.println("Data Berhasil Diubah");
                    return;
                }
            }
        } else {
            System.out.println("Pos Pantauan Belum Diinputkan!");
        }
    }

    static void editHasilPantauan() throws NumberFormatException, IOException {
        int IDEdit;
        Double hasilPantauan;
        if (listPos.size() != 0) {
            System.out.println("Data Pos Pantauan");
            System.out.println("================================================================");
            for (int i = 0; i < listPos.size(); i++) {
                System.out.println("[" + (i + 1) + "]");
                listPos.get(i).tampil();
            }

            System.out.println("Masukkan ID Pos Yang Ingin Dihapus");
            System.out.print("> ");
            IDEdit = Integer.parseInt(input.readLine());

            for (int i = 0; i < listPos.size(); i++) {
                Pos pos = listPos.get(i);
                if (pos.getId() == IDEdit) {
                    System.out.print("Masukkan Hasil Pantauan Pos Yang Baru > ");
                    hasilPantauan = Double.parseDouble(input.readLine());
                    if (pos instanceof PosPantauHujan) {
                        ((PosPantauHujan) pos).setHPH(hasilPantauan);
                        System.out.println("Data Berhasil Diubah");
                        return;
                    } else if (pos instanceof PosPantauanKelembapan) {
                        ((PosPantauanKelembapan) pos).setHPK(hasilPantauan);
                        System.out.println("Data Berhasil Diubah");
                        return;
                    }

                }
            }
        } else {
            System.out.println("Pos Pantauan Belum Diinputkan!");
        }
    }

    static void deletePos() throws NumberFormatException, IOException {
        int IDHapus;
        if (listPos.size() != 0) {
            System.out.println("Data Pos Pantauan");
            System.out.println("================================================================");
            for (int i = 0; i < listPos.size(); i++) {
                System.out.println("[" + (i + 1) + "]");
                listPos.get(i).tampil();
            }

            System.out.println("Masukkan ID Pos Yang Ingin Dihapus");
            System.out.print("> ");
            IDHapus = Integer.parseInt(input.readLine());

            for (int i = 0; i < listPos.size(); i++) {
                Pos pos = listPos.get(i);
                if (pos.getId() == IDHapus) {
                    listPos.remove(i);
                    System.out.println("Data Berhasil Dihapus!");
                    return;
                }
            }
        } else {
            System.out.println("Pos Pantauan Belum Diinputkan!");
        }
    }

    static boolean cekIDPos(int kode) {
        boolean result = false;
        for (int i = 0; i < listPos.size(); i++) {
            if (listPos.get(i).getId() == kode) {
                result = true;
                break;
            }
        }
        return result;
    }

    static void error() {
        System.out.println("Invalid Input!");
    }
}
