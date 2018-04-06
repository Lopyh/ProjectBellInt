package eas.dao.impl;

import eas.dao.CountryDAO;
import eas.model.Country;
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
public class CountryDAOImpl implements CountryDAO {
    @PersistenceContext(type= PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public List<Country> list() {
        TypedQuery<Country> query = em.createQuery("SELECT o FROM Country o", Country.class);
        return query.getResultList();
    }

    @Override
    public Country getByCode(Integer code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Country> criteria = builder.createQuery(Country.class);
        Root<Country> root = criteria.from(Country.class);

        CriteriaQuery<Country> where = criteria.where(
                builder.equal(root.<Integer>get("citizenshipCode"), code)
        );
        return em.createQuery(criteria).getSingleResult();
    }
}
