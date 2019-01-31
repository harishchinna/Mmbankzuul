package com.moneymoney.app.Transaction.Details;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
 
	@Autowired
	private RabbitMessagingTemplate rabbit;
	
	public void send(Transaction transaction)
	{
		rabbit.convertAndSend("transactionQueue", transaction);
	}
}
