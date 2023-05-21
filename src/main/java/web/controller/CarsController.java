package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarsService;
import web.service.CarsServiceImp;

import java.util.List;

@Controller
public class CarsController {

    @Autowired
    private final CarsService carsService = new CarsServiceImp();

    @GetMapping(value = "/cars")
    public String printCars (@RequestParam(value = "count", required = false, defaultValue = "5") Integer count, ModelMap model) {
        List<Car> cars = carsService.print(count);
        model.addAttribute("cars", cars);
        return "Car";
    }
}
