package blooddonation.service.donneur;

import blooddonation.bean.Donneur;
import blooddonation.dao.impl.DonneurDaoImpl;

public class DonneurProfileService {
    private final DonneurDaoImpl donneurDao;

    public DonneurProfileService(DonneurDaoImpl donneurDao) {
        this.donneurDao = donneurDao;
    }

    public void updateProfile(Donneur donneur) {
        donneurDao.update(donneur);
    }
}

