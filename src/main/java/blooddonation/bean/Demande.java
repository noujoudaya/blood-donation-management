package blooddonation.bean;

import java.time.LocalDate;

public class Demande {
    private int id;
    private Hopital hopital;
    private String groupeSanguin;
    private int quantite;
    private LocalDate dateDemande;

    public Demande() {}

    public Demande(int id, Hopital hopital, String groupeSanguin, int quantite, LocalDate dateDemande) {
        this.id = id;
        this.hopital = hopital;
        this.groupeSanguin = groupeSanguin;
        this.quantite = quantite;
        this.dateDemande = dateDemande;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Hopital getHopital() { return hopital; }
    public void setHopital(Hopital hopital) { this.hopital = hopital; }
    public String getGroupeSanguin() { return groupeSanguin; }
    public void setGroupeSanguin(String groupeSanguin) { this.groupeSanguin = groupeSanguin; }
    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }
    public LocalDate getDateDemande() { return dateDemande; }
    public void setDateDemande(LocalDate dateDemande) { this.dateDemande = dateDemande; }

    @Override
    public String toString() {
        return "Demande{" +
                "id=" + id +
                ", hopital=" + hopital +
                ", groupeSanguin='" + groupeSanguin + '\'' +
                ", quantite=" + quantite +
                ", dateDemande=" + dateDemande +
                '}';
    }
}
