package dao;

public interface EmpLogDao {
	public boolean login(int logid, String logpwd);
	public boolean doEmpLog(int logid);//添加新员工的同时，添加该员工的登录信息
    public boolean delEmpLog(int logid);//删除离职员工的同时，删除该员工的登录信息
    public boolean updatePwd(int logid, String newPwd);//修改密码
}
