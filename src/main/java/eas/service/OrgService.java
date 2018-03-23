package eas.service;


import eas.model.Organization;

import java.util.List;

public interface OrgService {



    public List<Organization> list(String name,String inn, boolean isActive);
    public String getById(Integer id);
    public String delete(Integer id);
    public String saveOrg(String nameOr, String fullName, String inn,
                          int kpp, String address, String phone, boolean isActive);
    public String update(String nameOr, String fullName, String inn,
                         int kpp, String address, String phone, boolean isActive);


}
