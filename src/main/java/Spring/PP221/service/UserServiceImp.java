package Spring.PP221.service;

import Spring.PP221.dao.UserDao;
import Spring.PP221.model.Car;
import Spring.PP221.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(Users users, Car car) {
        userDao.add(users, car);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Users> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public Users getUserByCar(String model, int series) {
        return userDao.getUserByCar(model, series);
    }

}