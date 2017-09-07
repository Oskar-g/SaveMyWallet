package es.savemywallet.com.interfaces;

import java.util.List;

import es.savemywallet.com.beans.User;

public interface IUserDAO {

	public User findByPrimaryId(int idUser);
	public void delete(int idUser);
	public int add(User user);
	public void update(User user);
	public List<User> list();
}