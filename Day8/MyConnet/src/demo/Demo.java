package demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;
public class Demo {
	@Test
	public void test01() {
		//应用程序和数据库的连接
		//1.加载驱动，指明应用程序和哪个数据库服务器建立连接
		//2.建立连接，指明应用程序具体和服务器中的哪一个数据库建立连接
		//3.
		try {
			//1.加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");//mysql8.0以上使用
			//Class.forName("com.mysql.jdbc.Driver");//驱动字符串
			//2.建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "feng9894");//连接字符串
			if(conn!=null) {
				System.out.println("连接成功");
			}
            conn.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void test02() {//添加
		//添加数据库
		//在应用程序只能利用sql语句给表添加数据，不能通过图形化界面添加
		try {
			//1.加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");//mysql8.0以上使用
			//Class.forName("com.mysql.jdbc.Driver");//驱动字符串
			//2.建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "feng9894");//连接字符串
			if(conn!=null) {
				//此处？称之为占位符，意味着这里有值需要赋
				String sql="insert into user(id,name,password,money) value(?,?,?,?)";
				//利用连接对象拿到能处理sql语句的对象
				PreparedStatement pstmt=conn.prepareStatement(sql);
				//如何给占位符赋值？第几个问号是什么类型就利用pstmt对象使用set类型给第几个问号赋值
				pstmt.setInt(1,2);
				pstmt.setString(2, "李四");
				pstmt.setString(3, "1872");
				pstmt.setDouble(4, 200);
				//增删改是updata，返回的是受影响的行数
				int num=pstmt.executeUpdate();
				if(num>0) {
					System.out.println("添加成功");
				}
	            pstmt.close();
	            conn.close();
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void test03() {//修改
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//mysql8.0以上使用
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "feng9894");//连接字符串
			if(conn!=null) {
				//此处？称之为占位符，意味着这里有值需要赋
				String sql="update user set name=?,password=?,money=? where id=?";
				//利用连接对象拿到能处理sql语句的对象
				PreparedStatement pstmt=conn.prepareStatement(sql);
				//如何给占位符赋值？第几个问号是什么类型就利用pstmt对象使用set类型给第几个问号赋值
				pstmt.setString(1,"李四");
				pstmt.setString(2, "187222");
				pstmt.setDouble(3, 200);
				pstmt.setInt(4, 2);
				//增删改是updata，返回的是受影响的行数
				int num=pstmt.executeUpdate();
				if(num>0) {
					System.out.println("修改成功");
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void test04() {//删除
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//mysql8.0以上使用
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "feng9894");//连接字符串
			if(conn!=null) {
				String sql="delete from user where id=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, 2);
				int num=pstmt.executeUpdate();
				if(num>0) {
					System.out.println("删除成功");
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void test05() {//查询，把数据从数据库丢到应用程序
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//mysql8.0以上使用
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "feng9894");//连接字符串
			if(conn!=null) {
				String sql="select * from user";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				//查询返回结果值，结果是包含列名在内的虚拟表
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {//next方法判断下一行是否存在数据，第一行是列名，所以一开始就是下一行
					System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getString("password")+"\t"+rs.getDouble("money"));
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
