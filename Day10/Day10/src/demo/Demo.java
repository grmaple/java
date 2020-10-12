package demo;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import bean.Dep;
import bean.Emp;
import bean.Pos;
import dao.impl.DepDaoImpl;
import dao.impl.EmpDaoImpl;
import dao.impl.EmpLogDaoImpl;
import dao.impl.PosDaoImpl;

public class Demo {
	Scanner input = new Scanner(System.in);
	@Test
	public void test01() {
		DepDaoImpl depDao = new DepDaoImpl();
		List<Dep> lp = depDao.findAllDep();
		for(int i = 0; i<lp.size();i++) {
			Dep dep = lp.get(i);
			System.out.println(dep.getId()+"\t"+dep.getName());
		}
	}
	@Test
	public void test02() {
		DepDaoImpl depDao = new DepDaoImpl();
		Dep dep = depDao.findDepById(2);
		System.out.println(dep.getId()+"\t"+dep.getName());
	}
	@Test
	public void test03() {
		PosDaoImpl posDao = new PosDaoImpl();
		Pos pos = posDao.findPosById(1);
		if(pos!=null)
		{
			System.out.println(pos.getName());
			DepDaoImpl depDao=new DepDaoImpl();
			Dep dep=depDao.findDepById(pos.getDepid());
			System.out.println(dep.getName());
		}
	}
	@Test
	public void test04() {
		DepDaoImpl depDao = new DepDaoImpl();
		PosDaoImpl posDao = new PosDaoImpl();
		EmpDaoImpl empDao = new EmpDaoImpl();
		Emp emp = empDao.findEmpById(20200701);//员工信息
		if(emp!=null) {
			String name = emp.getName();//员工信息名字
			Pos pos = posDao.findPosById(emp.getPosid());//员工职位
			String posName = pos.getName();//员工职位名字
			Dep dep = depDao.findDepById(pos.getDepid());//员工部门
			String depName = dep.getName();//员工部门名字
					
			System.out.println("欢迎"+depName+"\t"+posName+"\t"+name);
		}
	}
	@Test
	public void test05() {
		Emp emp = new Emp();
		System.out.println("请输入员工编号：");
        emp.setId(input.nextInt());
        System.out.println("请输入员工姓名：");
        emp.setName(input.next());
        System.out.println("请输入员工性别：");
        emp.setSex(input.next());
        System.out.println("请输入员工籍贯：");
        emp.setAddress(input.next());
        System.out.println("请输入员工电话：");
        emp.setPhone(input.next());
        System.out.println("请输入员工入职日期：");
        emp.setHiredate(input.next());
        System.out.println("请输入员工薪资：");
        emp.setSalary(input.nextDouble());
        System.out.println("请选择员工职位：");
        emp.setPosid(input.nextInt());
        EmpDaoImpl empDao = new EmpDaoImpl();
        if(empDao.doEmp(emp)) {
        	System.out.println("添加成功！");
        }else{
        	System.out.println("添加失败！");
        }
	}
	@Test
	public void test06() {
		System.out.println("请输入要删除的离职员工工号：");
        int logid = input.nextInt();
		EmpLogDaoImpl empLogDao = new EmpLogDaoImpl();
		if(empLogDao.delEmpLog(logid)) {
        	System.out.println("删除log成功！");
        }else{
        	System.out.println("删除log失败！");
        }
	}
	@Test
	public void test07() {
		System.out.println("请输入要修改的员工编号：");
        int id = input.nextInt();
		EmpDaoImpl empDao = new EmpDaoImpl();
		Emp emp = empDao.findEmpById(id);
		System.out.println("当前员工信息：");
		System.out.println(emp.getId()+"\t"+emp.getName()+"\t"+emp.getSex()+"\t"+emp.getAddress()+"\t"+emp.getPhone()+"\t"+emp.getHiredate()+"\t"+emp.getSalary()+"\t"+emp.getPosid());
        System.out.println("请输入要修改的员工姓名：");
        emp.setName(input.next());
        System.out.println("请输入要修改的员工性别：");
        emp.setSex(input.next());
        System.out.println("请输入要修改的员工籍贯：");
        emp.setAddress(input.next());
        System.out.println("请输入要修改的员工电话：");
        emp.setPhone(input.next());
        System.out.println("请输入要修改的员工入职日期：");
        emp.setHiredate(input.next());
        System.out.println("请输入要修改的员工薪资：");
        emp.setSalary(input.nextDouble());
        
        if(empDao.updateEmp(emp)) {
        	System.out.println("修改成功！");
        }else{
        	System.out.println("修改失败！");
        }
	}
	@Test
	public void test08() {
		System.out.println("请输入要查询的职位编号：");
		int posid = input.nextInt();
		EmpDaoImpl empDao = new EmpDaoImpl();
		List<Emp> lp = empDao.findEmpByPos(posid);
		if(lp.isEmpty()) System.out.println("该职位没有人，查找失败！");
		for(int i = 0; i<lp.size();i++) {
			Emp emp = lp.get(i);
			System.out.println(emp.getId()+"\t"+emp.getName()+"\t"+emp.getSex()+"\t"+emp.getAddress()+"\t"+emp.getPhone()+"\t"+emp.getHiredate()+"\t"+emp.getSalary()+"\t"+emp.getPosid());
		}
	}
	@Test
	public void test09() {
		System.out.println("请输入要查询的部门编号：");
		int depid = input.nextInt();
		EmpDaoImpl empDao = new EmpDaoImpl();
		List<Emp> lp = empDao.findEmpByDep(depid);
		if(lp.isEmpty()) System.out.println("该部门没有人，查找失败！");
		for(int i = 0; i<lp.size();i++) {
			Emp emp = lp.get(i);
			System.out.println(emp.getId()+"\t"+emp.getName()+"\t"+emp.getSex()+"\t"+emp.getAddress()+"\t"+emp.getPhone()+"\t"+emp.getHiredate()+"\t"+emp.getSalary()+"\t"+emp.getPosid());
		}
	}
	@Test
	public void test10() {
		System.out.println("请输入要修改密码的员工编号：");
		int logid = input.nextInt();
		System.out.println("请输入修改后的密码：");
        String newPwd = input.next();
        EmpLogDaoImpl empLogDao = new EmpLogDaoImpl();
		if(empLogDao.updatePwd(logid, newPwd)) {
        	System.out.println("修改密码成功！");
        }else{
        	System.out.println("修改密码失败！");
        }
	}
}
