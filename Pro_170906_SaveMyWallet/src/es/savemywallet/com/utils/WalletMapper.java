package es.savemywallet.com.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.savemywallet.com.beans.Wallet;

public class WalletMapper implements RowMapper<Wallet> {
	
	@Override
	public Wallet mapRow(ResultSet rs, int rowNum) throws SQLException {
		Wallet wallet = new Wallet();
		
		wallet.setIdWallet(rs.getInt("id_wallet"));
		wallet.setIdUser(rs.getInt("id_user"));
		wallet.setName(rs.getString("name_wallet"));
		wallet.setDescripcion(rs.getString("descripcion"));
		
		return wallet;
	}

}
