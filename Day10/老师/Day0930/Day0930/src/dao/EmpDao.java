package dao;

import java.util.List;

import bean.Emp;

public interface EmpDao
{
	/*
	 * 此接口中设计的方法都是和表emp相关的
	 */
	public Emp findEmpById(int id);//登录成功，工号正确的，通过工号把该员工查询出来
	
	public boolean doEmp(Emp emp);//添加新员工
	
	public boolean delEmp(int id);//删除离职员工
	
	public boolean updateEmp(Emp emp);//修改员工信息,参数对象包括所有信息，但是工号和职位编号不能修改
	
	public List<Emp> findEmpByDep(int depid);//查询某个部门的所有员工信息
	
	public List<Emp> findEmpByPos(int posid);//查询某个职位的所有员工信息
}
