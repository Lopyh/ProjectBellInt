package eas.dao.impl;

import eas.dao.ClientDAO;
import eas.model.Client;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
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
    public Client findById(Integer id) {
        return em.find(Client.class, id);
    }

    @Override
    public List<Client> list() {
        TypedQuery<Client> query = em.createQuery("SELECT o FROM Client o", Client.class);
        return query.getResultList();
    }

}
