package dao;

import java.util.List;

import bean.Pos;

public interface PosDao
{
	/*
	 * �˽ӿ�����Ƶķ������Ǻͱ�pos��ص�
	 */
	public Pos findPosById(int id);//ͨ��ְλ��Ų�ѯְλ��Ϣ
	
	public List<Pos> findPosByDepid(int depid);//��ѯĳ�����ŵ�����ְλ
}
