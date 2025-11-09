package blooddonation.service;

import blooddonation.bean.Donneur;
import blooddonation.dao.DonneurDAO;
import java.util.List;

public class DonneurServiceImpl implements DonneurService {

    private DonneurDAO donneurDAO;

    public DonneurServiceImpl(DonneurDAO donneurDAO) {
        this.donneurDAO = donneurDAO;
    }

    @Override
    public Donneur save(Donneur donneur) {
        return donneurDAO.save(donneur);
    }

    @Override
    public Donneur update(Donneur donneur) {
        return donneurDAO.update(donneur);
    }

    @Override
    public boolean delete(Long id) {
        return donneurDAO.delete(id);
    }

    @Override
    public Donneur findById(Long id) {
        return donneurDAO.findById(id);
    }

    @Override
    public List<Donneur> findAll() {
        return donneurDAO.findAll();
    }

    @Override
    public List<Donneur> findByGroupeSanguin(String groupe) {
        return donneurDAO.findByGroupeSanguin(groupe);
    }
}
