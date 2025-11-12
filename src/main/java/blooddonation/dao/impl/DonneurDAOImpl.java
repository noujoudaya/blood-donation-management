/*
package blooddonation.dao;

import blooddonation.bean.Donneur;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonneurDAOImpl implements DonneurDAO {

    private Connection conn;

    public DonneurDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addDonneur(Donneur d) {
        try {
            String sql = "INSERT INTO Donneur(nom, prenom, email, password, phoneNum, adresse, role, groupeSanguin, dateDernierDon, disponibilite) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getNom());
            ps.setString(2, d.getPrenom());
            ps.setString(3, d.getEmail());
            ps.setString(4, d.getPassword());
            ps.setString(5, d.getPhoneNum());
            ps.setString(6, d.getAdresse());
            ps.setString(7, d.getRole());
            ps.setString(8, d.getGroupeSanguin());
            ps.setDate(9, Date.valueOf(d.getDateDernierDon()));
            ps.setBoolean(10, d.isDisponibilite());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDonneur(Donneur d) {
        try {
            String sql = "UPDATE Donneur SET nom=?, prenom=?, email=?, password=?, phoneNum=?, adresse=?, role=?, groupeSanguin=?, dateDernierDon=?, disponibilite=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getNom());
            ps.setString(2, d.getPrenom());
            ps.setString(3, d.getEmail());
            ps.setString(4, d.getPassword());
            ps.setString(5, d.getPhoneNum());
            ps.setString(6, d.getAdresse());
            ps.setString(7, d.getRole());
            ps.setString(8, d.getGroupeSanguin());
            ps.setDate(9, Date.valueOf(d.getDateDernierDon()));
            ps.setBoolean(10, d.isDisponibilite());
            ps.setInt(11, d.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDonneur(int id) {
        try {
            String sql = "DELETE FROM Donneur WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Donneur getDonneurById(int id) {
        try {
            String sql = "SELECT * FROM Donneur WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Donneur d = new Donneur();
                d.setId(rs.getInt("id"));
                d.setNom(rs.getString("nom"));
                d.setPrenom(rs.getString("prenom"));
                d.setEmail(rs.getString("email"));
                d.setPassword(rs.getString("password"));
                d.setPhoneNum(rs.getString("phoneNum"));
                d.setAdresse(rs.getString("adresse"));
                d.setRole(rs.getString("role"));
                d.setGroupeSanguin(rs.getString("groupeSanguin"));
                d.setDateDernierDon(rs.getDate("dateDernierDon").toLocalDate());
                d.setDisponibilite(rs.getBoolean("disponibilite"));
                return d;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Donneur> getAllDonneurs() {
        List<Donneur> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Donneur";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Donneur d = new Donneur();
                d.setId(rs.getInt("id"));
                d.setNom(rs.getString("nom"));
                d.setPrenom(rs.getString("prenom"));
                d.setEmail(rs.getString("email"));
                d.setPassword(rs.getString("password"));
                d.setPhoneNum(rs.getString("phoneNum"));
                d.setAdresse(rs.getString("adresse"));
                d.setRole(rs.getString("role"));
                d.setGroupeSanguin(rs.getString("groupeSanguin"));
                d.setDateDernierDon(rs.getDate("dateDernierDon").toLocalDate());
                d.setDisponibilite(rs.getBoolean("disponibilite"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
*/
