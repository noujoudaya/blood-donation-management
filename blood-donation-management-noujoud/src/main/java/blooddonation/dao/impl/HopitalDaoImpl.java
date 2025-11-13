package blooddonation.dao.impl;

import blooddonation.dao.interfaces.HopitalDao;
import blooddonation.bean.Hopital;
import blooddonation.utils.HibernateUtil;
import org.hibernate.Session;

public class HopitalDaoImpl implements HopitalDao {

    @Override
    public int countAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Long count = (Long) session.createQuery("SELECT COUNT(h) FROM Hopital h").uniqueResult();
            return count.intValue();
        }
    }
}
