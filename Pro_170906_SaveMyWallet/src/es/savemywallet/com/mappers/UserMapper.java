package es.savemywallet.com.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.savemywallet.com.beans.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		System.out.println(2);
		User user = new User();
		
		user.toString();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setName(rs.getString("name"));
		user.setSurname(rs.getString("surname"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		
		return user;
	}
}
