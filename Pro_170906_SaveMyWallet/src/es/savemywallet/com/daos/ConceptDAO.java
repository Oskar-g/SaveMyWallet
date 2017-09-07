package es.savemywallet.com.daos;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import es.savemywallet.com.beans.Concept;
import es.savemywallet.com.beans.User;
import es.savemywallet.com.interfaces.IConceptDAO;
import es.savemywallet.com.utils.ConceptMapper;
import es.savemywallet.com.utils.UserMapper;


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
	
	@Override
	public Concept findByPrimaryId(Concept concept) {
		Concept aux = null;
		try{
			String sql = "SELECT * FROM concepts WHERE id_concept = ?";
			aux = jdbcTemplateObject.queryForObject(sql, new Object[] {concept.getIdConcept()}, new ConceptMapper());
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return aux;
	}

	@Override
	public void delete(Concept concept) {
		
		String sql = "DELETE FROM users WHERE id_user = ?";
		
		try{
			
			JdbcTemplateObject.update(sql, concept);
			
			System.out.println("deleted record with id = " + concept);
			
		}catch (Exception e) {
			
			System.out.println("excepcion " + e);
		}
	}

	@Override
	public int add(Concept concept) {
		
		System.out.println("dao " + concept.toString());
		String sql = "INSERT INTO users VALUES (?, ?, ?, ?, ?)";
		int result = -1;
		
		try{
			
			JdbcTemplateObject.update(sql,concept.getIdUser(), concept.getName(), concept.getSurname(), concept.getEmail(), concept.getPassword());
			System.out.println("created record");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;	
	}

	@Override
	public void update(Concept concept) {

		String sql = "UPDATE users SET name_user = ?, surname = ?, email = ?, password = ? WHERE id_user = ?;";
		
		try{
			
			JdbcTemplateObject.update(sql, concept.getName(), concept.getSurname(), concept.getEmail(), concept.getPassword(), concept.getIdUser());
			System.out.println("updated record with id = " + concept.getIdUser());
			
		}catch (Exception e) {

			System.out.println("excepcion " + e);
		}
	}

	@Override
	public List<User> list() {
		
		String sql = "SELECT * FROM concepts";
		
		List<User>concepts = null;
		
		try{
			
			concepts = (List<User>)JdbcTemplateObject.query(sql, new ConceptMapper());
			
		}catch (Exception e) {
			
			System.out.println("excepcion " + e);
		}
		
		return concepts;
	}
}

	

