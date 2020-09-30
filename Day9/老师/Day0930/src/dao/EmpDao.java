package dao;

import bean.Emp;

public interface EmpDao
{
	/*
	 * 此接口中设计的方法都是和表emp相关的
	 */
	public Emp findEmpById(int id);//登录成功，工号正确的，通过工号把该员工查询出来
}
