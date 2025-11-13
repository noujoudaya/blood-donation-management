package blooddonation.dao.impl;

import blooddonation.bean.Don;
import blooddonation.dao.interfaces.DonDao;
import blooddonation.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class DonDaoImpl implements DonDao {
    @Override
    public List<Don> findByDonneurId(int donneurId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "FROM Don d WHERE d.donneur.id = :id ORDER BY d.dateDon DESC",
                            Don.class
                    ).setParameter("id", donneurId)
                    .list();
        }
    }


    @Override
    public int countThisMonth() {
        LocalDate start = LocalDate.now().withDayOfMonth(1);
        LocalDate end = LocalDate.now();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery(
                    "SELECT COUNT(d) FROM Don d WHERE d.dateDon BETWEEN :start AND :end", Long.class
            );
            query.setParameter("start", start);
            query.setParameter("end", end);
            return query.uniqueResult().intValue();
        }
    }


    @Override
    public List<Don> getRecentDons(int limit) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Don> query = session.createQuery("FROM Don d ORDER BY d.dateDon DESC", Don.class);
            query.setMaxResults(limit);
            return query.list();
        }
    }
    @Override
    public List<Don> findByDonneur(int donneurId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Don> query = session.createQuery(
                    "FROM Don WHERE donneur.id = :id ORDER BY dateDon DESC", Don.class);
            query.setParameter("id", donneurId);
            return query.list();
        }
    }

    @Override
    public Don findLastDonationByDonneur(int donneurId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Don> query = session.createQuery(
                    "FROM Don WHERE donneur.id = :id ORDER BY dateDon DESC", Don.class);
            query.setParameter("id", donneurId);
            query.setMaxResults(1);
            return query.uniqueResult();
        }
    }
}
