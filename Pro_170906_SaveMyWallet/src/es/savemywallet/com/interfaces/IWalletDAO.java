package es.savemywallet.com.interfaces;

import java.util.List;

import es.savemywallet.com.beans.Wallet;

public interface IWalletDAO {
	
	public Wallet findByPrimaryId(Wallet wallet);
	public void add(Wallet wallet);
	public void update(Wallet wallet);
	public void delete(Wallet wallet);
	public List<Wallet> list();
}
