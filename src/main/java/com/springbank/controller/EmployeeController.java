package com.springbank.controller;

import org.hibernate.validator.constraints.Mod10Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbank.beans.Transactions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.springbank.beans.Account;
import com.springbank.beans.Client;
import com.springbank.beans.Employee;
import com.springbank.beans.Login;
import com.springbank.services.CustomerRepository;
import com.springbank.services.EmployeeRepository;
import com.springbank.services.TransactionsRepository;
import com.springbank.services.impl.SignupImpl;;
@SessionAttributes({"id","user"})
@Controller    // This means that this class is a Controller
@RequestMapping(path="/employee") // This means URL's start with /demo (after Application path)
public class EmployeeController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private TransactionsRepository transactionsRepository;
    @Autowired
    private EmployeeRepository er;
	
	@Autowired
	private CustomerRepository cr;
	
	private String id; 

	@GetMapping("")
    public String employeeDashboard(@ModelAttribute("id") String id, Model model) {
        // This returns a JSON or XML with the users
        System.out.println("Entered employeDashboard method");
		employeeLoader(model,id);
		return "employee/employee";
	}
	
	public void setId(String id) {
        this.id = id;
    }
	
	
	@PostMapping("")
    public String postSignupByEmployee(Model model,@ModelAttribute("account") Account account, @ModelAttribute("login") Login login) {
        System.out.println("Entered login post method");
        SignupImpl si = new SignupImpl();
        System.out.println(account.getDob());
        System.out.println(account.getType());
        if (si.Login(login) & si.Account(account)) {
            model.addAttribute("registration","Sucessfulle created new user");
        } else {
            model.addAttribute("registration","Were not able to make the account, try again!");
		}
		return "employee/employee";
    }
	
	@GetMapping("/clients")
	public String getClients(Model model){
        Iterable<Client> clients = cr.findAll();
        model.addAttribute("clients",clients);
		return "/employee/clients";
	}

	@PostMapping("/client")
	public String postClients(Model model, @RequestParam("id") String id){
        Client client = cr.findById(id).get();
        model.addAttribute("client",client);
		return "/employee/client";
	}

	@GetMapping(path="/transactions")
	public String getTranscations() {
        // This returns a JSON or XML with the users
		return "/employee/transactions";
	}
	
	@PostMapping("/transactions")
	public String getAllUsers(@RequestParam("id") String id, Model model) {
		// This returns a JSON or XML with the users
		Integer intid = cr.findById(id).get().getIntId();
		Iterable<Transactions> transactions = transactionsRepository.findByFromOrTo(intid,intid);
		model.addAttribute("transactions",transactions);
		return "/employee/transactions";
	}
	
	@GetMapping(path="/employees")
    public String getAllEmployees(Model model){
        Iterable<Employee> employees = er.findAll();
        model.addAttribute("employees",employees);
		return "/employee/employees";
	}

	@PostMapping("/employees")
	public String searchEmployees(Model model, @RequestParam("id") String id){
		List<String> ids = new ArrayList<String>();
		ids.add(id);
		Iterable<Employee> employee = er.findAllById(ids);
        model.addAttribute("employees",employee);
		return "/employee/employees";
	}

	
	@GetMapping(path="/account")
	public String getupdateEmployeeInfo(){
		return "employee/account";
	}

	@PostMapping(path="/account")
    public String postUpdateEmployeeInfo(@ModelAttribute("eu") Employee eu, @ModelAttribute("user") Employee user, Model model) {
		user.setFirstName(eu.getFirstName());
		user.setLastName(eu.getLastName());
		user.setDob(eu.getDob());
		er.save(user);
		employeeLoader(model,this.id);
		return "employee/account";
    }

	public void employeeLoader(Model model, @ModelAttribute("id") String id){
		setId(id);
		Employee user = er.findById(id).get();
        model.addAttribute("user", user);
	}

	// public String employee(Model model,@ModelAttribute("id") String id ){
    //     System.out.println(employeeRepository.findAll());
    //     return "employee";
    // }

	// @GetMapping(path="/add") // Map ONLY GET Requests
	// public @ResponseBody String addNewUser (@RequestParam String id
	// 		, @RequestParam Integer amount ) {
	// 	// @ResponseBody means the returned String is the response, not a view name
	// 	// @RequestParam means it is a parameter from the GET or POST request

	// 	Transactions t = new Transactions();
	// 	t.setName(name);
	// 	t.setEmail(email);
	// 	userRepository.save(n);
	// 	return "Saved";
	// }


}