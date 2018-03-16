package EAS.organization.DAO.impl;


import EAS.organization.DAO.OrganizationDAO;
import EAS.organization.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
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


}
