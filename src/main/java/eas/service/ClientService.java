package eas.service;


import eas.orika.ClientOrika;

public interface ClientService {
    public void save(ClientOrika clientOrika);
    public String hashCode(String code);
    public void login(ClientOrika clientOrika);



}
