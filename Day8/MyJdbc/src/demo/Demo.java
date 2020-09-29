package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.junit.Test;

import dbc.BaseDao;

public class Demo {
	Scanner input = new Scanner(System.in);
	BaseDao bs = new BaseDao();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Test
	public void test01() {//���һ�����꼶
		System.out.println("�������꼶�ı��:");
		int id = input.nextInt();
		System.out.println("�������꼶������:");
		String name = input.next();
		
		conn = bs.getConnection();
		if(conn!=null) {
			String sql = "insert into grade values(?,?)";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				int num = pstmt.executeUpdate();
				if(num>0) {
					System.out.println("��ӳɹ�");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				bs.closeConn(conn, pstmt, rs);
			}
		}
	}
	
	@Test
	public void test02() {//���һ����ѧ��
		System.out.println("������ѧ����ѧ�ţ�");
        int id = input.nextInt();
        System.out.println("������ѧ����������");
        String name = input.next();
        System.out.println("������ѧ�����Ա�");
        String sex = input.next();
        System.out.println("������ѧ���ļ��᣺");
        String address = input.next();
        System.out.println("������ѧ������ϵ��ʽ��");
        String phone = input.next();
        System.out.println("���\t����");
        showGrade();
        System.out.println("��ѡ���꼶�ı�ţ�");
        int gid = input.nextInt();
        
        conn = bs.getConnection();
        if(conn!=null) {
        	String sql = "insert into student values(?,?,?,?,?,?)";
        	try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                pstmt.setString(2, name);
                pstmt.setString(3, sex);
                pstmt.setString(4, address);
                pstmt.setString(5, phone);
                pstmt.setInt(6, gid);
                int num=pstmt.executeUpdate();
                if(num>0) {
                    System.out.println("��ӳɹ�");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
	public void showGrade() {//��ʾ�꼶�嵥
		conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from grade";
            try{
                pstmt=conn.prepareStatement(sql);
                ResultSet rs=pstmt.executeQuery();
   				while(rs.next()) {
                    System.out.println(rs.getInt("id")+"\t"+rs.getString("name"));
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
	@Test
	public void test03() {//��ѯĳ�꼶��ѧ����Ϣ
		System.out.println("���\t����");
        showGrade();
		System.out.println("�������ѯ�꼶�ı�ţ�");
        int gid = input.nextInt();
        conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from student where gid = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,gid);
                ResultSet rs = pstmt.executeQuery();
                //�� ResultSetΪ�ǿ�ʱ�����α�ָ���һ����¼ǰ�棬��Ϊ��ʱ���ڲ����ڵ�һ����¼��������ʱ���α�Ҳ�޷���ָ��һ����¼ǰ��
                if(rs.isBeforeFirst()) {
                	System.out.println("id\tname\tsex\taddress\tphone\tgid");
                	while(rs.next()) {
                        System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getString("sex")+"\t"+rs.getString("address")+"\t"+rs.getString("phone")+"\t"+rs.getInt("gid"));
                    }
                } else {
                	System.out.println("����ʧ��");
                }

            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
	@Test
	public void test04() {//��ѯĳ��ѧ�ŵ�ѧ����Ϣ
		System.out.println("�������ѯѧ����ѧ�ţ�");
        int id = input.nextInt();
        conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from student where id = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                rs = pstmt.executeQuery();
                if(rs.next()) {
                	System.out.println("id\tname\tsex\taddress\tphone\tgid");
                    System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getString("sex")+"\t"+rs.getString("address")+"\t"+rs.getString("phone")+"\t"+rs.getInt("gid"));
                } else {
                	System.out.println("����ʧ��");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
}
