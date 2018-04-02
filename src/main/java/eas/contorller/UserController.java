package eas.contorller;

import eas.orika.OfficeOrika;
import eas.orika.UserOrika;

import java.util.List;

public interface UserController {
    /** лист юзеров по входным параметрам
     * “officeId”:””, //обязательный параметр
     “firstName”:””,
     “lastName”:””,
     “middleName”:””,
     “position”,””,
     “docCode”:””,
     “citizenshipCode”:””
     */
    List<UserOrika> list(UserOrika userOrika);
    /** получить юзера по id*/
    String getUserById(Integer id);

    /** апдейт юзера по */
    void update(UserOrika userOrika);

    /**удаление юзера*/
    void delete(UserOrika userOrika);

    /** сохранение нового юзера*/
    void save(UserOrika userOrika);
}
