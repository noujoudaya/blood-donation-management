package blooddonation.dao.interfaces;

import blooddonation.bean.Donneur;
import java.util.List;

public interface DonneurDAO {
    void addDonneur(Donneur d);
    void updateDonneur(Donneur d);
    void deleteDonneur(int id);
    Donneur getDonneurById(int id);
    List<Donneur> getAllDonneurs();
}
