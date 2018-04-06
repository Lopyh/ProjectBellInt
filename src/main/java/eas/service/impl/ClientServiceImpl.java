package eas.service.impl;

import eas.dao.ClientDAO;
import eas.hash.HashCreator;
import eas.model.Client;
import eas.orika.ClientOrika;
import eas.orika.OrikaMapperFactory;
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
    OrikaMapperFactory mapperFactory;


    @Autowired
    private ClientServiceImpl(ClientDAO dao, OrikaMapperFactory mapperFactory){
        this.dao = dao;
        this.mapperFactory = mapperFactory;
    }


    @Transactional
    public void save(ClientOrika orika) {
        Client client = new Client(orika.getLogin(), HashCreator.getSHA256(orika.getPassword()),
                orika.getName(), HashCreator.getSHA256(HashCreator.randomString()));
        dao.registr(client);
    }

    @Override
    public String hashCode(String code) {
        return HashCreator.getSHA256(code);
    }

    @Override
    public void login(ClientOrika clientOrika) {
        dao.findByLoginPassword(mapperFactory.getClientMapper().mapReverse(clientOrika));
    }
}
