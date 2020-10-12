package dao;

import java.util.List;

import bean.Emp;

public interface EmpDao {
	public Emp findEmpById(int id);
	
	public boolean doEmp(Emp emp);//添加新员工，参数对象的值不包括id的值
    public boolean delEmp(int id);//删除离职员工
    public boolean updateEmp(Emp emp);//修改员工信息，参数对象包括所有信息，但是工号和职位编号不能修改。
    public List<Emp> findEmpByDep(int depid);//查询某个部门的所有员工信息
	public List<Emp> findEmpByPos(int posid);//查询某个职位的所有员工信息
}
