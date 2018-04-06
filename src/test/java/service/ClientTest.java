package service;

import eas.hash.HashCreator;
import eas.orika.ClientOrika;
import eas.service.ClientService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:/appConfig.xml")
public class ClientTest {

    @Autowired
    ClientService clientService;

    @Test
    public void test() {
        ClientOrika clientOrika = new ClientOrika("pol","lol", "Paul");
        clientService.save(clientOrika);
        Assert.assertEquals(1, 1);
    }

    @Test
    public void hashCod() {
        Assert.assertEquals(clientService.hashCode("qwer123"), HashCreator.getSHA256("qwer123"));
    }
}
