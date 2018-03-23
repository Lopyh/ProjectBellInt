package eas.dao;

import eas.model.Client;

public interface ClientDAO {
    /**Регистрирование нового клиента*/
    void registr(Client client);
    /**Отправка активационного кода*/
    void activationCode();
    /**Поиск клиента по логину*/
    Client findByName(String name);
}
