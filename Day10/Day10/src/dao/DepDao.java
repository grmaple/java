package dao;

import java.util.List;

import bean.Dep;

public interface DepDao {
	public List<Dep> findAllDep();
	public Dep findDepById(int id);
}
