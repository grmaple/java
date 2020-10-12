package dao;

import java.util.List;

import bean.Emp;

public interface EmpDao {
	public Emp findEmpById(int id);
	
	public boolean doEmp(Emp emp);//�����Ա�������������ֵ������id��ֵ
    public boolean delEmp(int id);//ɾ����ְԱ��
    public boolean updateEmp(Emp emp);//�޸�Ա����Ϣ�������������������Ϣ�����ǹ��ź�ְλ��Ų����޸ġ�
    public List<Emp> findEmpByDep(int depid);//��ѯĳ�����ŵ�����Ա����Ϣ
	public List<Emp> findEmpByPos(int posid);//��ѯĳ��ְλ������Ա����Ϣ
}
