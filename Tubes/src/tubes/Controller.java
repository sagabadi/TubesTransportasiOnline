/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import com.sun.javafx.css.CalculatedValue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author SagabAdi
 */
public class Controller {

    private Model model;
    private G1 g;

    public Controller(G1 g, Model model) {
        this.g = g;
        this.model = model;
        this.g.addListen1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String a, b;
                if (g.getNama().equals("") || g.getPass().equals("")) {
                    JOptionPane.showMessageDialog(null, "Isi Dengan Benar !!");
                    g.reset();
                } else {
                    a = g.getNama();
                    b = g.getPass();
                    model.loadPelall();
                    model.loadPengall();
                    if (model.searchPel(a, b) == null && model.searchPeng(a, b) == null) {
                        model.setPe(a, b);
                        JOptionPane.showMessageDialog(null, "Pelanggan Berhasil Ditambah");
                    } else {
                        JOptionPane.showMessageDialog(null, "Akun Sudah Terpakai !!");
                    }
                    g.reset();
                }
            }
        });
        this.g.addListen2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a, b;
                if (g.getNama().equals("") || g.getPass().equals("")) {
                    JOptionPane.showMessageDialog(null, "Isi Dengan Benar !!");
                    g.reset();
                } else {
                    a = g.getNama();
                    b = g.getPass();
                    model.loadPengall();
                    model.loadPengall();
                    if (model.searchPeng(a, b) == null && model.searchPel(a, b) == null) {
                        model.setPeng(a, b);
                        JOptionPane.showMessageDialog(null, "Pengemudi Berhasil Ditambah");
                        g.reset();
                    } else {
                        JOptionPane.showMessageDialog(null, "Akun Sudah Terpakai !!");
                    }
                    g.reset();
                }
            }
        });
        this.g.addListen3(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a, b;
                int i = 0;
                int j = 0;
                boolean nemu = false;
                a = g.getNama();
                b = g.getPass();
                model.loadPelall();
                if (model.LoginPel(a, b) != null) {
                    while (nemu != true) {
                        if (model.getPe(i).getNama().equals(a) && model.getPe(i).getId().equals(b)) {
                            nemu = true;
                        } else {
                            i++;
                        }
                    }
                }
                if (nemu == true) {
                    JOptionPane.showMessageDialog(null, "Berhasil Login");
                    g.dispose();
                    G2 g2 = new G2();
                    Controller2 c = new Controller2(g2, model, i);
                    g2.setVisible(true);
                } else if (nemu == false || model.getsizePe() == 0) {
                    JOptionPane.showMessageDialog(null, "Gagal Login");
                    g.reset();
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal Login");
                    g.reset();
                }
            }
        }
        );

        this.g.addListen4(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a, b;
                int i = 0;
                boolean nemu = false;
                a = g.getNama();
                b = g.getPass();
                model.loadPengall();
                if (model.LoginPeng(a, b) != null) {
                    while (nemu != true) {
                        if (model.getPeng(i).getNama().equals(a) && model.getPeng(i).getId().equals(b)) {
                            nemu = true;
                        } else {
                            i++;
                        }
                    }
                }
                if (nemu == true) {
                    JOptionPane.showMessageDialog(null, "Berhasil Login");
                    g.dispose();
                    G3 g3 = new G3();
                    Controller3 c = new Controller3(g3, model, i);
                    g3.setVisible(true);
                } else if (nemu == false || model.getsizePeng() == 0) {
                    JOptionPane.showMessageDialog(null, "Gagal Login");
                    g.reset();
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal Login");
                    g.reset();
                }
            }
        }
        );
    }

}
