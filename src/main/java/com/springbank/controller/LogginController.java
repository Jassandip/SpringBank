package com.springbank.controller;

import java.sql.SQLException;
import java.util.Map;
import com.springbank.services.impl.AccountServiceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
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
    public String logginmethod(@RequestParam("id") String username, @RequestParam("password") String password) {
        System.out.println("Entered loggin post method");
        String[] idAndPass = { username, password };
        try {
            if (AccountServiceImpl.authenticate(idAndPass)) {
                return "loggin";
            } else {
                return "loggin";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "loggin";
}
}
