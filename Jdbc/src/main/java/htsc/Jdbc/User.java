package htsc.Jdbc;

import java.io.Serializable;

public class User implements Serializable{
	int id;
	String username;
	String sex;
	String address;
	String birthday;

	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public void setUsername(String username) {
		// TODO Auto-generated method stub
		this.username = username;
	}

	public void setSex(String sex) {
		// TODO Auto-generated method stub
		this.sex = sex;
	}

	public void setAddress(String address) {
		// TODO Auto-generated method stub
		this.address = address;
	}

	public void setBirthday(String birthday) {
		// TODO Auto-generated method stub
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", address=" + address + ", birthday="
				+ birthday + "]";
	}
}
