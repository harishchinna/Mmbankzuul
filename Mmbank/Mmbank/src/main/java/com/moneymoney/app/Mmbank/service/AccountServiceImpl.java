package com.moneymoney.app.Mmbank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneymoney.app.Mmbank.accounts.BankAccount;
import com.moneymoney.app.Mmbank.accounts.SavingsAccount;
import com.moneymoney.app.Mmbank.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository repository;

	@Override
	public void addNewAccount(SavingsAccount savingsAccount) {
		repository.save(savingsAccount);
	}

	@Override
	public List<BankAccount> getAllAccounts() {
		return repository.findAll();
	}

	@Override
	public Optional<BankAccount> getById(int accountNumber) {
		Optional<BankAccount> account = repository.findById(accountNumber);
		/* System.out.println(account); */
		return account;

	}

	@Override
	public void updateAccount(SavingsAccount savingsAccount) {
		repository.save(savingsAccount);
	}

	@Override
	public void deleteAccount(int accountNumber) {
		repository.deleteById(accountNumber);
	}

	@Override
	public void updateBalance(BankAccount account) {
		repository.save(account);
	}

	@Override
	public Double getCurrentBalance(int accountNumber) {
		Optional<BankAccount> account= repository.findById(accountNumber);
		double balance= account.get().getCurrentBalance();
		return balance;
	}

}
