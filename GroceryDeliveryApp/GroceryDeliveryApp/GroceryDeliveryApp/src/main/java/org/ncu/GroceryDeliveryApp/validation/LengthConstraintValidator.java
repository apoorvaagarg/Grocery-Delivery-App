package org.ncu.GroceryDeliveryApp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LengthConstraintValidator implements ConstraintValidator<LengthValidation, String> 
{
	int len;
	
	@Override
	public void initialize(LengthValidation constraintAnnotation) {
		// TODO Auto-generated method stub
		len = constraintAnnotation.value();
	}	
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		int l = value.length();
		if(l==len)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
