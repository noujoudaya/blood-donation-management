package blooddonation.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hopital extends User {

    private String nomHopital;
    private String localisation;

    @OneToMany(mappedBy = "hopital", cascade = CascadeType.ALL)
    private List<Demande> demandes;

    // Getters et Setters
    public String getNomHopital() { return nomHopital; }
    public void setNomHopital(String nomHopital) { this.nomHopital = nomHopital; }

    public String getLocalisation() { return localisation; }
    public void setLocalisation(String localisation) { this.localisation = localisation; }

    public List<Demande> getDemandes() { return demandes; }
    public void setDemandes(List<Demande> demandes) { this.demandes = demandes; }
}
