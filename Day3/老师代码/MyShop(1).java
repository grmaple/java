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
				System.out.println("请问要继续购买"+typeName+"吗?");
				ap=input.next();
			}while(ap.equals("y"));
			System.out.println("请问要继续购物吗?");
			al=input.next();
		}while(al.equals("y"));
	}
}