package blooddonation.service;

import blooddonation.bean.Hopital;
import blooddonation.dao.HopitalDAO;
import java.util.List;

public class HopitalServiceImpl implements HopitalService {

    private HopitalDAO hopitalDAO;

    public HopitalServiceImpl(HopitalDAO hopitalDAO) {
        this.hopitalDAO = hopitalDAO;
    }

    @Override
    public Hopital save(Hopital hopital) {
        return hopitalDAO.save(hopital);
    }

    @Override
    public Hopital update(Hopital hopital) {
        return hopitalDAO.update(hopital);
    }

    @Override
    public boolean delete(Long id) {
        return hopitalDAO.delete(id);
    }

    @Override
    public Hopital findById(Long id) {
        return hopitalDAO.findById(id);
    }

    @Override
    public List<Hopital> findAll() {
        return hopitalDAO.findAll();
    }
}
