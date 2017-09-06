package es.savemywallet.com.daos;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import es.savemywallet.com.beans.User;
import es.savemywallet.com.interfaces.IUserDAO;

public class UserDAO implements IUserDAO {

	private DataSource dataSource;
	private JdbcTemplate JdbcTemplateObject;
	
	@Override
	public User findByPrimaryId(int id) {
		
		User aux = null;
		
		try{
			
			String sql = "SELECT * FROM users WHERE id_user = ?";
			
		}catch(){
			
		}
		
	}

	@Override
	public void delete(int id) {
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
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
