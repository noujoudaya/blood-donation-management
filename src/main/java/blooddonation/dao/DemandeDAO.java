package blooddonation.dao;

import blooddonation.bean.Demande;
import java.util.List;

public interface DemandeDAO {
    void addDemande(Demande d);
    void updateDemande(Demande d);
    void deleteDemande(int id);
    Demande getDemandeById(int id);
    List<Demande> getAllDemandes();
}
