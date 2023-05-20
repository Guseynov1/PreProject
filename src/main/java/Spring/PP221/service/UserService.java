package Spring.PP221.service;

import Spring.PP221.model.Car;
import Spring.PP221.model.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void add(Users users, Car car);
    List<Users> listUsers();
    Users getUserByCar(String model, int series);
}