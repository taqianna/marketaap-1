package com.market.services;

import java.util.List;

import com.market.entities.Customer;


public interface CustomerService {
      public void saveCustomer(Customer customer);
	  public List<Customer> listCustomer();
	public void deleteById(long id);
	public Customer getOneCustomer(long id);
}
