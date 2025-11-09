package blooddonation.service;

import blooddonation.bean.Correspondance;
import java.util.List;

public interface CorrespondanceService {

    Correspondance save(Correspondance correspondance);

    Correspondance update(Correspondance correspondance);

    boolean delete(Long id);

    Correspondance findById(Long id);

    List<Correspondance> findAll();
}
