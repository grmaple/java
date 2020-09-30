package bean;

public class EmpLog
{
	/*
	 * 员工登录信息类
	 */
	private int id;
	private int logid;
	private String logpwd;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getLogid()
	{
		return logid;
	}
	public void setLogid(int logid)
	{
		this.logid = logid;
	}
	public String getLogpwd()
	{
		return logpwd;
	}
	public void setLogpwd(String logpwd)
	{
		this.logpwd = logpwd;
	}
}
