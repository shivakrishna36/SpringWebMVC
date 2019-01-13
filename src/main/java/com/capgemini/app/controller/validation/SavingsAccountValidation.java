package com.capgemini.app.controller.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.capgemini.app.account.SavingsAccount;

@Component
public class SavingsAccountValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {

		SavingsAccount account = (SavingsAccount) target;
		String name = account.getBankAccount().getAccountHolderName();
		double balance = account.getBankAccount().getAccountBalance();
		if(balance<100)
		{
			errors.rejectValue("bankAccount.accountBalance", "Double Value", "Balance must be above 100");
		}
		
		if(name!=null || name.isEmpty())
		{
			if(name.length()<2)
			{
				errors.rejectValue("bankAccount.accountHolderName", "Input mismatch", "Please  enter atleast two characters");
			}
			
			if(!name.matches("^[a-zA-Z\\s]*$"))
			{
				errors.rejectValue("bankAccount.accountHolderName", "Input mismatch", "Please enter characters");
			}
		}
		
		boolean value = account.isSalary();
		
		 if(!value==true || !value==false) {
		 errors.rejectValue("salary", "Input mismatch",
		 "Select salary type"); }
		 
	}

}
