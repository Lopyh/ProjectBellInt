package EAS;

import EAS.Organization.DAO.OrganizationDAO;

import EAS.Organization.model.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class App {
    public static void main(String[] args) {
        ApplicationContext application = new ClassPathXmlApplicationContext("appConfig.xml");

        OrganizationDAO dao = (OrganizationDAO) application.getBean(OrganizationDAO.class);
        Organization org = dao.getById(1);
        System.out.println(org);

//        List<Organization> org1 = dao.all();
//        for (Organization r: org
//                ) {
//            System.out.println(org);
//        }
    }
}
