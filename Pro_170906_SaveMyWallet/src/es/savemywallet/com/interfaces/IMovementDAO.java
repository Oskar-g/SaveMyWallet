package es.savemywallet.com.interfaces;

import java.util.List;

import es.savemywallet.com.beans.Movement;

public interface IMovementDAO {

	public Movement findByPrimaryId(int idMovement);
	public void delete(int idMovement);
	public void add(Movement movement);
	public void update(Movement movement);
	public List<Movement> list();
}
