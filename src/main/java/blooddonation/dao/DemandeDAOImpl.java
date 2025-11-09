package blooddonation.dao;

import blooddonation.bean.Demande;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DemandeDAOImpl implements DemandeDAO {

    private Connection conn;

    public DemandeDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addDemande(Demande d) {
        try {
            String sql = "INSERT INTO Demande(groupeSanguin, quantite, urgence, dateDemande, statut, hopitalId) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getGroupeSanguin());
            ps.setDouble(2, d.getQuantite());
            ps.setString(3, d.getUrgence());
            ps.setDate(4, Date.valueOf(d.getDateDemande()));
            ps.setString(5, d.getStatut());
            ps.setInt(6, d.getHopital().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDemande(Demande d) {
        try {
            String sql = "UPDATE Demande SET groupeSanguin=?, quantite=?, urgence=?, dateDemande=?, statut=?, hopitalId=? WHERE idDemande=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getGroupeSanguin());
            ps.setDouble(2, d.getQuantite());
            ps.setString(3, d.getUrgence());
            ps.setDate(4, Date.valueOf(d.getDateDemande()));
            ps.setString(5, d.getStatut());
            ps.setInt(6, d.getHopital().getId());
            ps.setInt(7, d.getIdDemande());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDemande(int id) {
        try {
            String sql = "DELETE FROM Demande WHERE idDemande=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Demande getDemandeById(int id) {
        try {
            String sql = "SELECT * FROM Demande WHERE idDemande=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Demande d = new Demande();
                d.setIdDemande(rs.getInt("idDemande"));
                d.setGroupeSanguin(rs.getString("groupeSanguin"));
                d.setQuantite(rs.getDouble("quantite"));
                d.setUrgence(rs.getString("urgence"));
                d.setDateDemande(rs.getDate("dateDemande").toLocalDate());
                d.setStatut(rs.getString("statut"));
                // Récupération de l'hôpital si nécessaire
                return d;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Demande> getAllDemandes() {
        List<Demande> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Demande";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Demande d = new Demande();
                d.setIdDemande(rs.getInt("idDemande"));
                d.setGroupeSanguin(rs.getString("groupeSanguin"));
                d
