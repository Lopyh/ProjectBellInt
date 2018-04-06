package eas.contorller;

import eas.contorller.impl.ResultView;
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
    UserOrika getUserById(Integer id);

    /** апдейт юзера по */
    ResultView update(UserOrika userOrika);

    /**удаление юзера*/
    ResultView delete(UserOrika userOrika);

    /** сохранение нового юзера*/
    ResultView save(UserOrika userOrika);
}
