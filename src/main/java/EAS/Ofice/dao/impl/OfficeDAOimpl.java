package EAS.Ofice.dao.impl;

import EAS.Ofice.model.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OfficeDAOimpl implements ru.bellintegrator.practice.Office.dao.OfficeDAO{

    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public OfficeDAOimpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<Office> all() {
        TypedQuery<Office> query = em.createQuery("SELECT h FROM Office h", Office.class);
        return query.getResultList();
    }
}
