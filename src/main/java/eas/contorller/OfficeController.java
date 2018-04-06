package eas.contorller;

import eas.contorller.impl.ResultView;
import eas.orika.OfficeOrika;

import java.util.List;

public interface OfficeController {
    /**Лист офисов по id организации
     “orgId”:””, //обязательный параметр
     “name”:””,
     “phone”:””,
     “isActive”
     */
    List<OfficeOrika> list(Integer orgId, OfficeOrika officeOrika);

    /**Выбрать офис по его id*/
    OfficeOrika getById(Integer id);

    /**Апдейт офиса “id”:””,
     “name”:””,
     “address”:””,
     “phone”,””,
     “isActive”:”true”
     */
    ResultView update(OfficeOrika officeOrika);

    /**Удаление офиса по id*/
    ResultView delete(OfficeOrika officeOrika);

    /**Cохранение нового офиса
     * “name”:””,
     “address”:””,
     “phone”,””,
     “isActive”:”true”
     */
    ResultView save(OfficeOrika officeOrika);


}
