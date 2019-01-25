package com.moneymoney.app.Mmbank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.moneymoney.app.Mmbank.accounts.BankAccount;

@Repository
public interface AccountRepository extends MongoRepository<BankAccount, Integer>{

}
