package blooddonation.bean;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Correspondance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCorrespondance;
    private LocalDate dateCreation;
    private String statut;

    @ManyToOne
    @JoinColumn(name = "donneur_id")
    private Donneur donneur;

    @ManyToOne
    @JoinColumn(name = "demande_id")
    private Demande demande;

    // Getters et Setters
    public int getIdCorrespondance() { return idCorrespondance; }
    public void setIdCorrespondance(int idCorrespondance) { this.idCorrespondance = idCorrespondance; }

    public LocalDate getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDate dateCreation) { this.dateCreation = dateCreation; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Donneur getDonneur() { return donneur; }
    public void setDonneur(Donneur donneur) { this.donneur = donneur; }

    public Demande getDemande() { return demande; }
    public void setDemande(Demande demande) { this.demande = demande; }
}
