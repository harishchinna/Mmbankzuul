package com.moneymoney.app.Mmbank;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
@EnableDiscoveryClient
@SpringBootApplication
public class MmbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmbankApplication.class, args);
	}
	
	/*
	 * @Bean public CommandLineRunner sendingdata(AccountRepository repository) {
	 * repository.save(new Account(145,"hari",1000)); }
	 */
	@Bean
	public Queue queue() {
		return new Queue("transactionQueue", false);
	}

}

