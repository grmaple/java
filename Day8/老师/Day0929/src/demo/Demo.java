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
		 * Ӧ�ó�������ݿ������
		 * 1.����������ָ��Ӧ�ó�����ĸ����ݿ��������������
		 * 2.�������ӣ�ָ��Ӧ�ó������ͷ������е���һ�����ݿ⽨������
		 * 3.�����ַ���-com.mysql.jdbc.Driver���ɵ�����jar�ṩ
		 * 4.�����ַ���-jdbc:mysql://localhost:3306/myuser
		 * jdbc-java database connection
		 */
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser","root","feng9894");
		    if(conn!=null)
		    {
		    	System.out.println("���ӳɹ�!");
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
		 * �������
		 * ��Ӧ�ó�����ֻ������sql�������������
		 */
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser?characterEncoding=utf-8","root","123456");
			if(conn!=null)
			{
				//�˴���?��֮Ϊռλ������ζ����������ֵ��Ҫ����
				String sql="insert into user(id,name,password,money) values(?,?,?,?)";
				//�������Ӷ����õ��ܹ�����sql���Ķ���
				PreparedStatement pstmt=conn.prepareStatement(sql);
				//��θ�ռλ����ֵ:�ڼ����ʺ���ʲô���͵ģ�������pstmt����ʹ��set���͸��ڼ����ʺŸ�ֵ
				pstmt.setInt(1,1002);
				pstmt.setString(2,"����");
				pstmt.setString(3,"168168");
				pstmt.setDouble(4,200);
				//��ɾ�ĳɹ����ص�����Ӱ�������
				int num=pstmt.executeUpdate();//executeִ�У�update���£�ִ�и��¾�������ɾ�Ĳ���
				if(num>0)
				{
					System.out.println("��ӳɹ�!");
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
				pstmt.setString(1,"����");
				pstmt.setString(2,"168168");
				pstmt.setDouble(3,200);
				pstmt.setInt(4,1002);
				int num=pstmt.executeUpdate();
				if(num>0)
				{
					System.out.println("�޸ĳɹ�!");
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
					System.out.println("ɾ���ɹ�!");
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
				//��ѯ���ص��ǽ����������ǰ����������ڵ�һ�������
				ResultSet rs=pstmt.executeQuery();//query-��ѯ
				while(rs.next())//next���������ж���һ���Ƿ��������,��һ��������
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
