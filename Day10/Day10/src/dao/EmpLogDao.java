package dao;

public interface EmpLogDao {
	public boolean login(int logid, String logpwd);
	public boolean doEmpLog(int logid);//�����Ա����ͬʱ����Ӹ�Ա���ĵ�¼��Ϣ
    public boolean delEmpLog(int logid);//ɾ����ְԱ����ͬʱ��ɾ����Ա���ĵ�¼��Ϣ
    public boolean updatePwd(int logid, String newPwd);//�޸�����
}
