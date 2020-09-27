package impl;

import java.util.Scanner;

import bean.Good;
import bean.GoodList;
import bean.User;

public class ShopImpl
{
	/*
	 * 商城业务信息类
	 * 类:属性和方法
	 * 对象数组:用类作为数组的数据类型，数组中的每个元素都是这个类的对象，但是这些对象都是没有实例化的
	 */
	Scanner input=new Scanner(System.in);
	String username=null;//存储登录或注册成功的用户名
	
	Good[] gs=new Good[10];//数据类型[] 数组名=new 数据类型[长度]
	User[] us=new User[10];
	GoodList[] gl=new GoodList[10];
	
	public void init()
	{
		//实例化
		for(int i=0;i<10;i++)
		{
			gs[i]=new Good();//对象名=new 类();
			us[i]=new User();
			gl[i]=new GoodList();
		}
		
		//初始化
		gs[0].id=1;
		gs[0].name="TCL42吋液晶彩电";
		gs[0].place="中国";
		gs[0].price=1499;
		gs[0].num=10;
		gs[0].type="电器";
	}
	
	public void show()
	{
		init();
		System.out.println("====================================================");
		System.out.println("                   广大商城");
		String an=null;
		String typeName=null;
		do
		{
			an="n";
			System.out.println("商品类型");
			System.out.println("                    1.电器");
			System.out.println("                    2.服饰");
			System.out.println("                    3.水果");
			System.out.println("请选择:");
			int m=input.nextInt();
			if(m==1)
			{
				typeName="电器";
			}
			else if(m==2)
			{
				typeName="服饰";
			}
			else if(m==3)
			{
				typeName="水果";
			}
			else
			{
				an="y";
			}
		}while(an.equals("y"));
		showGood(typeName);
		System.out.println("请输入要购买的商品编号:");
		int p=input.nextInt();
		if(username==null)
		{
			System.out.println("您还没有登录，请登录或注册先!");
			showUser();
		}
	}
	
	public void showGood(String typeName)
	{
		/*
		 * 通过商品类型查询该类型的商品
		 */
	}
	
	public boolean checkGood(int gid,String typeName)
	{
		/*
		 * 判断gid是否存在于typeName类型的商品中
		 */
		boolean isFlag=false;
		
		return isFlag;
	}
	
	public void showUser()
	{
		System.out.println("----------------------------------------------");
		System.out.println("                    1.登录");
		System.out.println("                    2.注册");
		System.out.println("请选择:");
		int m=input.nextInt();
		if(m==1)
		{
			System.out.println("请输入用户名:");
			String name=input.next();
			System.out.println("请输入密    码:");
			String pwd=input.next();
			boolean isFlag=login(name,pwd);
		}
		else if(m==2)
		{
			System.out.println("请输入用户名:");
			String name=input.next();
			checkName(name);
		}
		else
		{
			
		}
	}
	
	public boolean checkName(String name)
	{
		/*
		 * 判断用户名是否可用
		 */
		boolean isFlag=false;
		
		return isFlag;
	}
	
	public boolean login(String name,String pwd)
	{
		/*
		 * 登录
		 */
		boolean isFlag=false;
		
		return isFlag;
	}
	
	
	public void register()
	{
		/*
		 * 注册
		 */
	}
	
	public boolean checkNum(int gid,int num)
	{
		/*
		 * 检查商品库存是否充足
		 */
		boolean isFlag=false;
		
		return isFlag;
	}
	
	public void showList()
	{
		/*
		 * 显示用户的小票信息
		 */
	}
	
	public boolean checkMoney(double sum)
	{
		/*
		 * 判断用户余额是否充足
		 */
		boolean isFlag=false;
		
		return isFlag;
	}
}
