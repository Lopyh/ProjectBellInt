package eas;



import eas.service.DocsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext application = new ClassPathXmlApplicationContext("appConfig.xml");//
//        ClientService clientService = application.getBean(ClientService.class);
//        ClientOrika orika = new ClientOrika("adf","adf","ff");
//
//        clientService.save(orika);
//        System.out.println(orika.getLogin());

//        OfficeDAO officeDAO = application.getBean(OfficeDAO.class);
//        List<Office> offices = officeDAO.list(2,"","",true);
//        for (Office o: offices
//             ) {
//            System.out.println(o);
//        }


    }
}
