package dao;

import java.util.List;

import bean.Pos;

public interface PosDao {
	public Pos findPosById(int id);//ͨ��ְλ��Ų�ѯְλ��Ϣ
	public List<Pos> findPosByDepid(int depid);//��ѯĳ�����ŵ�����ְλ
}
