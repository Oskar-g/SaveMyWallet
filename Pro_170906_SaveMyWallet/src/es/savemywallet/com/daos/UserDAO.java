package es.savemywallet.com.daos;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import es.savemywallet.com.beans.User;
import es.savemywallet.com.interfaces.IUserDAO;
import es.savemywallet.com.utils.UserMapper;

public class UserDAO implements IUserDAO {

	private DataSource dataSource;
	private JdbcTemplate JdbcTemplateObject;
	
	@Override
	public User findByPrimaryId(int idUser) {
		
		User aux = null;
		
		try{
			
			String sql = "SELECT * FROM users WHERE id_user = ?";
			aux = JdbcTemplateObject.queryForObject(sql, new Object[] {idUser}, new UserMapper());
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return aux;
	}

	@Override
	public void delete(int idUser) {
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
