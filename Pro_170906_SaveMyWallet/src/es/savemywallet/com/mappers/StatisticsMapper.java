package es.savemywallet.com.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import es.savemywallet.com.beans.Concept;

public class StatisticsMapper {

	public StatMapper statMapper;
	public VersusMapper versusMapper;

	public StatisticsMapper() {
		statMapper = new StatMapper();
		versusMapper = new VersusMapper();
	}

	public class StatMapper implements RowMapper<Object> {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

			Map<String, Object> stat = new HashMap<String, Object>();
			float value = rs.getFloat("quantity");
			float quantity = value;
			if (quantity < 0) {
				quantity = (value - (value * 2));
			}
			stat.put("quantity", quantity);
			stat.put("date", rs.getDate("date"));

			return stat;
		}
	}

	public class VersusMapper implements RowMapper<Object> {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

			Map<String, Object> stat = new HashMap<String, Object>();
			float ingresos = rs.getFloat("ingresos");
			float val2 = rs.getFloat("gastos");
			float gastos =  val2;
			if ( gastos < 0) {
				gastos = ( val2 - ( val2 * 2));
			}
			stat.put("totalGastos", val2);
			stat.put("totalIngresos", ingresos);

			return stat;
		}
	}

}
