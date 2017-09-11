package es.savemywallet.com.daos;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import es.savemywallet.com.beans.User;
import es.savemywallet.com.interfaces.IUserDAO;
import es.savemywallet.com.mappers.UserMapper;

public class UserDAO implements IUserDAO {
	
	/**
	 * Properties
	 */
	private DataSource dataSource;
	private JdbcTemplate JdbcTemplateObject;
	
	/**
	 * Setter
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.JdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Method find by primary id_user
	 */
	@Override
	public User findByPrimaryId(int id) {
		User aux = null;
		try{
			String sql = "SELECT * "
					+ "FROM users "
					+ "WHERE id_user = ?";
			aux = JdbcTemplateObject.queryForObject(sql, new Object[] {id}, new UserMapper());
		}catch(Exception e){
			
			System.out.println("excepcion " + e);
		}
		return aux;
	}
	
	/**
	 * Method find User
	 */
	@Override
	public User findUser(String user, String password) {
		
		User aux = null;
		try{
			
			String sql = "SELECT * FROM users "
					+ "		WHERE (username = ? OR email = ?) "
					+ "		AND password = md5(?)";
			System.out.println(1);					
			aux = JdbcTemplateObject.queryForObject(sql, new Object[] {user,user,password}, new UserMapper());
	
		}catch(Exception e){
			
			System.out.println("excepcion " + e);
		}
	
		return aux;
	}

	/**
	 * Method delete id_user
	 */
	@Override
	public void delete(int id) {
		String sql = "DELETE FROM "
				+ "		users WHERE id = ?";
		try{
			JdbcTemplateObject.update(sql, id);
			System.out.println("deleted record with id = " + id);
		}catch (Exception e) {		
			System.out.println("excepcion " + e);
		}
	}

	/**
	 * Method add user
	 */
	@Override
	public void add(User user) {
		
		System.out.println("dao " + user.toString());
		String sql = "INSERT INTO users "
				+ "		VALUES (null, ?, ?, ?, ?)";
				
		try{
			
			JdbcTemplateObject.update(sql, user.getUsername(), user.getName(), user.getSurname(), user.getEmail(), user.getPassword());
			System.out.println("created record");
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Method update user
	 */
	@Override
	public void update(User user) {
		String sql = "UPDATE users "
				+ "		SET username = ?, "
				+ "		surname = ?, "
				+ "		surname = ?, "
				+ "		email = ?, "
				+ "		password = ? "
				+ "		WHERE id = ?";
		try{
			JdbcTemplateObject.update(sql, user.getUsername(), user.getName(), user.getSurname(), user.getEmail(), user.getPassword(), user.getId());
			System.out.println("updated record with id = " + user.getId());
		}catch (Exception e) {
			System.out.println("excepcion " + e);
		}
	}

	
	/**
	 * Method list wallets
	 */
	@Override
	public List<User> list() {
		String sql = "SELECT * "
				+ "		FROM users";
		List<User>users = null;
		try{
			users = (List<User>)JdbcTemplateObject.query(sql, new UserMapper());
		}catch (Exception e) {
			System.out.println("excepcion " + e);
		}
		return users;
	}
}
