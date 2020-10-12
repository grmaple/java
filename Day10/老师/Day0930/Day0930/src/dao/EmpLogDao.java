package dao;

public interface EmpLogDao
{
	/*
	 * 此接口中设计的方法都是和表emplog相关的
	 */
	public boolean login(int logid,String logpwd);//登录，登录成功说明logid是正确的，即该工号是存在的
	
	public boolean doEmpLog(int logid);//添加新员工的同时添加该员工的登录信息
	
	public boolean delEmplg(int logid);//删除离职员工的同时要删除该员工的登录信息
	
	public boolean updatePwd(int logid,String newPwd);//修改密码
}
