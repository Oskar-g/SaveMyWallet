package es.savemywallet.com.interfaces;

import java.util.List;

import es.savemywallet.com.beans.User;

public interface IWalletDAO {
	
	public User findByPrimaryId(int idWallet);
	public void delete(int idWallet);
	public int add(User user);
	public void update(User user);
	public List<User> list();
}
