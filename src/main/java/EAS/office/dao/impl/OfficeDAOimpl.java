package EAS.office.dao.impl;

import EAS.office.dao.OfficeDAO;
import EAS.office.model.Office;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OfficeDAOimpl implements OfficeDAO {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Office> all() {
        TypedQuery<Office> query = em.createQuery("SELECT h FROM Office h", Office.class);
        return query.getResultList();
    }

    @Override
    public Office getById(Integer id) {
        return em.find(Office.class, id);
    }
}
