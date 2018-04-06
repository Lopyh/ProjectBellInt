package eas.dao.impl;

import eas.dao.ClientDAO;
import eas.hash.HashCreator;
import eas.model.Client;


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
public class ClientDaoImpl implements ClientDAO{

    @PersistenceContext(type= PersistenceContextType.EXTENDED)
    private EntityManager em;


   @Override
    public void registr(Client client) {
        em.persist(client);
    }

    @Override
    public void activationCode() {

    }

    @Override
    public Client findByLoginPassword(Client client) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Client> criteria = builder.createQuery(Client.class);
        Root<Client> root = criteria.from(Client.class);

        CriteriaQuery<Client> where = criteria.where(builder.and(
                builder.like(root.<String>get("login"), client.getLogin()),
                builder.like(root.<String>get("password"), HashCreator.getSHA256(client.getPassword()))
        ));
        System.out.println(client.getLogin());
        System.out.println(HashCreator.getSHA256(client.getPassword()));
        return em.createQuery(criteria).getSingleResult();
    }


}
