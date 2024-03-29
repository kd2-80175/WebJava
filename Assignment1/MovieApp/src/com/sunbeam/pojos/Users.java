package com.sunbeam.pojos;



import java.util.Date;

public class Users {
private int id;
private String firstname;
private String lastname;
private String email;
private String mobile;
public String password;
public Users(){
	
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
private Date birth;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public Date getBirth() {
	return birth;
}
public void setBirth(Date birth) {
	this.birth = birth;
}
public Users(int id, String firstname, String lastname, String email,String password, String mobile , Date birth) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.mobile = mobile;
	this.password = password;
	this.birth = birth;
}
@Override
public String toString() {
	return "Users [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", mobile="
			+ mobile + ", password=" + password + ", birth=" + birth + "]";
}



}

