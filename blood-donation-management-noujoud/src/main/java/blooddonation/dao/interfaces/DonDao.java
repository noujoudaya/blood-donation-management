package blooddonation.dao.interfaces;

import blooddonation.bean.Don;
import java.util.List;

public interface DonDao {
/*    void addDon(Don d);
    void updateDon(Don d);
    void deleteDon(int id);
    Don getDonById(int id);
    List<Don> getAllDons();*/
    List<Don> findByDonneur(int donneurId);
    Don findLastDonationByDonneur(int donneurId);

    List<Don> findByDonneurId(int donneurId);

    int countThisMonth();

    List<Don> getRecentDons(int limit);
}
