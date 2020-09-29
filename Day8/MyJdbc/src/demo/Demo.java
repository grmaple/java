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
	public void test01() {//添加一个新年级
		System.out.println("请输入年级的编号:");
		int id = input.nextInt();
		System.out.println("请输入年级的名称:");
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
					System.out.println("添加成功");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				bs.closeConn(conn, pstmt, rs);
			}
		}
	}
	
	@Test
	public void test02() {//添加一个新学生
		System.out.println("请输入学生的学号：");
        int id = input.nextInt();
        System.out.println("请输入学生的姓名：");
        String name = input.next();
        System.out.println("请输入学生的性别：");
        String sex = input.next();
        System.out.println("请输入学生的籍贯：");
        String address = input.next();
        System.out.println("请输入学生的联系方式：");
        String phone = input.next();
        System.out.println("编号\t名称");
        showGrade();
        System.out.println("请选择年级的编号：");
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
                    System.out.println("添加成功");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
	public void showGrade() {//显示年级清单
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
	public void test03() {//查询某年级的学生信息
		System.out.println("编号\t名称");
        showGrade();
		System.out.println("请输入查询年级的编号：");
        int gid = input.nextInt();
        conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from student where gid = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,gid);
                ResultSet rs = pstmt.executeQuery();
                //当 ResultSet为非空时，其游标指向第一条记录前面，若为空时由于不存在第一条记录，所以这时候游标也无法向指第一条记录前面
                if(rs.isBeforeFirst()) {
                	System.out.println("id\tname\tsex\taddress\tphone\tgid");
                	while(rs.next()) {
                        System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getString("sex")+"\t"+rs.getString("address")+"\t"+rs.getString("phone")+"\t"+rs.getInt("gid"));
                    }
                } else {
                	System.out.println("查找失败");
                }

            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
	@Test
	public void test04() {//查询某个学号的学生信息
		System.out.println("请输入查询学生的学号：");
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
                	System.out.println("查找失败");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
}
