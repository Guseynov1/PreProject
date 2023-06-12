package PP221.service;

import PP221.model.Car;
import PP221.model.Users;

import java.util.List;

public interface UserService {
    void add(Users users, Car car);
    List<Users> listUsers();
    Users getUserByCar(String model, int series);
}