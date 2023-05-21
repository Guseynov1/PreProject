package Spring.PP213;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigPP213.class);
        HelloWorld bean1h = (HelloWorld) applicationContext.getBean("helloworld");
        HelloWorld bean2h = (HelloWorld) applicationContext.getBean("helloworld");

        Cat bean1c = (Cat) applicationContext.getBean("cat");
        Cat bean2c = (Cat) applicationContext.getBean("cat");

        System.out.println(bean1h.equals(bean2h));
        System.out.println(bean1c.equals(bean2c));
    }
}