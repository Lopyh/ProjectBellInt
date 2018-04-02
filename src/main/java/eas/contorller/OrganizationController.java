package eas.contorller;

import eas.model.Organization;
import eas.orika.OrganizationOrika;

import java.util.List;

public interface OrganizationController {
    /**Лист организаций по параметрам Название, ИНН, Активность */
    List<OrganizationOrika> list(OrganizationOrika organizationOrika);/** - */

    /**Выбрать организацию по id*/
    String getById(Integer id);/** + */

    /**Апдейт органицазии*/
    void update(OrganizationOrika organizationOrika);
//    Integer id, String name, String fullName, String inn, String kpp,
//    String address, String phone, boolean isActive

    /**Cохранение новой организации*/
    void save(OrganizationOrika organizationOrika);

    /**Удаление по id*/
    void delete(OrganizationOrika organizationOrika);
}
