package es.savemywallet.com.daos;

import java.util.List;


import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import es.savemywallet.com.beans.Wallet;
import es.savemywallet.com.interfaces.IWalletDAO;
import es.savemywallet.com.mappers.WalletMapper;

public class WalletDAO implements IWalletDAO {
	
	/**
	 * Properties
	 */
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Setter
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Method find by primary id
	 */
	@Override
	public Wallet findByPrimaryId(int idWallet) {
		Wallet auxWallet = null;
		try{
			String SQL = "SELECT * "
					+ "		FROM wallets "
					+ "		WHERE id = ?";
			auxWallet = jdbcTemplateObject.queryForObject(SQL, new Object[]{idWallet}, new WalletMapper());
		}catch(Exception e){
			System.out.println(e);
		}
		return auxWallet;
	}

	/*
	public float getBalance(int idWallet) {
		String SQL = "SELECT IFNULL(SUM(movements.quantity),0) "
					+ "FROM movements "
					+ "WHERE id = ?";
		float balance = 0;
		try{
			balance = jdbcTemplateObject.query(SQL, new Object[]{idWallet},new WalletMapper());
		}catch(Exception e){
			System.out.println(e);
		}
		return balance;
	}
	*/
	
	/**
	 * Method add wallet
	 */
	@Override
	public void add(Wallet wallet) {
		String SQL = "INSERT INTO wallets VALUES (null,?,?,?)";
		try{
			jdbcTemplateObject.update(SQL, wallet.getUserId(), wallet.getName(), wallet.getDescription());
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	/**
	 * Method delete id
	 */
	@Override
	public void delete(int idWallet) {
		String SQL = "DELETE FROM wallets WHERE id = ?";
		try{
			jdbcTemplateObject.update(SQL, idWallet);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	/**
	 * Method update wallet
	 */
	@Override
	public void update(Wallet wallet) {
		String SQL = "UPDATE wallets "
				+ "		SET user_id = ?, "
				+ "		name= ?, "
				+ "		description = ? "
				+ "		WHERE id = ?";
		try{
			jdbcTemplateObject.update(SQL, wallet.getUserId(),wallet.getName(), wallet.getDescription(),wallet.getId());
		}catch(Exception e){			
			System.out.println(e);
		}
		
	}
	
	/**
	 * Method list wallets
	 */
	@Override
	public List<Wallet> list(int idUser) {
		String SQL = "SELECT * "
					+ "FROM wallets "
					+ "WHERE user_id = ?";
		List<Wallet> listWallet = null;
		try{
			listWallet = jdbcTemplateObject.query(SQL, new Object[]{idUser},new WalletMapper());
		}catch(Exception e){
			System.out.println(e);
		}
		return listWallet;
	}
	

	/**
	 * Method list wallets
	 */
	@Override
	public List<Wallet> list() {
		String SQL = "SELECT * "
				+ "FROM wallets ";
		List<Wallet> listWallet = null;
		try{
			listWallet = jdbcTemplateObject.query(SQL,new WalletMapper());
		}catch(Exception e){
			System.out.println(e);
		}
		return listWallet;
	}

}
