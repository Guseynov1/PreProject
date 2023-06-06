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
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
    @Transactional
    @Override
    public void update(Long id, User user) {
        userDao.update(id, user);
    }
    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }
}