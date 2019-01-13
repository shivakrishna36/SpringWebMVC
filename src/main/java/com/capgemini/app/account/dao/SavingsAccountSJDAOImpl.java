package com.capgemini.app.account.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.app.account.SavingsAccount;
import com.capgemini.app.exception.AccountNotFoundException;
import com.capgemini.app.mapper.SavingsAccountMapper;

@Repository
@Primary
public class SavingsAccountSJDAOImpl implements SavingsAccountDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public SavingsAccount createNewAccount(SavingsAccount account) {
		jdbcTemplate.update("INSERT INTO ACCOUNT VALUES(?,?,?,?,?,?)",
				new Object[] { account.getBankAccount().getAccountNumber(),
						account.getBankAccount().getAccountHolderName(), account.getBankAccount().getAccountBalance(),
						account.isSalary(), null, "SA" });
		return account;
	}

	@Override
	public SavingsAccount updateAccount(SavingsAccount account, String name, boolean value) {
		jdbcTemplate.update("update account set account_hn=?,salary=? where account_id=?",
				new Object[] { name, value, account.getBankAccount().getAccountNumber() });
		return account;
	}

	@Override
	public SavingsAccount getAccountById(int accountNumber) {
		return jdbcTemplate.queryForObject("SELECT * from account WHERE account_id=?", new Object[] { accountNumber },
				new SavingsAccountMapper());
	}

	@Override
	public String deleteAccount(int accountNumber) {
		jdbcTemplate.update("Delete From account WHERE account_id=?", new Object[] { accountNumber });
		return "Account deleted";
	}

	@Override
	public List<SavingsAccount> getAllSavingsAccount() {
		return jdbcTemplate.query("SELECT * from account WHERE salary =? OR salary=?",new Object[] {0,1}, new SavingsAccountMapper());
	}

	@Override
	public void updateBalance(int accountNumber, double currentBalance) {
		jdbcTemplate.update("UPDATE ACCOUNT SET account_bal=? where account_id=?",
				new Object[] { currentBalance, accountNumber });
	}

	@Override
	public void commit() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public SavingsAccount searchAccount(int accountNumber) {
		return jdbcTemplate.queryForObject("SELECT * from account WHERE account_id=?", new Object[] { accountNumber },
				new SavingsAccountMapper());

	}

	@Override
	public double checkCurrentBalance(int accountNumber) {

		return jdbcTemplate.queryForObject("select account_bal from account WHERE account_id=?",
				new Object[] { accountNumber }, Double.class);
	}

	@Override
	public SavingsAccount searchAccountByName(String accountHolderName) {
		return jdbcTemplate.queryForObject("SELECT * from account WHERE account_hn=?",
				new Object[] { accountHolderName }, new SavingsAccountMapper());

	}

	@Override
	public List<SavingsAccount> sortByAccountHolderName() {
		return jdbcTemplate.query("SELECT * from account WHERE salary = ? OR salary= ? ORDER BY account_hn",new Object[] {0,1}, new SavingsAccountMapper());
	}

	@Override
	public List<SavingsAccount> sortBySalaryRange(int minimunbalance, int maximumbalance) {
		return jdbcTemplate.query("SELECT * from account WHERE account_bal BETWEEN ? AND ?",
				new Object[] { minimunbalance, maximumbalance }, new SavingsAccountMapper());
	}

	@Override
	public List<SavingsAccount> sortByLessthanGivenSalary(int amount) {
		return jdbcTemplate.query("SELECT * from account WHERE account_bal<=?", new Object[] { amount },
				new SavingsAccountMapper());
	}

	@Override
	public List<SavingsAccount> sortByGreaterthanGivenSalary(int amount) {
		return jdbcTemplate.query("SELECT * from account WHERE account_bal>=?", new Object[] { amount },
				new SavingsAccountMapper());
	}

	@Override
	public List<SavingsAccount> getByAccountBalanceRange(double minimum, double maximum) {
		return jdbcTemplate.query("SELECT * from account WHERE account_bal BETWEEN ? AND ?",
				new Object[] { minimum, maximum }, new SavingsAccountMapper());

	}

	@Override
	public List<SavingsAccount> sortBySalary() {
		return jdbcTemplate.query("SELECT * from account ORDER BY account_bal", new SavingsAccountMapper());
	}

	@Override
	public List<SavingsAccount> sortBySalaried() {
		return jdbcTemplate.query("SELECT * from account ORDER BY salary", new SavingsAccountMapper());
	}

}
