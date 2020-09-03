package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
	int id;
	String username;
	String sex;
	String address;
	Date birthday;
	
	private List<Account> accounts;

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getSex() {
		return sex;
	}

	public String getAddress() {
		return address;
	}

	public Date getBirthday() {
		return birthday;
	}

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

	public void setBirthday(Date birthday) {
		// TODO Auto-generated method stub
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", address=" + address + ", birthday="
				+ birthday + "]";
	}
}
