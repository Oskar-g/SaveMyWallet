package es.savemywallet.com.interfaces;

import java.util.List;

import es.savemywallet.com.beans.Movement;

public interface IMovementDAO {

	public Movement findByPrimaryId(int id);
	public void delete(int id);
	public void add(Movement movement);
	public void update(Movement movement);
	public List<Movement> list(int walletId);
}
