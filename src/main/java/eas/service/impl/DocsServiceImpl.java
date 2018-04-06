package eas.service.impl;

import eas.dao.DocsDAO;

import eas.model.DocType;

import eas.service.DocsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class DocsServiceImpl implements DocsService{
    DocsDAO dao;

    @Autowired
    DocsServiceImpl(DocsDAO dao){
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<DocType> list() {
       return dao.list();
    }



}
