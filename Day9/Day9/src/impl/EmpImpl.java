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
	int nowid = 0;//��ǰ��¼��Ա������
	int nowdep = 0;//��ǰ��¼��Ա������
	String grade = null;//��ǰ��¼��Ա�����𣬼�pnameְλ����
	public void show() {
		String a2 =null;
		do {
			a2 = "n";
			String a1 =null;
			do {//��¼����
				a1 = "n";
				boolean tag = login();
				if(tag==false) a1="y";
			} while (a1.equals("y"));
			//���˽���
			boolean tag2 = false;
			if(grade.equals("����")) {
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
			System.out.println("                   1.�����Ա��");
			System.out.println("                   2.ɾ����ְԱ��");
			System.out.println("                   3.�޸�Ա����Ϣ��");
			System.out.println("                   4.��ѯԱ����Ϣ ");
			System.out.println("                   5.�޸�����");
			System.out.println("                   6.�˳�");
			System.out.println("��ѡ��");
			int n = input.nextInt();
			String a3 = null;
			if(n==1) {
				do {
					addEmp();//�����Ա��
					System.out.println("����Ҫ������");
					a3 = input.next();
				} while(a3.equals("y"));
				a2="y";
			} else if(n==2) {
				do {
					deleteEmplog();//ɾ����ְԱ��
					System.out.println("����Ҫ������");
					a3 = input.next();
				} while(a3.equals("y"));
				a2="y";
			} else if(n==3) {
				do {
					modifyEmp();//�޸�Ա����Ϣ��
					System.out.println("����Ҫ������");
					a3 = input.next();
				} while(a3.equals("y"));
				a2="y";
			} else if(n==4) {
				do {
					queryEmp();//��ѯԱ����Ϣ
					System.out.println("����Ҫ������");
					a3 = input.next();
				} while(a3.equals("y"));
				a2="y";
			} else if(n==5) {
				do {
					modifyPwd(nowid);//�޸�����
					System.out.println("����Ҫ������");
					a3 = input.next();
				} while(a3.equals("y"));
				a2="y";
			} else if(n==6) {
				a2 = "n";//�˳�
				tag = true;
			} else {
				System.out.println("���ѡ�����������ѡ��!");
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
			System.out.println("                   1.��ѯ������Ϣ");
			System.out.println("                   2.�޸ĸ�������");
			System.out.println("                   3.�˳�");
			System.out.println("��ѡ��");
			int n = input.nextInt();
			String a3 = null;
			if(n==1) {
				do {
					queryEmpById(nowid);
					System.out.println("����Ҫ������");
					a3 = input.next();
				} while(a3.equals("y"));
				a2="y";
			} else if(n==2) {
				do {
					modifyPwd(nowid);//�޸�����
					System.out.println("����Ҫ������");
					a3 = input.next();
				} while(a3.equals("y"));
				a2="y";
			} else if(n==3) {
				a2 = "n";//�˳�
				tag = true;
			} else {
				System.out.println("���ѡ�����������ѡ��!");
				a2="y";
			}
		} while(a2.equals("y"));
		return tag;
	}
	public boolean login() {//��¼��ͨ�����ҹ��ź������Ƿ�����ж��Ƿ�ɹ���¼
		boolean tag = false;
		System.out.println("======================================================");
		System.out.println("                   Ա������ϵͳ                             ");
		System.out.println("======================================================");
		System.out.println("�����빤�ţ�");
		int inid = input.nextInt();
		System.out.println("���������룺");
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
                	
                	String name = queryEmpName(inid);//�ҵ�Ա������
                	int pos = queryPos(inid);//�ҵ�ְλ���
                	String pname = queryPosName(pos);//�ҵ�ְλ����
                	int dep = queryDep(pos);//�ҵ����ű��
                	String dname = queryDepName(dep);//�ҵ���������
                	System.out.println("��¼�ɹ�,��ӭ"+dname+pname+name+"!");
                	nowid = inid;
                	grade = pname;
                	nowdep = dep;
                	tag = true;
                } else {
                	System.out.println("��¼ʧ��,�����µ�¼!");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	    return tag;
	}
	public String queryEmpName(int id) {//ͨ�����Ų���Ա������
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
                	System.out.println("����ʧ��");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
		return name;
	}
	public int queryPos(int id) {//�ҵ�ְλ���
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
                	System.out.println("����ʧ��");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
		return ret;
	}
	public String queryPosName(int pos){//�ҵ�ְλ����
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
                	System.out.println("����ʧ��");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
		return name;
	}
	public int queryDep(int pos){//�ҵ����ű��
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
                	System.out.println("����ʧ��");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
		return ret;
	}
	public String queryDepName(int dep){//�ҵ���������
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
                	System.out.println("����ʧ��");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
		return name;
	}
	public void addEmp() {//�����Ա��
		System.out.println("������Ա����ţ�");
        int id = input.nextInt();
        System.out.println("������Ա��������");
        String name = input.next();
        System.out.println("������Ա���Ա�");
        String sex = input.next();
        System.out.println("������Ա�����᣺");
        String address = input.next();
        System.out.println("������Ա���绰��");
        String phone = input.next();
        System.out.println("������Ա����ְ���ڣ�");
        String data = input.next();
        System.out.println("������Ա��н�ʣ�");
        int wage = input.nextInt();
        System.out.println("��ѡ��Ա��ְλ��");
        showPos(nowdep);//��ʾ�ò���Ա��ְλ��Ϣ
        //������set��ְλ��Ŵ洢������Ȼ���ж������ְλ����Ƿ���set����
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
                    System.out.println("��ӳɹ���");
                    addEmplog(id,"123456");//����Ա�����ӽ���¼��Ϣ��
                }
            } catch (Exception e){
            	//�������д�ӡ�쳣��Ϣ�ڳ����г����λ�ü�ԭ��
                e.printStackTrace();
                //System.out.println("���ʧ��");
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
	public void deleteEmp(int id) {//ɾ����ְԱ��
		conn = bs.getConnection();
        if(conn!=null) {
        	String sql = "delete from emp where id=?";
        	try{
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,id);
				int num=pstmt.executeUpdate();
				if(num<=0)
				{
					System.out.println("ɾ��empʧ��!");
				}
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
	public void modifyEmp() {//�޸�Ա����Ϣ
		System.out.println("������Ҫ�޸ĵ�Ա�����ţ�");
        int id = input.nextInt();
        queryEmpById(id);
        System.out.println("�������޸ĺ��Ա��������");
        String name = input.next();
        System.out.println("�������޸ĺ��Ա���Ա�");
        String sex = input.next();
        System.out.println("�������޸ĺ��Ա�����᣺");
        String address = input.next();
        System.out.println("�������޸ĺ��Ա���绰��");
        String phone = input.next();
        System.out.println("�������޸ĺ��Ա����ְ���ڣ�");
        String data = input.next();
        System.out.println("�������޸ĺ��Ա��н�ʣ�");
        int wage = input.nextInt();
        System.out.println("��ѡ���޸ĺ��Ա��ְλ��");
        showPos(nowdep);//��ʾ�ò���Ա��ְλ��Ϣ
        //������set��ְλ��Ŵ洢������Ȼ���ж������ְλ����Ƿ���set����
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
                    System.out.println("�޸ĳɹ���");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
	public void queryEmp() {//��ѯԱ����Ϣ
		String a4 = null;
		do {
			a4 = "n";
			System.out.println("1��ͨ�����Ų�ѯ");
			System.out.println("2��ͨ��ְλ��ѯ");
			int n = input.nextInt();
			if(n == 1) {
				System.out.println("������Ҫ��ѯ�Ĳ��ű�ţ�");
				int id = input.nextInt();
				queryEmpByDep(id);
			} else if(n == 2) {
				System.out.println("������Ҫ��ѯ��ְλ��ţ�");
				int id = input.nextInt();
				//System.out.println("id\tname\tsex\taddress\tphone\tdata\twage\tepos");
				queryEmpByPos(id);
			} else {
				System.out.println("���ѡ�����������ѡ��!");
				a4="y";
			}
		}while(a4.equals("y"));
	}
	public void modifyPwd(int id) {//�޸�����
		System.out.println("�������޸ĺ�����룺");
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
					System.out.println("�޸ĳɹ�");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				bs.closeConn(conn, pstmt, rs);
			}
		}
	}
	public void showPos(int dep) {//��ʾ�ò���Ա��ְλ��Ϣ
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
	public void addEmplog(int id, String pwd) {//�����Ա�����˺�����
        conn = bs.getConnection();
        if(conn!=null) {
        	String sql = "insert into emplog values(?,?)";
        	try{
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                pstmt.setString(2, pwd);
                int num=pstmt.executeUpdate();
                if(num<=0) {
                    System.out.println("���emplogʧ��");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
	public void deleteEmplog() {//ɾ����ְԱ�����˺�����
		
		conn = bs.getConnection();
        if(conn!=null) {
        	String sql = "delete from emplog where id=?";
        	try{
        		int num = 0;
        		int id = 0;
        		do {
        			System.out.println("������Ҫɾ������ְԱ�����ţ�");
                    id = input.nextInt();
    				pstmt=conn.prepareStatement(sql);
    				pstmt.setInt(1,id);
    				num=pstmt.executeUpdate();
    				if(num<=0)System.out.println("�ù��Ų����ڣ����������룡");
        		} while(num<=0);
				if(num>0)
				{
					System.out.println("ɾ���ɹ�!");
					deleteEmp(id);//��ɾ�������������ɾ�����
				}
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
	public void queryEmpById(int id) {//ͨ�����Ų���Ա����Ϣ
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
                	System.out.println("����ʧ��");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                bs.closeConn(conn,pstmt,rs);
            }
        }
	}
	public void queryEmpByDep(int id) {//ͨ�����Ų���Ա����Ϣ
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
                	System.out.println("����ʧ��");
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
	public void queryEmpByPos(int id) {//ͨ��ְλ����Ա����Ϣ
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
