package es.savemywallet.com.interfaces;

import java.util.List;

import es.savemywallet.com.beans.User;
import es.savemywallet.com.beans.Wallet;

public interface IWalletDAO {
	
	public int add(User user);
	public void update(User user);
	public List<Wallet> list();
	User findByPrimaryId(int idWallet);
	void delete(int idWallet);
}
