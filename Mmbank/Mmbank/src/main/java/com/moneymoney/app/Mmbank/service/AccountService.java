package com.moneymoney.app.Mmbank.service;

import java.util.List;
import java.util.Optional;

import com.moneymoney.app.Mmbank.accounts.BankAccount;
import com.moneymoney.app.Mmbank.accounts.SavingsAccount;

public interface AccountService {

	void addNewAccount(SavingsAccount savingsAccount);

	List<BankAccount> getAllAccounts();

	Optional<BankAccount> getById(int accountNumber);

	void updateAccount(SavingsAccount savingsAccount);

	void deleteAccount(int accountNumber);


	void updateBalance(BankAccount account);

	Double getCurrentBalance(int accountNumber);


}
