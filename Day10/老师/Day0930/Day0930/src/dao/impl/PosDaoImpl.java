package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Pos;
import dao.PosDao;
import dbc.BaseDao;

public class PosDaoImpl implements PosDao
{
	BaseDao bs=new BaseDao();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	@Override
	public Pos findPosById(int id)
	{
		Pos pos=null;
		conn=bs.getConnection();
		if(conn!=null)
		{
			String sql="select * from pos where id=?";
			try
			{
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,id);
				rs=pstmt.executeQuery();
				if(rs.next())
				{
					pos=new Pos();
					pos.setId(rs.getInt(1));
					pos.setName(rs.getString(2));
					pos.setDepid(rs.getInt(3));
				}
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				bs.closeConn(conn, pstmt, rs);
			}
		}
		return pos;
	}
	@Override
	public List<Pos> findPosByDepid(int depid)
	{
		List<Pos> lp=new ArrayList<Pos>();
		conn=bs.getConnection();
		if(conn!=null)
		{
			String sql="select * from pos where depid=?";
			try
			{
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,depid);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					/*
					 * 表中的每一行数据交给表对应的类的一个对象接收
					 */
					Pos p=new Pos();
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setDepid(rs.getInt(3));
					lp.add(p);
				}
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				bs.closeConn(conn, pstmt, rs);
			}
		}
		return lp;
	}
}
