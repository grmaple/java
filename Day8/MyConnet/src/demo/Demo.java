package demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;
public class Demo {
	@Test
	public void test01() {
		//Ӧ�ó�������ݿ������
		//1.����������ָ��Ӧ�ó�����ĸ����ݿ��������������
		//2.�������ӣ�ָ��Ӧ�ó������ͷ������е���һ�����ݿ⽨������
		//3.
		try {
			//1.��������
			Class.forName("com.mysql.cj.jdbc.Driver");//mysql8.0����ʹ��
			//Class.forName("com.mysql.jdbc.Driver");//�����ַ���
			//2.��������
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "feng9894");//�����ַ���
			if(conn!=null) {
				System.out.println("���ӳɹ�");
			}
            conn.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void test02() {//���
		//������ݿ�
		//��Ӧ�ó���ֻ������sql������������ݣ�����ͨ��ͼ�λ��������
		try {
			//1.��������
			Class.forName("com.mysql.cj.jdbc.Driver");//mysql8.0����ʹ��
			//Class.forName("com.mysql.jdbc.Driver");//�����ַ���
			//2.��������
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "feng9894");//�����ַ���
			if(conn!=null) {
				//�˴�����֮Ϊռλ������ζ��������ֵ��Ҫ��
				String sql="insert into user(id,name,password,money) value(?,?,?,?)";
				//�������Ӷ����õ��ܴ���sql���Ķ���
				PreparedStatement pstmt=conn.prepareStatement(sql);
				//��θ�ռλ����ֵ���ڼ����ʺ���ʲô���;�����pstmt����ʹ��set���͸��ڼ����ʺŸ�ֵ
				pstmt.setInt(1,2);
				pstmt.setString(2, "����");
				pstmt.setString(3, "1872");
				pstmt.setDouble(4, 200);
				//��ɾ����updata�����ص�����Ӱ�������
				int num=pstmt.executeUpdate();
				if(num>0) {
					System.out.println("��ӳɹ�");
				}
	            pstmt.close();
	            conn.close();
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void test03() {//�޸�
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//mysql8.0����ʹ��
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "feng9894");//�����ַ���
			if(conn!=null) {
				//�˴�����֮Ϊռλ������ζ��������ֵ��Ҫ��
				String sql="update user set name=?,password=?,money=? where id=?";
				//�������Ӷ����õ��ܴ���sql���Ķ���
				PreparedStatement pstmt=conn.prepareStatement(sql);
				//��θ�ռλ����ֵ���ڼ����ʺ���ʲô���;�����pstmt����ʹ��set���͸��ڼ����ʺŸ�ֵ
				pstmt.setString(1,"����");
				pstmt.setString(2, "187222");
				pstmt.setDouble(3, 200);
				pstmt.setInt(4, 2);
				//��ɾ����updata�����ص�����Ӱ�������
				int num=pstmt.executeUpdate();
				if(num>0) {
					System.out.println("�޸ĳɹ�");
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void test04() {//ɾ��
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//mysql8.0����ʹ��
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "feng9894");//�����ַ���
			if(conn!=null) {
				String sql="delete from user where id=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, 2);
				int num=pstmt.executeUpdate();
				if(num>0) {
					System.out.println("ɾ���ɹ�");
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void test05() {//��ѯ�������ݴ����ݿⶪ��Ӧ�ó���
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//mysql8.0����ʹ��
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "feng9894");//�����ַ���
			if(conn!=null) {
				String sql="select * from user";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				//��ѯ���ؽ��ֵ������ǰ����������ڵ������
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {//next�����ж���һ���Ƿ�������ݣ���һ��������������һ��ʼ������һ��
					System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getString("password")+"\t"+rs.getDouble("money"));
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
