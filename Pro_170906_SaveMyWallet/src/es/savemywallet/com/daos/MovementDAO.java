package es.savemywallet.com.daos;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import es.savemywallet.com.beans.*;

import es.savemywallet.com.interfaces.IMovementDAO;
import es.savemywallet.com.mappers.MovementMapper;

public class MovementDAO implements IMovementDAO{

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
	 * Method find by primary id_movement
	 */
	@Override
	public Movement findByPrimaryId(int id) {
		Movement aux = null;
		try{
			String sql = "SELECT * "
					+ "		FROM movements "
					+ "		WHERE id = ?";
			aux = JdbcTemplateObject.queryForObject(sql, new Object[] {id}, new MovementMapper());
		}catch(Exception e){
			e.printStackTrace();
		}
		return aux;
	}

	/**
	 * Method delete id_movement
	 */
	@Override
	public void delete(int idMovement) {
		String sql = "DELETE "
				+ "		FROM movements "
				+ "		WHERE id = ?";
		try{
			JdbcTemplateObject.update(sql, idMovement);
			System.out.println("deleted record with id = " + idMovement);
		}catch (Exception e) {
			System.out.println("excepcion " + e);
		}
	}

	/**
	 * Method add movement
	 */
	@Override
	public void add(Movement movement) {
		System.out.println("dao " + movement.toString());
		String sql = "INSERT INTO movements "
				+ "		VALUES (null, ?, ?, ?, ?, ?)";
		try{
			JdbcTemplateObject.update(sql, movement.getWalletId(), movement.getConcept().getName(),
					movement.getType(),movement.getDate(), movement.getQuantity());
			System.out.println("created record");
		}catch (Exception e) {
			System.out.println("excepcion " + e);
		}
	}

	/**
	 * Method update movement
	 */
	@Override
	public void update(Movement movement) {
		System.out.println("AQUI"+movement);
		String sql = "UPDATE movements "
				+ "		SET wallet_id = ?, "
				+ "		concept = ?, "
				+ "		date = ?, "
				+ "		type = ?, "
				+ "		quantity = ? "
				+ "		WHERE id = ?;";
		try{
			JdbcTemplateObject.update(sql, movement.getWalletId(), movement.getConcept().getName(), movement.getDate(), movement.getType(), movement.getQuantity(), movement.getId());
			System.out.println("updated record with id = " + movement.getId());
		}catch (Exception e) {
			System.out.println("excepcion " + e);
		}
	}

	/**
	 * Method list movement
	 */
	@Override
	public List<Movement> list(int walletId) {
		String sql = "SELECT * "
				+ "		FROM movements "
				+ "WHERE  wallet_id = ?";
		List<Movement>movements = null;
		try{
			movements = (List<Movement>)JdbcTemplateObject.query(sql,new Object[]{walletId}, new MovementMapper());
		}catch (Exception e) {
			System.out.println("excepcion " + e);
		}
		return movements;
	}

}
