package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		// �����Ա��
		Boolean isFlag = false;
		conn = bs.getConnection();
		if(conn!=null) {
			String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, emp.getId());
				pstmt.setString(2, emp.getName());
				pstmt.setString(3, emp.getSex());
                pstmt.setString(4, emp.getAddress());
                pstmt.setString(5, emp.getPhone());
                pstmt.setString(6, emp.getHiredate());
                pstmt.setDouble(7,emp.getSalary());
                pstmt.setInt(8,emp.getPosid());
				int num = pstmt.executeUpdate();
				if(num>0) {
					isFlag = true;
					EmpLogDaoImpl empLogDao = new EmpLogDaoImpl();
					if(empLogDao.doEmpLog(emp.getId())) {
			        	System.out.println("���log�ɹ���");
			        }else{
			        	System.out.println("���logʧ�ܣ�");
			        }
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
		// TODO �Զ����ɵķ������
		// ɾ��Ա��
		Boolean isFlag = false;
		conn = bs.getConnection();
		if(conn!=null) {
			String sql = "delete from emp where id = ?";
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
	public boolean updateEmp(Emp emp) {
		// TODO �Զ����ɵķ������
		// �޸�Ա��
		Boolean isFlag = false;
		conn = bs.getConnection();
		if(conn!=null) {
			String sql = "update emp set name = ?, sex = ?, address = ?, phone = ?, hiredate = ?, salary = ? where id = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, emp.getName());
				pstmt.setString(2, emp.getSex());
                pstmt.setString(3, emp.getAddress());
                pstmt.setString(4, emp.getPhone());
                pstmt.setString(5, emp.getHiredate());
                pstmt.setDouble(6,emp.getSalary());
                pstmt.setInt(7, emp.getId());
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
		// TODO �Զ����ɵķ������
		// ��ѯĳ�����ŵ�����Ա����Ա����Ϣ����û�в�����Ϣ��
		// ������Ҫ�Ȱ�������ŵ�����ְλ��ѯ������Ȼ���ٵ�Ա����Ϣ���а���Щְλ��Ա����ѯ����
		// �������̳�֮Ϊ�Ӳ�ѯ
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
					emp.setName(rs.getString(2));
					emp.setSex(rs.getString(3));
			        emp.setAddress(rs.getString(4));
			        emp.setPhone(rs.getString(5));
			        emp.setHiredate(rs.getString(6));
			        emp.setSalary(rs.getDouble(7));
			        emp.setPosid(rs.getInt(8));
					lp.add(emp);
				}
			} 
			catch (Exception e)
			{
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
	public List<Emp> findEmpByPos(int posid) {
		// TODO �Զ����ɵķ������
		// ��ѯĳ��ְλ������Ա����Ա����Ϣ���д���ְλ���
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
					emp.setName(rs.getString(2));
					emp.setSex(rs.getString(3));
			        emp.setAddress(rs.getString(4));
			        emp.setPhone(rs.getString(5));
			        emp.setHiredate(rs.getString(6));
			        emp.setSalary(rs.getDouble(7));
			        emp.setPosid(rs.getInt(8));
					lp.add(emp);
				}
			} 
			catch (Exception e)
			{
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
