package com.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.market.dto.CustomerData;
import com.market.entities.Customer;
import com.market.services.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//Handler methods
	@RequestMapping("/createCustomer")
	public String viewCreateCustomerPage() {
		return "create_customer";
	}

	@RequestMapping("/saveCustomer")
	public String saveOneCustomer( @ModelAttribute ("customer") Customer customer, ModelMap model) {
		customerService.saveCustomer(customer);
		model.addAttribute("msg", "Customer is saved!!");
		return "create_customer";
	}
	
	@RequestMapping("/listall")
	public String listAllCustomer(ModelMap model) {
		List<Customer> customers = customerService.listCustomer();
		model.addAttribute("customers", customers);
		return "customer_search_result";
	}
	
	@RequestMapping("/delete")
	public String deleteOneCustomer(@RequestParam("id") long id, ModelMap model) {
		
		customerService.deleteById(id);
		
		List<Customer> customers = customerService.listCustomer();
		model.addAttribute("customers", customers);
		return "customer_search_result";
	}
	
	@RequestMapping("/update")
	public String updateOneCustomer(@RequestParam("id") long id, ModelMap model) {
		
		Customer customer = customerService.getOneCustomer(id);
		model.addAttribute("customer", customer);
		return "update_customer";
	}
	
	@RequestMapping("/updateCustomer")
	public String updateOneCustomerData( CustomerData data, ModelMap model) {
		
		Customer customer = new Customer();
		
		customer.setFirstName(data.getFirstName());
		customer.setLastName(data.getLastName());
		customer.setEmail(data.getEmail());
		customer.setMobile(data.getMobile());
		customerService.saveCustomer(customer);
		
		List<Customer> customers = customerService.listCustomer();
		model.addAttribute("customers", customers);
		return "customer_search_result";
	}
	
//	@RequestMapping("/saveCustomer")
//	public String saveOneCustomer( @RequestParam("name") String fName, @RequestParam("lastName") String lName, @RequestParam("emailId") String email, @RequestParam("mobileNumber") long mobile) {
//		Customer l = new Customer();
//		l.setFirstName(fName);
//		l.setLastName(lName);
//		l.setEmail(email);
//		l.setMobile(mobile);
//	
//		customerService.saveCustomer(l);
//          return "create_customer";
//	}
	
  //	DTO-> Data Transfer Object
	
//	@RequestMapping("/saveCustomer")
//	public String saveOneCustomer( CustomerData data, ModelMap model) {
//		Customer customer= new Customer();
//		customer.setFirstName(data.getFirstName());
//		customer.setLastName(data.getLastName());
//		customer.setEmail(data.getEmail());
//		customer.setMobile(data.getMobile());
//		customerService.saveCustomer(customer);
//		
//		model.addAttribute("msg", "Customer is saved!!");
//		return "create_customer";
//	}
}
