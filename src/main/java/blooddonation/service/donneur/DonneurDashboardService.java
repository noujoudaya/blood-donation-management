package blooddonation.service.donneur;

import blooddonation.bean.Don;
import blooddonation.bean.Demande;
import blooddonation.dao.impl.DonDaoImpl;
import blooddonation.dao.impl.DemandeDaoImpl;
import blooddonation.enums.GroupeSang;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class DonneurDashboardService {
    private final DonDaoImpl donDao;
    private final DemandeDaoImpl demandeDao;

    public DonneurDashboardService(DonDaoImpl donDao, DemandeDaoImpl demandeDao) {
        this.donDao = donDao;
        this.demandeDao = demandeDao;
    }

    public int getTotalDons(int donorId) {
        return donDao.findByDonneur(donorId).size();
    }

    public String getLastDonation(int donorId) {
        Don d = donDao.findLastDonationByDonneur(donorId);
        return (d != null && d.getDateDon() != null)
                ? d.getDateDon().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                : "Aucun don encore";
    }

    public String getNextPossibleDate(int donorId) {
        Don d = donDao.findLastDonationByDonneur(donorId);
        if (d == null || d.getDateDon() == null) return "Disponible immédiatement";
        return d.getDateDon().plusMonths(3).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public List<Demande> getUrgentDemands(GroupeSang groupeSang) {
        return demandeDao.findUrgentByGroup(groupeSang);
    }
}
