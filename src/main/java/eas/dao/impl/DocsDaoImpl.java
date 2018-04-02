package eas.dao.impl;

import eas.dao.DocsDAO;
import eas.model.DocType;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DocsDaoImpl implements DocsDAO{
    @PersistenceContext(type= PersistenceContextType.EXTENDED)
    private EntityManager em;


    @Override
    public List<DocType> list() {
        TypedQuery<DocType> query = em.createQuery("SELECT o FROM DocType o", DocType.class);
        return query.getResultList();
    }
}
