package com.cg.ows.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.ows.model.OnlineWalletSystem;

public interface OnlineWalletSystemService {

	List<OnlineWalletSystem> getAccountDetails(BigInteger accountId);

	String addAccountDetailsToWallet(OnlineWalletSystem onlineWalletSystem);

	String addMoneyToWallet(OnlineWalletSystem onlineWalletSystem, BigInteger accountId, Double amount);

	String withdrawMoneyFromWallet(OnlineWalletSystem onlineWalletSystem, BigInteger accountId, Double amount);

	

}
