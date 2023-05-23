package PP214;

import PP214.config.AppConfigPP214;
import PP214.model.AnimalsCage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigPP214.class);
        for (int i = 0; i < 5; i++) {
            AnimalsCage bean = applicationContext.getBean(AnimalsCage.class);
            bean.whatAnimalSay();
        }
    }

}
