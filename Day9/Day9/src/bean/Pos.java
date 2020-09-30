package bean;

public class Pos {
	/*
	 * 职位信息
	 */
	private int pid;//职位编号
	private String pname;//职位名称
	private int pdep;//部门
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPdep() {
		return pdep;
	}
	public void setPdep(int pdep) {
		this.pdep = pdep;
	}
	
}
