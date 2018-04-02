package eas.service.impl;


import eas.dao.UserDAO;
import eas.model.User;
import eas.orika.OrikaMapperFactory;
import eas.orika.UserOrika;
import eas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class UserServiceImpl implements UserService {
    private UserDAO dao;
    OrikaMapperFactory mapperFactory;

    @Autowired
    UserServiceImpl(UserDAO dao, OrikaMapperFactory mapperFactory){
        this.dao = dao;
        this.mapperFactory = mapperFactory;
    }

    @Override
    @Transactional
    public UserOrika getById(Integer id) {
        return mapperFactory.getUserMapper().map(dao.getById(id));
    }

    @Override
    @Transactional
    public List<UserOrika> list(UserOrika userOrika) {
        List<User> userList = dao.list(userOrika.getId(), userOrika.getFirstName(), userOrika.getLastName(), userOrika.getMiddleName(),
                userOrika.getPosition(), userOrika.getDocNumber(), userOrika.getCitizenshipCode());
        List<UserOrika> result = new ArrayList<UserOrika>();
        for (User o: userList
             ) {
            result.add(mapperFactory.getUserMapper().map(o));
        }
        return result;
    }

    @Override
    @Transactional
    public void delete(UserOrika userOrika) {
        if (dao.getById(userOrika.getId())!=null){
            dao.remove(dao.getById(userOrika.getId()));
        }
    }

    @Override
    @Transactional
    public void save(UserOrika userOrika){
        dao.save(mapperFactory.getUserMapper().mapReverse(userOrika));
    }

    @Override
    @Transactional
    public void update(UserOrika userOrika) {
        dao.update(mapperFactory.getUserMapper().mapReverse(userOrika));
    }
}
