package PP231.dao;

import PP231.model.User;

import java.util.List;


public interface UserDao  {
    void saveUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(User user);
}