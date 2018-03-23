package eas.dao.impl;

import eas.dao.UserDAO;
import eas.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO{

    @PersistenceContext(type= PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public User getById(Integer Id) {
        return em.find(User.class, Id);
    }

    @Override
    public List<User> list(Integer officeId, String firstName, String lastName, String middleName,
                            String position, Integer docCode, Integer citizenshipCode) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);


        CriteriaQuery<User> where = criteria.where(builder.and(
                builder.equal(root.<Integer>get("office"), officeId),
                builder.like(root.<String>get("firstName"), "%" + firstName + "%"),
                builder.like(root.<String>get("lastName"), "%" + lastName + "%"),
                builder.like(root.<String>get("middleName"), "%" + middleName + "%"),
                builder.like(root.<String>get("positionUs"), "%" + position + "%"),
                builder.equal(root.<Integer>get("docNumber"), docCode)),
                builder.equal(root.<Integer>get("citizenshipCode"), citizenshipCode)
        );
        return em.createQuery(criteria).getResultList();
    }

    @Override
    public void update(User user){
        em.merge(user);
    }

    @Override
    public void remove(User user) {
        em.remove(user);
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }


}
