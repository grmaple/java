package bean;

public class User {
	private int id;
	private String name;
	private String password;
	private double money;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
	
	public void getName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return this.password;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	public double getMoney() {
		return this.money;
	}
}
