package eas.dao;

import eas.model.User;

import java.util.List;

public interface UserDAO {
    /**Поиск юзера по id*/
    User getById(Integer id);
    /**Лист юзеров по орп. параметрам*/
    List<User> list(Integer officeId, String firstName, String lastName,
                     String middleName, String position, Integer docCode, Integer citizenshipCode);
    /**Обновление юзера*/
    void update(User user);
    /**Удаление юзера*/
    void remove(User user);
    /**Сохранение нового юзера*/
    void save(User user);
}
