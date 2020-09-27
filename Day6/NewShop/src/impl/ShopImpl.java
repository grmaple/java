package impl;
import java.util.Scanner;

import bean.Good;
import bean.GoodList;
import bean.User;

public class ShopImpl {
	//商城业务信息类
	Scanner input = new Scanner(System.in);
	//类作为数组中的元素，这些类没有实例化
	//数据类型[] 数组名 = new 数据类型[长度]
	Good[] gs = new Good[10];
	User[] us = new User[10];
	GoodList[] gl = new GoodList[10];
	
	String username = null;
	public void init() {
		for(int i = 0; i < 10; i++) {
			//实例化对象数组
			//对象名 = new 类()
			gs[i] = new Good();
			us[i] = new User();
			gl[i] = new GoodList();
		}
		//初始化
		gs[0].id = 1;
		gs[0].name = "TCL42吋液晶彩电";
		gs[0].place = "CHINA";
		gs[0].price = 2500;
		gs[0].num = 10;
		gs[0].type = "电器";
		
		gs[1].id = 2;
		gs[1].name = "海尔节能电冰箱";
		gs[1].place = "CHINA";
		gs[1].price = 2499;
		gs[1].num = 10;
		gs[1].type = "电器";
		
		gs[2].id = 3;
		gs[2].name = "李宁篮球鞋";
		gs[2].place = "CHINA";
		gs[2].price = 500;
		gs[2].num = 50;
		gs[2].type = "服饰";
		
		gs[3].id = 4;
		gs[3].name = "乔丹10代球鞋";
		gs[3].place = "USA";
		gs[3].price = 1500;
		gs[3].num = 20;
		gs[3].type = "服饰";
		
		gs[4].id = 5;
		gs[4].name = "山东烟台苹果";
		gs[4].place = "China";
		gs[4].price = 5;
		gs[4].num = 50;
		gs[4].type = "水果";
		
		gs[5].id = 6;
		gs[5].name = "美国红蛇果";
		gs[5].place = "USA";
		gs[5].price = 15;
		gs[5].num = 20;
		gs[5].type = "水果";
		//内置用户
		us[0].id=1001;
		us[0].name="admin";
		us[0].password="123456";
		us[0].money=1000;
	}
	public void show() {
		init();//show()需要调用init()
		System.out.println("======================================================");
		System.out.println("                   GD商城                             ");
		String ab=null;
		do {
			String al=null;
			do {
				String typeName=null;
				String an=null;
				do {
					an = "n";
					System.out.println("商品类型");
					System.out.println("                   1.电器");
					System.out.println("                   2.服饰");
					System.out.println("                   3.水果");
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
					} else if(m ==0) {
						
					} else
					{
						System.out.println("类型选择错误，请重新选择!");
						an="y";
					}
				}while(an.equals("y"));
				String ap=null;
				do {
					int p=0;
					do {
						an="n";
						showGood(typeName);
						System.out.println("请输入要购买的商品编号:");
						p = input.nextInt();
						if(username == null) {
							showUser();
						}
						boolean isFlag=checkGood(p,typeName);
						if(isFlag==false)
						{
							System.out.println("商品编号输入错误，请重新选择!");
							an="y";
						}
					}while(an.equals("y"));
					int n=0;//购买的数量
					do {
						an="n";
						System.out.println("请输入要购买的数量:");
						n=input.nextInt();
						boolean isFlag = checkNum(p,n);
						if(isFlag==true)
						{
							System.out.println("库存不足，请重新输入!");
							an="y";
							for(int i=0;i<10;i++)
							{
								if(gs[i].id!=0&&gs[i].id==p)
								{
									System.out.println(gs[i].id+"\t"+gs[i].name+"\t"+gs[i].place+"\t"+gs[i].price+"\t"+gs[i].num);
								}
							}
						}
					}while(an.equals("y"));
					boolean fg = checkBuy(p,n);
					if(fg==false)
					{
						for(int i=0;i<10;i++)
						{
							if(gl[i].gid==0)
							{
								gl[i].gid=p;
								gl[i].num=n;
								gl[i].uname=username;
								break;
							}
						}
					}
					System.out.println("请问要继续购买"+typeName+"吗?");
					ap=input.next();
				} while(ap.equals("y"));
				System.out.println("请问要继续购物吗?");
				al=input.next();
			}while(al.equals("y"));
			boolean fg2 = showList();
			if(fg2==false) {
				ab = "n";
			} else {
				ab = "y";
			}
		}while(ab.equals("y"));
	}
	public void showGood(String typeName) {
		//通过商品类型查询该商品
		System.out.println("编号\t名称\t\t产地\t单价\t库存");
		for(int i=0;i<10;i++)
		{
			if(gs[i].name!=null)
			{
				if(gs[i].type.equals(typeName))
				{
					System.out.println(gs[i].id+"\t"+gs[i].name+"\t"+gs[i].place+"\t"+gs[i].price+"\t"+gs[i].num);
				}
			}
		}
	}
	public boolean checkGood(int gid, String typeName) {
		//判断gid是否存在于通过typeName类型的商品中
		boolean isFlag = false;
		for(int i=0;i<10;i++)
		{
			if(gs[i].name!=null)
			{
				if(gs[i].type.equals(typeName))
				{
					if(gs[i].id==gid)
					{
						isFlag=true;
						break;
					}
				}
			}
		}
		return isFlag;
	}
	public void showUser() {
		System.out.println("您还没有登录，请登录或注册先!");
		String ap = null;
		do
		{
			ap="n";
			System.out.println("----------------------------------------------------");
			System.out.println("                       1.登录");
			System.out.println("                       2.注册");
			System.out.println("请选择:");
			int m=input.nextInt();
			if(m==1) {
				do {
					ap="n";
					System.out.println("请输入用户名:");
					String inName=input.next();
					System.out.println("请输入密  码:");
					String inPwd=input.next();
					boolean isFlag = login(inName,inPwd);
					if(isFlag)
					{
						username=inName;
						System.out.println("登录成功，欢迎用户"+username);
					}
					else
					{
						System.out.println("登录失败，请重新输入!");
						ap="y";
					}
				}while(ap.equals("y"));
			} else if (m==2) {
				register();
			} else {
				System.out.println("选择错误，请重新选择!");
				ap="y";
			}
		} while (ap.equals("y"));
	}
	public boolean checkName(String name) {
		//判断用户名是否可用
		boolean isFlag = false;
		for(int i=0;i<10;i++)
		{
			if(us[i].name!=null)
			{
				if(us[i].name.equals(name))
				{
					isFlag=true;
					break;
				}
			}
		}
		return isFlag;
	}
	public boolean login(String name, String pwd) {
		//登录
		boolean isFlag = false;
		for(int i=0;i<10;i++)
		{
			if(us[i].name!=null)
			{
				if(us[i].name.equals(name)&&us[i].password.equals(pwd))
				{
					isFlag=true;
					break;
				}
			}
		}
		
		return isFlag;
	}
	public void register() {
		//注册
		String ap =null;
		String name = null;
		do {
			ap="n";
			System.out.println("请输入用户名:");
			name=input.next();
			boolean isFlag = checkName(name);
			if(isFlag)
			{
				System.out.println("该用户名已被占用，请重新输入!");
			    ap="y";
			}
		} while(ap.equals("y"));
		String pwd = null;
		do {
			ap="n";
			System.out.println("请输入密码:");
			pwd=input.next();
			if(pwd.length()<6)
			{
				System.out.println("密码长度不能少于六位，请重新输入!");
				ap="y";
			}
		} while(ap.equals("y"));
		String confPwd=null;
		do
		{
			ap="n";
			System.out.println("请输入确认密码:");
			confPwd=input.next();
			if(!pwd.equals(confPwd))
			{
				System.out.println("确认密码和密码不一致，请重新输入!");
				ap="y";
			}
		}while(ap.equals("y"));
		double money=0;
		do
		{
			ap="n";
			System.out.println("请输入注册金额:");
			money=input.nextDouble();
			if(money<100)
			{
				System.out.println("注册金额不能低于100元，请输入冲入!");
				ap="y";
			}
		}while(ap.equals("y"));
		for(int j=0;j<10;j++)
		{
			if(us[j].id==0)
			{
				us[j].id=us[j-1].id+1;
				us[j].name=name;
				us[j].password=pwd;
				us[j].money=money;
				break;
			}
		}
		username=name;
		System.out.println("注册成功，欢迎新用户"+username);
	}
	public boolean checkNum(int gid, int num) {
		//检查商品库存是否充足
		boolean isFlag = false;
		for(int i=0;i<10;i++)
		{
			if(gs[i].id!=0&&gs[i].id==gid)
			{
				if(gs[i].num<num)
				{
					isFlag=true;
				}
				else
				{
					gs[i].num=gs[i].num-num;//库存减少
				}
			}
		}
		return isFlag;
	}
	public boolean checkBuy(int gid, int num) {
		//判断购买的商品是否在本次购物过程中已经买过
		boolean isFlag = false;
		for(int i=0;i<10;i++)
		{
			if(gl[i].gid!=0&&gl[i].gid==gid)//判断购买的商品是否在本次购物过程中已经买过
			{
				gl[i].num=gl[i].num+num;
				isFlag=true;
				break;
			}
		}
		return isFlag;
	}
	public boolean showList() {
		//显示购物清单
		boolean isFlag = false;
		System.out.println("------------------------购物清单-------------------------");
		double sum=0;
		System.out.println("编号\t名称\t\t产地\t单价\t数量\t小计");
		for(int i=0;i<10;i++)//外循环走的是已购买的商品信息
		{
			if(gl[i].gid!=0&&gl[i].uname.equals(username))
			{
				for(int j=0;j<10;j++)//内循环走的是商品信息
				{
					if(gl[i].gid==gs[j].id)
					{
						System.out.println(gl[i].gid+"\t"+gs[j].name+"\t"+gs[j].place+"\t"+gs[j].price+"\t"+gl[i].num+"\t"+gs[j].price*gl[i].num);
					    sum=sum+gs[j].price*gl[i].num;
					}
				}
			}
		}
		System.out.println("本次消费共计:"+sum+"确定付款吗?(y/n)");
		String ak=input.next();
		String as=null;
		do
		{
			if(ak.equals("y"))
			{
				for(int i=0;i<10;i++)
				{
					if(us[i].name!=null&&us[i].name.equals(username))
					{
						if(us[i].money<sum)
						{
							System.out.println("您的余额不足，请充值!");
							System.out.println("请输入充值金额:");
							double mq=input.nextDouble();
							us[i].money=us[i].money+mq;
							as="y";
						}
						else
						{
							us[i].money=us[i].money-sum;
							as="n";
							System.out.println("您的余额是:"+us[i].money);
							System.out.println("谢谢您的惠顾！");
							System.out.println("你要不要继续逛逛?(y/n)");
							String a1=input.next();
							if(a1.equals("y")) {
								isFlag = true;
							} else {
								isFlag = false;
							}
						}
					}
				}
			} else {
				System.out.println("那您继续逛逛呗！");
				as="n";
				isFlag = true;
			}
		}while(as.equals("y"));
		return isFlag;
	}
	
}
