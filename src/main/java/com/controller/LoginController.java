package com.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // templates/login.html
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
            @RequestParam String password,
            HttpSession session) {
        // No security: accept anything non-empty
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            session.setAttribute("loginError", "Username and Password are required");
            return "redirect:/login";
        }
        session.setAttribute("username", username);
        session.removeAttribute("loginError");
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout";
    }
}
