package EAS;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) {
        ApplicationContext application = new ClassPathXmlApplicationContext("appConfig.xml");
    }
}
