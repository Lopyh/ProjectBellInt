package eas.dao.impl;

import eas.dao.CountryDAO;
import eas.model.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
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
}
