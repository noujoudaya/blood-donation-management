package blooddonation.service;

import blooddonation.bean.Correspondance;
import blooddonation.dao.CorrespondanceDAO;
import java.util.List;

public class CorrespondanceServiceImpl implements CorrespondanceService {

    private CorrespondanceDAO correspondanceDAO;

    public CorrespondanceServiceImpl(CorrespondanceDAO correspondanceDAO) {
        this.correspondanceDAO = correspondanceDAO;
    }

    @Override
    public Correspondance save(Correspondance correspondance) {
        return correspondanceDAO.save(correspondance);
    }

    @Override
    public Correspondance update(Correspondance correspondance) {
        return correspondanceDAO.update(correspondance);
    }

    @Override
    public boolean delete(Long id) {
        return correspondanceDAO.delete(id);
    }

    @Override
    public Correspondance findById(Long id) {
        return correspondanceDAO.findById(id);
    }

    @Override
    public List<Correspondance> findAll() {
        return correspondanceDAO.findAll();
    }
}
