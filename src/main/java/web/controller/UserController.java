package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "addUser";
    }
    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }
    @GetMapping("/edit")
    public String editUserForId(@RequestParam (value = "userId") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

//    @PostMapping("/edit")
//    public String editUser(@ModelAttribute("user") User user, Model model) {
//        userService.save(user);
//        return "redirect:/";
//    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user,
                           @RequestParam("userId") Long id, Model model) {
        user.setId(id); // Важно: устанавливаем ID из параметра
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}