package es.savemywallet.com.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.savemywallet.com.beans.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		
		user.setIdUser(rs.getInt("id_user"));
		user.setNameUser(rs.getString("name_user"));
		user.setSurname(rs.getString("surname"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		
		return user;
	}
}
