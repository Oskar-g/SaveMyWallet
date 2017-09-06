package es.savemywallet.com.interfaces;

import java.util.List;

import es.savemywallet.com.beans.User;

public interface IWalletDAO {
	
	public int add(User user);
	public void update(User user);
	public List<User> list();
}
