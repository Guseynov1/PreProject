package PP211_12;

import PP211_12.model.User;
import PP211_12.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {

    private static final UserServiceImpl userService = new UserServiceImpl();
    private static final User user1 = new User("Bob", "Malcolm", (byte) 18);
    private static final User user2 = new User("John", "Smith", (byte) 19);
    private static final User user3 = new User("Jeff", "Backoff", (byte) 21);
    private static final User user4 = new User("Martin", "Lorens", (byte) 22);
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        userService.createUsersTable();
        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();

    }
}
