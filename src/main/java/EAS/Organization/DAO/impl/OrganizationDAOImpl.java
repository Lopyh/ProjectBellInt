package EAS.Organization.DAO.impl;

import EAS.Organization.DAO.OrganizationDAO;
import EAS.Organization.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class OrganizationDAOImpl implements OrganizationDAO {
    @PersistenceContext
    private EntityManager em;

//    @Autowired
//    OrganizationDAOImpl(EntityManager em){
//        this.em = em;
//    }

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


}
