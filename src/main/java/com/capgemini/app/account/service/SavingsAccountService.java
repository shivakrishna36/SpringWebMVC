package com.capgemini.app.account.service;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.app.account.SavingsAccount;
import com.capgemini.app.exception.AccountNotFoundException;


public interface SavingsAccountService {

	SavingsAccount createNewAccount(String accountHolderName, double accountBalance, boolean salary) throws ClassNotFoundException, SQLException;

	SavingsAccount updateAccount(SavingsAccount account, String accountHolderName, boolean value) throws ClassNotFoundException, SQLException;

	SavingsAccount getAccountById(int accountNumber) throws ClassNotFoundException, SQLException, AccountNotFoundException;

	String deleteAccount(int accountNumber) throws ClassNotFoundException, SQLException;
	
	List<SavingsAccount> getAllSavingsAccount() throws ClassNotFoundException, SQLException;

	void fundTransfer(SavingsAccount sender, SavingsAccount receiver, double amount) throws ClassNotFoundException, SQLException;
	void deposit(SavingsAccount account, double amount) throws ClassNotFoundException, SQLException;
	void withdraw(SavingsAccount account, double amount) throws ClassNotFoundException, SQLException;

	SavingsAccount searchAccount(int accountNumber) throws ClassNotFoundException, SQLException, AccountNotFoundException;

	double checkCurrentBalance(int accountNumber) throws ClassNotFoundException, SQLException, AccountNotFoundException;

	SavingsAccount searchAccountByName(String accountHolderName) throws ClassNotFoundException, SQLException, AccountNotFoundException;

	List<SavingsAccount> sortByAccountHolderName() throws ClassNotFoundException, SQLException;

	List<SavingsAccount> sortBySalaryRange(int minimunbalance,
			int maximumbalance) throws ClassNotFoundException, SQLException;

	List<SavingsAccount> sortBySalaryLessthanGivenInput(int amount) throws ClassNotFoundException, SQLException;

	List<SavingsAccount> sortBySalaryGreaterthanGivenInput(int maximumAmount) throws ClassNotFoundException, SQLException;

	List<SavingsAccount> getAccountByRange(double minimum, double maximum) throws ClassNotFoundException, SQLException;
	
	List<SavingsAccount> sortBySalary() throws ClassNotFoundException, SQLException;
	
	List<SavingsAccount> sortBySalaried() throws ClassNotFoundException, SQLException;

}











