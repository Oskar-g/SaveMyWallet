package es.savemywallet.com.beans;

public class Wallet {
	
	/*
	 * -----------------------------------------------------------------------
	 * Properties
	 * -----------------------------------------------------------------------
	 */
	private int idWallet;
	private int userId;
	private User user;
	private String name;
	private String descripcion;
	private float balance;

	
	/*
	 * -----------------------------------------------------------------------
	 * Constructors
	 * -----------------------------------------------------------------------
	 */
	
	public Wallet (){}

	public Wallet(int idWallet, int userId, User user, String name, String descripcion) {
		super();
		this.idWallet = idWallet;
		this.userId = userId;
		this.user = user;
		this.name = name;
		this.descripcion = descripcion;
	}

	/*
	 * -----------------------------------------------------------------------
	 * Getters
	 * -----------------------------------------------------------------------
	 */

	public int getIdWallet() {
		return idWallet;
	}

	public int getUserId() {
		return userId;
	}

	public User getUser() {
		return user;
	}

	public String getName() {
		return name;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public float getBalance() {
		return balance;
	}
	
	/*
	 * -----------------------------------------------------------------------
	 * Setters
	 * -----------------------------------------------------------------------
	 */
	
	public void setIdWallet(int idWallet) {
		this.idWallet = idWallet;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
}