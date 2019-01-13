package com.capgemini.app.account.dao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.app.account.CurrentAccount;
import com.capgemini.app.exception.AccountNotFoundException;
import com.capgemini.app.mapper.CurrentAccountMapper;

@Repository
@Primary
public class CurrentAccountSJDAOImpl implements CurrentAccountDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public CurrentAccount createNewAccount(CurrentAccount account) {
		jdbcTemplate.update("INSERT INTO ACCOUNT VALUES(?,?,?,?,?,?)",
				new Object[] { account.getBankAccount().getAccountNumber(),
						account.getBankAccount().getAccountHolderName(), account.getBankAccount().getAccountBalance(),
						null, account.getOdlimit(), "CA" });
		return account;
	}

	@Override
	public List<CurrentAccount> getAllCurrentAccounts() {
		return jdbcTemplate.query("SELECT * from account WHERE odlimit >= ?",new Object[] {0}, new CurrentAccountMapper());

	}

	@Override
	public double checkCurrentBalance(int accountNumber) {
		return jdbcTemplate.queryForObject("select account_bal from account WHERE account_id=?",
				new Object[] { accountNumber }, Double.class);

	}

	@Override
	public CurrentAccount getAccountById(int accountNumber) {
		return jdbcTemplate.queryForObject("SELECT * from account WHERE account_id=?", new Object[] { accountNumber },
				new CurrentAccountMapper());
	}

	@Override
	public CurrentAccount updateAccount(CurrentAccount account, String accountHolderName, double odlimit) {
		jdbcTemplate.update("update account set account_hn=?,odlimit=? where account_id=?",
				new Object[] { accountHolderName, odlimit, account.getBankAccount().getAccountNumber() });
		return account;
	}

	@Override
	public String deleteAccount(int accountNumber) {
		jdbcTemplate.update("Delete From account WHERE account_id=?", new Object[] { accountNumber });
		return "Account deleted";
	}

	@Override
	public void updateBalance(int accountNumber, double currentBalance) {
		jdbcTemplate.update("UPDATE ACCOUNT SET account_bal=? where account_id=?",
				new Object[] { currentBalance, accountNumber });

	}

	@Override
	public CurrentAccount searchAccountByName(String accountHolderName) {
		return jdbcTemplate.queryForObject("SELECT * from account WHERE account_hn=?",
				new Object[] { accountHolderName }, new CurrentAccountMapper());
	}

	@Override
	public CurrentAccount searchAccountByAccountNumber(int accountNumber) {
		return jdbcTemplate.queryForObject("SELECT * from account WHERE account_id=?", new Object[] { accountNumber },
				new CurrentAccountMapper());
	}

	@Override
	public List<CurrentAccount> getAccountByRange(double minimum, double minimum2) {
		return jdbcTemplate.query("SELECT * from account WHERE account_bal BETWEEN ? AND ?",
				new Object[] { minimum, minimum2 }, new CurrentAccountMapper());
	}

	@Override
	public List<CurrentAccount> sortByAccountHolderName() {
		return jdbcTemplate.query("SELECT * from account WHERE odlimit >= ? ORDER BY account_hn",new Object[] {0}, new CurrentAccountMapper());
	}

	@Override
	public List<CurrentAccount> sortBySalaryRange(int minimunbalance, int maximumbalance) {
		return jdbcTemplate.query("SELECT * from account WHERE account_bal BETWEEN ? AND ?",
				new Object[] { minimunbalance, maximumbalance }, new CurrentAccountMapper());
	}

	@Override
	public List<CurrentAccount> sortBySalaryLessthanGivenInput(int amount) {
		return jdbcTemplate.query("SELECT * from account WHERE account_bal<=?", new Object[] { amount },
				new CurrentAccountMapper());
	}

	@Override
	public List<CurrentAccount> sortBySalaryGreaterthanGivenInput(int maximumAmount) {
		return jdbcTemplate.query("SELECT * from account WHERE account_bal>=?", new Object[] { maximumAmount },
				new CurrentAccountMapper());
	}

}
