package blooddonation.service;

import blooddonation.bean.Demande;
import blooddonation.dao.DemandeDAO;
import java.util.List;

public class DemandeServiceImpl implements DemandeService {

    private DemandeDAO demandeDAO;

    public DemandeServiceImpl(DemandeDAO demandeDAO) {
        this.demandeDAO = demandeDAO;
    }

    @Override
    public Demande save(Demande demande) {
        return demandeDAO.save(demande);
    }

    @Override
    public Demande update(Demande demande) {
        return demandeDAO.update(demande);
    }

    @Override
    public boolean delete(Long id) {
        return demandeDAO.delete(id);
    }

    @Override
    public Demande findById(Long id) {
        return demandeDAO.findById(id);
    }

    @Override
    public List<Demande> findAll() {
        return demandeDAO.findAll();
    }

    @Override
    public List<Demande> findByGroupeSanguin(String groupe) {
        return demandeDAO.findByGroupeSanguin(groupe);
    }
}
