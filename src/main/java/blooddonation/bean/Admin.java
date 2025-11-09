package blooddonation.bean;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

    // Méthode pour valider l'inscription d'un utilisateur
    public void validerInscription(User utilisateur) {
        utilisateur.setRole("valide"); // Exemple : changer le rôle après validation
    }

    // Méthode pour supprimer un utilisateur
    public void supprimerUtilisateur(User utilisateur) {
        // Ici tu pourrais appeler ton DAO pour supprimer l'utilisateur
        System.out.println("Utilisateur " + utilisateur.getNom() + " supprimé !");
    }

    // Méthode pour consulter les statistiques
    public void consulterStatistiques() {
        // Exemple simple
        System.out.println("Nombre de dons : ...");
        System.out.println("Nombre de demandes : ...");
        System.out.println("Nombre de correspondances : ...");
    }
}
