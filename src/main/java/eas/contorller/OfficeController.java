package eas.contorller;

import eas.orika.OfficeOrika;

import java.util.List;

public interface OfficeController {
    /**Лист офисов по id организации
     “orgId”:””, //обязательный параметр
     “name”:””,
     “phone”:””,
     “isActive”
     */
    List<OfficeOrika> list(OfficeOrika officeOrika);

    /**Выбрать офис по его id*/
    String getById(Integer id);

    /**Апдейт офиса “id”:””,
     “name”:””,
     “address”:””,
     “phone”,””,
     “isActive”:”true”
     */
    void update(OfficeOrika officeOrika);

    /**Удаление офиса по id*/
    void delete(OfficeOrika officeOrika);

    /**Cохранение нового офиса
     * “name”:””,
     “address”:””,
     “phone”,””,
     “isActive”:”true”
     */
    void save(OfficeOrika officeOrika);


}
