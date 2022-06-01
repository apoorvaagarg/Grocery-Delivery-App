package org.ncu.GroceryDeliveryApp.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=PhoneConstraintValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneValidation 
{	
	public String value() default "+91";
	
	public String message() default "must be prefixed with +91";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default{};	
}
