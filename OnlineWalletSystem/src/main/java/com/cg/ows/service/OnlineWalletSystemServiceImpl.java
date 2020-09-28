package com.cg.ows.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cg.ows.model.OnlineWalletSystem;
import com.cg.ows.repository.OnlineWalletSystemRepository;

@Service
public class OnlineWalletSystemServiceImpl implements OnlineWalletSystemService {
	
	@Autowired
	private OnlineWalletSystemRepository repo;

	//Getting account details
	@Override
	public List<OnlineWalletSystem> getAccountDetails(BigInteger accountId) {
		if (!repo.existsById(accountId)) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Account Id is Invalid");
		}else {
			return repo.getAccountDetails(accountId);
		}
		
	}

	//Adding account details
	@Override
	public String addAccountDetailsToWallet(OnlineWalletSystem onlineWalletSystem) {
		 repo.save(onlineWalletSystem);
		 return "Account details added successfully";
	}

	//Adding money to account 
	@Override
	public String addMoneyToWallet(OnlineWalletSystem onlineWalletSystem, BigInteger accountId, Double amount) {
		if (!repo.existsById(accountId)) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Account Id is Invalid");
		}else {
			Double balance = amount + onlineWalletSystem.getAccountBalance();
			onlineWalletSystem.setAccountBalance(balance);
			repo.save(onlineWalletSystem);
			return "Money added successfully";
		}
		
	}

	//Withdrawing money from account 
	@Override
	public String withdrawMoneyFromWallet(OnlineWalletSystem onlineWalletSystem, BigInteger accountId, Double amount) {
		
		if (!repo.existsById(accountId)) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Account Id is Invalid");
		}
		else if(onlineWalletSystem.getAccountBalance() <= 0) {
				return "Sorry!, You not have sufficient balance to withraw that much amount";
			}
		else if(onlineWalletSystem.getAccountBalance() < amount) {
			return "Sorry!, You not have sufficient balance to withraw that much amount";
			}
		else{
				Double balance =  onlineWalletSystem.getAccountBalance() - amount;
			
			    onlineWalletSystem.setAccountBalance(balance);
			    repo.save(onlineWalletSystem);
			    return "Money withdrawn successfully";
		}
		}
		
		
	}

	



	

