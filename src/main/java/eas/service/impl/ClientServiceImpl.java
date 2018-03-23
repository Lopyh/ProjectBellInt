package eas.service.impl;

import eas.dao.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl {
    private ClientDAO dao;

    @Autowired
    private ClientServiceImpl(ClientDAO dao){
        this.dao = dao;
    }


}
