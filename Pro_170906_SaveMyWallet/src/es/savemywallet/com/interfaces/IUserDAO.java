package es.savemywallet.com.interfaces;

import java.util.List;

import es.savemywallet.com.beans.User;

public interface IUserDAO {

	public User findByPrimaryId(int id);
	public void delete(int id);
	public int add(User user);
	public void update(User user);
	public List<User> list();
}