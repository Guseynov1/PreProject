package PP231.dao;

import PP231.model.User;

import java.util.List;


public interface UserDao  {
    void save(User user);

    User findById(Long id);

    List<User> findAll();

    void update(Long id, User user);

    void delete(User user);
}