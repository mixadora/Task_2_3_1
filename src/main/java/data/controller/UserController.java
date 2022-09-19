package data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import data.model.User;
import data.service.UserService;

import java.util.List;

@Controller

public class UserController {

    private UserService userService;
    private int userId;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String allUsers(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("userList", users);
        return "users";
    }

    @GetMapping("/change/{id}")
    public String editPage(Model model, @PathVariable("id") int id) {
        userId = id;
        model.addAttribute("user", new User());
        return "change_users";
    }

    @PostMapping("/change")
    public String editUser(@ModelAttribute("user") User user) {
        user.setId(userId);
        userService.change(user);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("user", new User());
        return "add_users";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }


    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}