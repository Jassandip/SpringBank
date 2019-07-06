package com.springbank.services;

import com.springbank.beans.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends JpaRepository<Client, String>{
    boolean existsByIntid(Integer intid);
}