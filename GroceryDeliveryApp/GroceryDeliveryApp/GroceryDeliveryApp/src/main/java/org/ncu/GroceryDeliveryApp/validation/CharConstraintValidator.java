package org.ncu.GroceryDeliveryApp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CharConstraintValidator implements ConstraintValidator<CharValidation, String> 
{

	 String[] r = {"[", "$", "&", "+",":", ";", "=", "?", "@", "#", "|", "'", "<", ">", ".", "-", "^", "*", "(", ")", "%", "!", "]", ","};
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		Boolean val = false;
		
		for(int i=0; i<r.length; i++)
		{
			if(value.contains(r[i]))
			{
				val = true;
				break;
			}
			else
			{
				val = false;
			}
		}
		return val;
	}
}
