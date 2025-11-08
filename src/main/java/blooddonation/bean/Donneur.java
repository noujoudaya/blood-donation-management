package blooddonation.bean;

import java.time.LocalDate;

public class Donneur extends User {
    private String groupeSanguin ;
    private LocalDate dateDernierDon;
    private boolean disponibilite;

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    public LocalDate getDateDernierDon() {
        return dateDernierDon;
    }

    public void setDateDernierDon(LocalDate dateDernierDon) {
        this.dateDernierDon = dateDernierDon;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }
}
