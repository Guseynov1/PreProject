package Spring.PP215;

import Spring.PP215.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        KoscheiTheDeathless koscheiTheDeathless = applicationContext.getBean(KoscheiTheDeathless.class);
        System.out.println(koscheiTheDeathless.getRulesByDeth());
    }
}