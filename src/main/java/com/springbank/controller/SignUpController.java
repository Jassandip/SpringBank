package com.springbank.controller;

import java.sql.SQLException;
import java.util.Map;
import com.springbank.services.impl.AccountServiceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/signup")
    public String sample(Map<String, Object> model) {
        // model.put("message", this.message);
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String logginmethod(@RequestParam("id") String username, @RequestParam("password") String password) {

        System.out.println("Entered loggin post method");
        String[] idAndPass = { username, password };
        try {
            if (AccountServiceImpl.authenticate(idAndPass)) {
                return "signup";
            } else {
                return "signup";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "signup";

    }
}
