package dao;

import java.util.List;

import bean.Emp;

public interface EmpDao
{
	/*
	 * �˽ӿ�����Ƶķ������Ǻͱ�emp��ص�
	 */
	public Emp findEmpById(int id);//��¼�ɹ���������ȷ�ģ�ͨ�����ŰѸ�Ա����ѯ����
	
	public boolean doEmp(Emp emp);//�����Ա��
	
	public boolean delEmp(int id);//ɾ����ְԱ��
	
	public boolean updateEmp(Emp emp);//�޸�Ա����Ϣ,�����������������Ϣ�����ǹ��ź�ְλ��Ų����޸�
	
	public List<Emp> findEmpByDep(int depid);//��ѯĳ�����ŵ�����Ա����Ϣ
	
	public List<Emp> findEmpByPos(int posid);//��ѯĳ��ְλ������Ա����Ϣ
}
