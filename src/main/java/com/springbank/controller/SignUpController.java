package com.springbank.controller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Map;
import com.springbank.services.impl.SignupImpl;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.springbank.beans.Account;
import com.springbank.beans.Login;

@Controller
public class SignUpController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/signup")
    public String sample(Map<String, Object> model) {
        model.put("msg","Signup below!");
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String logginmethod(Model model,@ModelAttribute("account") Account account, @ModelAttribute("login") Login login) {
        System.out.println("Entered loggin post method");
        System.out.println(new Timestamp(System.currentTimeMillis()));
        SignupImpl si = new SignupImpl();
        System.out.println(account.getDob());
        System.out.println(account.getType());
        if (si.Login(login) & si.Account(account)) {
            return "loggin";
        } else {
            model.addAttribute("msg","Were not able to make the account, try again!");
            return "signup";
        }
    }

}
