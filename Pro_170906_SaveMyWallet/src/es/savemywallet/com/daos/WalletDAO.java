package es.savemywallet.com.daos;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import es.savemywallet.com.beans.User;
import es.savemywallet.com.interfaces.IWalletDAO;

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
	 * Method find by primary id_user
	 */
	@Override
	public User findByPrimaryId(int idWallet) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public void delete(int idWallet) {
		// TODO Auto-generated method stub

	}

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Wallet> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
