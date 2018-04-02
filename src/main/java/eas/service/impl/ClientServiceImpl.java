package eas.service.impl;

import eas.dao.ClientDAO;
import eas.model.Client;
import eas.orika.ClientOrika;
import eas.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class ClientServiceImpl implements ClientService{
    private ClientDAO dao;

    @Autowired
    private ClientServiceImpl(ClientDAO dao){
        this.dao = dao;
    }


    @Transactional
    public void save(ClientOrika orika) {
        Client client = new Client(orika.getLogin(), orika.getPassword(), orika.getName());
        dao.registr(client);
    }
}
