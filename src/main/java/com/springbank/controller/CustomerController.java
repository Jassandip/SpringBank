package com.springbank.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbank.beans.Account;
import com.springbank.beans.Client;
import com.springbank.beans.SendMoney;
import com.springbank.services.impl.JDBClogin;
import com.springbank.services.CustomerRepository;
import com.springbank.services.impl.CustomerServicesImpl;

import org.hibernate.validator.constraints.Mod10Check;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@SessionAttributes({ "id", "type" })
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerServicesImpl CustomerServicesImpl;

    @Autowired
    private CustomerRepository cr;

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @GetMapping("")
    public String dashboard(Model model,@ModelAttribute("id") String id) {
        Client user = cr.findById(id).get();
        model.addAttribute("user", user);
        return "customer/customer";
    }

    
    @GetMapping("/sendmoney")
    public String getsendmoney(Map<String, Object> model, @ModelAttribute("sm") SendMoney sm,@ModelAttribute("id") String id){
        return "/customer/sendmoney";
    }

    @PostMapping("/sendmoney")
    public String postsendmoney(Map<String, Object> model, @ModelAttribute("sm") SendMoney sm,@ModelAttribute("id") String id){
        if(cr.existsById(sm.getTo())){
        CustomerServicesImpl.sendMoney(id,sm);
        return "/customer/sendmoney";
    }


}
