package PP231.controller;

import PP231.model.User;
import PP231.service.UserService;
import PP231.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService = new UserServiceImp();

    @GetMapping(value = "/users")
    public String printUsers (ModelMap model) {
        userService.add(new User(19, "Smith", "A01"));
        userService.add(new User(21, "Bob", "C03"));
        userService.add(new User(23, "Malcolm", "G57"));
        List<User> listOfUsers = userService.getAll();
        model.addAttribute("listOfUsers", listOfUsers);
        return "Users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser (ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new-user-info";
    }
    @PostMapping("/users")
    public String saveUser (@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser (ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.show(id));
        return "/editUser";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute ("user") User user, @PathVariable("id") Long id) {
        userService.update(id, user);
        return "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public String  deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
