package com.example.jpa;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.model.CURRENCY;
import com.example.jpa.model.Wallet;
import com.example.jpa.model.WalletPK;
import com.example.jpa.repository.WalletRepository;

@SpringBootApplication
public class JpaManyToManyDemoApplication implements CommandLineRunner {

	@Autowired
	private WalletRepository walletRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaManyToManyDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		WalletPK walletPK = new WalletPK(123L, CURRENCY.EUR);
		Wallet wallet = new Wallet(walletPK, BigDecimal.TEN);
		walletRepository.save(wallet);

		System.out.println(
				walletRepository.findById(new WalletPK.Builder().currency(CURRENCY.EUR).userID(123L).build()).get());
	}
}
