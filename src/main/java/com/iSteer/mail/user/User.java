package com.iSteer.mail.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;

	@Column(name = "useremail")
	private String userEmail;

	@Column(name = "username")
	private String userName;

	@Column(name = "pincode")
	private int pinCode;

	@Column(name = "address")
	private String address;

	@Column(name = "password")
	private String password;

	public User(long userid, String userEmail, String userName, int pinCode, String address, String password) {
		super();
		this.userid = userid;
		this.userEmail = userEmail;
		this.userName = userName;
		this.pinCode = pinCode;
		this.address = address;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getpassowrd() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;

	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", userEmail=" + userEmail + ", userName=" + userName + ", pinCode=" + pinCode
				+ ", address=" + address + "]";
	}

}
