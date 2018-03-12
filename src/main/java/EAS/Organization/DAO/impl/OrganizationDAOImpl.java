package EAS.Organization.DAO.impl;

import EAS.Organization.DAO.OrganizationDAO;
import EAS.Organization.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
public class OrganizationDAOImpl implements OrganizationDAO {
    private final EntityManager em;

    @Autowired
    public OrganizationDAOImpl(EntityManager em){this.em = em;}


    @Override
    public Organization getById(Integer Id) {
        return em.find(Organization.class, Id);

    }
}
