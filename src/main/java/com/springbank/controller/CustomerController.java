package com.springbank.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.springbank.beans.Account;
import com.springbank.beans.Client;
import com.springbank.beans.SendMoney;
import com.springbank.beans.Transactions;
import com.springbank.services.impl.JDBClogin;
import com.springbank.services.CustomerRepository;
import com.springbank.services.TransactionsRepository;
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
import org.springframework.web.bind.support.SessionStatus;



@Controller
@SessionAttributes({ "id", "type","user"})
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private TransactionsRepository transactionsRepository;
    
    @Autowired
    CustomerServicesImpl CustomerServicesImpl;

    @Autowired
    private CustomerRepository cr;

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @GetMapping("")
    public String dashboard(Model model, @ModelAttribute("id") String id) {
        clientloader(model,id); 
        return "customer/customer";
    }

    @GetMapping("/statement")
    public String getstatement(Model model, @ModelAttribute("id") String id,@ModelAttribute("user") Client user){
        Iterable<Transactions> transactions = transactionsRepository.findByFromOrTo(user.getIntId(),user.getIntId());
        model.addAttribute("transactions",transactions);
        return "/customer/statement";
    }

    @GetMapping("/sendmoney")
    public String getsendmoney(Model model, @ModelAttribute("sm") SendMoney sm,@ModelAttribute("id") String id, @ModelAttribute("user") Client user){
        System.out.println(user.getBalance());
        model.addAttribute("confirmation",user.getBalance());
        return "/customer/sendmoney";
    }

    @PostMapping("/sendmoney")
    public String postsendmoney(Model model, @ModelAttribute("sm") SendMoney sm,@ModelAttribute("id") String id, @ModelAttribute("user") Client user){
        String confirmation;
        if(cr.existsByIntid(sm.getTo()) && user.getBalance().compareTo(sm.getAmount()) >= 0  ){
            sm.setFrom(user.getIntId());
            user.setBalance(user.getBalance().subtract(sm.getAmount()));
            cr.save(user);
            clientloader(model,id);
            CustomerServicesImpl.sendMoney(sm);
        confirmation = "Sucessfully sent the money";
    }
        else{
            confirmation = "Could not send the money";
        }
        model.addAttribute("confirmation",confirmation);
        return "/customer/sendmoney";
    }

    @GetMapping("/deposit")
    public String getdepositmoney(){
        return "/customer/deposit";
    }

    @PostMapping("/deposit")
    public String postdepositmoney(@RequestParam("amount") BigDecimal amount, Model model,@ModelAttribute("id") String id,@ModelAttribute("user") Client user){
        user.setBalance(user.getBalance().add(amount));
        cr.save(user);
        clientloader(model,id);
        return "/customer/deposit";
    }

    @GetMapping("/account")
    public String getaccount(){
        return "/customer/account";
    }

    @PostMapping("/account")
    public String postaccount(@ModelAttribute("cu") Client cu, @ModelAttribute("user") Client user, Model model, @ModelAttribute("id") String id){
            // This returns a JSON or XML with the users
            System.out.println("Entered updateEmployeeInfo method");
            user.setFirstName(cu.getFirstName());
            user.setLastName(cu.getLastName());
            user.setDob(cu.getDob());
            cr.save(user);
            clientloader(model,id);
            return "customer/account";
    }
    
    public void clientloader(Model model, @ModelAttribute("id") String id){
        Client user = cr.findById(id).get();
        model.addAttribute("user", user);
    }


}
