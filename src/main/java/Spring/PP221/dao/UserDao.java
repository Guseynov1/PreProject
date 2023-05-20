package Spring.PP221.dao;

import Spring.PP221.model.Car;
import Spring.PP221.model.Users;

import java.util.List;

public interface UserDao {
    void add(Users users, Car car);
    List<Users> listUsers();
    Users getUserByCar(String model, int series);
}