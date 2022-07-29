package com.iSteer.mail.model;

public class UserPojo {

	private String emailId;

	private String userName;

	private String lastName;

	private String password;

	private String userEmail;

	private String token;

	private String login;

	private int logout;

	private int otp;

	public UserPojo(String emailId, String userName, String lastName, String password, String userEmail, String token,
			String login, int logout, int otp) {
		super();
		this.emailId = emailId;
		this.userName = userName;
		this.lastName = lastName;
		this.password = password;
		this.userEmail = userEmail;
		this.token = token;
		this.login = login;
		this.logout = logout;
		this.otp = otp;
	}

	public UserPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getLogout() {
		return logout;
	}

	public void setLogout(int logout) {
		this.logout = logout;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "UserPojo [emailId=" + emailId + ", userName=" + userName + ", lastName=" + lastName + ", password="
				+ password + ", userEmail=" + userEmail + ", token=" + token + ", login=" + login + ", logout=" + logout
				+ ", otp=" + otp + "]";
	}
    
	

}
