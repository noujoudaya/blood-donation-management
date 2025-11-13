package blooddonation.bean;


import blooddonation.enums.GroupeSang;
import blooddonation.enums.StatusDisponibilite;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Donneur extends User {

    @Enumerated(EnumType.STRING)
    private GroupeSang groupeSanguin;
    private LocalDate dateDernierDon;
    @Enumerated(EnumType.ORDINAL)
    private StatusDisponibilite disponibilite;

    @OneToMany(mappedBy = "donneur", cascade = CascadeType.ALL)
    private List<Don> dons;

    @OneToMany(mappedBy = "donneur", cascade = CascadeType.ALL)
    private List<Correspondance> correspondances;

    // Getters et Setters

    public LocalDate getDateDernierDon() { return dateDernierDon; }
    public void setDateDernierDon(LocalDate dateDernierDon) { this.dateDernierDon = dateDernierDon; }

    public List<Don> getDons() { return dons; }
    public void setDons(List<Don> dons) { this.dons = dons; }

    public List<Correspondance> getCorrespondances() { return correspondances; }
    public void setCorrespondances(List<Correspondance> correspondances) { this.correspondances = correspondances; }

    public GroupeSang getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(GroupeSang groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    public StatusDisponibilite getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(StatusDisponibilite disponibilite) {
        this.disponibilite = disponibilite;
    }
}
