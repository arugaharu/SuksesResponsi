/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lombaDAO;
import implemen.Lombaimplemen;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.*;
import konektor.Konektordb;
import model.datalomba;
import model.modeltabeldata;
/**
 *
 * @author Lab Informatika
 */
public class LombaDAO implements Lombaimplemen {
    Connection connection;
    final String select = "SELECT * FROM datalomba";
    final String selectJudul = "SELECT * FROM datalomba WHERE judul=?";
    final String selectAlur = "SELECT * FROM datalomba WHERE alur=?";
    final String selectOrisinalitas = "SELECT * FROM datalomba WHERE orisinalitas=?";
    final String selectPemilihan = "SELECT * FROM datalomba WHERE pemilihan=?";
    final String selectNilai = "SELECT * FROM datalomba WHERE nilai=?";
    final String insert = "INSERT INTO datalomba(judul, alur, orisinalitas, pemilihan, nilai) VALUES (?,?,?,?,?,?)";
    final String update = "UPDATE datalomba SET judul=?, alur=?, orisinalitas=?, pemilihan=?, nilai=?, WHERE judul=?";
    final String delete = "DELETE FROM datalomba WHERE judul=?";
    
    public LombaDAO(){
        connection = Konektordb.BukaKoneksi();
    }
     
    @Override
    public void insert(datalomba data) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, data.getJudul());
            statement.setInt(2, data.getAlur());
            statement.setInt(3, data.getOrisinalitas());
            statement.setInt(4, data.getPemilihan());
            statement.setInt(5, data.getNilai());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                data.setJudul(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(datalomba data) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, data.getJudul());
            statement.setInt(2, data.getAlur());
            statement.setInt(3, data.getOrisinalitas());
            statement.setInt(4, data.getPemilihan());
            statement.setInt(5, data.getNilai());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<datalomba> getAll() {
        List<datalomba> data = null;
        try {
            data = new ArrayList<datalomba>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                datalomba datal = new datalomba();
                datal.setJudul(rs.getString("judul"));
                datal.setAlur(rs.getInt("genre"));
                datal.setOrisinalitas(rs.getInt("penulis"));
                datal.setPemilihan(rs.getInt("penerbit"));
                datal.setNilai(rs.getInt("lokasi"));
                data.add(datal);
            }
        } catch (Exception e) {
            Logger.getLogger(LombaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return data;
    }
 
    @Override
    public List<datalomba> cariJudul(datalomba data) {
        List<datalomba> datat = null;
        PreparedStatement statement = null;
        try {
            datat = new ArrayList<datalomba>();
            statement = connection.prepareStatement(selectJudul);
            statement.setString(1, data.getJudul());
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                datalomba datal = new datalomba();
                datal.setJudul(rs.getString("judul"));
                datal.setAlur(rs.getInt("alur"));
                datal.setOrisinalitas(rs.getInt("orisinalitas"));
                datal.setPemilihan(rs.getInt("pemilihan"));
                datal.setNilai(rs.getInt("nilai"));
                datat.add(datal);
            }
        } catch (SQLException e) {
            Logger.getLogger(LombaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datat;
    }

    @Override
    public List<datalomba> cariAlur(datalomba data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<datalomba> cariOrisinalitas(datalomba data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<datalomba> cariPemilihan(datalomba data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<datalomba> cariNilai(datalomba data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
