package es.savemywallet.com.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.savemywallet.com.beans.Concept;
import es.savemywallet.com.beans.Movement;


public class MovementMapper implements RowMapper<Movement>{

	@Override
	public Movement mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Movement movement = new Movement();
		Concept concept = new Concept(rs.getString("concept"));
		
		
		movement.setIdMovement(rs.getInt("id_movement"));
		movement.setWalletId(rs.getInt("wallet_id"));
		movement.setType(rs.getString("type"));
		movement.setConcept(concept);
		movement.setDate(rs.getDate("date"));
		movement.setQuantity(rs.getDouble("quantity"));
		
		return movement;
	}

}
