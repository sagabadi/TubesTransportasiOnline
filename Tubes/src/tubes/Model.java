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
public class Model {

    private ArrayList<Pelanggan> pe = new ArrayList();
    private ArrayList<Pengemudi> peng = new ArrayList();
    private ArrayList<Pesanan> pes = new ArrayList();
    private ArrayList<Kurir> kur = new ArrayList();
    private database db;

    public Model() {
        db = new database();
        db.connect();
    }
    
    public void loadPelall (){
        pe = db.loadPelanggan();
    }
    
    public void loadPengall (){
        peng = db.loadPengemudi();
    }
    
    public int getsizePe (){
        return pe.size();
    }
    
    public int getsizePeng(){
        return peng.size();
    }
    
    public int getsizePes(){
        return pes.size();
    }
    
    public int getsizeKur(){
        return kur.size();
    }

    public Pelanggan getPe(int i) {
        pe = db.loadPelanggan();
        pe.get(i).setDb(db);
        pes = db.loadPesananPelanggan(pe.get(i));
        kur = db.loadKurirPelanggan(pe.get(i));
        pe.get(i).setPesanan(pes);
        pe.get(i).setKurir(kur);
        return pe.get(i);
    }

    public Pelanggan getPel(int i) {
        pe = db.loadPelanggan();
        pe.get(i).setDb(db);
        pes = db.loadPesananPelangganal(pe.get(i));
        kur = db.loadKurirPelangganal(pe.get(i));
        pe.get(i).setPesanan(pes);
        pe.get(i).setKurir(kur);
        return pe.get(i);
    }

    public void setPe(String a, String b) {
        pe = db.loadPelanggan();
        String c;
        if (pe.size() == 0) {

            c = (Integer.toString(pe.size() + 1));
        } else {
            c = (Integer.toString(Integer.parseInt(pe.get(pe.size() - 1).getPk()) + 1));
        }
        Pelanggan p = new Pelanggan(a, b, c, (pe.size() + 1));
        db.savePelanggan(p);
        pe.add(p);
    }

    public Pengemudi getPeng(int i) {
        peng = db.loadPengemudi();
        pes = db.loadPesananPelangganalll(peng.get(i));
        kur = db.loadKurirPelangganalll(peng.get(i));
        peng.get(i).setPesanan(db.loadPesananPelangganalll(peng.get(i)));
        peng.get(i).setKurir(db.loadKurirPelangganalll(peng.get(i)));
        pe = db.loadPelanggan();
        return peng.get(i);
    }

    public Pengemudi getPenge(int i) {
        peng = db.loadPengemudi();
        pes = db.loadPesananPelangganalll(peng.get(i));
        kur = db.loadKurirPelangganalll(peng.get(i));
        peng.get(i).setPesanan(db.loadPesananPelangganalll(peng.get(i)));
        peng.get(i).setKurir(db.loadKurirPelangganalll(peng.get(i)));
        pe = db.loadPelanggan();
        return peng.get(i);
    }

    public void setPeng(String a, String b) {
        String c;
        if (peng.size() == 0) {

            c = (Integer.toString(peng.size() + 1));
        } else {
            c = (Integer.toString(Integer.parseInt(peng.get(peng.size() - 1).getPk()) + 1));
        }
        Pengemudi pe = new Pengemudi(a, b, c);
        db.savePengemudi(pe);
        peng.add(pe);
    }

    public Pelanggan searchPel(String Nama, String Id) {
        Pelanggan p = null;
        for (Pelanggan pel : pe) {
            if (pel.getNama().equals(Nama)) {
                p = pel;
            }
        }
        return p;
    }

    public Pelanggan LoginPel(String Nama, String Id) {
        Pelanggan p = null;
        for (Pelanggan pel : pe) {
            if (pel.getNama().equals(Nama) && pel.getId().equals(Id)) {
                p = pel;
            }
        }
        return p;
    }

    public Pengemudi searchPeng(String Nama, String Id) {
        Pengemudi p = null;
        for (Pengemudi pel : peng) {
            if (pel.getNama().equals(Nama)) {
                p = pel;
            }
        }
        return p;
    }

    public Pengemudi LoginPeng(String Nama, String Id) {
        Pengemudi p = null;
        for (Pengemudi pel : peng) {
            if (pel.getNama().equals(Nama) && pel.getId().equals(Id)) {
                p = pel;
            }
        }
        return p;
    }

    public Pesanan searchPesan(String s) {
        Pesanan pesan = null;
        for (Pesanan p : pes) {
            if (p.getId().equals(s)) {
                pesan = p;
            }
        }
        return pesan;
    }

    public Kurir searchKurir(String s) {
        Kurir kur = null;
        for (Kurir k : this.kur) {
            if (k.getIdKurir().equals(s)) {
                kur = k;
            }
        }
        return kur;
    }

    public void addPesananPengemudi(String a, int i) {
        Pesanan p = searchPesan(a);
        Pengemudi peng = this.peng.get(i);
        db.addPesananPengemudi(p, peng);
    }

    public void addKurirPengemudi(String a, int i) {
        Kurir p = searchKurir(a);
        Pengemudi peng = this.peng.get(i);
        db.addKurirPengemudi(p, peng);
    }

    public void deletePesananPelanggan(String a) {
        Pesanan p = searchPesan(a);
        db.delPesananPelanggan(p);
    }

    public void deleteKurirPelanggan(String a) {
        Kurir k = searchKurir(a);
        db.delKurirPelanggan(k);
    }

    public void deletePesananPengemudi(String a, int i) {
        Pesanan p = searchPesan(a);
        db.delPesananPengemudi(p, peng.get(i));
    }

    public void deleteKurirPengemudi(String a, int i) {
        Kurir p = searchKurir(a);
        db.delKurirPengemudi(p, peng.get(i));
    }
}
