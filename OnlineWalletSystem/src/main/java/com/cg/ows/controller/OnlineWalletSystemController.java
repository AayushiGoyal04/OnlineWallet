package com.cg.ows.controller;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ows.model.OnlineWalletSystem;
import com.cg.ows.service.OnlineWalletSystemService;


@RestController
public class OnlineWalletSystemController {
	
	@Autowired
	private OnlineWalletSystemService service;
	Logger logger = LoggerFactory.getLogger(OnlineWalletSystemService.class);
	
	//To get the details of a particular account id
	@GetMapping("/get/wallet/details/{accountId}")
	public List<OnlineWalletSystem> getAccountDetails(@PathVariable BigInteger accountId){
		return service.getAccountDetails(accountId);
	}
	
	//To add a new account details
	@PostMapping("/add/account/details")
	public String addAccountDetailsToWallet(@RequestBody OnlineWalletSystem onlineWalletSystem) {
		return service.addAccountDetailsToWallet(onlineWalletSystem);
	}
	
	//To add money in a particular account id
	@PutMapping("/add/money/{accountId}/{amount}")
	public String addMoneyToWallet(@RequestBody OnlineWalletSystem onlineWalletSystem, @PathVariable BigInteger accountId, @PathVariable Double amount) {
		return service.addMoneyToWallet(onlineWalletSystem, accountId, amount);
	}
	
	//To withdraw money from a particular account id
	@PutMapping("/withdraw/money/{accountId}/{amount}")
	public String withdrawMoneyFromWallet(@RequestBody OnlineWalletSystem onlineWalletSystem, @PathVariable BigInteger accountId, @PathVariable Double amount) {
		return service.withdrawMoneyFromWallet(onlineWalletSystem, accountId, amount);
	}

}
