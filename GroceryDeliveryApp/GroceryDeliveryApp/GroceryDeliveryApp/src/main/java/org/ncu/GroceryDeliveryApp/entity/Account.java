package org.ncu.GroceryDeliveryApp.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.ncu.GroceryDeliveryApp.validation.CharValidation;
import org.ncu.GroceryDeliveryApp.validation.PhoneValidation;

public class Account {

	private String adminUser;
	private String adminPass;
		
	@NotEmpty(message="This field is required.")
	private String buyerUser;
	
	@CharValidation
	@Size(min=8)
	@NotEmpty(message="This field is required.")
	private String buyerPass;
	
	@NotEmpty(message="This field is required.")
	private String buyerAddress;
	
	@PhoneValidation 
	private String buyerPhone;
	
	@Override
	public String toString() {
		return "Account [buyerAddress=" + buyerAddress + ", buyerPhone=" + buyerPhone
				+ "]";
	}

	public String getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}

	public String getAdminPass() {
		return adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

	public String getBuyerUser() {
		return buyerUser;
	}

	public void setBuyerUser(String buyerUser) {
		this.buyerUser = buyerUser;
	}

	public String getBuyerPass() {
		return buyerPass;
	}

	public void setBuyerPass(String buyerPass) {
		this.buyerPass = buyerPass;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}
}