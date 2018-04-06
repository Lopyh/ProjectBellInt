package eas.service;


import eas.orika.UserOrika;
import java.util.List;

public interface UserService {

    UserOrika getById(Integer id);
    List<UserOrika> list(UserOrika userOrika);
    void update(UserOrika userOrika);
    void delete(UserOrika userOrika);
    void save(UserOrika userOrika);

}
