package EAS.user.DAO;

import EAS.user.model.Users;

import java.sql.Date;
import java.util.List;

public interface UserDAO {
    Users getById(Integer id);
    List<Users> list(Integer officeId, String firstName, String lastName,
                     String middleName, String position, Integer docCode, Integer citizenshipCode);

    void update(Users users);
    void remove(Users users);
    void save(Users users);
}
