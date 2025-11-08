package blooddonation.service;

import blooddonation.bean.Donneur;
import java.util.List;

public interface DonneurService {

    Donneur save(Donneur donneur);

    Donneur update(Donneur donneur);

    boolean delete(Long id);

    Donneur findById(Long id);

    List<Donneur> findAll();

    List<Donneur> findByGroupeSanguin(String groupe);
}
