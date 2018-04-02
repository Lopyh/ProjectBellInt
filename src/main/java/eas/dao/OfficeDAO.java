package eas.dao;

import eas.model.Office;


import java.util.List;

public interface OfficeDAO {

    /**Лист офисов с опр. занчениями полей*/
    List<Office> list(Integer orgId, String name, String phone, boolean isActive);
    /**Посик офиса по Id */
    Office getById(Integer id);
    /**Обнавление офиса*/
    public void update(Office office);
    /**Удаление офиса*/
    public void remove(Office office);
    /**Сохранение нового офиса*/
    public void save(Office office);
}
