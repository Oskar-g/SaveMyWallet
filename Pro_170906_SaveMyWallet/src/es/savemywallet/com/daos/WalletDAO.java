package es.savemywallet.com.daos;

import java.util.ArrayList;
import java.util.List;


import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import es.savemywallet.com.beans.Wallet;
import es.savemywallet.com.interfaces.IWalletDAO;
import es.savemywallet.com.utils.WalletMapper;

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
	 * 
	 * Method find by primary id_user
	 */
	@Override
	public Wallet findByPrimaryId(Wallet wallet) {
		Wallet auxWallet = null;
		try{
			String SQL = "SELECT * FROM wallets WHERE id_wallet = ?";
			auxWallet = jdbcTemplateObject.queryForObject(SQL, new Object[]{wallet.getIdWallet()}, new WalletMapper());
		}catch(Exception e){
			System.out.println(e);
		}
		return auxWallet;
	}
	
	/**
	 * Method add wallet
	 */
	@Override
	public void add(Wallet wallet) {
		String SQL = "INSERT INTO wallets (id_wallet, id_user, name_wallet, description) VALUES (?,?,?,?)";
		try{
			jdbcTemplateObject.update(SQL, wallet.getIdWallet(), wallet.getIdUser(), wallet.getName(), wallet.getDescripcion());
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	/**
	 * Method delete wallet
	 */
	@Override
	public void delete(Wallet wallet) {
		String SQL = "DELETE FROM wallets WHERE id_wallet = ?";
		try{
			jdbcTemplateObject.update(SQL, wallet.getIdWallet());
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	/**
	 * Method list wallets
	 */
	@Override
	public List<Wallet> list() {
		String SQL = "SELECT * FROM wallets";
		List<Wallet> listWallet = null;
		try{
			listWallet = jdbcTemplateObject.query(SQL, new WalletMapper());
		}catch(Exception e){
			System.out.println(e);
		}
		return listWallet;
	}
	

}
