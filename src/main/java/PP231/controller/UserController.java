package PP231.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import PP231.model.User;
import PP231.service.UserService;

import java.util.List;

@AllArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "all";
    }

    @GetMapping("/new")
    public String getCreateUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String getUpdateUserForm(@RequestParam("id") Long id, Model model) {
        User user = userService.getUserById(id);
        if (user == null) return "redirect:/";
        model.addAttribute("user", user);
        return "edit";
    }

    @PatchMapping("/edit")
    public String updateUserSubmit(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/delete")
    public String getDeleteUserSubmit(@RequestParam("id") Long id) {
        User byId = userService.getUserById(id);
        userService.deleteUser(byId);
        return "redirect:/";
    }
}