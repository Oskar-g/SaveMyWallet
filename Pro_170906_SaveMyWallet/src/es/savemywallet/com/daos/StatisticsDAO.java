package es.savemywallet.com.daos;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import es.savemywallet.com.interfaces.IConceptDAO;
import es.savemywallet.com.interfaces.IStatisticsDAO;
import es.savemywallet.com.mappers.ConceptMapper;
import es.savemywallet.com.mappers.StatisticsMapper;
import es.savemywallet.com.mappers.UserMapper;


public class StatisticsDAO implements IStatisticsDAO {
	
	/**
	 * Properties
	 */
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Setter
	 * @param dataSource
	 */	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Object versus(int walletId){
		String sql = "SELECT "
				+ "		(SELECT SUM(quantity) "
				+ "			FROM movements "
				+ "			WHERE type = 'ingreso' "
				+ "			AND wallet_id = ? ) as ingresos, "
				+ "		(SELECT SUM(quantity) "
				+ "			FROM movements "
				+ "			WHERE type = 'gasto' "
				+ "			AND wallet_id = ? ) as gastos ";

		List<Object> list = null;
		try{
			list = (List<Object>)jdbcTemplateObject.query(sql, new Object[]{walletId,walletId}, new StatisticsMapper().versusMapper);
		}catch (Exception e) {
			System.out.println("excepcion " + e);
		}
		return list;
	}
	
	@Override
	public Object versusAll(int userId){
		String sql = "SELECT"
				+ "		(SELECT SUM(movements.quantity) "
				+ "			FROM movements "
				+ "			JOIN wallets ON wallets.id = movements.wallet_id "
				+ "			WHERE type = 'ingreso' "
				+ "			AND wallets.user_id = ? ) as ingresos, "
				+ "		(SELECT SUM(movements.quantity) "
				+ "			FROM movements "
				+ "			JOIN wallets ON wallets.id = movements.wallet_id "
				+ "			WHERE type = 'gasto' "
				+ "			AND wallets.user_id = ? ) as gastos;"
				+ "";

		List<Object> list = null;
		try{
			list = (List<Object>)jdbcTemplateObject.query(sql, new Object[]{userId,userId}, new StatisticsMapper().versusMapper);
		}catch (Exception e) {
			System.out.println("excepcion " + e);
		}
		return list;
	}
	
	@Override
	public List<Object> ingresos(int walletId) {
		String sql = "SELECT SUM(quantity) as quantity, date "
				+ "		FROM movements "
				+ "		WHERE quantity > 0 "
				+ "		AND wallet_id = ? "
				+ "		AND date > DATE_SUB(now(), INTERVAL 1 MONTH)"
				+ "		GROUP BY date ";

		List<Object> list = null;
		try{
			list = (List<Object>)jdbcTemplateObject.query(sql, new Object[]{walletId}, new StatisticsMapper().statMapper);
		}catch (Exception e) {
			System.out.println("excepcion " + e);
		}
		return list;
	}
	

	@Override
	public List<Object> gastos(int walletId) {
		String sql = "SELECT SUM(quantity) as quantity, date "
				+ "		FROM movements "
				+ "		WHERE quantity < 0 "
				+ "		AND wallet_id = ? "
				+ "		AND date > DATE_SUB(now(), INTERVAL 1 MONTH)"
				+ "		GROUP BY date ";

		List<Object> list = null;
		try{
			list = (List<Object>)jdbcTemplateObject.query(sql, new Object[]{walletId}, new StatisticsMapper().statMapper);
		}catch (Exception e) {
			System.out.println("excepcion " + e);
		}
		return list;
	}
}

	

