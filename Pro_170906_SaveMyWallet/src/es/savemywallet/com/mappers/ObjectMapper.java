package es.savemywallet.com.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

	public class ObjectMapper implements RowMapper<Object> {
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			
			Object o = new Object();
/*			
			o.setId_Objet(rs.getInt("id_object"));
			...
			...
*/
			
			return o;
		}
}
