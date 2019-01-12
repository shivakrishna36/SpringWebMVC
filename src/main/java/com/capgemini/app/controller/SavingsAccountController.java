package com.capgemini.app.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.app.account.SavingsAccount;
import com.capgemini.app.account.service.SavingsAccountService;
import com.capgemini.app.controller.validation.SavingsAccountValidation;
import com.capgemini.app.exception.AccountNotFoundException;

@Controller
public class SavingsAccountController {

	private static Logger logger = Logger.getLogger(SavingsAccountController.class.getName());
	
	@Autowired
	SavingsAccountValidation validation;
	
	@Autowired
	private SavingsAccountService service;
	@RequestMapping("/getAll")
	public String getAllAccounts(Model model) throws ClassNotFoundException, SQLException {
		List<SavingsAccount> account = service.getAllSavingsAccount();
		model.addAttribute("accounts", account);
		return "getAll";
	}

	@RequestMapping("/update")
	public String searchId() 
	{
		return "searchId";
	}

	@RequestMapping("/searchAccount")
	public String searchAccount(Model model,@RequestParam("accNUmber") int accNUmber) throws ClassNotFoundException, SQLException, AccountNotFoundException
	{
		SavingsAccount account = service.getAccountById(accNUmber);
		model.addAttribute("account", account);
		return "searchAccount";
	}

	@RequestMapping("/updateDetails")
	public String update(Model model,@RequestParam("accountNumber") int accountNumber,@RequestParam("name") String name,@RequestParam("salary") boolean salary) throws ClassNotFoundException, SQLException, AccountNotFoundException
	{
		SavingsAccount account = service.getAccountById(accountNumber);
		service.updateAccount(account, name, salary);
		return "redirect:getAll";
	}
	
	@RequestMapping("/search")
	public String searchById() 
	{
		return "searchById";
	}
	

	@RequestMapping("/getByAccountId")
	public String searchAccountById(Model model,@RequestParam("accNUmber") int accountNumber) throws ClassNotFoundException, SQLException, AccountNotFoundException
	{
		SavingsAccount account = service.getAccountById(accountNumber);
		model.addAttribute("account", account);
		return "getById";
	}
	
	@RequestMapping("/addNewaccount")
	public String addAccount(Model model)
	{
		model.addAttribute("account", new SavingsAccount());
		return "createSavingsAccount";
	}
	
	@RequestMapping(value= "/createAccount", method= RequestMethod.POST)
	public String addNewAccount(@ModelAttribute("account") SavingsAccount account,BindingResult result) throws ClassNotFoundException, SQLException
	{
		validation.validate(account, result);
		if(result.hasErrors())
		{
			return "createSavingsAccount";
		}
		logger.info(""+account.getBankAccount().getAccountBalance());
		service.createNewAccount(account.getBankAccount().getAccountHolderName(),account.getBankAccount().getAccountBalance(),account.isSalary());
		logger.info(""+account.getBankAccount().getAccountBalance()+account.getBankAccount().getAccountHolderName());
		return "redirect:getAll";
	}
	
	@RequestMapping("/closeAccount")
	public String close()
	{
		return "delete";
	}
	
	@RequestMapping("/deleteAccount")
	public String deleteAccount(@RequestParam("accNUmber") int accountNumber) throws ClassNotFoundException, SQLException
	{
		service.deleteAccount(accountNumber);
		return "redirect:getAll";
	}
	
	@RequestMapping("/getcurrentbalance")
	public String getBalance()
	{
		return "getbalance";
	}
	
	@RequestMapping("/getBalance")
	public String getAccountBalance(@RequestParam("accNUmber") int accountNumber,Model model) throws ClassNotFoundException, SQLException, AccountNotFoundException
	{
		double balance = service.checkCurrentBalance(accountNumber);
		model.addAttribute("balance", balance);
		return "showBalance";
	}
	
	@RequestMapping("/deposit")
	public String deposit()
	{
		return "depositMoney";
	}
	
	@RequestMapping("/depositMoney")
	public String depositMoney(@RequestParam("accountNumber") int accountNumber,@RequestParam("accountBalance") double amount) throws ClassNotFoundException, SQLException, AccountNotFoundException
	{
		SavingsAccount account = service.getAccountById(accountNumber);
		service.deposit(account, amount);
		return "redirect:getAll";
	}
	
	@RequestMapping("/withdraw")
	public String withdraw()
	{
		return "withdrawMoney";
	}
	
	@RequestMapping("/withdrawMoney")
	public String withdrawMoney(@RequestParam("accountNumber") int accountNumber,@RequestParam("accountBalance") double amount) throws ClassNotFoundException, SQLException, AccountNotFoundException
	{
		SavingsAccount account = service.getAccountById(accountNumber);
		service.withdraw(account, amount);
		System.out.println(account.getBankAccount().getType());
		return "redirect:getAll";
	}
	
	@RequestMapping("/fundtransfer")
	public String fundTransfer()
	{
		return "moneyTransfer";
	}
	
	@RequestMapping("/FundTransfer")
	public String fundtransfer(@RequestParam("sender") int sender,@RequestParam("receiver") int receiver,@RequestParam("amountToTransfer") double amount) throws ClassNotFoundException, SQLException, AccountNotFoundException 
	{
		SavingsAccount senderAccount = service.getAccountById(sender);
		SavingsAccount receiverAccount = service.getAccountById(receiver);
		service.fundTransfer(senderAccount, receiverAccount, amount);
		return "redirect:getAll";
	}
	
	@RequestMapping("/sortByName")
	public String sortByName(Model model) throws ClassNotFoundException, SQLException
	{
		List<SavingsAccount> account = service.sortByAccountHolderName();
		model.addAttribute("account", account);
		return "sortByName";
	}
}
