package com.springbank.services;

import org.springframework.data.repository.CrudRepository;

import com.springbank.beans.Transactions;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TransactionsRepository extends CrudRepository<Transactions, Integer> {

}