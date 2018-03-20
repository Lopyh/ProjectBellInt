package EAS.user.service;

import EAS.user.model.Users;

import java.util.List;

public interface UserService {

    Users getById(Integer id);
    List<Users> list(Integer officeId, String firstName, String lastName,
                     String middleName, String position, Integer docCode, Integer citizenshipCode);
    String update();
    String delete(Integer id);
    String save();

}
