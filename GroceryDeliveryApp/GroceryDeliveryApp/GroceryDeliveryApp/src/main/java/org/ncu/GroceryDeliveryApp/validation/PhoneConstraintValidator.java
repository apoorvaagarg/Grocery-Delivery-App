package org.ncu.GroceryDeliveryApp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneConstraintValidator implements ConstraintValidator<PhoneValidation, String> {
	
	String prefixCode;
	
	@Override
	public void initialize(PhoneValidation constraintAnnotation) {
		// TODO Auto-generated method stub
		//ConstraintValidator.super.initialize(constraintAnnotation);
		prefixCode = constraintAnnotation.value();
	}	
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		//return false;
		Boolean validate = value.startsWith(prefixCode);
		return validate;
	}
}

