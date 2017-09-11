package es.savemywallet.com.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import es.savemywallet.com.beans.User;

public interface IUserService {
	@Transactional
	public User findByPrimaryIdUSer(int id);
	public User findUser(String user, String password);
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public List<User> listUser();
}
