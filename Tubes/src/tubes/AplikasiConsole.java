/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author SagabAdi
 */
public class AplikasiConsole {

    Model model;

    public AplikasiConsole(Model model) {
        this.model = model;
    }

    public void appss() {
        Scanner cin = new Scanner(System.in);
        Scanner can = new Scanner(System.in);
        boolean nemu = false;
        boolean nemus = false;
        String a;
        String b;
        String c;
        String d;
        String e;
        int pil = 0;
        int pal = 0;
        int i = 0;
        do {
            System.out.println("1. Tambah Pelanggan ");
            System.out.println("2. Tambah Pengemudi ");
            System.out.println("3. Login Pelanggan ");
            System.out.println("4. Login Pengemudi ");
            System.out.println("5. Exit ");
            System.out.print("Masukkan Pilihan Anda : ");
            pil = can.nextInt();
            if (pil == 1) {
                System.out.print("Masukkan Nama Anda : ");
                a = cin.nextLine();
                System.out.print("Masukkan Id Anda   : ");
                b = cin.nextLine();
                model.loadPelall();
                model.loadPengall();
                if (model.searchPel(a, b) == null && model.searchPeng(a, b) == null) {
                    model.setPe(a, b);
                } else {
                    System.out.println("Akun Sudah Terpakai");
                }
                System.out.println("1. Tambah Pelanggan");
                System.out.println("2. Selesai");
                System.out.print("Masukkan Pilihan Anda :  ");
                pal = can.nextInt();
                while (pal != 2) {
                    System.out.print("Masukkan Nama Anda : ");
                    a = cin.nextLine();
                    System.out.print("Masukkan Id Anda   : ");
                    b = cin.nextLine();
                    model.loadPelall();
                    model.loadPengall();
                    if (model.searchPel(a, b) == null && model.searchPeng(a, b) == null) {
                        model.setPe(a, b);
                    } else {
                        System.out.println("Akun Sudah Terpakai");
                    }
                    System.out.println("1. Tambah Pelanggan");
                    System.out.println("2. Selesai");
                    System.out.print("Masukkan Pilihan Anda :  ");
                    pal = can.nextInt();
                }
            } else if (pil == 2) {
                System.out.print("Masukkan Nama Anda : ");
                a = cin.nextLine();
                System.out.print("Masukkan Id Anda   : ");
                b = cin.nextLine();
                model.loadPengall();
                model.loadPelall();
                if (model.searchPeng(a, b) == null && model.searchPel(a, b) == null) {
                    model.setPeng(a, b);
                } else {
                    System.out.println("Akun Sudah terpakai");
                }
                System.out.println("1. Tambah Pengemudi");
                System.out.println("2. Selesai");
                System.out.print("Masukkan Pilihan Anda :  ");
                pal = can.nextInt();
                while (pal != 2) {
                    System.out.print("Masukkan Nama Anda : ");
                    a = cin.nextLine();
                    System.out.print("Masukkan Id Anda   : ");
                    b = cin.nextLine();
                    model.loadPengall();
                    model.loadPelall();
                    if (model.searchPeng(a, b) == null && model.searchPel(a, b) == null) {
                        model.setPeng(a, b);
                    } else {
                        System.out.println("Akun Sudah Terpakai");
                    }
                    System.out.println("1. Tambah Pengemudi");
                    System.out.println("2. Selesai");
                    System.out.print("Masukkan Pilihan Anda :  ");
                    pal = can.nextInt();
                }
            } else if (pil == 3) {
                System.out.print("Masukkan Nama Anda : ");
                c = cin.nextLine();
                System.out.print("Masukkan Id Anda   : ");
                d = cin.nextLine();
                model.loadPelall();
                if (model.LoginPel(c, d) != null) {
                    while (nemu != true) {
                        if (model.getPe(i).getId().equals(d) && model.getPe(i).getNama().equals(c)) {
                            nemu = true;
                        } else {
                            i++;
                        }
                    }
                }

                if (nemu == true) {
                    System.out.println("Login Sukses");
                    do {
                        System.out.println("1. Tambah Pesanan Transportasi ");
                        System.out.println("2. Batalkan Pesanan Transportasi ");
                        System.out.println("3. Lihat Pesanan ");
                        System.out.println("4. Tambah Pesanan Kurir ");
                        System.out.println("5. Batalkan Pesanan Kurir ");
                        System.out.println("6. Lihat Pesanan Kurir ");
                        System.out.println("7. Exit ");
                        System.out.print("Masukkan Pilihan Anda :  ");
                        pil = can.nextInt();
                        if (pil == 1) {
                            pal = 0;
                            while (pal != 2) {
                                System.out.print("Masukkan Asal Keberangkatan : ");
                                a = cin.nextLine();
                                System.out.print("Masukkan Tujuan             : ");
                                b = cin.nextLine();
                                model.getPe(i).createPesanan(a, b);
                                System.out.println("1. Tambah pesanan");
                                System.out.println("2. Selesai");
                                System.out.print("Masukkan Pilihan Anda :  ");
                                pal = can.nextInt();
                            }
                            pil = 0;
                        } else if (pil == 2) {
                            System.out.print("Masukkan ID Pemesanan yang akan dibatalkan : ");
                            a = cin.nextLine();
                            if (model.searchPesan(a) != null) {
                                model.deletePesananPelanggan(a);
                                System.out.println("Pesanan berhasil dibatalkan");
                                System.out.println("");
                            } else {
                                System.out.println("Pesanan tidak ada");
                                System.out.println("");
                            }

                        } else if (pil == 3) {
                            System.out.println("Nama Pelanggan : " + model.getPe(i).getNama());
                            for (int j = 0; j < model.getPe(i).getLength(); j++) {
                                System.out.println(j + 1 + "." + model.getPe(i).getPesanan(j).toString());
                                System.out.println("");
                            }
                            pil = 0;
                        } else if (pil == 4) {
                            System.out.print("Masukkan Jenis Kurir (Makanan / Paket / dll) : ");
                            a = cin.nextLine();
                            System.out.print("Masukkan Asal                                : ");
                            b = cin.nextLine();
                            System.out.print("Masukkan Tujuan                              : ");
                            c = cin.nextLine();
                            model.getPe(i).createKurir(a, b, c);
                        } else if (pil == 5) {
                            System.out.print("Masukkan ID Kurir yang akan dibatalkan : ");
                            a = cin.nextLine();
                            if (model.searchKurir(a) == null) {
                                System.out.println("Pesanan tidak ada");
                            } else {
                                System.out.println("Pesanan berhasil dibatalkan");
                                model.deleteKurirPelanggan(a);
                            }
                        } else if (pil == 6) {
                            for (int j = 0; j < model.getPe(i).getLengthk(); j++) {
                                System.out.println(j + 1 + "." + model.getPe(i).getKurir(j).toString());
                                System.out.println("");
                            }
                        }

                    } while (pil != 7);
                    nemu = false;
                    pil = 0;
                    i = 0;
                    System.out.println("Anda Telah Logout");
                } else {
                    System.out.println("Login Gagal");
                    i = 0;
                }
            } else if (pil == 4) {
                System.out.print("Masukkan Nama Anda : ");
                c = cin.nextLine();
                System.out.print("Masukkan Id Anda   : ");
                d = cin.nextLine();
                model.loadPengall();
                i = 0;
                if (model.LoginPeng(c, d) != null) {
                    while (nemu != true) {
                        if (model.getPeng(i).getId().equals(d) && model.getPeng(i).getNama().equals(c)) {
                            nemu = true;
                        } else {
                            i++;
                        }
                    }
                }
                if (nemu == true) {
                    System.out.println("Login Sukses");
                    while (pil != 7) {
                        System.out.println("1. Terima Pesanan ");
                        System.out.println("2. Lihat Pesanan Transportasi Yang anda Terima ");
                        System.out.println("3. Batalkan Pesanan ");
                        System.out.println("4. Terima Pesanan Kurir ");
                        System.out.println("5. Lihat Pesanan Kurir Yang anda Terima ");
                        System.out.println("6. Batalkan Pesanan ");
                        System.out.println("7. Exit");
                        System.out.print("Masukkan Pilihan Anda :  ");
                        pil = can.nextInt();
                        switch (pil) {
                            case 1:
                                int k = 0;
                                int j = 0;
                                for (j = 0; j < model.getsizePe(); j++) {
                                    for (k = 0; k < model.getPel(j).getLength(); k++) {
                                        System.out.println("Id Pelanggan      : " + model.getPel(j).getPk());
                                        System.out.println("Nama Pelanggan    : " + model.getPel(j).getNama());
                                        System.out.println(model.getPel(j).getPesanan(k).toString());
                                        System.out.println("");
                                    }
                                }
                                System.out.print("Masukkan Id Pemesanan : ");
                                b = cin.nextLine();
                                j = 0;
                                j = (Integer.parseInt(b) / 100) - 1;
                                model.getPel(j);
                                if (model.searchPesan(b) != null) {
                                    model.addPesananPengemudi(b, i);
                                    System.out.println("Pesanan Diambil");
                                    System.out.println("");
                                } else {
                                    System.out.println("Pesanan Tidak Ada");
                                    System.out.println("");
                                }
                                break;
                            case 2:
                                for (j = 0; j < model.getPeng(i).getLength(); j++) {
                                    System.out.println(j + 1 + ".Id Pesanan : " + model.getPeng(i).getPesanan(j).getId());
                                    System.out.println("  Asal       : " + model.getPeng(i).getPesanan(j).getAsal());
                                    System.out.println("  Tujuan     : " + model.getPeng(i).getPesanan(j).getTujuan());
                                    System.out.println("");
                                }
                                break;
                            case 3:
                                System.out.print("Masukkan ID Pemesanan yang akan dibatalkan : ");
                                a = cin.nextLine();
                                model.getPeng(i);
                                if (model.searchPesan(a) != null) {
                                    model.deletePesananPengemudi(a, i);
                                    System.out.println("Berhasil Dibatalkan");
                                    System.out.println("");
                                } else {
                                    System.out.println("Anda Tidak Mengambil Pesanan Tersebut");
                                    System.out.println("");
                                }
                                break;

                            case 4:
                                for (j = 0; j < model.getsizePe(); j++) {
                                    for (k = 0; k < model.getPel(j).getLengthk(); k++) {
                                        System.out.println("Id Pelanggan   : " + model.getPel(j).getPk());
                                        System.out.println("Nama Pelanggan : " + model.getPel(j).getNama());
                                        System.out.println("Id Kurir       : " + model.getPel(j).getKurir(k).getId());
                                        System.out.println("Jenis Kurir    : " + model.getPel(j).getKurir(k).getNama());
                                        System.out.println("Asal           : " + model.getPel(j).getKurir(k).getAsal());
                                        System.out.println("Tujuan         : " + model.getPel(j).getKurir(k).getTujuan());
                                        System.out.println("");
                                    }
                                }
                                System.out.print("Masukkan Id Pemesanan : ");
                                b = cin.nextLine();
                                j = 0;
                                j = (Integer.parseInt(b) / 100) - 1;
                                model.getPel(j);
                                if (model.searchKurir(b) != null) {
                                    model.addKurirPengemudi(b, i);
                                    System.out.println("Pesanan Diambil");
                                    System.out.println("");
                                } else {
                                    System.out.println("Pesanan Tidak Ada");
                                    System.out.println("");
                                }
                                break;
                            case 5:
                                for (j = 0; j < model.getPeng(i).getLengthk(); j++) {
                                    System.out.println(j + 1 + ".Id Pesanan : " + model.getPeng(i).getKurir(j).getId());
                                    System.out.println("  Asal       : " + model.getPeng(i).getKurir(j).getAsal());
                                    System.out.println("  Tujuan     : " + model.getPeng(i).getKurir(j).getTujuan());
                                    System.out.println("  Jenis      : " + model.getPeng(i).getKurir(j).getNama());
                                    System.out.println("");
                                }
                                break;
                            case 6:
                                System.out.print("Masukkan ID Pemesanan yang akan dibatalkan : ");
                                a = cin.nextLine();
                                model.getPeng(i);
                                if (model.searchKurir(a) != null) {
                                    model.deleteKurirPengemudi(a, i);
                                    System.out.println("Berhasil Dibatalkan");
                                    System.out.println("");
                                } else {
                                    System.out.println("Anda Tidak Mengambil Pesanan Tersebut");
                                    System.out.println("");
                                }
                                break;
                            case 7:
                                break;
                        }
                    }
                    nemu = false;
                    pil = 0;
                    i = 0;

                } else {
                    System.out.println("Login Gagal");
                    i = 0;
                }
            }
        } while (pil != 5);

    }

}
