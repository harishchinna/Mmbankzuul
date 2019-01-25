package com.moneymoney.app.Mmbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
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

}

