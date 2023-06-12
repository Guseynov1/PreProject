package PP231.service;

import PP231.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(User user);
}