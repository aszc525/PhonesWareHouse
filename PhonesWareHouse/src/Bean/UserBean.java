package Bean;
public class UserBean {
private String ID;         //�û�ID
private String users;      //�û���
private String password;   //�û�����
private String mess;
public String getID() {
	return ID;
}
public void setID(String iD) {
	ID = iD;
}
public String getUsers() {
	return users;
}
public void setUsers(String users) {
	this.users = users;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMess() {
	return mess;
}
public void setMess(String mess) {
	this.mess = mess;
}
public boolean selectUser(UserBean name) {
	return false;
}
}
