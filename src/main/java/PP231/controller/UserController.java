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
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "all";
    }

    @GetMapping("/new")
    public String showCreateUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        if (user == null) {
            return "redirect:/";
        }
        model.addAttribute("user", user);
        return "edit";
    }

    @PatchMapping("/edit/{id}")
    public String updateUserSubmit(@PathVariable Long id, @ModelAttribute User user) {
        userService.update(id, user);
        return "redirect:/";
    }



    @DeleteMapping("/delete/{id}")
    public String deleteUserSubmit(@PathVariable Long id) {
        User byId = userService.findById(id);
        userService.delete(byId);
        return "redirect:/";
    }
}