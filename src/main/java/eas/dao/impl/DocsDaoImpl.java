package eas.dao.impl;

import eas.dao.DocsDAO;
import eas.model.DocType;


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
public class DocsDaoImpl implements DocsDAO{
    @PersistenceContext(type= PersistenceContextType.EXTENDED)
    private EntityManager em;


    @Override
    public List<DocType> list() {
        TypedQuery<DocType> query = em.createQuery("SELECT o FROM DocType o", DocType.class);
        return query.getResultList();
    }

    @Override
    public DocType getByCode(Integer code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<DocType> criteria = builder.createQuery(DocType.class);
        Root<DocType> root = criteria.from(DocType.class);

        CriteriaQuery<DocType> where = criteria.where(
                builder.equal(root.<Integer>get("docCode"), code)
        );
        return em.createQuery(criteria).getSingleResult();
    }

    @Override
    public DocType getByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<DocType> criteria = builder.createQuery(DocType.class);
        Root<DocType> root = criteria.from(DocType.class);

        CriteriaQuery<DocType> where = criteria.where(
                builder.like(root.<String>get("docName"), "%"+name+"%")
        );
        return em.createQuery(criteria).getSingleResult();
    }
}
