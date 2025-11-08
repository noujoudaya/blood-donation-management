package blooddonation.bean;

public class Hopital extends User {
    private String ville;
    private int capacite;

    public Hopital() {
        super();
    }

    public Hopital(int id, String nom, String prenom, String email, String password,
                   String phoneNum, String adresse, String role, String ville, int capacite) {
        super(id, nom, prenom, email, password, phoneNum, adresse, role);
        this.ville = ville;
        this.capacite = capacite;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "Hopital{" +
                super.toString() +
                ", ville='" + ville + '\'' +
                ", capacite=" + capacite +
                '}';
    }
}

