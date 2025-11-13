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
    @Override
    public Hopital findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Hopital.class, id);
        }
    }

    @Override
    public Hopital findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Hopital> query = session.createQuery("FROM Hopital WHERE email = :email", Hopital.class);
            query.setParameter("email", email);
            return query.uniqueResult();
        }
    }

    @Override
    public List<Hopital> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Hopital", Hopital.class).list();
        }
    }

    @Override
    public void save(Hopital hopital) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(hopital);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Hopital hopital) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(hopital);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Hopital hopital = session.get(Hopital.class, id);
            if (hopital != null) session.remove(hopital);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
