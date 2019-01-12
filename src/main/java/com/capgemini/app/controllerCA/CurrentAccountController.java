package com.capgemini.app.controllerCA;
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

import com.capgemini.app.account.CurrentAccount;
import com.capgemini.app.account.SavingsAccount;
import com.capgemini.app.account.service.CurrentAccountService;
import com.capgemini.app.exception.AccountNotFoundException;

@Controller
public class CurrentAccountController {

	private static Logger logger = Logger.getLogger(CurrentAccountController.class.getName());
	
	//@Autowired
	//CurrentAccountValidation validation;
	
	
	  @Autowired private CurrentAccountService service;
	 
	  @RequestMapping("/getAllAccounts") 
	  public String getAllAccounts(Model model) throws ClassNotFoundException, SQLException 
	  { 
		  List<CurrentAccount> account =service.getAllCurrentAccounts(); 
		  model.addAttribute("accounts", account);
		  return "getAllAccounts";
	  }
	 
	@RequestMapping("/updateCurrentAccount")
	public String searchId() 
	{
		return "searchCAId";
	}

	@RequestMapping("/CAupdate")
	public String searchAccount(Model model,@RequestParam("accNUmber") int accNUmber) throws ClassNotFoundException, SQLException, AccountNotFoundException
	{
		CurrentAccount account = service.getAccountById(accNUmber);
		model.addAttribute("account", account);
		return "searchCAAccount";
	}

	@RequestMapping("/updateCurrentDetails")
	public String update(Model model,@RequestParam("accountNumber") int accountNumber,@RequestParam("name") String name,@RequestParam("odlimit") double odlimit) throws ClassNotFoundException, SQLException, AccountNotFoundException
	{
		CurrentAccount account = service.getAccountById(accountNumber);
		service.updateAccount(account, name, odlimit);
		return "redirect:getAllAccounts";
	}
	
	@RequestMapping("/searchcurrentaccount")
	public String searchById() 
	{
		return "searchByIdNumber";
	}
	

	@RequestMapping("/searchCurrentAccount")
	public String searchAccountById(Model model,@RequestParam("accNUmber") int accountNumber) throws ClassNotFoundException, SQLException, AccountNotFoundException
	{
		CurrentAccount account = service.getAccountById(accountNumber);
		model.addAttribute("account", account);
		return "getByCurrentIdNumber";
	}
	
	@RequestMapping("/addNewcurrentaccount")
	public String addAccount(Model model)
	{
		model.addAttribute("account", new CurrentAccount());
		return "createCurrentAccount";
	}
	
	@RequestMapping(value= "/createNewAccount", method= RequestMethod.POST)
	public String addNewAccount(@ModelAttribute("account") CurrentAccount account,BindingResult result) throws ClassNotFoundException, SQLException
	{
		//validation.validate(account, result);
		if(result.hasErrors())
		{
			return "createCurrentAccount";
		}
		
		service.createNewAccount(account.getBankAccount().getAccountHolderName(), account.getBankAccount().getAccountBalance(), account.getOdlimit());
		logger.info("Account created:");
		return "redirect:getAllAccounts";
	}
	
	@RequestMapping("/closecurrentAccount")
	public String close()
	{
		return "close";
	}
	
	@RequestMapping("/closeCurrentAccount")
	public String deleteAccount(@RequestParam("accNUmber") int accountNumber) throws ClassNotFoundException, SQLException
	{
		service.deleteAccount(accountNumber);
		return "redirect:getAllAccounts";
	}
	
	@RequestMapping("/getAccbalance")
	public String getBalance()
	{
		return "getcurrentbalance";
	}
	
	@RequestMapping("/getCurrentBalance")
	public String getAccountBalance(@RequestParam("accNUmber") int accountNumber,Model model) throws ClassNotFoundException, SQLException, AccountNotFoundException
	{
		double balance = service.checkCurrentBalance(accountNumber);
		model.addAttribute("balance", balance);
		return "showBalance";
	}
	
	@RequestMapping("/moneydeposit")
	public String deposit()
	{
		return "depositCurrentMoney";
	}
	
	@RequestMapping("/depositCurrentMoney")
	public String depositMoney(@RequestParam("accountNumber") int accountNumber,@RequestParam("accountBalance") double amount) throws ClassNotFoundException, SQLException, AccountNotFoundException
	{
		CurrentAccount account = service.getAccountById(accountNumber);
		service.deposit(account, amount);
		return "redirect:getAllAccounts";
	}
	
	@RequestMapping("/moneywithdraw")
	public String withdraw()
	{
		return "withdrawCurrentMoney";
	}
	
	@RequestMapping("/withdrawCurrentMoney")
	public String withdrawMoney(@RequestParam("accountNumber") int accountNumber,@RequestParam("accountBalance") double amount) throws ClassNotFoundException, SQLException, AccountNotFoundException
	{
		CurrentAccount account = service.getAccountById(accountNumber);
		service.withdraw(account, amount);
		return "redirect:getAllAccounts";
	}
	
	@RequestMapping("/moneyfundtransfer")
	public String fundTransfer()
	{
		return "transfer";
	}
	
	@RequestMapping("/CurrentAccountFundTransfer")
	public String fundtransfer(@RequestParam("sender") int sender,@RequestParam("receiver") int receiver,@RequestParam("amountToTransfer") double amount) throws ClassNotFoundException, SQLException, AccountNotFoundException 
	{
		CurrentAccount senderAccount = service.getAccountById(sender);
		CurrentAccount receiverAccount = service.getAccountById(receiver);
		service.fundTransfer(senderAccount, receiverAccount, amount);
		return "redirect:getAllAccounts";
	}
	
	@RequestMapping("/CurrentsortByName")
	public String sortByName(Model model) throws ClassNotFoundException, SQLException
	{
		List<CurrentAccount> account = service.sortByAccountHolderName();
		model.addAttribute("account", account);
		return "sortByCurrentName";
	}
}

