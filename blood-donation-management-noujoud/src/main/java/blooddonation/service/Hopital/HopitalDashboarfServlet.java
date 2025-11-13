package blooddonation.service.hopital;

import blooddonation.bean.Demande;
import blooddonation.dao.impl.DemandeDaoImpl;
import java.util.List;

public class HopitalDashboardService {

    private final DemandeDaoImpl demandeDao;

    public HopitalDashboardService(DemandeDaoImpl demandeDao) {
        this.demandeDao = demandeDao;
    }

    public int getTotalDemandes(int hopitalId) {
        return demandeDao.countByHopital(hopitalId);
    }

    public int getActiveDemandes(int hopitalId) {
        return demandeDao.countActiveByHopital(hopitalId);
    }

    public List<Demande> getRecentDemandes(int hopitalId) {
        return demandeDao.getRecentByHopital(hopitalId, 5);
    }
}