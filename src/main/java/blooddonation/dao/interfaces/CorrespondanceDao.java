package blooddonation.dao.interfaces;

import blooddonation.bean.Correspondance;
import java.util.List;

public interface CorrespondanceDao {
    void addCorrespondance(Correspondance c);
    void updateCorrespondance(Correspondance c);
    void deleteCorrespondance(int id);
    Correspondance getCorrespondanceById(int id);
    List<Correspondance> getAllCorrespondances();
}
