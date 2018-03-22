package EAS;

import EAS.Client.DAO.ClientDAO;
import EAS.Client.model.Client;
import EAS.hashCreator.HashSHA;
import EAS.office.dao.OfficeDAO;
import EAS.office.model.Office;


import EAS.office.service.OfficeService;
import EAS.organization.DAO.OrganizationDAO;
import EAS.organization.model.Organization;
import EAS.organization.service.OrgService;
import EAS.organization.service.impl.OrgServiceImpl;
import EAS.user.DAO.UserDAO;
import EAS.user.model.Users;
import EAS.user.service.UserService;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.h2.engine.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.List;


public class App {
    public static void main(String[] args) {
        ApplicationContext application = new ClassPathXmlApplicationContext("appConfig.xml");
//
//        OrganizationDAO dao = (OrganizationDAO) application.getBean(OrganizationDAO.class);
//        Organization org = dao.getById(1);
//        System.out.println(org);
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

            ClientDAO clientDAO = application.getBean(ClientDAO.class);
            Client client = clientDAO.findByName("log");
            System.out.println(client);
    }
}
