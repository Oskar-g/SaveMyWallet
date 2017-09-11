package es.savemywallet.com.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.RowMapper;

import es.savemywallet.com.beans.Wallet;

public class WalletBalanceMapper implements RowMapper<Wallet> {
	
	@Override
	public Wallet mapRow(ResultSet rs, int rowNum) throws SQLException {

		Wallet wallet = new Wallet();	
		wallet.setId(rs.getInt("id"));
		wallet.setUserId(rs.getInt("user_id"));
		wallet.setName(rs.getString("name"));
		wallet.setDescription(rs.getString("description"));
		wallet.setBalance(rs.getFloat("balance"));
		
		return wallet;
	}

}
