package blooddonation.dao;

import blooddonation.bean.Administrateur;
import java.util.List;

public interface AdministrateurDAO {
    void addAdministrateur(Administrateur a);
    void updateAdministrateur(Administrateur a);
    void deleteAdministrateur(int id);
    Administrateur getAdministrateurById(int id);
    List<Administrateur> getAllAdministrateurs();
}
