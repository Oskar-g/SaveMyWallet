package es.savemywallet.com.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.savemywallet.com.beans.Wallet;

public class WalletMapper implements RowMapper<Wallet> {
	
	@Override
	public Wallet mapRow(ResultSet rs, int rowNum) throws SQLException {
		Wallet wallet = new Wallet();
		
		wallet.setIdWallet(rs.getInt("id"));
		wallet.setUserId(rs.getInt("user_id"));
		wallet.setName(rs.getString("name"));
		wallet.setDescription(rs.getString("description"));
		
		return wallet;
	}

}
