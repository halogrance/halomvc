package cn.springmvc.model;

public class User {
	private long id;
private String UserName;
private String UserPass;
private String UserPass2;
private long loginTime;
private long registerTime;

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public String getUserPass() {
	return UserPass;
}
public void setUserPass(String userPass) {
	UserPass = userPass;
}
public String getUserPass2() {
	return UserPass2;
}
public void setUserPass2(String userPass2) {
	UserPass2 = userPass2;
}

public long getLoginTime() {
	return loginTime;
}
public void setLoginTime(long loginTime) {
	this.loginTime = loginTime;
}
public long getRegisterTime() {
	return registerTime;
}
public void setRegisterTime(long registerTime) {
	this.registerTime = registerTime;
}

}
