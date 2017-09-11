package es.savemywallet.com.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.savemywallet.com.beans.Wallet;

public class WalletBalanceMapper implements RowMapper<Wallet> {
	
	@Override
	public Wallet mapRow(ResultSet rs, int rowNum) throws SQLException {
		Wallet wallet = new Wallet();
		
		wallet.setIdWallet(rs.getInt("id_wallet"));
		wallet.setIdUser(rs.getInt("id_user"));
		wallet.setNameWallet(rs.getString("name_wallet"));
		wallet.setDescription(rs.getString("description"));
		wallet.setBalance(rs.getFloat("balance"));
		
		return wallet;
	}

}
