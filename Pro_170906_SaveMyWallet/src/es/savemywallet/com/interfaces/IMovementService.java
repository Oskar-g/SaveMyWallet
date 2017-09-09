package es.savemywallet.com.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import es.savemywallet.com.beans.Movement;

public interface IMovementService {

	@Transactional
	public Movement findByPrimaryIdMovement(int idMovement);
	public void addMovement(Movement movement);
	public void updateMovement(Movement movement);
	public void deleteMovement(int idMovement);
	public List<Movement> listMovement(int idWallet);
}
