package es.savemywallet.com.daos;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import es.savemywallet.com.beans.*;

import es.savemywallet.com.interfaces.IMovementDAO;
import es.savemywallet.com.utils.MovementMapper;

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
	
	@Override
	public Movement findByPrimaryId(int idMovement) {
		
		Movement aux = null;
		
		try{
			
			String sql = "SELECT * FROM movements WHERE id_movement = ?";
			aux = JdbcTemplateObject.queryForObject(sql, new Object[] {idMovement}, new MovementMapper());
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return aux;
	}

	@Override
	public void delete(int idMovement) {

		String sql = "DELETE FROM movements WHERE id_movement = ?";
		
		try{
			
			JdbcTemplateObject.update(sql, idMovement);
			
			System.out.println("deleted record with id = " + idMovement);
			
		}catch (Exception e) {
			
			System.out.println("excepcion " + e);
		}
	}

	@Override
	public void add(Movement movement) {

		System.out.println("dao " + movement.toString());
		String sql = "INSERT INTO movements VALUES (?, ?, ?, ?, ?)";
		
		try{
			
			JdbcTemplateObject.update(sql, movement.getIdMovement(), movement.getIdWallet(), movement.getIdConcept(),
					movement.getDateMovement(), movement.getQuantity());
			
			System.out.println("created record");
			
		}catch (Exception e) {
			
			System.out.println("excepcion " + e);
		}
	}

	@Override
	public void update(Movement movement) {
	
		String sql = "UPDATE movements SET id_wallet = ?, id_concept = ?, date_movement = ?, quantity = ? WHERE id_movement = ?;";
		
		try{
			
			JdbcTemplateObject.update(sql, movement.getIdWallet(), movement.getIdConcept(), movement.getDateMovement(), movement.getQuantity(), movement.getIdMovement());
			System.out.println("updated record with id = " + movement.getIdMovement());
			
		}catch (Exception e) {

			System.out.println("excepcion " + e);
		}
		
	}

	@Override
	public List<Movement> list() {
		
		String sql = "SELECT * FROM movements";
		
		List<Movement>movements = null;
		
		try{
			
			movements = (List<Movement>)JdbcTemplateObject.query(sql, new MovementMapper());
			
		}catch (Exception e) {
			
			System.out.println("excepcion " + e);
		}
		
		return movements;
	}

}
