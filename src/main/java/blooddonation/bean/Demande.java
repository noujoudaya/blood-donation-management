package blooddonation.bean;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDemande;
    private String groupeSanguin;
    private double quantite;
    private String urgence;
    private LocalDate dateDemande;
    private String statut;

    @ManyToOne
    @JoinColumn(name = "hopital_id")
    private Hopital hopital;

    @OneToMany(mappedBy = "demande", cascade = CascadeType.ALL)
    private List<Correspondance> correspondances;

    @OneToOne(mappedBy = "demande", cascade = CascadeType.ALL)
    private Don don;

    // Getters et Setters
    public int getIdDemande() { return idDemande; }
    public void setIdDemande(int idDemande) { this.idDemande = idDemande; }

    public String getGroupeSanguin() { return groupeSanguin; }
    public void setGroupeSanguin(String groupeSanguin) { this.groupeSanguin = groupeSanguin; }

    public double getQuantite() { return quantite; }
    public void setQuantite(double quantite) { this.quantite = quantite; }

    public String getUrgence() { return urgence; }
    public void setUrgence(String urgence) { this.urgence = urgence; }

    public LocalDate getDateDemande() { return dateDemande; }
    public void setDateDemande(LocalDate dateDemande) { this.dateDemande = dateDemande; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Hopital getHopital() { return hopital; }
    public void setHopital(Hopital hopital) { this.hopital = hopital; }

    public List<Correspondance> getCorrespondances() { return correspondances; }
    public void setCorrespondances(List<Correspondance> correspondances) { this.correspondances = correspondances; }

    public Don getDon() { return don; }
    public void setDon(Don don) { this.don = don; }
}
