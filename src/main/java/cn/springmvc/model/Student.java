package cn.springmvc.model;

public class Student {
private int id;
private String stuNo;
private String stuQQ;
private String stuName;
private String stuPro;
private long createAt;
private long updateAt;
private int password;

public int getPassword() {
	return password;
}
public void setPassword(int password) {
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStuNo() {
	return stuNo;
}
public void setStuNo(String stuNo) {
	this.stuNo = stuNo;
}
public String getStuQQ() {
	return stuQQ;
}
public void setStuQQ(String stuQQ) {
	this.stuQQ = stuQQ;
}
public String getStuName() {
	return stuName;
}
public void setStuName(String stuName) {
	this.stuName = stuName;
}
public String getStuPro() {
	return stuPro;
}
public void setStuPro(String stuPro) {
	this.stuPro = stuPro;
}
public long getCreateAt() {
	return createAt;
}
public void setCreateAt(long createAt) {
	this.createAt = createAt;
}
public long getUpdateAt() {
	return updateAt;
}
public void setUpdateAt(long updateAt) {
	this.updateAt = updateAt;
}

}
