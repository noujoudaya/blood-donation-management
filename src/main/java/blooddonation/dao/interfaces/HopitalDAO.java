package blooddonation.dao.interfaces;

import blooddonation.bean.Hopital;
import java.util.List;

public interface HopitalDAO {
    void addHopital(Hopital h);
    void updateHopital(Hopital h);
    void deleteHopital(int id);
    Hopital getHopitalById(int id);
    List<Hopital> getAllHopitaux();
}
