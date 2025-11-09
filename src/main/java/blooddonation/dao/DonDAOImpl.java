package blooddonation.dao;

import blooddonation.bean.Don;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonDAOImpl implements DonDAO {

    private Connection conn;

    public DonDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addDon(Don d) {
        try {
            String sql = "INSERT INTO Don(dateDon, lieu, quantite, donneurId, demandeId) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(d.getDateDon()));
            ps.setString(2, d.getLieu());
            ps.setDouble(3, d.getQuantite());
            ps.setInt(4, d.getDonneur().getId());
            ps.setObject(5, d.getDemande() != null ? d.getDemande().getIdDemande() : null);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDon(Don d) {
        try {
            String sql = "UPDATE Don SET dateDon=?, lieu=?, quantite=?, donneurId=?, demandeId=? WHERE idDon=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(d.getDateDon()));
            ps.setString(2, d.getLieu());
            ps.setDouble(3, d.getQuantite());
            ps.setInt(4, d.getDonneur().getId());
            ps.setObject(5, d.getDemande() != null ? d.getDemande().getIdDemande() : null);
            ps.setInt(6, d.getIdDon());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDon(int id) {
        try {
            String sql = "DELETE FROM Don WHERE idDon=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Don getDonById(int id) {
        try {
            String sql = "SELECT * FROM Don WHERE idDon=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Don d = new Don();
                d.setIdDon(rs.getInt("idDon"));
                d.setDateDon(rs.getDate("dateDon").toLocalDate());
                d.setLieu(rs.getString("lieu"));
                d.setQuantite(rs.getDouble("quantite"));
                return d;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Don> getAllDons() {
        List<Don> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Don";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Don d = new Don();
                d.setIdDon(rs.getInt("idDon"));
                d.setDateDon(rs.getDate("dateDon").toLocalDate());
                d.setLieu(rs.getString("lieu"));
                d.setQuantite(rs.getDouble("quantite"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
