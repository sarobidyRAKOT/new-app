package itu.mg.new_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import itu.mg.new_app.model.User;
import itu.mg.new_app.models_form.Login_form;
import itu.mg.new_app.service.API_Service;
import jakarta.servlet.http.HttpSession;

@Controller 
public class Main_controller {
    
    @Autowired private API_Service api_Service;

    @GetMapping ("/")
    public String page_login (Model model) {

        Login_form login_form = new Login_form();

        login_form.setUsr("administrator");
        login_form.setPwd("admin");
        model.addAttribute("login_form", login_form);
        return "login";
    }


    @PostMapping ("/login")
    public String login (@ModelAttribute Login_form login_form, HttpSession session) {
        try {
            User user = api_Service.API("/api/method/login", login_form, null, HttpMethod.POST, new ParameterizedTypeReference<User>() {}, false);
            if (user != null) {
                session.setAttribute("user", user);
                return "redirect:/employee-list";
            }  else {
                return "redirect:/";
            }
        } catch (HttpClientErrorException e) {
            System.err.println(e.getMessage());
            return "redirect:/";
        }
    }



    @GetMapping ("/logout")
    public String logout_toLogin (HttpSession session) {

        session.removeAttribute("user");
        session.invalidate();
    
        return "redirect:/";
    }



}
