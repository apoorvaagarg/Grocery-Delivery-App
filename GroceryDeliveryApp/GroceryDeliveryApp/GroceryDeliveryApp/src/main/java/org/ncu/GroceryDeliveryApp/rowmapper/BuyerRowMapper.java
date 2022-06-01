package org.ncu.GroceryDeliveryApp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ncu.GroceryDeliveryApp.entity.Account;
import org.springframework.jdbc.core.RowMapper;

public class BuyerRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account acc = new Account();
		acc.setBuyerUser(rs.getString("buyerUser"));
		acc.setBuyerPass(rs.getString("buyerPass"));
		acc.setBuyerAddress(rs.getString("buyerAddress"));
		acc.setBuyerPhone(rs.getString("buyerPhone"));
		return acc;
	}

}