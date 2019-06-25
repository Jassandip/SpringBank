package com.springbank.controller;

import java.sql.SQLException;
import java.util.Map;

import com.springbank.beans.Account;
import com.springbank.services.impl.LoginImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("test")
public class LogginController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/loggin")
    public String sample(Map<String, Object> model) {
        // model.put("message", this.message);
        return "loggin";
    }

    @RequestMapping(value = "/loggin", method = RequestMethod.POST)
    public String logginmethod(@RequestParam("id") String username, @RequestParam("password") String password,
            Model model) {
        System.out.println("Entered loggin post method");
        String[] idAndPass = { username, password };
        try {
            if (LoginImpl.authenticate(idAndPass)) {
                Account user = LoginImpl.authorize(idAndPass);
                model.addAttribute("user", user);
                model.addAttribute("msg", "Successfully logged in!");
                model.addAttribute("type", user.getType());
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
}
