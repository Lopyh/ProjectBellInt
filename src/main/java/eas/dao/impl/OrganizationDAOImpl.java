package eas.dao.impl;


import eas.dao.OrganizationDAO;
import eas.model.Organization;

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
public class OrganizationDAOImpl implements OrganizationDAO {

    @PersistenceContext(type= PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public Organization getById(Integer Id) {
        return em.find(Organization.class, Id);
    }

    @Override
    public List<Organization> all() {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o", Organization.class);
        return query.getResultList();
    }

    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }

    @Override
    public void remove(Organization organization) {
        em.remove(organization);
    }

    @Override
    public void update(Organization organization) {
        em.merge(organization);
    }

    @Override
    public List<Organization> list(String name, String inn, boolean isActive
                                   ) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);
        Root<Organization> root = criteria.from(Organization.class);


        CriteriaQuery<Organization> where = criteria.where(builder.and(
                builder.like(root.<String>get("nameOr"), "%" + name + "%"),
                builder.like(root.<String>get("inn"), "%" + inn + "%"),
                builder.equal(root.<Boolean>get("isActive"), isActive))
        );
        return em.createQuery(criteria).getResultList();

    }


}
