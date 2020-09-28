package demo;

import org.junit.Test;

import bean.Computer;

public class Demo
{
	/*
	 * MySql
	 * Navicat
	 * Junit使用
	 *        1.选中项目，右键找到build path
	 *        2.进入configure build path
	 *        3.进入lib,找到add lib
	 *        4.添加junit
	 *        5.方法名的上面加@Test
	 */
	@Test
	public void test01()
	{
		Computer c=new Computer();
		double s=c.getRs(5,2,"-");//调用一个有返回值的方法，需要声明一个和方法返回值类型相同的变量去接收!
		System.out.println(s);
	}
}
