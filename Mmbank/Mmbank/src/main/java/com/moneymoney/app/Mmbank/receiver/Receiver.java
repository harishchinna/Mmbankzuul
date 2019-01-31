package com.moneymoney.app.Mmbank.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moneymoney.app.Mmbank.accounts.Transaction;
import com.moneymoney.app.Mmbank.resource.AccountResource;

@Component
public class Receiver {

	@Autowired
	private AccountResource resource;

	@RabbitListener(queues = "transactionQueue")
	public void receiver(Transaction transaction) {
		resource.updateBalance(transaction);

	}
	
	/*
	 * @RabbitListener(queues = "transactionQueue") public void
	 * receivingDepositUpdatedBalance(Transaction transaction) { resource. }
	 */
}