package blooddonation.bean;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Donneur extends User {

    private String groupeSanguin;
    private LocalDate dateDernierDon;
    private boolean disponibilite;

    @OneToMany(mappedBy = "donneur", cascade = CascadeType.ALL)
    private List<Don> dons;

    @OneToMany(mappedBy = "donneur", cascade = CascadeType.ALL)
    private List<Correspondance> correspondances;

    // Getters et Setters
    public String getGroupeSanguin() { return groupeSanguin; }
    public void setGroupeSanguin(String groupeSanguin) { this.groupeSanguin = groupeSanguin; }

    public LocalDate getDateDernierDon() { return dateDernierDon; }
    public void setDateDernierDon(LocalDate dateDernierDon) { this.dateDernierDon = dateDernierDon; }

    public boolean isDisponibilite() { return disponibilite; }
    public void setDisponibilite(boolean disponibilite) { this.disponibilite = disponibilite; }

    public List<Don> getDons() { return dons; }
    public void setDons(List<Don> dons) { this.dons = dons; }

    public List<Correspondance> getCorrespondances() { return correspondances; }
    public void setCorrespondances(List<Correspondance> correspondances) { this.correspondances = correspondances; }
}
