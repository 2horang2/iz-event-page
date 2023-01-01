package com.shinhancard.izeventpage.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shinhancard.izeventpage.common.entitiy.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
