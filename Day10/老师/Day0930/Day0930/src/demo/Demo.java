package demo;

import java.util.List;

import org.junit.Test;

import bean.Dep;
import bean.Emp;
import bean.Pos;
import dao.impl.DepDaoImpl;
import dao.impl.EmpDaoImpl;
import dao.impl.PosDaoImpl;

public class Demo
{
	@Test
	public void test01()
	{
		DepDaoImpl depDao=new DepDaoImpl();
		List<Dep> lp=depDao.findAllDep();
		for(int i=0;i<lp.size();i++)
		{
			Dep dep=lp.get(i);
			System.out.println(dep.getId()+"\t"+dep.getName());
		}
	}
	
	@Test
	public void test02()
	{
		DepDaoImpl depDao=new DepDaoImpl();
		Dep dep=depDao.findDepById(2);
		System.out.println(dep.getId()+"\t"+dep.getName());
	}
	
	@Test
	public void test03()
	{
		PosDaoImpl posDao=new PosDaoImpl();
		Pos pos=posDao.findPosById(1);
		if(pos!=null)
		{
			System.out.println(pos.getName());
			DepDaoImpl depDao=new DepDaoImpl();
			Dep dep=depDao.findDepById(pos.getDepid());
			System.out.println(dep.getName());
		}
	}
	
	@Test
	public void test04()
	{
		DepDaoImpl depDao=new DepDaoImpl();
		PosDaoImpl posDao=new PosDaoImpl();
		EmpDaoImpl empDao=new EmpDaoImpl();
		Emp emp=empDao.findEmpById(20120901);
		if(emp!=null)
		{
			System.out.println(emp.getName()+"\t"+posDao.findPosById(emp.getPosid()).getName());
		}
	}
}
