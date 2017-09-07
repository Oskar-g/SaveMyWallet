package es.savemywallet.com.interfaces;

import java.util.List;

import es.savemywallet.com.beans.User;
import es.savemywallet.com.beans.Wallet;

public interface IWalletDAO {
	
	public Wallet findByPrimaryId(int idWallet);
	public void delete(int idWallet);
	public int add(Wallet wallet);
	public void update(Wallet wallet);
	public List<Wallet> list();
}
