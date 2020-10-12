package bean;

public class Emp
{
	/*
	 * 员工信息类
	 */
	private int id;
	private String name;
	private String sex;
	private String address;
	private String phone;
	private String hiredate;
	private double salary;
	private int posid;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getHiredate()
	{
		return hiredate;
	}
	public void setHiredate(String hiredate)
	{
		this.hiredate = hiredate;
	}
	public double getSalary()
	{
		return salary;
	}
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	public int getPosid()
	{
		return posid;
	}
	public void setPosid(int posid)
	{
		this.posid = posid;
	}
}
