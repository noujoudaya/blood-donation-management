package blooddonation.service;

import blooddonation.bean.Administrateur;
import java.util.List;

public interface AdministrateurService {

    Administrateur save(Administrateur admin);

    Administrateur update(Administrateur admin);

    boolean delete(Long id);

    Administrateur findById(Long id);

    List<Administrateur> findAll();
}
