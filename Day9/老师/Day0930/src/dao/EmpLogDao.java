package dao;

public interface EmpLogDao
{
	/*
	 * 此接口中设计的方法都是和表emplog相关的
	 */
	public boolean login(int logid,String logpwd);//登录，登录成功说明logid是正确的，即该工号是存在的
}
