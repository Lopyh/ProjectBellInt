package eas.dao;


import eas.model.Organization;

import java.util.List;

public interface OrganizationDAO {
    /**Получение организации по Id*/
    public Organization getById(Integer Id);
    /**ист всех организаций*/
    public List<Organization> all();
    /**Сохранение новой организации*/
    public void save(Organization organization);
    /**Удаление организации*/
    public void remove(Organization organization);
    /**Обновление организации*/
    public void update(Organization organization);
    /**Лист организаций по опр. параметрам*/
    public List<Organization> list(String name,String inn, boolean isActive);
}
