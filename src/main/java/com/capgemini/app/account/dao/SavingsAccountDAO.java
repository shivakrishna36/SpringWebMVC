package com.capgemini.app.account.dao;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.app.account.SavingsAccount;
import com.capgemini.app.exception.AccountNotFoundException;


public interface SavingsAccountDAO {
	
	SavingsAccount createNewAccount(SavingsAccount account) throws ClassNotFoundException, SQLException;
	SavingsAccount updateAccount(SavingsAccount account,String name,boolean value) throws SQLException, ClassNotFoundException;
	SavingsAccount getAccountById(int accountNumber) throws ClassNotFoundException, SQLException, AccountNotFoundException;
	String deleteAccount(int accountNumber) throws ClassNotFoundException, SQLException;
	List<SavingsAccount> getAllSavingsAccount() throws ClassNotFoundException, SQLException;
	void updateBalance(int accountNumber, double currentBalance) throws ClassNotFoundException, SQLException;
	void commit() throws SQLException;
	SavingsAccount searchAccount(int accountNumber) throws ClassNotFoundException, SQLException, AccountNotFoundException;
	double checkCurrentBalance(int accountNumber) throws SQLException, ClassNotFoundException, AccountNotFoundException;
	SavingsAccount searchAccountByName(String accountHolderName) throws SQLException, AccountNotFoundException, ClassNotFoundException;
	List<SavingsAccount> sortByAccountHolderName() throws SQLException, ClassNotFoundException;
	List<SavingsAccount> sortBySalaryRange(int minimunbalance, int maximumbalance) throws ClassNotFoundException, SQLException;
	List<SavingsAccount> sortByLessthanGivenSalary(int amount) throws ClassNotFoundException, SQLException;
	List<SavingsAccount> sortByGreaterthanGivenSalary(int amount)
			throws ClassNotFoundException, SQLException;
	List<SavingsAccount> getByAccountBalanceRange(double minimum, double maximum) throws SQLException, ClassNotFoundException;
	List<SavingsAccount> sortBySalary() throws ClassNotFoundException,
			SQLException;
	List<SavingsAccount> sortBySalaried() throws SQLException, ClassNotFoundException;
	
	
}
