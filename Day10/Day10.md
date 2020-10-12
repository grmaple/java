### 二、java编程

使用面向对象的思想，采用Dao模式开发

##### 1.根据表建立实体类，特点是表名即类名，列名即属性名。

创建bean.Dep实体类

```java
package bean;

public class Dep
{
	/*
	 * 部门信息类
	 */
	private int id;
	private String name;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
}
```

创建bean.EmpLog实体类

```java
package bean;

public class EmpLog
{
	/*
	 * 员工登录信息类
	 */
	private int id;
	private int logid;
	private String logpwd;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getLogid()
	{
		return logid;
	}
	public void setLogid(int logid)
	{
		this.logid = logid;
	}
	public String getLogpwd()
	{
		return logpwd;
	}
	public void setLogpwd(String logpwd)
	{
		this.logpwd = logpwd;
	}
}
```

创建bean.Pos实体类

```java
package bean;

public class Pos
{
	/*
	 * 职位信息类
	 */
	private int id;
	private String name;
	private int depid;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getDepid()
	{
		return depid;
	}
	public void setDepid(int depid)
	{
		this.depid = depid;
	}
}
```

创建bean.Emp实体类

```java
package bean;

public class Emp
{
	/*
	 * 员工信息类
	 */
	private int id;
	private String name;
	private String sex;
	private String address;
	private String phone;
	private String hiredate;
	private double salary;
	private int posid;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getHiredate()
	{
		return hiredate;
	}
	public void setHiredate(String hiredate)
	{
		this.hiredate = hiredate;
	}
	public double getSalary()
	{
		return salary;
	}
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	public int getPosid()
	{
		return posid;
	}
	public void setPosid(int posid)
	{
		this.posid = posid;
	}
}
```

##### 2.新建数据库的连接以及关闭类BaseDao

```java
package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao
{
	/*
	 * 数据库的连接和关闭类
	 */
	public Connection getConnection()
	{
		/*
		 * 连接数据库
		 */
		Connection conn=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/oa?characterEncoding=utf-8","root","123456");
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConn(Connection conn,PreparedStatement pstmt,ResultSet rs)
	{
		/*
		 * 1.先拿连接对象conn
		 * 2.通过连接对象调用prepareStatement拿到处理sql语句的对象pstmt
		 * 3.如果是查询利用结果集rs接收
		 * 4.关闭的原则采取是先进后出
		 */
		if(rs!=null)
		{
			try
			{
				rs.close();
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstmt!=null)
		{
			try
			{
				pstmt.close();
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null)
		{
			try
			{
				conn.close();
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

```

##### 3.设计接口类

创建dao.DepDao接口类

```java
package dao;
import java.util.List;
import bean.Dep;
public interface DepDao{
    //接口是一种特殊的类interface，只能拥有抽象方法的类，抽象方法是指没有方法体的方法,即没有实现的方法。
    //List是集合，是一种特殊的数组，普通数组是有类型和长度限制的，集合是没有长度没有类型约束的数组。
    //List<Dep>是泛型集合，是一种有类型约束的集合。
    public List<Dep> findAllDep();//查询所有的部门信息
    public Dep findDepById(int id);//查询具体编号的部门信息
}
```

接口用于设计，设计项目中需要实现的功能，根据需求分析中功能依赖于那张表，我们就在这个类对应的接口设计该方法

我们根据实体类设计接口。实体类Dep设计的对应接口是DepDao，DepDao中设计的都是和表dep相关的增删改查操作。

因此

创建dao.EmpLogDao接口类

```java
package dao;
public interface EmpLogDao{
    public boolean login(int logid,String logpwd);//登录，登录成功说明logid是正确的，即该工号是存在的
    
    public boolean doEmpLog(int logid);//添加新员工的同时，添加该员工的登录信息
    public boolean delEmpLog(int logid);//删除离职员工的同时，删除该员工的登录信息
    public boolean updatePwd(int lohid, String newPwd);//修改密码
}
```

创建dao.EmpDao接口类

```java
package dao;
import java.util.List;
import bean.Emp;
public interface EmpDao{
    public Emp findEmpById(int id);//通过工号把该员工查询出来
    
    public boolean doEmp(Emp emp);//添加新员工
    public boolean delEmp(int id);//删除离职员工
    public boolean updateEmo(Emp emp);//修改员工信息，参数对象包括所有信息，但是工号和职位编号不能修改。
    public List<Emp> findEmpByDep(int depid);//查询某个部门的所有员工信息
    public List<Emp> findEmpByDep(int posid);//查询某个职位的所有员工信息
}
```

创建dao.PosDao接口类

```java
package dao;
import bean.Pos;
public interface PosDao{
    public Pos findPosById(int id);//通过编号查询职位信息
    
    public List<Pos> findPosByDepid(int depid);
}
```

为什么根据表设计类对象？因为类和表是对应的，因此类对象可以存储表中数据。

##### 4.创建实现类

建立dao.impl.DepDaoImpl实现类

```java
package dao.impl;
import java.util.List;
import dao.DepDao;
public class DepDaoImpl implements DepDao{
    //类实现某个接口，那么这个类必须实现这个接口的所有方法
    Scanner input = new Scanner(System.in);
	BaseDao bs = new BaseDao();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
    @Override
    public List<Dep> findAllDep(){
        List<Dep> list = new ArrayList<Dep>();
        conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from dep";
            try{
                pstmt=conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while(rs.next()) {
               		Dep dep = new Dep();
                    dep.setDid(rs.getInt(1));
                    dep.setDname(rs.getString(2));
                    list.add(dep);
                    
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
        return list;
    }
    @Override
    public Dep findDepById(int id){
        Dep dep = null;
        conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from dep where id = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                rs = pstmt.executeQuery();
                if(rs.next()) {
               		dep = new Dep();
                    dep.setIid(rs.getInt(1));
                    dep.setName(rs.getString(2));
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
        return dep;
    }
}
```

建立dao.impl.PosDaoImpl实现类

```java
package dao.impl;
import java.util.List;
import dao.PosDao;
public class PosDaoImpl implements PosDao{
    //类实现某个接口，那么这个类必须实现这个接口的所有方法
	BaseDao bs = new BaseDao();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
    @Override
    public Pos findPosById(int id){
        Pos pos = null;
        conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from pos where id = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                rs = pstmt.executeQuery();
                if(rs.next()) {
               		pos = new Pos();
                    pos.setId(rs.getInt(1));
                    pos.setName(rs.getString(2));
                    pos.setDepid(rs.getInt(3));
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
        return pos;
    }
}
```

建立dao.impl.EmpLogDaoImpl实现类

```java
package dao.impl;
import java.util.List;
import dao.EmpLogDao;
public class EmpLogDaoImpl implements EmpLogDao{
    //类实现某个接口，那么这个类必须实现这个接口的所有方法
	BaseDao bs = new BaseDao();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
    @Override
    public Pos login(int logid,String logpwd){
        boolean isFlag = false;
        conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from emplog where logid = ? and logpwd = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,logid);
                pstmt.setString(2,logpwd);
                rs = pstmt.executeQuery();
                if(rs.next()) {
               		isFlag = true;
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
    }
}
```

建立dao.impl.EmpDaoImpl实现类

```java
package dao.impl;
import java.util.List;
import dao.EmpDao;
public class EmpDaoImpl implements EmpDao{
    //类实现某个接口，那么这个类必须实现这个接口的所有方法
	BaseDao bs = new BaseDao();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
    @Override
    public Pos findEmpById(int id){
        Emp emp = null;
        conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from emp where id = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                rs = pstmt.executeQuery();
                if(rs.next()) {
               		emp = new Emp();
                    emp.setId(rs.getInt(1));
                    emp.setName(rs.getString(2));
                    emp.setSex(rs.getString(3));
                    emp.setAddress(rs.getString(4));
                    emp.setPhone(rs.getString(5));
                    emp.setHiredate(rs.getString(6));
                    emp.setSalary(rs.getDouble(7));
                    emp.setPosid(rs.getInt(8));
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
    }
}
```

5.在demo.Demo中进行Test框架测试。

```java
package demo;

import java.util.List;

import org.junit.Test;

import bean.Dep;
import bean.Emp;
import bean.Pos;
import dao.impl.DepDaoImpl;
import dao.impl.EmpDaoImpl;
import dao.impl.PosDaoImpl;

public class Demo
{
	@Test
	public void test01()
	{
		DepDaoImpl depDao=new DepDaoImpl();
		List<Dep> lp=depDao.findAllDep();
		for(int i=0;i<lp.size();i++)
		{
			Dep dep=lp.get(i);
			System.out.println(dep.getId()+"\t"+dep.getName());
		}
	}
	
	@Test
	public void test02()
	{
		DepDaoImpl depDao=new DepDaoImpl();
		Dep dep=depDao.findDepById(2);
		System.out.println(dep.getId()+"\t"+dep.getName());
	}
	
	@Test
	public void test03()
	{
		PosDaoImpl posDao=new PosDaoImpl();
		Pos pos=posDao.findPosById(1);
		if(pos!=null)
		{
			System.out.println(pos.getName());
			DepDaoImpl depDao=new DepDaoImpl();
			Dep dep=depDao.findDepById(pos.getDepid());
			System.out.println(dep.getName());
		}
	}
	
	@Test
	public void test04()
	{
		DepDaoImpl depDao=new DepDaoImpl();
		PosDaoImpl posDao=new PosDaoImpl();
		EmpDaoImpl empDao=new EmpDaoImpl();
		Emp emp=empDao.findEmpById(20120901);
		if(emp!=null)
		{
			System.out.println(emp.getName()+"\t"+posDao.findPosById(emp.getPosid()).getName());
		}
	}
}

```



下午完善

​	public List<Pos> findPosByDepid(int depid);



​	public boolean doEmpLog(int logid);//添加新员工的同时，添加该员工的登录信息
​    public boolean delEmpLog(int logid);//删除离职员工的同时，删除该员工的登录信息
​    public boolean updatePwd(int lohid, String newPwd);//修改密码



public boolean doEmp(Emp emp);//添加新员工，参数对象的值不包括id的值
    public boolean delEmp(int id);//删除离职员工
    public boolean updateEmo(Emp emp);//修改员工信息，参数对象包括所有信息，但是工号和职位编号不能修改。
    public List<Emp> findEmpByDep(int depid);//查询某个部门的所有员工信息
    public List<Emp> findEmpByDep(int posid);//查询某个职位的所有员工信息

```java
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Emp;
import dao.EmpDao;
import dbc.BaseDao;

public class EmpDaoImpl implements EmpDao {
	BaseDao bs = new BaseDao();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	@Override
	public Emp findEmpById(int id) {
		// TODO 自动生成的方法存根
		Emp emp = null;
		conn = bs.getConnection();
		if(conn!=null) {
			String sql = "select * from emp where id = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					emp = new Emp();
                    emp.setId(rs.getInt(1));
                    emp.setName(rs.getString(2));
                    emp.setSex(rs.getString(3));
                    emp.setAddress(rs.getString(4));
                    emp.setPhone(rs.getString(5));
                    emp.setHiredate(rs.getString(6));
                    emp.setSalary(rs.getDouble(7));
                    emp.setPosid(rs.getInt(8));
				}
			} catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
		}
		return emp;
	}
	@Override
	public boolean doEmp(Emp emp) {
		// TODO 自动生成的方法存根
		//工号是业务层来决定，我们这是数据层
		Boolean isFlag = false;
		conn = bs.getConnection();
		if(conn!=null) {
			String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(sql);
				
				int num = pstmt.executeUpdate();
				if(num>0) {
					isFlag = true;
				}
			} catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
		}
		return isFlag;
	}
	@Override
	public boolean delEmp(int id) {
		// TODO 自动生成的方法存根
		Boolean isFlag = false;
		conn = bs.getConnection();
		if(conn!=null) {
			String sql = "delect from emp where id = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				int num = pstmt.executeUpdate();
				if(num>0) {
					isFlag = true;
				}
			} catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
		}
		return isFlag;
	}
	@Override
	public boolean updateEmo(Emp emp) {
		// TODO 自动生成的方法存根
		// 修改员工信息，除编号和职位编号
		Boolean isFlag = false;
		conn = bs.getConnection();
		if(conn!=null) {
			String sql = "update emp set name = ?, sex = ?, address = ?, phone = ?, hiredate = ?, salary = ? where id = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				
				int num = pstmt.executeUpdate();
				if(num>0) {
					isFlag = true;
				}
			} catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
		}
		return isFlag;
	}
	@Override
	public List<Emp> findEmpByDep(int depid) {
		// TODO 自动生成的方法存根
		List<Emp> list = new ArrayList<Emp>();
        conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from emp where depid = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1, depid);
                rs = pstmt.executeQuery();
                while(rs.next()) {
                	Emp emp = new Emp();
                	emp.setId(rs.getInt(1));
                	emp.setName(rs.getString(2));
                    list.add(emp);
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
        return list;
	}
	@Override
	public List<Emp> findEmpByPos(int posid){
		return null;
		
	}
}

```

