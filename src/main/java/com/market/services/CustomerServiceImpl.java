package com.market.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.entities.Customer;
import com.market.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public void saveCustomer(Customer customer) {

		customerRepo.save(customer);
	}

	@Override
	public List<Customer> listCustomer() {
    List<Customer> customers = customerRepo.findAll();
		return customers;
	}

	@Override
	public void deleteById(long id) {
       customerRepo.deleteById(id);		
	}

	@Override
	public Customer getOneCustomer(long id) {
        Optional<Customer> findById = customerRepo.findById(id);
		Customer customer = findById.get();
		return customer;
	}

}
