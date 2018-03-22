package EAS.user.service;

import EAS.user.model.Users;

import java.sql.Date;
import java.util.List;

public interface UserService {

    Users getById(Integer id);
    List<Users> list(Integer officeId, String firstName, String lastName,
                     String middleName, String position, Integer docCode, Integer citizenshipCode);
    String update(Integer id, String firstName, String secondName,
                  String middleName, String position, String phone, String docName,
                  Integer docNumber, String docDate, String citizenshipName, Integer citizenshipCode, boolean isIdentified);
    String delete(Integer id);
    String save(String firstName, String secondName,
                String middleName, String position, String phone, String docName,
                Integer docNumber, Date docDate, String citizenshipName, Integer citizenshipCode, boolean isIdentified);

}
