package eas.dao;

import eas.model.Client;

import java.util.List;

public interface ClientDAO {
    /**Регистрирование нового клиента*/
    void registr(Client client);
    /**Отправка активационного кода*/
    void activationCode();
    /**Поиск клиента по логину*/
    Client findById(Integer id);
    List<Client> list();

}
