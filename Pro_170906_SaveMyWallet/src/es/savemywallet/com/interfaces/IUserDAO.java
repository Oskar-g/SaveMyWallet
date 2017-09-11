package es.savemywallet.com.interfaces;

import java.util.List;

import es.savemywallet.com.beans.User;

public interface IUserDAO {

	public User findByPrimaryId(int id);
	public User findUser(String user, String password);
	public void delete(int id);
	public void add(User user);
	public void update(User user);
	public List<User> list();
}