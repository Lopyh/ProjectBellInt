package eas.service.impl;

import eas.dao.OfficeDAO;
import eas.model.Office;
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
   OfficeDAO dao;

   @Autowired
   OfficeServiceImpl (OfficeDAO dao, OrikaMapperFactory mapperFactory){
       this.mapperFactory = mapperFactory;
       this.dao = dao;
   }


    @Override
    @Transactional
    public List<OfficeOrika> list(OfficeOrika officeOrika) {
        List<Office> offices = dao.list(officeOrika.getId(),officeOrika.getName(),officeOrika.getPhone(),officeOrika.isActive());
        List<OfficeOrika> result = new ArrayList<OfficeOrika>();
        for (Office o: offices
             ) {
            result.add(mapperFactory.getOfficeMapper().map(o));
        }
        return result;
    }

    @Override
    @Transactional
    public OfficeOrika getById(Integer id) {
        OfficeOrika officeOrika = mapperFactory.getOfficeMapper().map(dao.getById(id));
        return officeOrika;
    }

    @Override
    @Transactional
    public void update(OfficeOrika officeOrika) {
        dao.update(mapperFactory.getOfficeMapper().mapReverse(officeOrika));
    }

    @Override
    @Transactional
    public void delete(OfficeOrika officeOrika) {
        dao.remove(mapperFactory.getOfficeMapper().mapReverse(officeOrika));
    }

    @Override
    @Transactional
    public void save(OfficeOrika officeOrika) {
        dao.save(mapperFactory.getOfficeMapper().mapReverse(officeOrika));
    }

}
