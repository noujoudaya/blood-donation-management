package blooddonation.dao.interfaces;

import blooddonation.bean.Don;
import java.util.List;

public interface DonDAO {
    void addDon(Don d);
    void updateDon(Don d);
    void deleteDon(int id);
    Don getDonById(int id);
    List<Don> getAllDons();
}
