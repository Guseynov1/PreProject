package Spring.PP215;

import Spring.PP215.config.AppConfigPP215;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigPP215.class);
        KoscheiTheDeathless koscheiTheDeathless = applicationContext.getBean(KoscheiTheDeathless.class);
        System.out.println(koscheiTheDeathless.getRulesByDeth());
    }
}