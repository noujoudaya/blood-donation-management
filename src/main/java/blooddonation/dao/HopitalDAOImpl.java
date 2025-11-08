package blooddonation.dao;

import blooddonation.bean.Hopital;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HopitalDAOImpl implements HopitalDAO {

    private Connection conn;

    public HopitalDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addHopital(Hopital h) {
        try {
            String sql = "INSERT INTO Hopital(nom, prenom, email, password, phoneNum, adresse, role, nomHopital, localisation) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, h.getNom());
            ps.setString(2, h.getPrenom());
            ps.setString(3, h.getEmail());
            ps.setString(4, h.getPassword());
            ps.setString(5, h.getPhoneNum());
            ps.setString(6, h.getAdresse());
            ps.setString(7, h.getRole());
            ps.setString(8, h.getNom());
            ps.setString(9, h.getAdresse());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateHopital(Hopital h) {
        try {
            String sql = "UPDATE Hopital SET nom=?, prenom=?, email=?, password=?, phoneNum=?, adresse=?, role=?, nomHopital=?, localisation=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, h.getNom());
            ps.setString(2, h.getPrenom());
            ps.setString(3, h.getEmail());
            ps.setString(4, h.getPassword());
            ps.setString(5, h.getPhoneNum());
            ps.setString(6, h.getAdresse());
            ps.setString(7, h.getRole());
            ps.setString(8, h.getNom());
            ps.setString(9, h.getAdresse());
            ps.setInt(10, h.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteHopital(int id) {
        try {
            String sql = "DELETE FROM Hopital WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Hopital getHopitalById(int id) {
        try {
            String sql = "SELECT * FROM Hopital WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Hopital h = new Hopital();
                h.setId(rs.getInt("id"));
                h.setNom(rs.getString("nom"));
                h.setPrenom(rs.getString("prenom"));
                h.setEmail(rs.getString("email"));
                h.setPassword(rs.getString("password"));
                h.setPhoneNum(rs.getString("phoneNum"));
                h.setAdresse(rs.getString("adresse"));
                h.setRole(rs.getString("role"));
                return h;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Hopital> getAllHopitaux() {
        List<Hopital> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Hopital";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Hopital h = new Hopital();
                h.setId(rs.getInt("id"));
                h.setNom(rs.getString("nom"));
                h.setPrenom(rs.getString("prenom"));
                h.setEmail(rs.getString("email"));
                h.setPassword(rs.getString("password"));
                h.setPhoneNum(rs.getString("phoneNum"));
                h.setAdresse(rs.getString("adresse"));
                h.setRole(rs.getString("role"));
                list.add(h);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
