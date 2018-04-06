package eas.service.impl;

import eas.dao.OfficeDAO;
import eas.dao.OrganizationDAO;
import eas.model.Office;
import eas.model.Organization;
import eas.orika.OfficeOrika;
import eas.orika.OrikaMapperFactory;
import eas.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OfficeServiceImpl implements OfficeService{

   OrikaMapperFactory mapperFactory;
   OrganizationDAO organizationDAO;
   OfficeDAO dao;

   @Autowired
   OfficeServiceImpl (OfficeDAO dao, OrikaMapperFactory mapperFactory, OrganizationDAO organizationDAO){
       this.mapperFactory = mapperFactory;
       this.dao = dao;
       this.organizationDAO = organizationDAO;

   }


    @Override
    @Transactional
    public List<OfficeOrika> list(OfficeOrika officeOrika) {
        List<Office> offices = dao.list(officeOrika.getOrgId(), officeOrika.getName(),
                officeOrika.getPhone(),Boolean.valueOf(officeOrika.getIsActive()));
        List<OfficeOrika> result = new ArrayList<OfficeOrika>();
        for (Office o: offices
             ) {
            OfficeOrika officeOrika1 = mapperFactory.getOfficeMapper().map(o);
            officeOrika1.setOrgId(mapperFactory.getOfficeMapper().map(o).getOrganization().getId());
            result.add(officeOrika1);
        }
        return result;
    }

    @Override
    @Transactional
    public OfficeOrika getById(Integer id) {
       Office office = dao.getById(id);
        OfficeOrika officeOrika = mapperFactory.getOfficeMapper().map(office);
        officeOrika.setIsActive(String.valueOf(office.isActive()));
        System.out.println(officeOrika);
        return officeOrika;
    }

    @Override
    @Transactional
    public void update(OfficeOrika officeOrika) {
       Office office = dao.getById(officeOrika.getId());
       office.setName(officeOrika.getName());
       office.setAddress(officeOrika.getAddress());
       office.setPhone(officeOrika.getPhone());
       office.setActive(Boolean.valueOf(officeOrika.getIsActive()));
       System.out.println(office);
       dao.update(office);
    }

    @Override
    @Transactional
    public void delete(OfficeOrika officeOrika) {
        dao.remove(dao.getById(officeOrika.getId()));
    }

    @Override
    @Transactional
    public void save(OfficeOrika officeOrika) {
       Office office = mapperFactory.getOfficeMapper().mapReverse(officeOrika);
       Organization organization = organizationDAO.getById(officeOrika.getOrgId());
       office.setOrganization(organization);
       System.out.println(office);
       dao.save(office);
    }

}
