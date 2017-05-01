/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author SagabAdi
 */
public class Controller3 {

    private Model model;
    private G3 g3;
    int x;

    public Controller3(G3 g3, Model model, int i) {
        this.model = model;
        this.g3 = g3;
        this.x = i;
        for (int j = 0; j < model.getsizePe(); j++) {
            for (int k = 0; k < model.getPel(j).getLength(); k++) {
                g3.settable(model.getPel(j).getPk(), model.getPel(j).getNama(), model.getPel(j).getPesanan(k).getId(), model.getPel(j).getPesanan(k).getAsal(), model.getPel(j).getPesanan(k).getTujuan());
            }
        }
        for (int j = 0; j < model.getsizePe(); j++) {
            for (int k = 0; k < model.getPel(j).getLengthk(); k++) {
                g3.settable1(model.getPel(j).getPk(), model.getPel(j).getNama(), model.getPel(j).getKurir(k).getId(), model.getPel(j).getKurir(k).getNama(), model.getPel(j).getKurir(k).getAsal(), model.getPel(j).getKurir(k).getTujuan());
            }
        }
        for (int j = 0; j < model.getPeng(i).getLength(); j++) {
            g3.settterima(model.getPeng(i).getPesanan(j).getId(), model.getPeng(i).getPesanan(j).getAsal(), model.getPeng(i).getPesanan(j).getTujuan());
        }
        for (int j = 0; j < model.getPeng(i).getLengthk(); j++) {
            g3.settterima1(model.getPeng(i).getKurir(j).getId(), model.getPeng(i).getKurir(j).getNama(), model.getPeng(i).getKurir(j).getAsal(), model.getPeng(i).getKurir(j).getTujuan());
        }

        g3.Listener1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b;
                boolean nemu = false;
                int i = 0;
                int j = 0;
                b = g3.getTerima2();
                i = (Integer.parseInt(b) / 100) - 1;
                model.getPel(i);
                if (model.searchPesan(b) != null) {
                    while (nemu != true) {
                        if (model.getPel(i).getPesanan(j).getId().equals(b)) {
                            nemu = true;
                        } else {
                            j++;
                        }
                    }
                    Pesanan p = new Pesanan(model.getPel(i).getPesanan(j).getId(), model.getPel(i).getPesanan(j).getAsal(), model.getPel(i).getPesanan(j).getTujuan());
                    model.getPeng(x).addPesanan(p);
                    JOptionPane.showMessageDialog(null, "Pesanan telah diambil");
                    g3.settterima(model.getPel(i).getPesanan(j).getId(), model.getPel(i).getPesanan(j).getAsal(), model.getPel(i).getPesanan(j).getTujuan());
                    model.addPesananPengemudi(b, x);
                    g3.reset();
                } else {
                    JOptionPane.showMessageDialog(null, "Pesanan Tidak Ada atau Pesanan telah diambil sebelumnya !!");
                    g3.reset();
                }
                g3.reset();
            }
        });
        g3.Listener2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a;
                if (g3.getBatals2().equals("")) {
                    JOptionPane.showMessageDialog(null, "Isi Dengan Benar !! ");
                } else {
                    a = g3.getBatals2();
                    if (model.getPeng(i).getLength() == 0) {
                        JOptionPane.showMessageDialog(null, "PESANAN KOSONG !!");
                        g3.reset();
                    } else {
                        model.getPeng(i);
                        if (model.searchPesan(a) != null) {
                            JOptionPane.showMessageDialog(null, "Pesanan Berhasil Dibatalkan");
                            g3.reset();
                            int n = 0;
                            boolean nemu = false;
                            while (nemu != true) {
                                if (model.getPeng(i).getPesanan(n).getId().equals(a)) {
                                    nemu = true;
                                } else {
                                    n++;
                                }
                            }
                            g3.removeRow(n);
                            model.deletePesananPengemudi(a, x);
//                            model.getPeng(i).Removepesanan(n);
                        } else {
                            JOptionPane.showMessageDialog(null, "Gagal");
                        }
                        g3.reset();
                    }
                }
            }

        });
        g3.Listener3(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g3.dispose();
                G1 g = new G1();
                Controller c = new Controller(g, model);
                g.setVisible(true);
            }
        });
        g3.Listener4(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b;
                boolean nemu = false;
                int i = 0;
                int j = 0;
                b = g3.getTerima4();
                i = (Integer.parseInt(b) / 100) - 1;
                model.getPel(i);
                if (model.searchKurir(b) != null) {
                    while (nemu != true) {
                        if (model.getPel(i).getKurir(j).getId().equals(b)) {
                            nemu = true;
                        } else {
                            j++;
                        }
                    }
                    Kurir p = new Kurir(model.getPel(i).getKurir(j).getId(), model.getPel(i).getKurir(j).getNama(), model.getPel(i).getKurir(j).getAsal(), model.getPel(i).getKurir(j).getTujuan());
                    model.getPeng(x).addKurir(p);
                    JOptionPane.showMessageDialog(null, "Pesanan telah diambil");
                    g3.settterima1(model.getPel(i).getKurir(j).getId(), model.getPel(i).getKurir(j).getNama(), model.getPel(i).getKurir(j).getAsal(), model.getPel(i).getKurir(j).getTujuan());
                    model.addKurirPengemudi(b, x);
                    g3.reset();
                } else {
                    JOptionPane.showMessageDialog(null, "Pesanan Tidak Ada atau Pesanan telah diambil sebelumnya !!");
                    g3.reset();
                }

            }
        });
        g3.Listener5(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a;
                if (g3.getBatals3().equals("")) {
                    JOptionPane.showMessageDialog(null, "Isi Dengan Benar !! ");
                } else {
                    a = g3.getBatals3();
                    if (model.getPeng(i).getLengthk() == 0) {
                        JOptionPane.showMessageDialog(null, "PESANAN KOSONG !!");
                        g3.reset();
                    } else {
                        model.getPeng(i);
                        if (model.searchKurir(a) != null) {
                            JOptionPane.showMessageDialog(null, "Pesanan Berhasil Dibatalkan");
                            g3.reset();
                            int n = 0;
                            boolean nemu = false;
                            while (nemu != true) {
                                if (model.getPeng(i).getKurir(n).getId().equals(a)) {
                                    nemu = true;
                                } else {
                                    n++;
                                }
                            }
                            g3.removeRowk(n);
                            model.deleteKurirPengemudi(a, x);
//                            model.getPeng(i).Removekurir(n);
                        } else {
                            JOptionPane.showMessageDialog(null, "Gagal");
                        }
                        g3.reset();
                    }
                }
            }
        });
    }
}
