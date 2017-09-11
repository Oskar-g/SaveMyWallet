package es.savemywallet.com.beans;

public class User {

	/*
	 * -----------------------------------------------------------------------
	 * Properties
	 * -----------------------------------------------------------------------
	 */
	private int id;
	private String UserName;
	private String name;
	private String surname;
	private String email;
	private String password;
	
	/*
	 * -----------------------------------------------------------------------
	 * Constructors
	 * -----------------------------------------------------------------------
	 */
	
	public User(){}

	public User(int id, String userName, String name, String surname, String email, String password) {
		super();
		this.id = id;
		UserName = userName;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}

	/*
	 * -----------------------------------------------------------------------
	 * Getters
	 * -----------------------------------------------------------------------
	 */
	
	public int getId() {
		return id;
	}

	public String getUserName() {
		return UserName;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	/*
	 * -----------------------------------------------------------------------
	 * Setters
	 * -----------------------------------------------------------------------
	 */
	
	public void setId(int id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}