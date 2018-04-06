package eas.service.impl;



import eas.dao.CountryDAO;
import eas.dao.DocsDAO;
import eas.dao.OfficeDAO;
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

    private OfficeDAO officeDAO;
    private UserDAO dao;
    private DocsDAO daoDocs;
    private CountryDAO daoCountry;
    OrikaMapperFactory mapperFactory;

    @Autowired
    UserServiceImpl(UserDAO dao, OrikaMapperFactory mapperFactory, DocsDAO daoDocs,
                    CountryDAO daoCountry, OfficeDAO officeDAO){
        this.dao = dao;
        this.mapperFactory = mapperFactory;
        this.daoDocs = daoDocs;
        this.daoCountry = daoCountry;
        this.officeDAO = officeDAO;
    }

    @Override
    @Transactional
    public UserOrika getById(Integer id) {
            User user = dao.getById(id);
            UserOrika userOrika = mapperFactory.getUserMapper().map(dao.getById(id));
            userOrika.setDocCode(user.getDocType().getDocCode());
            userOrika.setDocName(user.getDocType().getDocName());
            userOrika.setCitizenshipCode(user.getCountry().getCitizenshipCode());
            userOrika.setCitizenshipName(user.getCountry().getCitizenshipName());
            userOrika.setIsIdentified(String.valueOf(user.getIdentified()));
            return userOrika;
    }

    @Override
    @Transactional
    public List<UserOrika> list(UserOrika userOrika) {
        System.out.println(userOrika);
        List<User> userList = dao.list(userOrika.getOfficeId(), userOrika.getFirstName(),
                userOrika.getLastName(), userOrika.getMiddleName(),
                userOrika.getPosition(), userOrika.getDocCode(), userOrika.getCitizenshipCode());
        List<UserOrika> result = new ArrayList<UserOrika>();
        for (User o: userList
             ) {
            UserOrika userOrika1;
            userOrika1 = mapperFactory.getUserMapper().map(o);
            userOrika1.setCitizenshipName(o.getCountry().getCitizenshipName());
            userOrika1.setCitizenshipCode(o.getCountry().getCitizenshipCode());
            userOrika1.setDocName(o.getDocType().getDocName());
            userOrika1.setDocCode(o.getDocType().getDocCode());
            userOrika1.setId(o.getId());
            userOrika1.setOfficeId(o.getOffice().getId());
            userOrika1.setIsIdentified(String.valueOf(o.getIdentified()));
            result.add(userOrika1);
        }
        return result;
    }

    @Override
    @Transactional
    public void delete(UserOrika userOrika) {
            dao.remove(dao.getById(userOrika.getId()));
    }

    @Override
    @Transactional
    public void save(UserOrika userOrika){
        User user = mapperFactory.getUserMapper().mapReverse(userOrika);
        user.setDocType(daoDocs.getByCode(userOrika.getDocCode()));
        user.setCountry(daoCountry.getByCode(userOrika.getCitizenshipCode()));
        user.setOffice(officeDAO.getById(userOrika.getOfficeId()));
        user.setIdentified(Boolean.valueOf(userOrika.getIsIdentified()));
        dao.save(user);
    }

    @Override
    @Transactional
    public void update(UserOrika userOrika) {
        User user = dao.getById(userOrika.getId());

        user.setFirstName(userOrika.getFirstName());
        user.setLastName(userOrika.getLastName());
        user.setMiddleName(userOrika.getMiddleName());
        user.setPosition(userOrika.getPosition());
        user.setPhone(userOrika.getPhone());
        user.setDocNumber(userOrika.getDocNumber());
        user.setDocDate(userOrika.getDocDate());
        user.setIdentified(Boolean.valueOf(userOrika.getIsIdentified()));
        user.setDocType(daoDocs.getByName(userOrika.getDocName()));
        user.setCountry(daoCountry.getByCode(userOrika.getCitizenshipCode()));
        user.setIdentified(Boolean.valueOf(userOrika.getIsIdentified()));

        dao.update(user);
    }
}
