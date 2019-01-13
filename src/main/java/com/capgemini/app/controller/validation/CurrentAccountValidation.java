package com.capgemini.app.controller.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.capgemini.app.account.CurrentAccount;

@Component
public class CurrentAccountValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {

		CurrentAccount account = (CurrentAccount) target;
		String name = account.getBankAccount().getAccountHolderName();
		if(account.getBankAccount().getAccountBalance()<1000)
		{
			errors.rejectValue("bankAccount.accountBalance", "Double Value", "Balance must be above 1000");
		}
		
		if(name!=null || name.isEmpty())
		{
			if(name.length()<2)
			{
				errors.rejectValue("bankAccount.accountHolderName", "Input mismatch", "Please  enter atleast two characters");
			}
			
			
			if(!name.matches("^[a-zA-Z\\s]*$"))
			{
				errors.rejectValue("bankAccount.accountHolderName", "Input mismatch", "Enter only characters");
			}
			
		}
		
		if(account.getOdlimit()<100)
		{
			errors.rejectValue("odlimit", "Double Value", "odlimit must be above 100");
		}
	}
}