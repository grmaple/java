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

public class EmpDaoImpl implements EmpDao
{
	BaseDao bs=new BaseDao();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	@Override
	public Emp findEmpById(int id)
	{
		Emp emp=null;
		conn=bs.getConnection();
		if(conn!=null)
		{
			String sql="select * from emp where id=?";
			try
			{
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,id);
				rs=pstmt.executeQuery();
				if(rs.next())
				{
					emp=new Emp();
					emp.setId(rs.getInt(1));
					emp.setName(rs.getString(2));
					emp.setSex(rs.getString(3));
					emp.setAddress(rs.getString(4));
					emp.setPhone(rs.getString(5));
					emp.setHiredate(rs.getString(6));
					emp.setSalary(rs.getDouble(7));
					emp.setPosid(rs.getInt(8));
				}
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				bs.closeConn(conn, pstmt, rs);
			}
		}
		return emp;
	}
	@Override
	public boolean doEmp(Emp emp)
	{
		/*
		 * 添加新员工
		 * 工号是入职日期，应该在业务层确定
		 */
		boolean isFlag=false;
		conn=bs.getConnection();
		if(conn!=null)
		{
			String sql="insert into emp values(?,?,?,?,?,?,?,?)";
			try
			{
				pstmt=conn.prepareStatement(sql);
				
				int num=pstmt.executeUpdate();
				if(num>0)
				{
					isFlag=true;
				}
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				bs.closeConn(conn, pstmt, rs);
			}
		}
		return isFlag;
	}
	@Override
	public boolean delEmp(int id)
	{
		/*
		 * 删除离职员工
		 */
		boolean isFlag=false;
		conn=bs.getConnection();
		if(conn!=null)
		{
			String sql="delete from emp where id=?";
			try
			{
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,id);
				int num=pstmt.executeUpdate();
				if(num>0)
				{
					isFlag=true;
				}
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				bs.closeConn(conn, pstmt, rs);
			}
		}
		return isFlag;
	}
	@Override
	public boolean updateEmp(Emp emp)
	{
		/*
		 * 修改员工信息，除工号和职位编号不能修改
		 */
		boolean isFlag=false;
		conn=bs.getConnection();
		if(conn!=null)
		{
			String sql="update emp set name=?,sex=?,address=?,phone=?,hiredate=?,salary=? where id=?";
			try
			{
				pstmt=conn.prepareStatement(sql);
				
				int num=pstmt.executeUpdate();
				if(num>0)
				{
					isFlag=true;
				}
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				bs.closeConn(conn, pstmt, rs);
			}
		}
		return isFlag;
	}
	@Override
	public List<Emp> findEmpByDep(int depid)
	{
		/*
		 * 查询某个部门的所有员工，员工信息表中没有部门信息的
		 * 我们需要先把这个部门的所有职位查询出来，然后再到员工信息表中把这些职位的员工查询出来
		 * 上述过程称之为子查询
		 */
		List<Emp> lp=new ArrayList<Emp>();
		conn=bs.getConnection();
		if(conn!=null)
		{
			String sql="select * from emp where posid in (select id from pos where depid=?)";
			try
			{
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,depid);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					Emp emp=new Emp();
					emp.setId(rs.getInt(1));
					
					lp.add(emp);
				}
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				bs.closeConn(conn, pstmt, rs);
			}
		}
		return lp;
	}
	@Override
	public List<Emp> findEmpByPos(int posid)
	{
		/*
		 * 查询某个职位的所有员工，员工信息表中存在职位编号
		 */
		List<Emp> lp=new ArrayList<Emp>();
		conn=bs.getConnection();
		if(conn!=null)
		{
			String sql="select * from emp where posid=?";
			try
			{
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,posid);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					Emp emp=new Emp();
					emp.setId(rs.getInt(1));
					
					lp.add(emp);
				}
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				bs.closeConn(conn, pstmt, rs);
			}
		}
		return lp;
	}
}
