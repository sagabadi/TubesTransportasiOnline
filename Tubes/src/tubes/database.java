/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SagabAdi
 */
public class database {

    private String url = "jdbc:mysql://localhost/tubes";
    private String username = "root";
    private String pass = "";
    private Connection con;

    public void connect() {
        try {
            con = DriverManager.getConnection(url, username, pass);
            con.setAutoCommit(false);
            System.out.println("Connected");
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Gagal Konek" + ex.getMessage());
        }
    }

    public void savePelanggan(Pelanggan p) {
        try {
            String query = "insert into pelanggan values ("
                    + "'" + p.getPk() + "','" + p.getId() + "','" + p.getNama() + "');";
            Statement stmt = con.createStatement();
            stmt.execute(query);
            con.commit();
            stmt.close();
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Gagal save " + ex.getMessage());
        }
    }

    public void savePengemudi(Pengemudi p) {
        try {
            String query = "insert into pengemudi values ( "
                    + "'" + p.getPk() + "','" + p.getId() + "','" + p.getNama() + "');";
            Statement stmt = con.createStatement();
            stmt.execute(query);
            con.commit();
            stmt.close();
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Error " + ex.getMessage());
        }
    }

    public void savePesananPelanggan(String p, Pesanan pe) {
        try {
            String query = "insert into pesanan values (" + "'" + pe.getId()
                    + "','" + pe.getAsal() + "','" + pe.getTujuan() + "','"
                    + p + "','');";
            Statement stmt = con.createStatement();
            stmt.execute(query);
            con.commit();
            stmt.close();
        } catch (SQLException ex) {
            throw new IllegalArgumentException("gagal " + ex.getMessage());
        }
    }

    public void saveKurirPelanggan(String p, Kurir k) {
        try {
            String query = "insert into kurir values (" + "'" + k.getIdKurir()
                    + "','" + k.getAsal() + "','" + k.getTujuan() + "','"
                    + k.getNama() + "','" + p + "','');";
            Statement stmt = con.createStatement();
            stmt.execute(query);
            con.commit();
            stmt.close();
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Gagal " + ex.getMessage());
        }
    }

    public void addPesananPengemudi(Pesanan p, Pengemudi peng) {
        try {
            String query = "update pesanan set pk_peng = '" + peng.getPk()
                    + "' where id = '" + p.getId() + "';";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            con.commit();
            stmt.close();
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Error " + ex.getMessage());
        }
    }

    public void addKurirPengemudi(Kurir k, Pengemudi peng) {
        try {
            String query = "update kurir set pk_peng = '" + peng.getPk() 
                    + "' where id_kur = '" + k.getId() + "';";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            con.commit();
            stmt.close();
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Error " + ex.getMessage());
        }
    }

    public ArrayList<Pelanggan> loadPelanggan() {
        try {
            Pelanggan p;
            ArrayList<Pelanggan> pel = new ArrayList();
            String query = "select * from pelanggan;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String pk = rs.getString("pk_pel");
                String id = rs.getString("id");
                String nama = rs.getString("nama");
                p = new Pelanggan(nama, id, pk, pel.size() + 1);
                pel.add(p);
            }
            return pel;
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Error " + ex.getMessage());
        }
    }

    public ArrayList<Pengemudi> loadPengemudi() {
        try {
            Pengemudi p;
            ArrayList<Pengemudi> peng = new ArrayList();
            String query = "select * from pengemudi";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String pk = rs.getString("pk_peng");
                String id = rs.getString("id");
                String nama = rs.getString("nama");
                p = new Pengemudi(nama, id, pk);
                peng.add(p);
            }
            return peng;
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Error" + ex.getMessage());
        }
    }

    public ArrayList<Pesanan> loadPesananPelanggan(Pelanggan p) {
        try {
            ArrayList<Pesanan> pe = new ArrayList();
            Pesanan pes;
            String query = "select * from pesanan where pk_pel = '" + p.getPk() + "';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                pes = new Pesanan(rs.getString("id"), rs.getString("asal"), rs.getString("tujuan"));
                pe.add(pes);
            }
            return pe;
        } catch (SQLException ex) {
            throw new IllegalArgumentException("gagal " + ex.getMessage());
        }
    }

    public ArrayList<Kurir> loadKurirPelanggan(Pelanggan p) {
        try {
            ArrayList<Kurir> k = new ArrayList();
            Kurir kur;
            String query = "select * from kurir where pk_pel = '" + p.getPk() + "';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                kur = new Kurir(rs.getString("id_kur"), rs.getString("nama"), rs.getString("asal"), rs.getString("tujuan"));
                k.add(kur);
            }
            return k;
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Error " + ex.getMessage());
        }
    }

    public ArrayList<Pesanan> loadPesananPelangganal(Pelanggan p) {
        try {
            ArrayList<Pesanan> pe = new ArrayList();
            Pesanan pes;
            String query = "select * from pesanan where pk_pel = '" + p.getPk() + "' and pk_peng = '';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                pes = new Pesanan(rs.getString("id"), rs.getString("asal"), rs.getString("tujuan"));
                pe.add(pes);
            }
            return pe;
        } catch (SQLException ex) {
            throw new IllegalArgumentException("gagal " + ex.getMessage());
        }
    }

    public ArrayList<Kurir> loadKurirPelangganal(Pelanggan p) {
        try {
            ArrayList<Kurir> k = new ArrayList();
            Kurir kur;
            String query = "select * from kurir where pk_pel = '" + p.getPk() + "' and pk_peng = '';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                kur = new Kurir(rs.getString("id_kur"), rs.getString("nama"), rs.getString("asal"), rs.getString("tujuan"));
                k.add(kur);
            }
            return k;
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Error " + ex.getMessage());
        }
    }

    public ArrayList<Pesanan> loadPesananPelangganall() {
        try {
            ArrayList<Pesanan> pe = new ArrayList();
            Pesanan pes;
            String query = "select * from pesanan where pk_peng = '';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                pes = new Pesanan(rs.getString("id"), rs.getString("asal"), rs.getString("tujuan"));
                pe.add(pes);
            }
            return pe;
        } catch (SQLException ex) {
            throw new IllegalArgumentException("gagal " + ex.getMessage());
        }
    }

    public ArrayList<Kurir> loadKurirPelangganall() {
        try {
            ArrayList<Kurir> k = new ArrayList();
            Kurir kur;
            String query = "select * from kurir where pk_peng= '';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                kur = new Kurir(rs.getString("id_kur"), rs.getString("nama"), rs.getString("asal"), rs.getString("tujuan"));
                k.add(kur);
            }
            return k;
        } catch (SQLException ex) {
            throw new IllegalArgumentException("gagal " + ex.getMessage());
        }
    }

    public ArrayList<Pesanan> loadPesananPelangganalll(Pengemudi p) {
        try {
            ArrayList<Pesanan> pe = new ArrayList();
            Pesanan pes;
            String query = "select * from pesanan where pk_peng = '" + p.getPk() + "';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                pes = new Pesanan(rs.getString("id"), rs.getString("asal"), rs.getString("tujuan"));
                pe.add(pes);
            }
            return pe;
        } catch (SQLException ex) {
            throw new IllegalArgumentException("gagal " + ex.getMessage());
        }
    }

    public ArrayList<Kurir> loadKurirPelangganalll(Pengemudi p) {
        try {
            ArrayList<Kurir> k = new ArrayList();
            Kurir kur;
            String query = "select * from kurir where pk_peng = '" + p.getPk() + "';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                kur = new Kurir(rs.getString("id_kur"), rs.getString("nama"), rs.getString("asal"), rs.getString("tujuan"));
                k.add(kur);
            }
            return k;
        } catch (SQLException ex) {
            throw new IllegalArgumentException("gagal " + ex.getMessage());
        }
    }

    public void delPesananPelanggan(Pesanan p) {
        try {
            String query = "delete from pesanan where id = '" + p.getId() + "';";
            Statement stmt = con.createStatement();
            stmt.execute(query);
            con.commit();
            stmt.close();
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Error " + ex.getMessage());
        }
    }

    public void delKurirPelanggan(Kurir k) {
        try {
            String query = "delete from kurir where id_kur = '" + k.getIdKurir() + "';";
            Statement stmt = con.createStatement();
            stmt.execute(query);
            con.commit();
            stmt.close();
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Error " + ex.getMessage());
        }
    }

    public void delPesananPengemudi(Pesanan p, Pengemudi peng) {
        try {
            String query = "update pesanan set pk_peng = '' where id = '" + p.getId() + "' "
                    + "and pk_peng = '" + peng.getPk() + "';";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            con.commit();
            stmt.close();
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Error " + ex.getMessage());
        }
    }

    public void delKurirPengemudi(Kurir p, Pengemudi peng) {
        try {
            String query = "update kurir set pk_peng = '' where id_kur = '" + p.getId() + "'"
                    + "and pk_peng = '" + peng.getPk() + "';";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            con.commit();
            stmt.close();
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Error " + ex.getMessage());
        }
    }

}
