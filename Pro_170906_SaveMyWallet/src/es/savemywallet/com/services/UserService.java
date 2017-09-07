package es.savemywallet.com.services;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.savemywallet.com.beans.User;
import es.savemywallet.com.beans.Wallet;
import es.savemywallet.com.interfaces.IUserDAO;
import es.savemywallet.com.interfaces.IUserService;
import es.savemywallet.com.interfaces.IWalletDAO;

public class UserService implements IUserService {
	
	/**
	 * Properties
	 */
	private IUserDAO userDAO;
	
	/**
	 * Contructor
	 */
	public UserService() {
		super();
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		userDAO = (IUserDAO) context.getBean("userDAO");
	}
	
	
	/**
	 * Method fin by primary id_user
	 */
	@Override
	public User findByPrimaryIdUSer(int idUser) {
		User auxUser = userDAO.findByPrimaryId(idUser);
		return auxUser;
	}

	/**
	 * Method addUSer
	 */
	@Override
	public void addUser(User user) {
		userDAO.add(user);
	}
	
	/**
	 * Method update user
	 */
	@Override
	public void updateUser(User user) {
		userDAO.update(user);		
	}
	
	/**
	 * Method delete user
	 */
	@Override
	public void deleteUser(int user) {
		userDAO.delete(user);		
	}
	
	/**
	 * Method list users
	 */
	@Override
	public List<User> listUser() {
		List<User> listUser = userDAO.list();
		return listUser;
	}

}
