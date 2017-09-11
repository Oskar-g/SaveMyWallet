package es.savemywallet.com.beans;

public class Wallet {
	
	/*
	 * -----------------------------------------------------------------------
	 * Properties
	 * -----------------------------------------------------------------------
	 */
	private int id;
	private int userId;
	private User user;
	private String name;
	private String description;
	private float balance;

	
	/*
	 * -----------------------------------------------------------------------
	 * Constructors
	 * -----------------------------------------------------------------------
	 */
	
	public Wallet (){}

	public Wallet(int id, int userId, User user, String name, String description) {
		super();
		this.id = id;
		this.userId = userId;
		this.user = user;
		this.name = name;
		this.description = description;
	}

	/*
	 * -----------------------------------------------------------------------
	 * Getters
	 * -----------------------------------------------------------------------
	 */

	public int getId() {
		return id;
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

	public String getDescription() {
		return description;
	}

	public float getBalance() {
		return balance;
	}
	
	/*
	 * -----------------------------------------------------------------------
	 * Setters
	 * -----------------------------------------------------------------------
	 */
	
	public void setIdWallet(int id) {
		this.id = id;
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

	public void setDescription(String description) {
		this.description = description;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
}