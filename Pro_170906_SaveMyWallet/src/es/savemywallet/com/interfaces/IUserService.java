package es.savemywallet.com.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import es.savemywallet.com.beans.User;

public interface IUserService {
	@Transactional
	public User findByPrimaryIdUSer(int idUser);
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int user);
	public List<User> listUser();
}
