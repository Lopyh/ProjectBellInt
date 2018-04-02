package eas.orika;

import eas.model.Office;
import eas.model.Organization;
import eas.model.User;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.MapperFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrikaMapperFactory {

    BoundMapperFacade<Organization, OrganizationOrika> orgMapper;
    BoundMapperFacade<Office, OfficeOrika> officeMapper;
    BoundMapperFacade<User, UserOrika> userMapper;


    @Autowired
    public OrikaMapperFactory(){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        orgMapper = mapperFactory.getMapperFacade(Organization.class, OrganizationOrika.class);
        officeMapper = mapperFactory.getMapperFacade(Office.class, OfficeOrika.class);
        userMapper = mapperFactory.getMapperFacade(User.class, UserOrika.class);
    }

    public BoundMapperFacade<Office, OfficeOrika> getOfficeMapper() {
        return officeMapper;
    }

    public void setOfficeMapper(BoundMapperFacade<Office, OfficeOrika> officeMapper) {
        this.officeMapper = officeMapper;
    }

    public BoundMapperFacade<User, UserOrika> getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(BoundMapperFacade<User, UserOrika> userMapper) {
        this.userMapper = userMapper;
    }

    public BoundMapperFacade<Organization, OrganizationOrika> getOrgMapper() {
        return orgMapper;
    }

    public void setOrgMapper(BoundMapperFacade<Organization, OrganizationOrika> orgMapper) {
        this.orgMapper = orgMapper;
    }
}
