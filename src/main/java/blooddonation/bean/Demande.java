package blooddonation.bean;

import blooddonation.enums.GroupeSang;
import blooddonation.enums.Statut;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDemande;
    @Enumerated(EnumType.STRING)
    private GroupeSang groupeSanguin;
    private LocalDate dateDemande;

    @Enumerated(EnumType.STRING)
    private Statut statut;

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

    public GroupeSang getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(GroupeSang groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    public Statut getStatut() {
        return statut;
    }

    public LocalDate getDateDemande() { return dateDemande; }
    public void setDateDemande(LocalDate dateDemande) { this.dateDemande = dateDemande; }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Hopital getHopital() { return hopital; }
    public void setHopital(Hopital hopital) { this.hopital = hopital; }

    public List<Correspondance> getCorrespondances() { return correspondances; }
    public void setCorrespondances(List<Correspondance> correspondances) { this.correspondances = correspondances; }

    public Don getDon() { return don; }
    public void setDon(Don don) { this.don = don; }
}
