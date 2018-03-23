package eas.dao.impl;

import eas.dao.ClientDAO;
import eas.model.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

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
    public Client findByName(String name) {
        return em.find(Client.class, name);
    }

}
