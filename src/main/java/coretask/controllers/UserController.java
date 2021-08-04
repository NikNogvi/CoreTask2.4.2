package coretask.controllers;

import coretask.model.User;
import coretask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
@GetMapping("/{id}")
    public String userInfo (Principal principal, Model model) {
    User user = userService.getUserByUsername(principal.getName());
    model.addAttribute("user", user);
    return "user";
}
}
