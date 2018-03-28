package eas;

import eas.dao.ClientDAO;
import eas.dao.OrganizationDAO;
import eas.model.Client;
import eas.model.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class App {
    public static void main(String[] args) {
        ApplicationContext application = new ClassPathXmlApplicationContext("WEB-INF/appConfig.xml");
//
        OrganizationDAO dao = (OrganizationDAO) application.getBean(OrganizationDAO.class);
        Organization org = dao.getById(1);
        System.out.println(org);
//
//        OfficeDAO daoOffice = application.getBean(OfficeDAO.class);
//        Office office = daoOffice.getById(2);
//        System.out.println(office.getId());
//
//        OrgService orgService = application.getBean(OrgService.class);
//
//        System.out.println(orgService.saveOrg("Жж","ц", 52, 34,"Промышленная 23", "785212", true));
//
//        System.out.println(orgService.getById(2));
//
//
//
//        System.out.println(HashSHA.getSHA256("SHA-256"));

//        OrgService organizationDAO = application.getBean(OrgService.class);
//        List<Organization> list = organizationDAO.list("Рога","123", true);
//        for (Organization or: list
//             ) {
//            System.out.println(or);
//        }
//        System.out.println("вот так вот");
//
//        OfficeDAO officeDAO = application.getBean(OfficeDAO.class);
//        Office office = officeDAO.getById(1);
//        System.out.println(office);

//       OfficeService officeService = application.getBean(OfficeService.class);
//        System.out.println(officeService.save("Офис рогов", "Энгельса 21", "78 52 12", true));
//
//        UserService userDAO = application.getBean(UserService.class);
//        userDAO.save("Василий", "Петров", "Сидорович", "Повар", "322", "",123,
//                Date.valueOf("2012-07-24"), "УФМС Опа", 322, true);

        ClientDAO clientDAO =application.getBean(ClientDAO.class);
        Client mn = new Client("Vasya", "qwer123", "Vasilii");
        clientDAO.registr(mn);

        ClientDAO clientDAO1 =application.getBean(ClientDAO.class);
        List<Client> list = clientDAO1.list();

        for (Client o: list
             ) {
            System.out.println(o);
        }



    }
}
