package blooddonation.service;

import blooddonation.bean.Don;
import blooddonation.dao.DonDAO;
import java.util.List;

public class DonServiceImpl implements DonService {

    private DonDAO donDAO;

    public DonServiceImpl(DonDAO donDAO) {
        this.donDAO = donDAO;
    }

    @Override
    public Don save(Don don) {
        return donDAO.save(don);
    }

    @Override
    public Don update(Don don) {
        return donDAO.update(don);
    }

    @Override
    public boolean delete(Long id) {
        return donDAO.delete(id);
    }

    @Override
    public Don findById(Long id) {
        return donDAO.findById(id);
    }

    @Override
    public List<Don> findAll() {
        return donDAO.findAll();
    }
}
