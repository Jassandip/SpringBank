package com.springbank.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbank.beans.Account;
import com.springbank.beans.Client;
import com.springbank.services.impl.JDBClogin;
import com.springbank.services.impl.LoginImpl;

import org.hibernate.validator.constraints.Mod10Check;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginController {
    @Autowired
    JDBClogin jdbclogin;

    @RequestMapping("/")
    public String home(Map<String, Object> model) {
        Logger logger = LoggerFactory.getLogger(this.getClass().getName());    
        System.out.println("-- in doSomething() --");
        logger.info("made it to login controller");
    return "start";
    }
    
    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/login")
    public String sample(Map<String, Object> model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void loginmethod(@RequestParam("id") String username, @RequestParam("password") String password,
            Model model, HttpServletResponse response) throws IOException {
        System.out.println("Entered login post method");
        String[] idAndPass = { username, password };
                String type = jdbclogin.authenticate(idAndPass);
                model.addAttribute("id", idAndPass[0]);
                model.addAttribute("type",type);
                if(type.equals("employee")){
                    response.sendRedirect("/employee");
            } else if (type.equals("client")) {
                response.sendRedirect("/customer");
            } else {
                model.addAttribute("msg", "Unuccessfull login!");
                response.sendRedirect("/login");
    }

}}
