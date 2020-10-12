package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Dep;
import dao.DepDao;
import dbc.BaseDao;

public class DepDaoImpl implements DepDao{
	BaseDao bs = new BaseDao();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public List<Dep> findAllDep() {
		// TODO 自动生成的方法存根
		List<Dep> list = new ArrayList<Dep>();
		conn = bs.getConnection();
		if(conn!=null) {
			String sql = "select * from dep";
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Dep dep = new Dep();
					dep.setId(rs.getInt(1));
					dep.setName(rs.getString(2));
					list.add(dep);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				bs.closeConn(conn, pstmt, rs);
			}
		}
		return list;
	}

	@Override
	public Dep findDepById(int id) {
		// TODO 自动生成的方法存根
		Dep dep = null;
		conn = bs.getConnection();
		if(conn!=null) {
			String sql = "select * from dep where id = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					dep = new Dep();
					dep.setId(rs.getInt(1));
					dep.setName(rs.getString(2));
				}
			} catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
		}
		return dep;
	}

}
