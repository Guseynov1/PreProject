package Spring.PP221.dao;

import Spring.PP221.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
}