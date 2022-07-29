package com.iSteer.mail.model;

public class UserCurdPojo {

	private long userid;

	private String userEmail;

	private String userName;

	private int pinCode;

	private String address;

	@Override
	public String toString() {
		return "UserCurdPojo [userid=" + userid + ", userEmail=" + userEmail + ", userName=" + userName + ", pinCode="
				+ pinCode + ", address=" + address + "]";
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

}
