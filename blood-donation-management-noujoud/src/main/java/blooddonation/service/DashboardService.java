package blooddonation.service;

import blooddonation.bean.Don;
import blooddonation.bean.Donneur;
import blooddonation.bean.Demande;
import blooddonation.dao.interfaces.*;

import java.util.List;

public class DashboardService {

    private DonneurDao donneurDao;
    private DonDao donDao;
    private DemandeDao demandeDao;
    private HopitalDao hopitalDao;

    public DashboardService(DonneurDao donneurDao, HopitalDao hopitalDao, DonDao donDao, DemandeDao demandeDao) {
        this.donneurDao = donneurDao;
        this.hopitalDao = hopitalDao;
        this.donDao = donDao;
        this.demandeDao = demandeDao;
    }

    public int getTotalDonors() { return donneurDao.countAll(); }
    public int getTotalDonationsThisMonth() { return donDao.countThisMonth(); }
    public int getActiveUrgentDemands() { return demandeDao.countActiveUrgent(); }
    public int getDonorsByCity(String city) { return donneurDao.getDonorsByCity(city); }

    public List<Don> getRecentDonations() { return donDao.getRecentDons(5); }
    public List<Demande> getRecentDemands() { return demandeDao.getRecentDemands(5); }
    public List<Donneur> getRecentDonors() { return donneurDao.getRecentDonors(5); }

    public int getTotalHospitals() {
        return hopitalDao.countAll();
    }
}
