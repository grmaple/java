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
