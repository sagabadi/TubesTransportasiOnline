/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SagabAdi
 */
public class Pelanggan extends Orang {

    private ArrayList<Pesanan> pesanan = new ArrayList();
    private ArrayList<Kurir> kurir = new ArrayList();
    private String Nama;
    private String id, pk;
    private int i;
    private int length;
    private database db;

    public Pelanggan(String Nama, String id, String pk, int i) {
        super(Nama, id, pk);
        this.i = i;

    }

    public void createPesanan(String Asal, String Tujuan) {
        boolean nemu = false;
        Pesanan p = new Pesanan(Asal, Tujuan);
        if (pesanan.size() == 0) {
            p.setId(Integer.toString((this.i * 100) + (pesanan.size() + 1)));
        } else {
            p.setId(Integer.toString(Integer.parseInt(pesanan.get(pesanan.size() - 1).getId()) + 1));
        }
        db.savePesananPelanggan(Integer.toString(i), p);
        pesanan.add(p);
    }

    public void createKurir(String nama, String Asal, String Tujuan) {
        boolean nemu = false;
        Kurir p;

        if (kurir.size() == 0) {
            p = new Kurir(Integer.toString((this.i * 100) + (kurir.size() + 1)), nama, Asal, Tujuan);
        } else {
            p = new Kurir(Integer.toString(Integer.parseInt(kurir.get(kurir.size() - 1).getId()) + 1), nama, Asal, Tujuan);
        }
        db.saveKurirPelanggan(Integer.toString(i), p);
        kurir.add(p);

    }

    public void setPesanan(ArrayList<Pesanan> pesanan) {
        this.pesanan = pesanan;
    }

    public void setKurir(ArrayList<Kurir> kurir) {
        this.kurir = kurir;
    }

    public ArrayList<Pesanan> getPes() {
        return pesanan;
    }

    public ArrayList<Kurir> getKur() {
        return kurir;
    }

    public void setDb(database db) {
        this.db = db;
    }

    public String getPk() {
        return super.getPk();
    }

    public String getNama() {
        return super.getNama();
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getId() {
        return super.getId();
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pesanan getPesanan(int i) {
        return pesanan.get(i);
    }

    public Pesanan getPesan(String s) {
        Pesanan pes = null;
        for (Pesanan p : pesanan ){
            if (p.getId().equals(s)){
                pes = p;
            }
        }
        return pes;
    }

    public Pesanan getKurir(int i) {
        return kurir.get(i);
    }
    
    public Pesanan getKurirr(String s) {
        Kurir kur = null;
        for (Kurir k : kurir){
            if (k.getIdKurir().equals(s)){
                kur = k;
            }
        }
        return kur;
    }

    public int getLength() {
        return pesanan.size();
    }

    public int getLengthk() {
        return kurir.size();
    }

    public void Removepesanan(int i) {
        pesanan.remove(i);

    }
    
    public void Removepesan(Pesanan p) {
        pesanan.remove(p);

    }

    public void Removekurir(int i) {
        kurir.remove(i);

    }

}
