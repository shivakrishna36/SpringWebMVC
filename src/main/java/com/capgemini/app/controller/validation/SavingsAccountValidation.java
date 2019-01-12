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
		if(account.getBankAccount().getAccountBalance()<100)
		{
			errors.reject("Balance must be above 100");
		}
	}

}
