package domain;

import java.io.Serializable;

public class Account implements Serializable{
	private Integer id;
	private Integer uid;
	private double money;
	
	public Integer getUid() {
		return uid;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", uid=" + uid + ", money=" + money + "]";
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}
