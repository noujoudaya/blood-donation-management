package blooddonation.dao.interfaces;

import blooddonation.bean.Demande;
import blooddonation.enums.GroupeSang;

import java.util.List;

public interface DemandeDao {
/*    void addDemande(Demande d);
    void updateDemande(Demande d);
    void deleteDemande(int id);
    Demande getDemandeById(int id);
    List<Demande> getAllDemandes();*/
    int countActiveUrgent();
    List<Demande> getRecentDemands(int limit);
    List<Demande> findUrgentByGroup(GroupeSang group);
    int countByHopital(int hopitalId);

    int countActiveByHopital(int hopitalId);

    List<Demande> getRecentByHopital(int hopitalId, int limit);

}
