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
		if(account.getBankAccount().getAccountBalance()<0)
		{
			errors.rejectValue("bankAccount.accountBalance","Double Value","Balance must be above 0");
		}
	}
}