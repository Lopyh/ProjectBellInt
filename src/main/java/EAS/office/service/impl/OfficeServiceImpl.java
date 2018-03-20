package EAS.office.service.impl;

import EAS.office.dao.OfficeDAO;
import EAS.office.model.Office;
import EAS.office.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService{

   OfficeDAO dao;

   @Autowired
   OfficeServiceImpl (OfficeDAO dao){
       this.dao = dao;
   }


    @Override
    @Transactional
    public List<Office> list(Integer orgId, String name, String phone, boolean isActive) {
        return dao.list(orgId, name, phone, isActive);
    }

    @Override
    @Transactional
    public Office getById(Integer id) {
        return dao.getById(id);
    }

    @Override
    @Transactional
    public String update(Integer id, String name, String address, String phone, boolean isActive) {
        return null;
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
    @Transactional
    public String save(String name, String address, String phone, boolean isActive) {
       Office office =  new Office(name, address, phone, isActive);
       dao.save(office);
       return "Success";
    }

    @Override
    public List<Office> all() {
        return dao.all();
    }
}
