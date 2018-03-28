package eas.orika;


import eas.model.Client;
import eas.model.Organization;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

public class Mapper extends ConfigurableMapper {
    protected void configure(MapperFactory factory){
        factory.classMap(Organization.class, OrganizationOrika.class)
                .field("id", "id")
                .field("nameOr","nameOr")
                .field("fullName","fullName")
                .field("inn","inn")
                .field("kpp","kpp")
                .field("address","address")
                .field("phone","phone")
                .field("isActive","isActive")
                .field("offices","offices")
                .byDefault()
                .register();

        factory.classMap(Client.class, ClientOrika.class)
                .field("login","login")
                .field("password", "password")
                .field("name", "name")
                .byDefault()
                .register();
    }
}