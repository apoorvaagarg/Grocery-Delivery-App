package org.ncu.GroceryDeliveryApp.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=LengthConstraintValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LengthValidation 
{
	public int value() default 10;
	
	public String message() default "must be of length 10";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default{};	
}
