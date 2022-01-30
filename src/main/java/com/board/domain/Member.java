package com.board.domain;

public class Member {
	private String userid;
	private String passwd;
	private String name;
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}




	@Override
	public String toString() {
	return "Member [userid=" + userid + ", passwd=" + passwd +" , name=" + name +" , address=" + address +"]";
	 }
	}	
