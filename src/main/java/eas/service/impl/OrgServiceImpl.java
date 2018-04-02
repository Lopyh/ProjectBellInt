package eas.service.impl;


import eas.dao.OrganizationDAO;
import eas.model.Organization;
import eas.orika.OrganizationOrika;
import eas.orika.OrikaMapperFactory;
import eas.service.OrgService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OrgServiceImpl implements OrgService {

    OrikaMapperFactory mapperFactory;
    OrganizationDAO dao;

    @Autowired
    private OrgServiceImpl(OrganizationDAO dao, OrikaMapperFactory mapperFactory) {
        this.dao = dao;
        this.mapperFactory = mapperFactory;
    }


    @Override
    @Transactional
    public List<OrganizationOrika> list(OrganizationOrika organizationOrika) {
        Organization organization = mapperFactory.getOrgMapper().mapReverse(organizationOrika);
        List<Organization> organizationList = dao.list(organization.getName(),organization.getInn(),organization.getIsActive());
        List<OrganizationOrika> result = new ArrayList<OrganizationOrika>();
        for (Organization o: organizationList
             ) {
            result.add(mapperFactory.getOrgMapper().map(o));
        }
        return result;
    }

    @Override
    @Transactional
    public OrganizationOrika getById(Integer id){
        OrganizationOrika organizationOrika = mapperFactory.getOrgMapper().map(dao.getById(id));
        return organizationOrika;
    }

    @Override
    @Transactional
    public void delete(OrganizationOrika organizationOrika) {
        if (dao.getById(organizationOrika.getId())!=null){
            dao.remove(dao.getById(organizationOrika.getId()));
        }
    }

    @Override
    @Transactional
    public void saveOrg(OrganizationOrika organizationOrika) {
        Organization organization = mapperFactory.getOrgMapper().mapReverse(organizationOrika);
        dao.save(organization);
    }

    @Override
    @Transactional
    public void update(OrganizationOrika organizationOrika) {
        Organization organization = mapperFactory.getOrgMapper().mapReverse(organizationOrika);
        dao.update(organization);
    }
}
