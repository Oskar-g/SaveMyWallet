package es.savemywallet.com.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import es.savemywallet.com.beans.Movement;

public interface IMovementService {
	
	@Transactional
	public Movement findByPrimaryIdMovement(Movement movement);
	public void addMovement(Movement movement);
	public void updateMovement(Movement movement);
	public void deleteMovement(Movement movement);
	public List<Movement> listMovement();
}
