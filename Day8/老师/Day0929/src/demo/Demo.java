package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class Demo
{
	@Test
	public void test01()
	{
		/*
		 * 应用程序和数据库的连接
		 * 1.加载驱动，指明应用程序和哪个数据库服务器建立连接
		 * 2.建立连接，指明应用程序具体和服务器中的哪一个数据库建立连接
		 * 3.驱动字符窜-com.mysql.jdbc.Driver，由第三方jar提供
		 * 4.连接字符窜-jdbc:mysql://localhost:3306/myuser
		 * jdbc-java database connection
		 */
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser","root","feng9894");
		    if(conn!=null)
		    {
		    	System.out.println("连接成功!");
		    }
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test02()
	{
		/*
		 * 添加数据
		 * 在应用程序中只能利用sql语句给表添加数据
		 */
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser?characterEncoding=utf-8","root","123456");
			if(conn!=null)
			{
				//此处的?称之为占位符，意味着这里是有值需要赋的
				String sql="insert into user(id,name,password,money) values(?,?,?,?)";
				//利用连接对象拿到能够处理sql语句的对象
				PreparedStatement pstmt=conn.prepareStatement(sql);
				//如何给占位符赋值:第几个问号是什么类型的，就利用pstmt对象使用set类型给第几个问号赋值
				pstmt.setInt(1,1002);
				pstmt.setString(2,"李四");
				pstmt.setString(3,"168168");
				pstmt.setDouble(4,200);
				//增删改成功返回的是受影响的行数
				int num=pstmt.executeUpdate();//execute执行，update更新，执行更新就是做增删改操作
				if(num>0)
				{
					System.out.println("添加成功!");
				}
			}
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test03()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser?characterEncoding=utf-8","root","123456");
			if(conn!=null)
			{
				String sql="update user set name=?,password=?,money=? where id=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,"李四");
				pstmt.setString(2,"168168");
				pstmt.setDouble(3,200);
				pstmt.setInt(4,1002);
				int num=pstmt.executeUpdate();
				if(num>0)
				{
					System.out.println("修改成功!");
				}
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test04()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser?characterEncoding=utf-8","root","123456");
			if(conn!=null)
			{
				String sql="delete from user where id=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,1002);
				int num=pstmt.executeUpdate();
				if(num>0)
				{
					System.out.println("删除成功!");
				}
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test05()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser?characterEncoding=utf-8","root","123456");
			if(conn!=null)
			{
				String sql="select * from user";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				//查询返回的是结果集，结果是包含列名在内的一张虚拟表
				ResultSet rs=pstmt.executeQuery();//query-查询
				while(rs.next())//next方法逐行判断下一行是否存在数据,第一行是列名
				{
					System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getString("password")+"\t"+rs.getDouble("money"));
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
