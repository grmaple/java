package cn.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class Demo
{
	/*
	 * Java应用程序连接MySql平台中的数据库
	 * JDBC--java database connection
	 */
	@Test
	public void test01()
	{
		/*
		 * 连接数据库的步骤:
		 * 1.加载驱动，让应用程序连接到指定的数据库平台
		 * 2.建立连接，让应用行横须连接平台中具体的某个数据库
		 */
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//驱动字符窜
		    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser","root","root");//连接字符窜
		    if(conn!=null)
		    {
		    	//在Eclipse中只能通过sql语句操作数据库中的表进行增删改查的操作
		    	String sql="select * from student";
		    	PreparedStatement pstmt=conn.prepareStatement(sql);
		    	ResultSet rs=pstmt.executeQuery();
		    	while(rs.next())
		    	{
		    		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
		    	}
		    }
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
