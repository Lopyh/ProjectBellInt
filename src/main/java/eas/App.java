package eas;

import eas.orika.ClientOrika;
import eas.service.ClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.URISyntaxException;

public class App {
    public static void main(String[] args) throws URISyntaxException {
        ApplicationContext application = new ClassPathXmlApplicationContext("appConfig.xml");//

        ClientService clientService = application.getBean(ClientService.class);
        ClientOrika clientOrika = new ClientOrika();
        clientOrika.setLogin("Jora322");
        clientOrika.setPassword("qwer123");
        clientOrika.setName("Jora");
        clientService.save(clientOrika);




    }
}
