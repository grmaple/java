package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.EmpLogDao;
import dbc.BaseDao;

public class EmpLogDaoImpl implements EmpLogDao
{
	BaseDao bs=new BaseDao();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	@Override
	public boolean login(int logid, String logpwd)
	{
		boolean isFlag=false;
		conn=bs.getConnection();
		if(conn!=null)
		{
			String sql="select * from emplog where logid=? and logpwd=?";
			try
			{
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,logid);
				pstmt.setString(2,logpwd);
				rs=pstmt.executeQuery();
				if(rs.next())
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
	public boolean doEmpLog(int logid)
	{
		/*
		 * ���Ա����¼��Ϣ
		 * �����������һ����ʼֵ������6��8
		 */
		boolean isFlag=false;
		
		return isFlag;
	}
	@Override
	public boolean delEmplg(int logid)
	{
		/*
		 * ɾ����ְԱ���ĵ�¼��Ϣ
		 */
		boolean isFlag=false;
		
		return isFlag;
	}
	@Override
	public boolean updatePwd(int logid, String newPwd)
	{
		/*
		 * �����޸ĸ��˵�����
		 */
		boolean isFlag=false;
		
		return isFlag;
	}
}
