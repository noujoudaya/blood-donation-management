package blooddonation.service;

import blooddonation.bean.Hopital;
import java.util.List;

public interface HopitalService {

    Hopital save(Hopital hopital);

    Hopital update(Hopital hopital);

    boolean delete(Long id);

    Hopital findById(Long id);

    List<Hopital> findAll();
}
