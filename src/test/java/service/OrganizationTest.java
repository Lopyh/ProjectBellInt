package service;



import eas.orika.OrganizationOrika;
import eas.service.OrgService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:/appConfig.xml")
public class OrganizationTest{
    @Autowired
    OrgService orgService;

    @Autowired
    OrganizationOrika organizationOrika;

    @Test
    public void getById() {
        String name = orgService.getById(1).getName();
        Assert.assertEquals("Samsung", name);
    }

    @Test
    public void updateOrg(){
        organizationOrika.setId(1);
        organizationOrika.setName("Microsoft");
        organizationOrika.setFullName("OAO Micro");
        organizationOrika.setInn("12345");
        organizationOrika.setKpp("54321");
        organizationOrika.setAddress("Zhukova");
        organizationOrika.setPhone("785212");
        organizationOrika.setIsActive("true");
        orgService.update(organizationOrika);
        Assert.assertEquals(organizationOrika.getId(),orgService.getById(1).getId());
        Assert.assertEquals(organizationOrika.getName(),orgService.getById(1).getName());
        Assert.assertEquals(organizationOrika.getFullName(),orgService.getById(1).getFullName());
        Assert.assertEquals(organizationOrika.getInn(),orgService.getById(1).getInn());
        Assert.assertEquals(organizationOrika.getKpp(),orgService.getById(1).getKpp());
        Assert.assertEquals(organizationOrika.getAddress(),orgService.getById(1).getAddress());
        Assert.assertEquals(organizationOrika.getPhone(),orgService.getById(1).getPhone());
        Assert.assertEquals(organizationOrika.getIsActive(),orgService.getById(1).getIsActive());
    }

    @Test
    public void deleteOrg(){
        organizationOrika = orgService.getById(1);
        orgService.delete(organizationOrika);
        Assert.assertNotEquals(organizationOrika,orgService.getById(1));
    }

}
