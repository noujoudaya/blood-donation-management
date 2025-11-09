package blooddonation.service;

import blooddonation.bean.Demande;
import java.util.List;

public interface DemandeService {

    Demande save(Demande demande);

    Demande update(Demande demande);

    boolean delete(Long id);

    Demande findById(Long id);

    List<Demande> findAll();

    List<Demande> findByGroupeSanguin(String groupe);
}
