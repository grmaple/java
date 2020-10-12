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
		Emp emp = empDao.findEmpById(20200701);//Ա����Ϣ
		if(emp!=null) {
			String name = emp.getName();//Ա����Ϣ����
			Pos pos = posDao.findPosById(emp.getPosid());//Ա��ְλ
			String posName = pos.getName();//Ա��ְλ����
			Dep dep = depDao.findDepById(pos.getDepid());//Ա������
			String depName = dep.getName();//Ա����������
					
			System.out.println("��ӭ"+depName+"\t"+posName+"\t"+name);
		}
	}
	@Test
	public void test05() {
		Emp emp = new Emp();
		System.out.println("������Ա����ţ�");
        emp.setId(input.nextInt());
        System.out.println("������Ա��������");
        emp.setName(input.next());
        System.out.println("������Ա���Ա�");
        emp.setSex(input.next());
        System.out.println("������Ա�����᣺");
        emp.setAddress(input.next());
        System.out.println("������Ա���绰��");
        emp.setPhone(input.next());
        System.out.println("������Ա����ְ���ڣ�");
        emp.setHiredate(input.next());
        System.out.println("������Ա��н�ʣ�");
        emp.setSalary(input.nextDouble());
        System.out.println("��ѡ��Ա��ְλ��");
        emp.setPosid(input.nextInt());
        EmpDaoImpl empDao = new EmpDaoImpl();
        if(empDao.doEmp(emp)) {
        	System.out.println("��ӳɹ���");
        }else{
        	System.out.println("���ʧ�ܣ�");
        }
	}
	@Test
	public void test06() {
		System.out.println("������Ҫɾ������ְԱ�����ţ�");
        int logid = input.nextInt();
		EmpLogDaoImpl empLogDao = new EmpLogDaoImpl();
		if(empLogDao.delEmpLog(logid)) {
        	System.out.println("ɾ��log�ɹ���");
        }else{
        	System.out.println("ɾ��logʧ�ܣ�");
        }
	}
	@Test
	public void test07() {
		System.out.println("������Ҫ�޸ĵ�Ա����ţ�");
        int id = input.nextInt();
		EmpDaoImpl empDao = new EmpDaoImpl();
		Emp emp = empDao.findEmpById(id);
		System.out.println("��ǰԱ����Ϣ��");
		System.out.println(emp.getId()+"\t"+emp.getName()+"\t"+emp.getSex()+"\t"+emp.getAddress()+"\t"+emp.getPhone()+"\t"+emp.getHiredate()+"\t"+emp.getSalary()+"\t"+emp.getPosid());
        System.out.println("������Ҫ�޸ĵ�Ա��������");
        emp.setName(input.next());
        System.out.println("������Ҫ�޸ĵ�Ա���Ա�");
        emp.setSex(input.next());
        System.out.println("������Ҫ�޸ĵ�Ա�����᣺");
        emp.setAddress(input.next());
        System.out.println("������Ҫ�޸ĵ�Ա���绰��");
        emp.setPhone(input.next());
        System.out.println("������Ҫ�޸ĵ�Ա����ְ���ڣ�");
        emp.setHiredate(input.next());
        System.out.println("������Ҫ�޸ĵ�Ա��н�ʣ�");
        emp.setSalary(input.nextDouble());
        
        if(empDao.updateEmp(emp)) {
        	System.out.println("�޸ĳɹ���");
        }else{
        	System.out.println("�޸�ʧ�ܣ�");
        }
	}
	@Test
	public void test08() {
		System.out.println("������Ҫ��ѯ��ְλ��ţ�");
		int posid = input.nextInt();
		EmpDaoImpl empDao = new EmpDaoImpl();
		List<Emp> lp = empDao.findEmpByPos(posid);
		if(lp.isEmpty()) System.out.println("��ְλû���ˣ�����ʧ�ܣ�");
		for(int i = 0; i<lp.size();i++) {
			Emp emp = lp.get(i);
			System.out.println(emp.getId()+"\t"+emp.getName()+"\t"+emp.getSex()+"\t"+emp.getAddress()+"\t"+emp.getPhone()+"\t"+emp.getHiredate()+"\t"+emp.getSalary()+"\t"+emp.getPosid());
		}
	}
	@Test
	public void test09() {
		System.out.println("������Ҫ��ѯ�Ĳ��ű�ţ�");
		int depid = input.nextInt();
		EmpDaoImpl empDao = new EmpDaoImpl();
		List<Emp> lp = empDao.findEmpByDep(depid);
		if(lp.isEmpty()) System.out.println("�ò���û���ˣ�����ʧ�ܣ�");
		for(int i = 0; i<lp.size();i++) {
			Emp emp = lp.get(i);
			System.out.println(emp.getId()+"\t"+emp.getName()+"\t"+emp.getSex()+"\t"+emp.getAddress()+"\t"+emp.getPhone()+"\t"+emp.getHiredate()+"\t"+emp.getSalary()+"\t"+emp.getPosid());
		}
	}
	@Test
	public void test10() {
		System.out.println("������Ҫ�޸������Ա����ţ�");
		int logid = input.nextInt();
		System.out.println("�������޸ĺ�����룺");
        String newPwd = input.next();
        EmpLogDaoImpl empLogDao = new EmpLogDaoImpl();
		if(empLogDao.updatePwd(logid, newPwd)) {
        	System.out.println("�޸�����ɹ���");
        }else{
        	System.out.println("�޸�����ʧ�ܣ�");
        }
	}
}
