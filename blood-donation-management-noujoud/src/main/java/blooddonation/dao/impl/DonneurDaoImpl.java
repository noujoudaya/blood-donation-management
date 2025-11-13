package blooddonation.dao.impl;

import blooddonation.bean.Donneur;
import blooddonation.dao.interfaces.DonneurDao;
import blooddonation.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DonneurDaoImpl implements DonneurDao {



    @Override
    public int countAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Long count = (Long) session.createQuery("SELECT COUNT(d) FROM Donneur d").uniqueResult();
            return count.intValue();
        }
    }

    @Override
    public int getDonorsByCity(String city) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Long count = session.createQuery(
                            "SELECT COUNT(d) FROM Donneur d WHERE d.adresse LIKE :city", Long.class)
                    .setParameter("city", "%" + city + "%")
                    .uniqueResult();
            return count != null ? count.intValue() : 0;
        }
    }

    @Override
    public List<Donneur> getRecentDonors(int limit) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Donneur> query = session.createQuery("FROM Donneur d ORDER BY d.id DESC", Donneur.class);
            query.setMaxResults(limit);
            return query.list();
        }
    }

    @Override
    public Donneur findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Donneur.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void update(Donneur donneur) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            // use merge to handle detached entities safely
            session.merge(donneur);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            throw e; // rethrow or handle as you prefer
        }
    }

    @Override
    public List<Donneur> getAllDonneurs()  {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Donneur> donors = session.createQuery("FROM Donneur", Donneur.class).list();
        session.close();
        return donors;
    }

}
