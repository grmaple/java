package dao;

import java.util.List;

import bean.Dep;

public interface DepDao
{
	/*
	 * 接口关键字interface,一种特殊的类，只能拥有抽象方法的类,抽象方法是指没有方法体的方法(即没有实现的方法)
	 * 我们根据实体类设计接口 实体类Dep设计的对应接口就是DepDao,DepDao中设计的都是和表dep相关的增删改查操作
	 * 接口用于设计，设计项目中需要实现的功能,根据需求分析中功能依赖于哪张表的，我们就在这个类对应的接口中设计该方法
	 * List是集合，集合是一种特殊的数组，普通数组是有类型和长度限制的，但是集合是一种没有长度没有类型约束的数组，集合中可以添加任意多个元素
	 * List<E>泛型集合，泛型集合是一种有类型约束的集合,此类集合中只能添加指定类型的数据，例如:List<Dep> 这个集合中只能添加Dep类型的对象，有点类似于对象数组
	 */
	public List<Dep> findAllDep();//查询所有的部门信息
	
	public Dep findDepById(int id);//查询具体编号的部门信息
}
