package impl;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbc.BaseDao;

public class EmpImpl {
	Scanner input = new Scanner(System.in);
	BaseDao bs = new BaseDao();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int nowid = 0;//当前登录的员工工号
	int nowdep = 0;//当前登录的员工部门
	String grade = null;//当前登录的员工级别，即pname职位名称
	public void show() {
		String a2 =null;
		do {
			a2 = "n";
			String a1 =null;
			do {//登录界面
				a1 = "n";
				boolean tag = login();
				if(tag==false) a1="y";
			} while (a1.equals("y"));
			//个人界面
			boolean tag2 = false;
			if(grade.equals("经理")) {
				tag2 = showMan();
			} else {
				tag2 = showEmp();
			}
			if (tag2 == true) a2 = "y";
		} while(a2.equals("y"));
	}
	public boolean showMan() {
		String a2 = null;
		boolean tag = false;
		do {
			a2 = "n";
			System.out.println("                   1.添加新员工");
			System.out.println("                   2.删除离职员工");
			System.out.println("                   3.修改员工信息工");
			System.out.println("                   4.查询员工信息 ");
			System.out.println("                   5.修改密码");
			System.out.println("                   6.退出");
			System.out.println("请选择：");
			int n = input.nextInt();
			String a3 = null;
			if(n==1) {
				do {
					addEmp();//添加新员工
					System.out.println("请问要继续吗？");
					a3 = input.next();
				} while(a3.equals("y"));
				a2="y";
			} else if(n==2) {
				do {
					deleteEmplog();//删除离职员工
					System.out.println("请问要继续吗？");
					a3 = input.next();
				} while(a3.equals("y"));
				a2="y";
			} else if(n==3) {
				do {
					modifyEmp();//修改员工信息工
					System.out.println("请问要继续吗？");
					a3 = input.next();
				} while(a3.equals("y"));
				a2="y";
			} else if(n==4) {
				do {
					queryEmp();//查询员工信息
					System.out.println("请问要继续吗？");
					a3 = input.next();
				} while(a3.equals("y"));
				a2="y";
			} else if(n==5) {
				do {
					modifyPwd(nowid);//修改密码
					System.out.println("请问要继续吗？");
					a3 = input.next();
				} while(a3.equals("y"));
				a2="y";
			} else if(n==6) {
				a2 = "n";//退出
				tag = true;
			} else {
				System.out.println("编号选择错误，请重新选择!");
				a2="y";
			}
		} while(a2.equals("y"));
		return tag;
	}
	public boolean showEmp() {
		String a2 = null;
		boolean tag = false;
		do {
			a2 = "n";
			System.out.println("                   1.查询个人信息");
			System.out.println("                   2.修改个人密码");
			System.out.println("                   3.退出");
			System.out.println("请选择：");
			int n = input.nextInt();
			String a3 = null;
			if(n==1) {
				do {
					queryEmpById(nowid);
					System.out.println("请问要继续吗？");
					a3 = input.next();
				} while(a3.equals("y"));
				a2="y";
			} else if(n==2) {
				do {
					modifyPwd(nowid);//修改密码
					System.out.println("请问要继续吗？");
					a3 = input.next();
				} while(a3.equals("y"));
				a2="y";
			} else if(n==3) {
				a2 = "n";//退出
				tag = true;
			} else {
				System.out.println("编号选择错误，请重新选择!");
				a2="y";
			}
		} while(a2.equals("y"));
		return tag;
	}
	public boolean login() {//登录，通过查找工号和密码是否存在判断是否成功登录
		boolean tag = false;
		System.out.println("======================================================");
		System.out.println("                   员工管理系统                             ");
		System.out.println("======================================================");
		System.out.println("请输入工号：");
		int inid = input.nextInt();
		System.out.println("请输入密码：");
		String inpwd = input.next();
		conn = bs.getConnection();
	    if(conn!=null){
	    	String sql = "select * from emplog where id = ? and pwd = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,inid);
                pstmt.setString(2, inpwd);
                rs = pstmt.executeQuery();
                if(rs.next()) {
                	
                	String name = queryEmpName(inid);//找到员工名字
                	int pos = queryPos(inid);//找到职位编号
                	String pname = queryPosName(pos);//找到职位名字
                	int dep = queryDep(pos);//找到部门编号
                	String dname = queryDepName(dep);//找到部门名字
                	System.out.println("登录成功,欢迎"+dname+pname+name+"!");
                	nowid = inid;
                	grade = pname;
                	nowdep = dep;
                	tag = true;
                } else {
                	System.out.println("登录失败,请重新登录!");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	    return tag;
	}
	public String queryEmpName(int id) {//通过工号查找员工名字
		String name = null;
		conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from emp where id = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                rs = pstmt.executeQuery();
                if(rs.next()) {
                	name = rs.getString("name");
                } else {
                	System.out.println("查找失败");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
		return name;
	}
	public int queryPos(int id) {//找到职位编号
		int ret = 0;
		conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from emp where id = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                rs = pstmt.executeQuery();
                if(rs.next()) {
                	ret = rs.getInt("epos");
                } else {
                	System.out.println("查找失败");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
		return ret;
	}
	public String queryPosName(int pos){//找到职位名字
		String name = null;
		conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from pos where pid = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,pos);
                rs = pstmt.executeQuery();
                if(rs.next()) {
                	name = rs.getString("pname");
                } else {
                	System.out.println("查找失败");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
		return name;
	}
	public int queryDep(int pos){//找到部门编号
		int ret = 0;
		conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from pos where pid = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,pos);
                rs = pstmt.executeQuery();
                if(rs.next()) {
                	ret = rs.getInt("pdep");
                } else {
                	System.out.println("查找失败");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
		return ret;
	}
	public String queryDepName(int dep){//找到部门名字
		String name = null;
		conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from dep where did = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,dep);
                rs = pstmt.executeQuery();
                if(rs.next()) {
                	name = rs.getString("dname");
                } else {
                	System.out.println("查找失败");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
		return name;
	}
	public void addEmp() {//添加新员工
		System.out.println("请输入员工编号：");
        int id = input.nextInt();
        System.out.println("请输入员工姓名：");
        String name = input.next();
        System.out.println("请输入员工性别：");
        String sex = input.next();
        System.out.println("请输入员工籍贯：");
        String address = input.next();
        System.out.println("请输入员工电话：");
        String phone = input.next();
        System.out.println("请输入员工入职日期：");
        String data = input.next();
        System.out.println("请输入员工薪资：");
        int wage = input.nextInt();
        System.out.println("请选择员工职位：");
        showPos(nowdep);//显示该部门员工职位信息
        //可以用set把职位编号存储起来，然后判断输入的职位编号是否在set里面
        int epos = input.nextInt();
        conn = bs.getConnection();
        if(conn!=null) {
        	String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
        	try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                pstmt.setString(2, name);
                pstmt.setString(3, sex);
                pstmt.setString(4, address);
                pstmt.setString(5, phone);
                pstmt.setString(6, data);
                pstmt.setInt(7,wage);
                pstmt.setInt(8,epos);
                int num=pstmt.executeUpdate();
                if(num>0) {
                    System.out.println("添加成功！");
                    addEmplog(id,"123456");//把新员工增加进登录信息表
                }
            } catch (Exception e){
            	//在命令行打印异常信息在程序中出错的位置及原因
                e.printStackTrace();
                //System.out.println("添加失败");
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
	public void deleteEmp(int id) {//删除离职员工
		conn = bs.getConnection();
        if(conn!=null) {
        	String sql = "delete from emp where id=?";
        	try{
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,id);
				int num=pstmt.executeUpdate();
				if(num<=0)
				{
					System.out.println("删除emp失败!");
				}
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
	public void modifyEmp() {//修改员工信息
		System.out.println("请输入要修改的员工工号：");
        int id = input.nextInt();
        queryEmpById(id);
        System.out.println("请输入修改后的员工姓名：");
        String name = input.next();
        System.out.println("请输入修改后的员工性别：");
        String sex = input.next();
        System.out.println("请输入修改后的员工籍贯：");
        String address = input.next();
        System.out.println("请输入修改后的员工电话：");
        String phone = input.next();
        System.out.println("请输入修改后的员工入职日期：");
        String data = input.next();
        System.out.println("请输入修改后的员工薪资：");
        int wage = input.nextInt();
        System.out.println("请选择修改后的员工职位：");
        showPos(nowdep);//显示该部门员工职位信息
        //可以用set把职位编号存储起来，然后判断输入的职位编号是否在set里面
        int epos = input.nextInt();
        conn = bs.getConnection();
        if(conn!=null) {
        	String sql = "update emp set name=?,sex=?,address=?,phone=?,data=?,wage=?,epos=? where id=?";
        	try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.setString(2, sex);
                pstmt.setString(3, address);
                pstmt.setString(4, phone);
                pstmt.setString(5, data);
                pstmt.setInt(6,wage);
                pstmt.setInt(7,epos);
                pstmt.setInt(8,id);
                int num=pstmt.executeUpdate();
                if(num>0) {
                    System.out.println("修改成功！");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
	public void queryEmp() {//查询员工信息
		String a4 = null;
		do {
			a4 = "n";
			System.out.println("1：通过部门查询");
			System.out.println("2：通过职位查询");
			int n = input.nextInt();
			if(n == 1) {
				System.out.println("请输入要查询的部门编号：");
				int id = input.nextInt();
				queryEmpByDep(id);
			} else if(n == 2) {
				System.out.println("请输入要查询的职位编号：");
				int id = input.nextInt();
				//System.out.println("id\tname\tsex\taddress\tphone\tdata\twage\tepos");
				queryEmpByPos(id);
			} else {
				System.out.println("编号选择错误，请重新选择!");
				a4="y";
			}
		}while(a4.equals("y"));
	}
	public void modifyPwd(int id) {//修改密码
		System.out.println("请输入修改后的密码：");
        String pwd = input.next();
		conn = bs.getConnection();
		if(conn!=null) {
			String sql = "update emplog set pwd=? where id=?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, pwd);
				pstmt.setInt(2, id);
				int num=pstmt.executeUpdate();
				if(num>0) {
					System.out.println("修改成功");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				bs.closeConn(conn, pstmt, rs);
			}
		}
	}
	public void showPos(int dep) {//显示该部门员工职位信息
		conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from pos where pdep = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,dep);
                ResultSet rs=pstmt.executeQuery();
   				while(rs.next()) {
                    System.out.println(rs.getInt("pid")+"\t"+rs.getString("pname")+"\t"+rs.getInt("pdep"));
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
	public void addEmplog(int id, String pwd) {//添加新员工的账号密码
        conn = bs.getConnection();
        if(conn!=null) {
        	String sql = "insert into emplog values(?,?)";
        	try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                pstmt.setString(2, pwd);
                int num=pstmt.executeUpdate();
                if(num<=0) {
                    System.out.println("添加emplog失败");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
	public void deleteEmplog() {//删除离职员工的账号密码
		
		conn = bs.getConnection();
        if(conn!=null) {
        	String sql = "delete from emplog where id=?";
        	try{
        		int num = 0;
        		int id = 0;
        		do {
        			System.out.println("请输入要删除的离职员工工号：");
                    id = input.nextInt();
    				pstmt=conn.prepareStatement(sql);
    				pstmt.setInt(1,id);
    				num=pstmt.executeUpdate();
    				if(num<=0)System.out.println("该工号不存在，请重新输入！");
        		} while(num<=0);
				if(num>0)
				{
					System.out.println("删除成功!");
					deleteEmp(id);//先删除引用外键的再删除外键
				}
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
	public void queryEmpById(int id) {//通过工号查找员工信息
		conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from emp where id = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                rs = pstmt.executeQuery();
                if(rs.next()) {
                	System.out.println("id\tname\tsex\taddress\tphone\tdata\twage\tepos");
                    System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getString("sex")+"\t"+rs.getString("address")+"\t"+rs.getString("phone")+"\t"+rs.getString("data")+"\t"+rs.getInt("wage")+"\t"+rs.getInt("epos"));
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
	public void queryEmpByDep(int id) {//通过部门查找员工信息
		conn = bs.getConnection();
		int[] p = new int[10];
		int i = 0;
        if(conn!=null){
            String sql = "select * from pos where pdep = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                rs = pstmt.executeQuery();
                if(rs.isBeforeFirst()) {
                	System.out.println("id\tname\tsex\taddress\tphone\tdata\twage\tepos");
                    while(rs.next()) {
                    	int pos = rs.getInt("pid");
                    	p[i++] = pos;
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
        for(int j = 0; j<i; j++) {
        	queryEmpByPos(p[j]);
        }
        
	}
	public void queryEmpByPos(int id) {//通过职位查找员工信息
		conn = bs.getConnection();
        if(conn!=null){
            String sql = "select * from emp where epos = ?";
            try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                rs = pstmt.executeQuery();
                if(rs.isBeforeFirst()) {
                    while(rs.next()) {
                    	
                    	System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getString("sex")+"\t"+rs.getString("address")+"\t"+rs.getString("phone")+"\t"+rs.getString("data")+"\t"+rs.getInt("wage")+"\t"+rs.getInt("epos"));
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
}
