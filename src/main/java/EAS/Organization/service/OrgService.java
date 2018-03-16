package EAS.organization.service;


public interface OrgService {



    public String getById(Integer id);
    public String delete(Integer id);
    public String saveOrg(String nameOr, String fullName, int inn,
                          int kpp, String address, String phone, boolean isActive);
    public String update(String nameOr, String fullName, int inn,
                         int kpp, String address, String phone, boolean isActive);


}
