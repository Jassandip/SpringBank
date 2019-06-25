package com.springbank.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbank.beans.Account;
import com.springbank.beans.Client;
import com.springbank.services.impl.LoginImpl;

import org.hibernate.validator.constraints.Mod10Check;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "id", "type" })
public class LogginController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/loggin")
    public String sample(Map<String, Object> model) {
        return "loggin";
    }

    @RequestMapping(value = "/loggin", method = RequestMethod.POST)
    public String logginmethod(@RequestParam("id") String username, @RequestParam("password") String password,
            Model model, HttpServletResponse response) throws IOException {
        System.out.println("Entered loggin post method");
        String[] idAndPass = { username, password };
        try {
            if (LoginImpl.authenticate(idAndPass)) {
                Account user = LoginImpl.authorize(idAndPass);
                model.addAttribute("id", idAndPass[0]);
                model.addAttribute("type", user.getType());
                if(user.getType().equals("employee")){
                    response.sendRedirect("/employee");
            } else{
                response.sendRedirect("/customer");
            }} else {
                model.addAttribute("msg", "Unuccessfull loggin!");
                return "loggin";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "loggin";
    }

}
