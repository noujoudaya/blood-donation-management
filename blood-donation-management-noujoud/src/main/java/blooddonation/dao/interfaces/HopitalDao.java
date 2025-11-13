package blooddonation.dao.interfaces;

import blooddonation.bean.Hopital;
import java.util.List;

public interface HopitalDao {
    Hopital findById(int id);
    Hopital findByEmail(String email);
    List<Hopital> findAll();
    void save(Hopital hopital);
    void update(Hopital hopital);
    void delete(int id);
    int countAll();
}