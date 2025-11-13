package blooddonation.service.donneur;

import blooddonation.bean.Demande;
import blooddonation.dao.interfaces.DemandeDao;
import blooddonation.enums.GroupeSang;
import java.util.List;

public class DonneurAnnoncesService {
    private final DemandeDao demandeDao;

    public DonneurAnnoncesService(DemandeDao demandeDao) {
        this.demandeDao = demandeDao;
    }

    public List<Demande> getUrgentDemands(GroupeSang group) {
        return demandeDao.findUrgentByGroup(group);
    }
}
