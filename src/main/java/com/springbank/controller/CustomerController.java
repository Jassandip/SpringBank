package com.springbank.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.springbank.beans.Account;
import com.springbank.beans.Client;
import com.springbank.services.impl.LoginImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"id","type"})
public class CustomerController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/customer")
    public String sample(@ModelAttribute("user") Client user, Model model){
        System.out.println(user.getFirstName());
        System.out.println("^^^^^");
        return "customer";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String logginmethod(@RequestParam("id") String username, @RequestParam("password") String password,
            Model model) {
        System.out.println("11111111");
        String[] idAndPass = { username, password };
        try {
            if (LoginImpl.authenticate(idAndPass)) {
                Account user = LoginImpl.authorize(idAndPass);
                model.addAttribute("user", user);
                model.addAttribute("msg", "Successfully logged in!");
                // model.addAttribute("type", user.getType());
                return "loggin";
            } else {
                model.addAttribute("msg", "Successfully logged in!");
                return "loggin";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "loggin";
    }
    @ModelAttribute("user")
    public Client userloader(@ModelAttribute("id") String id) throws SQLException {
        System.out.println(id);
        Client user = LoginImpl.clientLoader(id);
        return user;
    }
}
