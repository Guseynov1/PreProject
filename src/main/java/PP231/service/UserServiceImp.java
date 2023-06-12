package PP231.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import PP231.dao.UserDao;
import PP231.model.User;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;
    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Transactional
    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
}