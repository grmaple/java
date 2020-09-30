package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao
{
	/*
	 * ���ݿ�����Ӻ͹ر���
	 */
	public Connection getConnection()
	{
		/*
		 * �������ݿ�
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
		 * 1.�������Ӷ���conn
		 * 2.ͨ�����Ӷ������prepareStatement�õ�����sql���Ķ���pstmt
		 * 3.����ǲ�ѯ���ý����rs����
		 * 4.�رյ�ԭ���ȡ���Ƚ����
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
