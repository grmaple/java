import java.util.Scanner;
public class MyShop
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		
		String username=null;//存储登录或注册成功的用户名
		//设计数据源信息
		int[] gid=new int[10];
		String[] game=new String[10];
		String[] place=new String[10];
		double[] price=new double[10];
		int[] num=new int[10];
		String[] type=new String[10];
		
		int[] uid=new int[10];
		String[] uame=new String[10];
		String[] uwd=new String[10];
		double[] money=new double[10];
		
		int[] bid=new int[20];//购买的商品编号
		int[] bum=new int[20];//购买的商品数量
		String[] bame=new String[20];//购买商品的用户
		
		//初始化数据
		gid[0]=1;
		game[0]="TCL42吋液晶彩电";
		place[0]="CHINA";
		price[0]=1499;
		num[0]=10;
		type[0]="电器";
		
		gid[1]=2;
		game[1]="海尔节能电冰箱";
		place[1]="CHINA";
		price[1]=2499;
		num[1]=10;
		type[1]="电器";
		
		gid[2]=3;
		game[2]="西门子绿色洗衣机";
		place[2]="GERMANY";
		price[2]=5499;
		num[2]=5;
		type[2]="电器";
		
		uid[0]=1001;
		uame[0]="admin";
		uwd[0]="123456";
		money[0]=1000;
		
		System.out.println("======================================================");
		System.out.println("                   JD商城                             ");
		String al=null;
		do
		{
			String typeName=null;
			String an=null;
			do
			{
				an="n";
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
				}
				else
				{
					System.out.println("类型选择错误，请重新选择!");
					an="y";
				}
			}while(an.equals("y"));
			String ap=null;
			do
			{
				int p=0;//购买的商品编号
				do
				{
					an="n";
					System.out.println("编号\t名称\t\t产地\t单价\t库存");
					for(int i=0;i<10;i++)
					{
						if(game[i]!=null)
						{
							if(type[i].equals(typeName))
							{
								System.out.println(gid[i]+"\t"+game[i]+"\t"+place[i]+"\t"+price[i]+"\t"+num[i]);
							}
						}
					}
					System.out.println("请输入要购买的商品编号:");
					p=input.nextInt();
					if(username==null)
					{
						System.out.println("您还没有登录，请登录或注册先!");
						do
						{
							ap="n";
							System.out.println("----------------------------------------------------");
							System.out.println("                       1.登录");
							System.out.println("                       2.注册");
							System.out.println("请选择:");
							int a=input.nextInt();
							if(a==1)
							{
								do
								{
									ap="n";
									boolean flag=false;
									System.out.println("请输入用户名:");
									String inName=input.next();
									System.out.println("请输入密  码:");
									String inPwd=input.next();
									for(int i=0;i<10;i++)
									{
										if(uame[i]!=null)
										{
											if(uame[i].equals(inName)&&uwd[i].equals(inPwd))
											{
												flag=true;
												break;
											}
										}
									}
									if(flag)
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
							}
							else if(a==2)
							{
								String inName=null;
								do
								{
									ap="n";
									boolean flag=false;
									System.out.println("请输入用户名:");
									inName=input.next();
									for(int i=0;i<10;i++)
									{
										if(uame[i]!=null)
										{
											if(uame[i].equals(inName))
											{
												flag=true;
												break;
											}
										}
									}
									if(flag)
									{
										System.out.println("该用户名已被占用，请重新输入!");
									    ap="y";
									}
								}while(ap.equals("y"));
								String inPwd=null;
								do
								{
									ap="n";
									System.out.println("请输入密码:");
									inPwd=input.next();
									if(inPwd.length()<6)
									{
										System.out.println("密码长度不能少于六位，请重新输入!");
										ap="y";
									}
								}while(ap.equals("y"));
								String confPwd=null;
								do
								{
									ap="n";
									System.out.println("请输入确认密码:");
									confPwd=input.next();
									if(!inPwd.equals(confPwd))
									{
										System.out.println("确认密码和密码不一致，请重新输入!");
										ap="y";
									}
								}while(ap.equals("y"));
								double inMoney=0;
								do
								{
									ap="n";
									System.out.println("请输入注册金额:");
									inMoney=input.nextDouble();
									if(inMoney<100)
									{
										System.out.println("注册金额不能低于100元，请输入冲入!");
										ap="y";
									}
								}while(ap.equals("y"));
								for(int j=0;j<10;j++)
								{
									if(uid[j]==0)//找到第一个uid值为0的即可
									{
										uid[j]=uid[j-1]+1;
										uame[j]=inName;
										uwd[j]=inPwd;
										money[j]=inMoney;
										break;
									}
								}
								username=inName;
								System.out.println("注册成功，欢迎新用户"+username);
							}
							else
							{
								System.out.println("选择错误，请重新选择!");
								ap="y";
							}
						}while(ap.equals("y"));
					}
					boolean isFlag=false;
					for(int i=0;i<10;i++)
					{
						if(game[i]!=null)
						{
							if(type[i].equals(typeName))
							{
								if(gid[i]==p)
								{
									isFlag=true;
									break;
								}
							}
						}
					}
					if(isFlag==false)
					{
						System.out.println("商品编号输入错误，请重新选择!");
						an="y";
					}
				}while(an.equals("y"));
				int n=0;//购买的数量
				do
				{
					an="n";
					boolean isFlag=false;
					System.out.println("请输入要购买的数量:");
					n=input.nextInt();
					for(int i=0;i<10;i++)
					{
						if(gid[i]!=0&&gid[i]==p)
						{
							if(num[i]<n)
							{
								isFlag=true;
							}
							else
							{
								num[i]=num[i]-n;//库存减少
							}
						}
					}
					if(isFlag==true)
					{
						System.out.println("库存不足，请重新输入!");
						an="y";
						for(int i=0;i<10;i++)
						{
							if(gid[i]!=0&&gid[i]==p)
							{
								System.out.println(gid[i]+"\t"+game[i]+"\t"+place[i]+"\t"+price[i]+"\t"+num[i]);
							}
						}
					}
				}while(an.equals("y"));
				boolean fg=false;
				for(int i=0;i<20;i++)
				{
					/*
					 *存储已购买的商品信息
					 */
					if(bid[i]!=0&&bid[i]==p)//判断购买的商品是否在本次购物过程中已经买过
					{
						bum[i]=bum[i]+n;
						fg=true;
						break;
					}
				}
				if(fg==false)
				{
					for(int i=0;i<20;i++)
					{
						if(bid[i]==0)
						{
							bid[i]=p;
							bum[i]=n;
							bame[i]=username;
							break;
						}
					}
				}
				System.out.println("请问要继续购买"+typeName+"吗?");
				ap=input.next();
			}while(ap.equals("y"));
			System.out.println("请问要继续购物吗?");
			al=input.next();
		}while(al.equals("y"));
		System.out.println("------------------------购物清单-------------------------");
		double sum=0;
		System.out.println("编号\t名称\t\t产地\t单价\t数量\t小计");
		for(int i=0;i<20;i++)//外循环走的是已购买的商品信息
		{
			if(bid[i]!=0&&bame[i].equals(username))
			{
				for(int j=0;j<10;j++)//内循环走的是商品信息
				{
					if(bid[i]==gid[j])
					{
						System.out.println(bid[i]+"\t"+game[j]+"\t"+place[j]+"\t"+price[j]+"\t"+bum[i]+"\t"+price[j]*bum[i]);
					    sum=sum+price[j]*bum[i];
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
					if(uame[i]!=null&&uame[i].equals(username))
					{
						if(money[i]<sum)
						{
							System.out.println("您的余额不足，请充值!");
							System.out.println("请输入充值金额:");
							double mq=input.nextDouble();
							money[i]=money[i]+mq;
							as="y";
						}
						else
						{
							money[i]=money[i]-sum;
							as="n";
							System.out.println("您的余额是:"+money[i]);
						}
					}
				}
			}
		}while(as.equals("y"));
	}
}