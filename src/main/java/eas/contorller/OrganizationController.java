package eas.contorller;

import eas.contorller.impl.ResultView;

import eas.orika.OrganizationOrika;

import java.util.List;

public interface OrganizationController {
    /**Лист организаций по параметрам Название, ИНН, Активность */
    List<OrganizationOrika> list(OrganizationOrika organizationOrika);/** - */

    /**Выбрать организацию по id*/
    OrganizationOrika getById(Integer id);/** + */

    /**Апдейт органицазии*/
    ResultView update(OrganizationOrika organizationOrika);
//    Integer id, String name, String fullName, String inn, String kpp,
//    String address, String phone, boolean isActive

    /**Cохранение новой организации*/
    ResultView save(OrganizationOrika organizationOrika);

    /**Удаление по id*/
    ResultView delete(OrganizationOrika organizationOrika);
}
