package Spring.PP221;

import Spring.PP221.config.AppConfigPP221;
import Spring.PP221.model.Car;
import Spring.PP221.model.Users;
import Spring.PP221.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigPP221.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new Users("Bob", "Lacoste", "bob@mail.ru"), new Car("BMW",707));
        userService.add(new Users("Mike", "Perry", "mike@mail.ru"), new Car("Mercedes",421));
        userService.add(new Users("Piter", "Solazar", "piter@mail.ru"), new Car("Maserati",395));
        userService.add(new Users("Jerome", "Smith", "jerome@mail.ru"), new Car("Ferrari",586));

        List<Users> users = userService.listUsers();

        for (Users user : users) {
            System.out.printf("\nID(%s)\n%s\n%s\n%s\n%s\n\n",
                    user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getCar());
        }
        System.out.println(userService.getUserByCar("Mercedes", 421));
        context.close();
    }
}