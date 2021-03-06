package dao;

import java.util.List;

import bean.Pos;

public interface PosDao {
	public Pos findPosById(int id);//通过职位编号查询职位信息
	public List<Pos> findPosByDepid(int depid);//查询某个部门的所有职位
}
