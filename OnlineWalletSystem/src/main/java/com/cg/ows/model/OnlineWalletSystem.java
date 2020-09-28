package com.cg.ows.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "account_id", initialValue = 741258961)
@Table(name = "online_wallet_system_tbl")
public class OnlineWalletSystem {

	private String name;
	private BigInteger accountId;
	private Double accountBalance;
	private Date transactionDate;
	private BigInteger mobileNumber;

	public OnlineWalletSystem() {
	}

	public OnlineWalletSystem(String name, BigInteger accountId, Double accountBalance, Date transactionDate,
			BigInteger mobileNumber) {
		super();
		this.name = name;
		this.accountId = accountId;
		this.accountBalance = accountBalance;
		this.transactionDate = transactionDate;
		this.mobileNumber = mobileNumber;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id")
	public BigInteger getAccountId() {
		return accountId;
	}

	public void setAccountId(BigInteger accountId) {
		this.accountId = accountId;
	}

	@Column(name = "account_balance", nullable = false)
	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Column(name = "transaction_date", nullable = false)
	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	@Column(name = "mobile_number", nullable = false)
	public BigInteger getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "OnlineWalletSystem [name=" + name + ", accountId=" + accountId + ", accountBalance=" + accountBalance
				+ ", transactionDate=" + transactionDate + ", mobileNumber=" + mobileNumber + "]";
	}

}
