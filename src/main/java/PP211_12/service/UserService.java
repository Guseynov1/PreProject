package PP211_12.service;

import PP211_12.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void createUsersTable() throws SQLException;

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age) throws SQLException;

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
