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
	
	/**
	 * Setter
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.JdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
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
		
		String sql = "DELETE FROM users WHERE id_user = ?";
		
		try{
			
			JdbcTemplateObject.update(sql, idUser);
			
			System.out.println("deleted record with id = " + idUser);
			
		}catch (Exception e) {
			
			System.out.println("excepcion " + e);
		}
	}

	@Override
	public void add(User user) {
		
		System.out.println("dao " + user.toString());
		String sql = "INSERT INTO users VALUES (?, ?, ?, ?, ?)";
				
		try{
			
			JdbcTemplateObject.update(sql,user.getIdUser(), user.getNameUser(), user.getSurname(), user.getEmail(), user.getPassword());
			System.out.println("created record");
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void update(User user) {

		String sql = "UPDATE users SET name_user = ?, surname = ?, email = ?, password = ? WHERE id_user = ?;";
		
		try{
			
			JdbcTemplateObject.update(sql, user.getNameUser(), user.getSurname(), user.getEmail(), user.getPassword(), user.getIdUser());
			System.out.println("updated record with id = " + user.getIdUser());
			
		}catch (Exception e) {

			System.out.println("excepcion " + e);
		}
	}

	@Override
	public List<User> list() {
		
		String sql = "SELECT * FROM users";
		
		List<User>users = null;
		
		try{
			
			users = (List<User>)JdbcTemplateObject.query(sql, new UserMapper());
			
		}catch (Exception e) {
			
			System.out.println("excepcion " + e);
		}
		
		return users;
	}
}
