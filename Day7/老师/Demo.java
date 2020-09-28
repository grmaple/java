package cn.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class Demo
{
	/*
	 * JavaӦ�ó�������MySqlƽ̨�е����ݿ�
	 * JDBC--java database connection
	 */
	@Test
	public void test01()
	{
		/*
		 * �������ݿ�Ĳ���:
		 * 1.������������Ӧ�ó������ӵ�ָ�������ݿ�ƽ̨
		 * 2.�������ӣ���Ӧ���к�������ƽ̨�о����ĳ�����ݿ�
		 */
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//�����ַ���
		    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser","root","root");//�����ַ���
		    if(conn!=null)
		    {
		    	//��Eclipse��ֻ��ͨ��sql���������ݿ��еı������ɾ�Ĳ�Ĳ���
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
