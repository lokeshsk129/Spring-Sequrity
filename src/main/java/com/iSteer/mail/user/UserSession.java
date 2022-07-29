package com.iSteer.mail.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usersession")
public class UserSession {

	@Id
	@Column(name = "useremail")
	private String userEmail;

	@Column(name = "token")
	private String token;

	@Column(name = "login")
	private String login;

	@Column(name = "logout")
	private int logout;

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

	@Override
	public String toString() {
		return "UserSession [userEmail=" + userEmail + ", token=" + token + ", login=" + login + ", logout=" + logout
				+ "]";
	}

}
