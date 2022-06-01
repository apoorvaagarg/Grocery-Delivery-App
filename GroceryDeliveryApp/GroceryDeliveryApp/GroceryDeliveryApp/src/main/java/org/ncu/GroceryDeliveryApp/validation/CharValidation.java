package org.ncu.GroceryDeliveryApp.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=CharConstraintValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CharValidation 
{	
	public String message() default "must contain special characters";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default{};	
}
