package es.savemywallet.com.daos;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import es.savemywallet.com.beans.Concept;
import es.savemywallet.com.interfaces.IConceptDAO;
import es.savemywallet.com.mappers.ConceptMapper;
import es.savemywallet.com.mappers.UserMapper;


public class ConceptDAO implements IConceptDAO {
	
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
	
	/**
	 * Method find by primary id
	 */
	@Override
	public Concept findByPrimaryId(Concept concept) {
		Concept aux = null;
		try{
			String sql = "SELECT * "
					+ "		FROM concepts "
					+ "		WHERE name = ?";
			aux = jdbcTemplateObject.queryForObject(sql, new Object[] {concept.getName()}, new ConceptMapper());
		}catch(Exception e){
			e.printStackTrace();
		}
		return aux;
	}

	/**
	 * Method delete concept
	 */
	@Override
	public void delete(Concept concept) {
		String sql = "DELETE FROM concepts "
				+ "		WHERE name = ?";
		try{
			jdbcTemplateObject.update(sql, concept.getName());
			System.out.println("deleted record with id = " + concept.getName());
		}catch (Exception e) {
			System.out.println("excepcion " + e);
		}
	}

	/**
	 * Method add concept
	 */
	@Override
	public void add(Concept concept) {
		String sql = "INSERT INTO concepts "
				+ "		VALUES (?)";
		
		try{
			jdbcTemplateObject.update(sql,concept.getName());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method update concept
	 */
	@Override
	public void update(Concept concept) {
		String sql = "UPDATE concepts "
				+ "		SET name= ? "
				+ "		WHERE name=?;";
		try{
			jdbcTemplateObject.update(sql, concept.getName(), concept.getName());
			System.out.println("updated record with name = " + concept.getName());
		}catch (Exception e) {
			System.out.println("excepcion " + e);
		}
	}
	
	/**
	 * Method list concepts
	 */
	@Override
	public List<Concept> list() {
		String sql = "SELECT * "
				+ "		FROM concepts";
		List<Concept> listConcepts = null;
		try{
			listConcepts = (List<Concept>)jdbcTemplateObject.query(sql, new ConceptMapper());
		}catch (Exception e) {
			System.out.println("excepcion " + e);
		}
		return listConcepts;
	}
}

	

