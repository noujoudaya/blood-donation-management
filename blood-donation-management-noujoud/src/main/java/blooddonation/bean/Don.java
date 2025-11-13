package blooddonation.bean;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Don {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDon;
    private LocalDate dateDon;
    private String lieu;

    @ManyToOne
    @JoinColumn(name = "donneur_id")
    private Donneur donneur;

    @OneToOne
    @JoinColumn(name = "demande_id")
    private Demande demande;

    // Getters et Setters
    public int getIdDon() { return idDon; }
    public void setIdDon(int idDon) { this.idDon = idDon; }

    public LocalDate getDateDon() { return dateDon; }
    public void setDateDon(LocalDate dateDon) { this.dateDon = dateDon; }

    public String getLieu() { return lieu; }
    public void setLieu(String lieu) { this.lieu = lieu; }


    public Donneur getDonneur() { return donneur; }
    public void setDonneur(Donneur donneur) { this.donneur = donneur; }

    public Demande getDemande() { return demande; }
    public void setDemande(Demande demande) { this.demande = demande; }
}
