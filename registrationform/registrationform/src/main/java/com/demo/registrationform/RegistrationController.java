package com.demo.registrationform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String showForm() {
        return "registration";
    }

    @PostMapping("/register")
    public String submitForm(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            @RequestParam("birthday") String birthday,
            @RequestParam("profession") String profession,
            Model model) {

        // Add data to model
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("email", email);
        model.addAttribute("birthday", birthday);
        model.addAttribute("profession", profession);

        return "registration-success";
    }
}
