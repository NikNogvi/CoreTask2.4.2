package coretask.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LognController {
    @GetMapping(value = "/")
    public String startPage() {
        return "startPage";
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "loginPage";
    }

}
