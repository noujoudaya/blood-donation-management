package blooddonation.dao.impl;

import blooddonation.bean.Demande;
import blooddonation.dao.interfaces.DemandeDao;
import blooddonation.enums.GroupeSang;
import blooddonation.enums.Statut;
import blooddonation.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DemandeDaoImpl implements DemandeDao {

    @Override
    public int countActiveUrgent() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Long count = (Long) session.createQuery(
                            "SELECT COUNT(d) FROM Demande d WHERE d.statut = :urgent OR d.statut = :critique"
                    )
                    .setParameter("urgent", Statut.Urgent)
                    .setParameter("critique", Statut.Critique)
                    .uniqueResult();

            return count != null ? count.intValue() : 0;
        }
    }

    @Override
    public List<Demande> getRecentDemands(int limit) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Demande> query = session.createQuery(
                    "FROM Demande d ORDER BY d.dateDemande DESC", Demande.class
            );
            query.setMaxResults(limit);
            return query.list();
        }
    }

    @Override
    public List<Demande> findUrgentByGroup(GroupeSang group) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Demande> query = session.createQuery(
                    "FROM Demande d WHERE d.groupeSanguin = :grp AND (d.statut = :urgent OR d.statut = :critique) ORDER BY d.dateDemande DESC",
                    Demande.class
            );
            query.setParameter("grp", group.toString()); // if groupeSanguin is String
            query.setParameter("urgent", Statut.Urgent);
            query.setParameter("critique", Statut.Critique);
            query.setMaxResults(5);
            return query.list();
        }
    }
}
