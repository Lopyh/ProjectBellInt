package eas.dao.impl;

import eas.dao.OfficeDAO;
import eas.model.Office;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OfficeDAOimpl implements OfficeDAO {

    @PersistenceContext(type= PersistenceContextType.EXTENDED)
    private EntityManager em;


    @Override
    public List<Office> all() {
        TypedQuery<Office> query = em.createQuery("SELECT h FROM Office h", Office.class);
        return query.getResultList();
    }

    @Override
    public List<Office> list(Integer orgId, String name, String phone, boolean isActive) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteria = builder.createQuery(Office.class);
        Root<Office> root = criteria.from(Office.class);

        CriteriaQuery<Office> where = criteria.where(builder.and(
                builder.equal(root.<Integer>get("organization"), orgId),
                builder.like(root.<String>get("nameOf"),"%" + name + "%"),
                builder.like(root.<String>get("phone"), "%"+phone+"%"),
                builder.equal(root.<Boolean>get("isActive"), isActive)

        ));
        return em.createQuery(criteria).getResultList();
    }

    @Override
    public Office getById(Integer id) {
        return em.find(Office.class, id);
    }

    @Override
    public void update(Office office) {
        em.merge(office);
    }

    @Override
    public void remove(Office office) {
        em.remove(office);
    }

    @Override
    public void save(Office office) {
        em.persist(office);
    }
}
