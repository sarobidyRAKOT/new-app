package itu.mg.new_app.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import itu.mg.new_app.model.User;
import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class Global_controller {

    @ModelAttribute
    public void addUserToModel(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
    }
}
