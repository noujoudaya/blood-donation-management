package blooddonation.bean;

import java.time.LocalDate;

public class Donneur extends User {
    private String groupeSanguin;
    private LocalDate dateDernierDon;
    private boolean disponibilite;

    public Donneur() { super(); }

    public Donneur(int id, String nom, String prenom, String email, String password,
                   String phoneNum, String adresse, String role,
                   String groupeSanguin, LocalDate dateDernierDon, boolean disponibilite) {
        super(id, nom, prenom, email, password, phoneNum, adresse, role);
        this.groupeSanguin = groupeSanguin;
        this.dateDernierDon = dateDernierDon;
        this.disponibilite = disponibilite;
    }

    public String getGroupeSanguin() { return groupeSanguin; }
    public void setGroupeSanguin(String groupeSanguin) { this.groupeSanguin = groupeSanguin; }
    public LocalDate getDateDernierDon() { return dateDernierDon; }
    public void setDateDernierDon(LocalDate dateDernierDon) { this.dateDernierDon = dateDernierDon; }
    public boolean isDisponibilite() { return disponibilite; }
    public void setDisponibilite(boolean disponibilite) { this.disponibilite = disponibilite; }

    @Override
    public String toString() {
        return "Donneur{" +
                super.toString() +
                ", groupeSanguin='" + groupeSanguin + '\'' +
                ", dateDernierDon=" + dateDernierDon +
                ", disponibilite=" + disponibilite +
                '}';
    }
}
