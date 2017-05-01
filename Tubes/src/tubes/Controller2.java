/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author SagabAdi
 */
public class Controller2 {

    private Model model;
    private G2 g2;
    int l = 0;
    private ArrayList<String> jenis = new ArrayList();

    public Controller2(G2 g2, Model model, int i) {
        jenis.add("Makanan");
        jenis.add("Paket");
        this.g2 = g2;
        this.model = model;
        if (model.getPe(i).getLength() >= 0) {
            for (int j = 0; j < model.getPe(i).getLength(); j++) {
                g2.setTpesan(model.getPe(i).getPesanan(j).getId(), model.getPe(i).getPesanan(j).getAsal(), model.getPe(i).getPesanan(j).getTujuan());
            }
        }
        if (model.getPe(i).getLengthk() >= 0) {
            for (int j = 0; j < model.getPe(i).getLengthk(); j++) {
                g2.setTkurir(model.getPe(i).getKurir(j).getId(), model.getPe(i).getKurir(j).getNama(), model.getPe(i).getKurir(j).getAsal(), model.getPe(i).getKurir(j).getTujuan());

            }
        }
        g2.setUse(model.getPe(i).getNama(), model.getPe(i).getPk());
        this.g2.addListener1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a, b;
                if (g2.getAsal().equals("") || g2.getTujuan().equals("")) {
                    JOptionPane.showMessageDialog(null, "Isi Dengan Benar !!");
                    g2.reset();
                } else {
                    a = g2.getAsal();
                    b = g2.getTujuan();
                    model.getPe(i).createPesanan(a, b);
                    l = model.getsizePes();
                    JOptionPane.showMessageDialog(null, "Pesanan Berhasil");
                    g2.reset();
                    g2.setTpesan(model.getPe(i).getPesanan(l - 1).getId(), model.getPe(i).getPesanan(l - 1).getAsal(), model.getPe(i).getPesanan(l - 1).getTujuan());
                }

            }
        });
        this.g2.addListener2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String j;
                if (g2.getBatals().equals("")) {
                    JOptionPane.showMessageDialog(null, "Isi Dengan Benar !! ");
                } else {
                    j = g2.getBatals();
                    if (model.getPe(i).getLength() == 0) {
                        JOptionPane.showMessageDialog(null, "PESANAN KOSONG !!");
                        g2.reset();
                    } else {
                        int n = 0;
                        boolean nemu = false;
                        if (model.searchPesan(j) != null) {
                            while (nemu != true) {
                                if (model.getPe(i).getPesanan(n).getId().equals(j)) {
                                    nemu = true;
                                } else {
                                    n++;
                                }
                            }
                            g2.removeRow(n);
                            model.deletePesananPelanggan(j);
                            JOptionPane.showMessageDialog(null, "Pesanan Berhasil Dibatalkan");
                        } else {
                            JOptionPane.showMessageDialog(null, "Pesanan Tidak Ada");
                        }
                        g2.reset();
                    }
                }
            }
        });
        this.g2.addListener3(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g2.dispose();
                G1 g = new G1();
                Controller c = new Controller(g, model);
                g.setVisible(true);
            }
        });
        this.g2.addListener4(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a, b;
                if (g2.getAsal1().equals("") || g2.getTujuan1().equals("")) {
                    JOptionPane.showMessageDialog(null, "Isi Dengan Benar !!");
                    g2.reset();
                } else {
                    a = g2.getAsal1();
                    b = g2.getTujuan1();
                    model.getPe(i).createKurir(jenis.get(g2.getJeniskurir()), a, b);
                    l = model.getsizeKur();
                    JOptionPane.showMessageDialog(null, "Pesanan Berhasil");
                    g2.reset();
                    g2.setTkurir(model.getPe(i).getKurir(l - 1).getId(), model.getPe(i).getKurir(l - 1).getNama(), model.getPe(i).getKurir(l - 1).getAsal(), model.getPe(i).getKurir(l - 1).getTujuan());
                }
            }
        });
        this.g2.addListener5(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String j;
                if (g2.getBatals1().equals("")) {
                    JOptionPane.showMessageDialog(null, "Isi Dengan Benar !! ");
                } else {
                    j = g2.getBatals1();
                    if (model.getPe(i).getLengthk() == 0) {
                        JOptionPane.showMessageDialog(null, "PESANAN KOSONG !!");
                        g2.reset();
                    } else {
                        int n = 0;
                        boolean nemu = false;
                        if (model.searchKurir(j) != null) {
                            while (nemu != true) {
                                if (model.getPe(i).getKurir(n).getId().equals(j)) {
                                    nemu = true;
                                } else {
                                    n++;
                                }
                            }
                            model.deleteKurirPelanggan(j);
                            g2.removeRowk(n);
                            JOptionPane.showMessageDialog(null, "Pesanan Berhasil Dibatalkan");
                        } else {
                            JOptionPane.showMessageDialog(null, "Pesanan Tidak Ada");
                        }
                        g2.reset();
                    }
                }
            }
        });
    }
}
