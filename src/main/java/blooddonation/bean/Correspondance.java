package blooddonation.bean;

import java.time.LocalDate;

public class Correspondance {
    private int id;
    private Donneur donneur;
    private Demande demande;
    private LocalDate dateCorrespondance;

    public Correspondance() {}

    public Correspondance(int id, Donneur donneur, Demande demande, LocalDate dateCorrespondance) {
        this.id = id;
        this.donneur = donneur;
        this.demande = demande;
        this.dateCorrespondance = dateCorrespondance;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Donneur getDonneur() { return donneur; }
    public void setDonneur(Donneur donneur) { this.donneur = donneur; }
    public Demande getDemande() { return demande; }
    public void setDemande(Demande demande) { this.demande = demande; }
    public LocalDate getDateCorrespondance() { return dateCorrespondance; }
    public void setDateCorrespondance(LocalDate dateCorrespondance) { this.dateCorrespondance = dateCorrespondance; }

    @Override
    public String toString() {
        return "Correspondance{" +
                "id=" + id +
                ", donneur=" + donneur +
                ", demande=" + demande +
                ", dateCorrespondance=" + dateCorrespondance +
                '}';
    }
}
