package blooddonation.dao;

import blooddonation.bean.Correspondance;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CorrespondanceDAOImpl implements CorrespondanceDAO {

    private Connection conn;

    public CorrespondanceDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addCorrespondance(Correspondance c) {
        try {
            String sql = "INSERT INTO Correspondance(dateCreation, statut, donneurId, demandeId) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(c.getDateCreation()));
            ps.setString(2, c.getStatut());
            ps.setInt(3, c.getDonneur().getId());
            ps.setInt(4, c.getDemande().getIdDemande());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCorrespondance(Correspondance c) {
        try {
            String sql = "UPDATE Correspondance SET dateCreation=?, statut=?, donneurId=?, demandeId=? WHERE idCorrespondance=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(c.getDateCreation()));
            ps.setString(2, c.getStatut());
            ps.setInt(3, c.getDonneur().getId());
            ps.setInt(4, c.getDemande().getIdDemande());
            ps.setInt(5, c.getIdCorrespondance());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCorrespondance(int id) {
        try {
            String sql = "DELETE FROM Correspondance WHERE idCorrespondance=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Correspondance getCorrespondanceById(int id) {
        try {
            String sql = "SELECT * FROM Correspondance WHERE idCorrespondance=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Correspondance c = new Correspondance();
                c.setIdCorrespondance(rs.getInt("idCorrespondance"));
                c.setDateCreation(rs.getDate("dateCreation").toLocalDate());
                c.setStatut(rs.getString("statut"));
                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Correspondance> getAllCorrespondances() {
        List<Correspondance> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Correspondance";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Correspondance c = new Correspondance();
                c.setIdCorrespondance(rs.getInt("idCorrespondance"));
                c.setDateCreation(rs.getDate("dateCreation").toLocalDate());
                c.setStatut(rs.getString("statut"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
