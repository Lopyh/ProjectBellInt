package service;


import eas.orika.OfficeOrika;
import eas.service.OfficeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:/appConfig.xml")
public class OfficeTest {

    @Autowired
    OfficeService officeService;

    @Autowired
    OfficeOrika officeOrika;


    @Test
    public void getById() {
        String name = officeService.getById(1).getName();
        Assert.assertEquals("Mazda Office 1", name);
    }

    @Test
    public void updateOffice(){
        officeOrika.setId(4);
        officeOrika.setName("OBI");
        officeOrika.setAddress("Bolshaya Bronnaya");
        officeService.update(officeOrika);

        Assert.assertEquals(officeOrika.getName(),officeService.getById(4).getName());
        Assert.assertEquals(officeOrika.getAddress(),officeService.getById(4).getAddress());
    }
}
