package es.savemywallet.com.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.savemywallet.com.beans.Concept;

public class ConceptMapper implements RowMapper<Concept> {

	@Override
	public Concept mapRow(ResultSet rs, int rowNum) throws SQLException {
		Concept concept = new Concept();
		
		concept.setName(rs.getString("name"));
			
		return concept;
	}
	

}
