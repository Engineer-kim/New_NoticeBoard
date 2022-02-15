package com.board.domain;

import org.hibernate.validator.constraints.Email;

public class Member {
	/*userId Key 값*/
	private String userid;
	
	/*암호*/
	private String passwd;
	/*사용자 성명*/
	private String name;
	
	/*사용자주소  (현재 사용하지 않는 DB 컬럼  추후 기능 추가로 사용할수도있음)*/
	private String address;
	
	/*최근 수정시간*/
	private String updateDt;
	
	/*이메일*/
	private String email;
	
	/*회원 연락처*/
	private String number;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}
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
	


	/*사용시 email 뒤에 밑의 코드에 추가*/
	@Override
	public String toString() {
	return "Member [userid=" + userid + ", passwd=" + passwd +" , name=" + name +" ,  updateDt="+ updateDt +" , email="+ email+",number="+ number+"]";
	 }
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	}	
/*-naver login Api info  
Client Id :  ctfYqsYWlICd4PpzYwkV  
	Client  Secret   :QR38Rmp9o2

After Login Router : http://localhost:8080/board/loginCheck
*/