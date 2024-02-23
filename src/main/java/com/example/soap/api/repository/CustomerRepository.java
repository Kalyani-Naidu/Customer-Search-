package com.example.soap.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.soap.api.entities.CustomerData;

public interface CustomerRepository extends JpaRepository<CustomerData, String>{

}
