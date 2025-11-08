package blooddonation.bean;

public class Hopital extends User {
    private String ville;

    public Hopital() { super(); }

    public Hopital(int id, String nom, String prenom, String email, String password,
                   String phoneNum, String adresse, String role, String ville) {
        super(id, nom, prenom, email, password, phoneNum, adresse, role);
        this.ville = ville;
    }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    @Override
    public String toString() {
        return "Hopital{" + super.toString() + ", ville='" + ville + '\'' + '}';
    }
}
