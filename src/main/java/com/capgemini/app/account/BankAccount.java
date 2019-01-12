package com.capgemini.app.account;

public class BankAccount {
	private int accountNumber;
	private double accountBalance;
	private String accountHolderName;
	private String type;
	private static int accountId;

	/*
	 * static { accountId = 100; }
	 */

	public BankAccount() {
	
	}
	
	
	public BankAccount(String accountHolderName, double accountBalance) {
		//accountNumber = ++accountId;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}

	public BankAccount(String accountHolderName) {
		accountNumber = ++accountId;
		this.accountHolderName = accountHolderName;
	}

	public BankAccount(int accountNumber, String accountHolderName, double accountBalance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}

	public BankAccount(int accountNumber, double accountBalance, String accountHolderName, String type) {
		
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.accountHolderName = accountHolderName;
		this.type = type;
	}


	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getType() {
		return type;
	}


	public double getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(double accountBalance) {
		this.accountBalance =  accountBalance;
	}
	
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance
				+ ", accountHolderName=" + accountHolderName + "]";
	}

}
