package dao;

public interface EmpLogDao
{
	/*
	 * �˽ӿ�����Ƶķ������Ǻͱ�emplog��ص�
	 */
	public boolean login(int logid,String logpwd);//��¼����¼�ɹ�˵��logid����ȷ�ģ����ù����Ǵ��ڵ�
	
	public boolean doEmpLog(int logid);//�����Ա����ͬʱ��Ӹ�Ա���ĵ�¼��Ϣ
	
	public boolean delEmplg(int logid);//ɾ����ְԱ����ͬʱҪɾ����Ա���ĵ�¼��Ϣ
	
	public boolean updatePwd(int logid,String newPwd);//�޸�����
}
