package es.savemywallet.com.beans;

public class User {

	/**
	 * Properties
	 */
	private int idUser;
	private String nameUser;
	private String surname;
	private String email;
	private String password;
	
	/**
	 * Default Constructor
	 */
	public User(){}

	/**
	 * Constructor
	 * @param idUser
	 * @param name
	 * @param surname
	 * @param email
	 * @param password
	 */
	public User(int idUser, String nameUser, String surname, String email, String password) {
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}
		

	/*
	 * -----------------------------------------------------------------------
	 * Getters
	 * -----------------------------------------------------------------------
	 */
	public int getIdUser() {
		return idUser;
	}

	public String getNameUser() {
		return nameUser;
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
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
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