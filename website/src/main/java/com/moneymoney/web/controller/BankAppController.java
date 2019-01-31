package com.moneymoney.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.moneymoney.web.entity.CurrentDataSet;
import com.moneymoney.web.entity.Transaction;

@Controller
public class BankAppController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RabbitMessagingTemplate rabbit;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/depositform")
	public String depositForm() {
		return "DepositForm";
	}

	@RequestMapping("/deposit")
	public String deposit(@ModelAttribute Transaction transaction, Model model) {
		restTemplate.postForEntity("http://localhost:8080/transaction/transactions/deposit", transaction, null);
		model.addAttribute("message", "Success!");
		return "DepositForm";
	}

	@RequestMapping("/withdrawform")
	public String withdrawForm() {
		return "WithdrawForm";
	}

	@RequestMapping("/withdraw")
	public String withdraw(@ModelAttribute Transaction transaction, Model model) {
		restTemplate.postForEntity("http://localhost:8080/transaction/transactions/withdraw", transaction, null);
		model.addAttribute("message", "Success!");
		return "WithdrawForm";
	}
	@RequestMapping("/transfer")
	public String transfer()
	{
		return "FundTransferForm";
	}
	
	@RequestMapping("/fundtransfer")
	public String fundsTransfer(@RequestParam("senderaccountNumber") int senderaccountNumber,@RequestParam("receiveraccountNumber") int receiveraccountNumber,@RequestParam("amount") int amount,@ModelAttribute Transaction transaction,Model model) {
		transaction.setAccountNumber(senderaccountNumber);
		restTemplate.postForEntity("http://localhost:8080/transaction/transactions/withdraw", transaction, null);
		transaction.setAccountNumber(receiveraccountNumber);
		restTemplate.postForEntity("http://localhost:8080/transaction/transactions/deposit", transaction, null);
		model.addAttribute("message", "success!");
		return "FundTransferForm";
	}
	@RequestMapping("/statementform")
	public String getMiniStatement()
	{
		return "statementForm";
	}
	
	@RequestMapping("/statement")
	public ModelAndView getStatement(@RequestParam("offset") int offset, @RequestParam("size") int size) {
		int currentSize = size==0?5:size;
		int currentOffset = offset==0?1:offset;
		Link previous = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(BankAppController.class).getStatement(currentOffset-currentSize, currentSize)).withRel("previous");
		Link next = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(BankAppController.class).getStatement(currentOffset+currentSize, currentSize)).withRel("next");
		CurrentDataSet currentDataSet = restTemplate.getForObject("http://localhost:8080/transaction/transactions/statements", CurrentDataSet.class);
		List<Transaction> transactionList = currentDataSet.getTransactions();
		List<Transaction> transactions = new ArrayList<Transaction>();
		for(int value=currentOffset-1; value<currentOffset+currentSize-1; value++) {
			if((transactionList.size() <= value && value > 0) || currentOffset < 1)
				break;
			Transaction transaction = transactionList.get(value);
			transactions.add(transaction);		
		}
		currentDataSet.setPreviousLink(previous);
		currentDataSet.setNextLink(next);
		currentDataSet.setTransactions(transactions);
		return new ModelAndView("statementForm", "currentDataSet", currentDataSet);
	}

}
