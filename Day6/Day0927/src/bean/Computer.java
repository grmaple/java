package bean;

public class Computer
{
	/*
	 * 实体类
	 */
	public double getRs(double m,double n,String oper)
	{
		//如果一个方法有返回值，进入该方法第一时间可以声明一个和该方法返回值类型相同的变量
		double rs=0;
		if(oper.equals("+"))
		{
			rs=m+n;
		}
		else if(oper.equals("-"))
		{
			rs=m-n;
		}
		else if(oper.equals("*"))
		{
			rs=m*n;
		}
		else if(oper.equals("/"))
		{
			rs=m/n;
		}
		else
		{
			rs=m%n;
		}
		return rs;
	}
}
