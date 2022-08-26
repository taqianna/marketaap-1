package com.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.entities.Customer;
import com.market.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
   
	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<Customer> getAllCustomers(){
		
		List<Customer> customers = customerService.listCustomer();
		
		return customers;
	}
	
	@PostMapping
	public void saveOneCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteOneCustomer(@PathVariable("id") long id) {
		customerService.deleteById(id);
	
	}
	
	@PutMapping
	public void updateOneCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
   }
	
	@GetMapping("/customer/{id}")
	public Customer getOneCustomer(@PathVariable("id") long id) {
		Customer customer = customerService.getOneCustomer(id);
	
		return customer;
	}

	
}	

