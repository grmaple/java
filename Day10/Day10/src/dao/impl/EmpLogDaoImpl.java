package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import dao.EmpLogDao;
import dbc.BaseDao;

public class EmpLogDaoImpl implements EmpLogDao{
	BaseDao bs = new BaseDao();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int count = 0;
	Scanner input = new Scanner(System.in);
	@Override
	public boolean login(int logid, String logpwd) {
		// TODO 自动生成的方法存根
		boolean isFlag = false;
		conn = bs.getConnection();
		if(conn!=null) {
			String sql = "select * from emplog where logid = ? and logpwd = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, logid);
				pstmt.setString(2, logpwd);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					isFlag = true;
				}
			} catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
		}
		return isFlag;
	}
	@Override
	public boolean doEmpLog(int logid) {
		// TODO 自动生成的方法存根
		boolean isFlag=false;
		conn = bs.getConnection();
        if(conn!=null) {
        	String sql = "insert into emplog values(?,?,?)";
        	try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1, count);
                pstmt.setInt(2, logid);
                pstmt.setString(3, "123456");
                int num=pstmt.executeUpdate();
                if(num>0) {
					isFlag = true;
					count++;
				}
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
		return isFlag;
	}
	@Override
	public boolean delEmpLog(int logid) {
		// TODO 自动生成的方法存根
		boolean isFlag=false;
		conn = bs.getConnection();
        if(conn!=null) {
        	String sql = "delete from emplog where logid=?";
        	try{
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,logid);
				int num=pstmt.executeUpdate();
				if(num>0)
				{
					isFlag = true;
					EmpDaoImpl empDao = new EmpDaoImpl();
			        if(empDao.delEmp(logid)) {
			        	System.out.println("删除成功！");
			        }else{
			        	System.out.println("删除失败！");
			        }
				}
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
        return isFlag;
	}
	@Override
	public boolean updatePwd(int logid, String newPwd) {
		// TODO 自动生成的方法存根
		boolean isFlag=false;
		conn = bs.getConnection();
		if(conn!=null) {
			String sql = "update emplog set logpwd=? where logid=?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, newPwd);
				pstmt.setInt(2, logid);
				int num=pstmt.executeUpdate();
				if(num>0) {
					isFlag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				bs.closeConn(conn, pstmt, rs);
			}
		}
		return isFlag;
	}
}
