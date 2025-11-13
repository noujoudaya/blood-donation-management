package blooddonation.dao.interfaces;

import blooddonation.bean.Donneur;
import java.util.List;

public interface DonneurDao {
/*    void addDonneur(Donneur d);
    void deleteDonneur(int id);
    Donneur getDonneurById(int id);*/
    Donneur findById(int id);
    void update(Donneur donneur);
    List<Donneur> getAllDonneurs();
    int countAll();

    int getDonorsByCity(String city);

    List<Donneur> getRecentDonors(int limit);
}
