package bean;

public class Computer
{
	/*
	 * ʵ����
	 */
	public double getRs(double m,double n,String oper)
	{
		//���һ�������з���ֵ������÷�����һʱ���������һ���͸÷�������ֵ������ͬ�ı���
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
