package EAS.user.service.impl;


import EAS.user.DAO.UserDAO;
import EAS.user.model.Users;
import EAS.user.service.UserService;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO dao;

    @Autowired
    UserServiceImpl(UserDAO dao){
        this.dao = dao;
    }

    @Override
    @Transactional
    public Users getById(Integer id) {
        return dao.getById(id);
    }

    @Override
    @Transactional
    public List<Users> list(Integer officeId, String firstName, String lastName, String middleName,
                            String position, Integer docCode, Integer citizenshipCode) {
        return dao.list(officeId, firstName, lastName, middleName, position,docCode, citizenshipCode);
    }

    @Override
    @Transactional
    public String update(Integer id, String firstName, String secondName,
                         String middleName, String position, String phone, String docName,
                         Integer docNumber, String docDate, String citizenshipName, Integer citizenshipCode, boolean isIdentified) {
        return "Success";
    }

    @Override
    @Transactional
    public String delete(Integer id) {
        if (dao.getById(id)!=null){
            dao.remove(dao.getById(id));
        }
        return "Success";
    }

    @Override
    @Transactional
    public String save(String firstName, String secondName,
                       String middleName, String position, String phone, String docName,
                       Integer docNumber, Date docDate, String citizenshipName, Integer citizenshipCode, boolean isIdentified) {
        Users user = new Users(firstName, secondName, middleName, position, phone, docName, docNumber,
                docDate, citizenshipName, citizenshipCode, isIdentified);


        dao.save(user);
        return "Success";
    }
}
