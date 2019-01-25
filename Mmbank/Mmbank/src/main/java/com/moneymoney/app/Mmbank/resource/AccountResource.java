package com.moneymoney.app.Mmbank.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moneymoney.app.Mmbank.accounts.BankAccount;
import com.moneymoney.app.Mmbank.accounts.SavingsAccount;
import com.moneymoney.app.Mmbank.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountResource {
	
	
	@Autowired
	private AccountService service;
	
	@PostMapping
	public void addNewSavingsAccount(@RequestBody SavingsAccount savingsAccount)
	{
		service.addNewAccount(savingsAccount);
	}
	
	@GetMapping
	public List<BankAccount> getAllAccounts()
	{
		return service.getAllAccounts();
	}
	
	@GetMapping("/{accountNumber}")
	public Optional<BankAccount> getById(@PathVariable int accountNumber)
	{
		return service.getById(accountNumber);
	}
	
	 @PutMapping 
	 public void updateAccount(@RequestBody SavingsAccount savingsAccount) { 
		 service.updateAccount(savingsAccount);
	  }
	 
	 @DeleteMapping("/{accountNumber}")
	 public void deleteAccount(@PathVariable int accountNumber)
	 {
		 service.deleteAccount(accountNumber);
	 }
	 @PutMapping("/{accountNumber}")
	 public void updateBalance(@PathVariable int accountNumber ,@RequestParam("currentBalance") double currentBalance)
	 {
		 Optional<BankAccount> object = service.getById(accountNumber);
		 BankAccount account = object.get();
		 account.setCurrentBalance(currentBalance);
		 service.updateBalance(account);
	 }
	 @GetMapping("/{accountNumber}/balance")
	public Double getCurrentBalance(@PathVariable int accountNumber)
	{
		return  service.getCurrentBalance(accountNumber);
	}
}
