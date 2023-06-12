package PP222.service;

import org.springframework.stereotype.Component;
import PP222.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarsServiceImp implements CarsService{

    private final List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("AA1", "Nissan", 1999));
        cars.add(new Car("BB1", "Honda", 1970));
        cars.add(new Car("CC1", "Mercedes", 1965));
        cars.add(new Car("DD1", "BMW", 1998));
        cars.add(new Car("EE1", "Maserati", 1975));
    }

    public List<Car> print(Integer count) {
        if (count == null) return cars;
        return cars.stream().limit(count).toList();
    }
}
