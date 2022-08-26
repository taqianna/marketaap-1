package com.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
