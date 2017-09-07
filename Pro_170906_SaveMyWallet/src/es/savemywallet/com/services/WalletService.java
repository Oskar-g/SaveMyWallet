package es.savemywallet.com.services;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.savemywallet.com.beans.Wallet;
import es.savemywallet.com.interfaces.IWalletDAO;

public class WalletService implements IWalletService {
	
	/**
	 * Properties
	 */
	private IWalletDAO walletDAO;
	
	
	/**
	 * Constructor
	 */
	public WalletService() {
		super();
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		walletDAO = (IWalletDAO) context.getBean("walletDAO");
	}
	
	/**
	 * Method fin by primary id_wallet
	 */
	@Override
	public Wallet findByPrimaryIdWallet(Wallet wallet) {
		Wallet auxWallet = walletDAO.findByPrimaryId(wallet);
		return auxWallet;
	}
	
	/**
	 * Method addWallet
	 */
	@Override
	public void addWallet(Wallet wallet) {
		walletDAO.add(wallet);
	}
	
	/**
	 * Method update wallet
	 */
	@Override
	public void updateWallet(Wallet wallet) {
		walletDAO.update(wallet);
	}

	/**
	 * Method delete wallet
	 */
	@Override
	public void deleteWallet(Wallet wallet) {
		walletDAO.delete(wallet);
	}
	
	/**
	 * Method list wallets
	 */
	@Override
	public List<Wallet> listWallet() {
		List<Wallet> listWallet = walletDAO.list();
		return listWallet;
	}

}
