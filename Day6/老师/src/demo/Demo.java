package demo;

import org.junit.Test;

import bean.Computer;

public class Demo
{
	/*
	 * MySql
	 * Navicat
	 * Junitʹ��
	 *        1.ѡ����Ŀ���Ҽ��ҵ�build path
	 *        2.����configure build path
	 *        3.����lib,�ҵ�add lib
	 *        4.���junit
	 *        5.�������������@Test
	 */
	@Test
	public void test01()
	{
		Computer c=new Computer();
		double s=c.getRs(5,2,"-");//����һ���з���ֵ�ķ�������Ҫ����һ���ͷ�������ֵ������ͬ�ı���ȥ����!
		System.out.println(s);
	}
}
