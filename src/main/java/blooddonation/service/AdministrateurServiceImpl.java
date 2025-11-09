package blooddonation.service;

import blooddonation.bean.Administrateur;
import blooddonation.dao.AdministrateurDAO;
import java.util.List;

public class AdministrateurServiceImpl implements AdministrateurService {

    private AdministrateurDAO administrateurDAO;

    public AdministrateurServiceImpl(AdministrateurDAO administrateurDAO) {
        this.administrateurDAO = administrateurDAO;
    }

    @Override
    public Administrateur save(Administrateur admin) {
        return administrateurDAO.save(admin);
    }

    @Override
    public Administrateur update(Administrateur admin) {
        return administrateurDAO.update(admin);
    }

    @Override
    public boolean delete(Long id) {
        return administrateurDAO.delete(id);
    }

    @Override
    public Administrateur findById(Long id) {
        return administrateurDAO.findById(id);
    }

    @Override
    public List<Administrateur> findAll() {
        return administrateurDAO.findAll();
    }
}
