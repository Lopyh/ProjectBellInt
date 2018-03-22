package EAS.user.DAO.impl;

import EAS.user.DAO.UserDAO;
import EAS.user.model.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO{

    @PersistenceContext(type= PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public Users getById(Integer Id) {
        return em.find(Users.class, Id);
    }

    @Override
    public List<Users> list(Integer officeId, String firstName, String lastName, String middleName,
                            String position, Integer docCode, Integer citizenshipCode) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Users> criteria = builder.createQuery(Users.class);
        Root<Users> root = criteria.from(Users.class);


        CriteriaQuery<Users> where = criteria.where(builder.and(
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
    public void update(Users users){
        em.merge(users);
    }

    @Override
    public void remove(Users users) {
        em.remove(users);
    }

    @Override
    public void save(Users users) {
        em.persist(users);
    }


}
