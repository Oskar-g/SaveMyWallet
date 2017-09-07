package es.savemywallet.com.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.savemywallet.com.beans.Movement;


public class MovementMapper implements RowMapper<Movement>{

	@Override
	public Movement mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Movement movement = new Movement();
		
		movement.setIdConcept(rs.getInt("id_movement"));
		movement.setIdWallet(rs.getInt("id_wallet"));
		movement.setIdMovement(rs.getInt("id_movement"));
		movement.setDateMovement(rs.getDate("date_movement"));
		movement.setQuantity(rs.getDouble("quantity"));
		
		return movement;
	}

}
