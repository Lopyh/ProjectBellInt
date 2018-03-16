package EAS.organization.service.impl;


import EAS.organization.DAO.OrganizationDAO;
import EAS.organization.model.Organization;
import EAS.organization.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OrgServiceImpl implements OrgService {

    OrganizationDAO dao;

    @Autowired
    private OrgServiceImpl(OrganizationDAO dao){
        this.dao = dao;
    }

    @Override
    @Transactional
    public String getById(Integer id){
        return ("id: "+dao.getById(id).getId()+", name: "+dao.getById(id).getNameOr()+
                ", fullName "+"inn: "+dao.getById(id).getInn()+", kkp: "+dao.getById(id).getKpp()+
                ", adress: "+dao.getById(id).getAddress()+", phone: "+dao.getById(id).getPhone()+
                ", isActive: "+dao.getById(id).getIsActive());
    }

    @Override
    @Transactional
    public String delete(Integer id) {
        if (dao.getById(id)!=null){
            dao.remove(dao.getById(id));
        }
        return "Success";
    }

    @Override
    public String saveOrg(String nameOr, String fullName, int inn, int kpp, String address, String phone, boolean isActive) {
        Organization organization = new Organization(nameOr, fullName, inn, kpp, address, phone, isActive);
        dao.save(organization);
        return "Success";
    }

    @Override
    public String update(String nameOr, String fullName, int inn, int kpp, String address, String phone, boolean isActive) {
       return "Success";
    }


}
