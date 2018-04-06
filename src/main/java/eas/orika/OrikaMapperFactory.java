package eas.orika;

import eas.model.Client;
import eas.model.Office;
import eas.model.Organization;
import eas.model.User;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class OrikaMapperFactory {

    BoundMapperFacade<Organization, OrganizationOrika> orgMapper;
    BoundMapperFacade<Office, OfficeOrika> officeMapper;
    BoundMapperFacade<User,UserOrika> userMapper;
    BoundMapperFacade<Client,ClientOrika> clientMapper;


    @Autowired
    public OrikaMapperFactory(){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        userMapper = mapperFactory.getMapperFacade(User.class,UserOrika.class);
        orgMapper = mapperFactory.getMapperFacade(Organization.class, OrganizationOrika.class);
        officeMapper = mapperFactory.getMapperFacade(Office.class, OfficeOrika.class);
        clientMapper = mapperFactory.getMapperFacade(Client.class,ClientOrika.class);
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

    public BoundMapperFacade<Client, ClientOrika> getClientMapper() {
        return clientMapper;
    }

    public void setClientMapper(BoundMapperFacade<Client, ClientOrika> clientMapper) {
        this.clientMapper = clientMapper;
    }
}


//mapperFactory.classMap(User.class,UserOrika.class)
//        .field("docType.docName", "docName")
//        .field("docType.docCode","docCode")
//        .field("country.citizenshipName", "citizenshipName")
//        .field("country.citizenshipCode","citizenshipCode")
//        .field("firstName","firstName")
//        .field("lastName","lastName")
//        .field("middleName","middleName")
//        .field("position","position")
//        .field("phone","phone")
//        .field("docNumber","docNumber")
//        .field("docDate","docDate")
//        .field("isIdentified","isIdentified")
//        .byDefault().register();