package PP231.DAO;

import PP231.model.User;

import java.util.List;

public interface UserDAO {
    void add (User user);
    void update(Long id, User user);
    void delete (Long id);
    List<User> getAll();
    User show (Long id);
}
