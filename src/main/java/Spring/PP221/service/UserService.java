package Spring.PP221.service;

import Spring.PP221.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
}