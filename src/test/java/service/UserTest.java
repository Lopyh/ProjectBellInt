package service;

import eas.orika.UserOrika;
import eas.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:/appConfig.xml")
public class UserTest {
    @Autowired
    UserService userService;

    @Autowired
    UserOrika userOrika;

    @Test
    public void getById() {
        String name = userService.getById(1).getFirstName();
        Assert.assertEquals("Vladislav", name);
    }

    @Test
    public void updateUser() {
        userOrika.setId(2);
        userOrika.setFirstName("Vovan");
        userOrika.setDocCode(21);
        userOrika.setCitizenshipCode(643);
        userOrika.setDocName("Passport of the citizen of the Russian Federation");
        System.out.println(userOrika);
        userService.update(userOrika);
        Assert.assertEquals(userOrika.getFirstName(),userService.getById(2).getFirstName());
        Assert.assertEquals(userOrika.getDocCode(),userService.getById(2).getDocCode());
        Assert.assertEquals(userOrika.getCitizenshipCode(),userService.getById(2).getCitizenshipCode());
    }

}
