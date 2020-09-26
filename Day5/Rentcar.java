/*
 *	作    者:grample
 *	版    本：01
 *	增加功能：
 *	解决 bug：
 */
import java.util.Scanner;
public class Rentcar {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String username=null;//存储租车资格验证通过的用户身份证
		//设计数据源信息
		//车辆信息
		int[] cid=new int[10];//编号
		String[] cname=new String[10];//名称
		double[] cdep=new double[10];//押金
		double[] cpri=new double[10];//日租金
		int[] cnum=new int[10];//库存
		double[] clat=new double[10];//滞纳金
		String[] ctype=new String[10];//类型
		//用户信息
		int[] uid=new int[10];//用户id
		String[] uname=new String[10];//用户身份证
		String[] udriver=new String[10];//用户驾驶证
		String[] uphone=new String[10];//用户电话号码
		//清单信息
		int[] bid=new int[20];//租赁的汽车编号
		int[] bnum=new int[20];//租赁的汽车数量
		String[] bname=new String[20];//租赁汽车的用户
		String[] bdata1=new String[10];//租车日期
		String[] bdata2=new String[10];//还车日期
		//内置用户
		uid[0]=1001;
		uname[0]="123456789123456789";
		udriver[0]="10000";
		uphone[0]=null;
		
		uid[1]=1002;
		uname[1]="123456789123456780";
		udriver[1]=null;
		uphone[1]=null;
		//内置汽车
		cid[0]=1;
		cname[0]="宝马";
		cdep[0]=6000;
		cpri[0]=400;
		cnum[0]=2;
		clat[0]=800;
		ctype[0]="轿车";
		
		cid[1]=2;
		cname[1]="奔驰";
		cdep[1]=5000;
		cpri[1]=300;
		cnum[1]=5;
		clat[1]=600;
		ctype[1]="轿车";
		
		cid[2]=3;
		cname[2]="丰田";
		cdep[2]=4000;
		cpri[2]=200;
		cnum[2]=10;
		clat[2]=400;
		ctype[2]="轿车";
		
		cid[3]=4;
		cname[3]="本田";
		cdep[3]=3000;
		cpri[3]=100;
		cnum[3]=10;
		clat[3]=200;
		ctype[3]="轿车";
		
		cid[4]=5;
		cname[4]="金龙";
		cdep[4]=4500;
		cpri[4]=250;
		cnum[4]=2;
		clat[4]=500;
		ctype[4]="客车";
		
		cid[5]=6;
		cname[5]="金杯";
		cdep[5]=3500;
		cpri[5]=150;
		cnum[5]=2;
		clat[5]=300;
		ctype[5]="客车";
		
		System.out.println("------------------------------------------------------------");
		System.out.println("                              汽车租赁系统");
		System.out.println("------------------------------------------------------------");
		String a7=null;
		do {
			a7 = "n";
			String a1=null;
			do {//租车主界面
				String typeName = null;
				String a2 = null;
				do {//车辆类型界面
					a2 = "n";//一开始设置不循环
					System.out.println("------------------------------------------------------------");
					System.out.println("车辆类型：");
					System.out.println("                              1.轿车");
					System.out.println("                              2.客车");
					System.out.println("------------------------------------------------------------");
					System.out.println("请选择您需要选择的车辆类型:");
					int i1=input.nextInt();
					if (i1 == 1) {
						typeName = "轿车";
					} else if (i1 == 2) {
						typeName = "客车";
					} else {//输入错误，循环
						System.out.println("类型选择错误，请重新选择!");
						a2="y";
					}
				} while(a2.equals("y"));
				String a3 = null;
				do {//车辆详情界面
					int i2 = 0;//租赁的车辆编号
					String a4 = null;
					do {//输入租赁车辆编号
						a4 = "n";
						System.out.println("编号\t名称\t押金\t日租金\t库存\t滞纳金");
						for(int i=0;i<10;i++)
						{
							if(cname[i]!=null)
							{
								if(ctype[i].equals(typeName))
								{
									System.out.println(cid[i]+"\t"+cname[i]+"\t"+cdep[i]+"\t"+cpri[i]+"\t"+cnum[i]+"\t"+clat[i]);
								}
							}
						}
						System.out.println("请选择您需要选择的车辆编号：");
						i2=input.nextInt();
						if(username==null) {//驾驶资格验证
							System.out.println("您还没有通过驾驶资格验证，请先验证!");
							//String a9 = null;
							while(true) {
								//a9 = "n";
								boolean flag=false;
								System.out.println("请输入您的身份证：");
								String inName=input.next();
								int i=0;
								for(;i<10;i++) {
									if(uname[i]!=null) {
										if(uname[i].equals(inName)) {
											flag=true;
											break;
										}
									}
								}
								if(!flag) {
									System.out.println("你输入的身份证不存在，请重新输入！");
									//a9="y";
									continue;
								} else {//身份证存在
									if(uname[i].equals(inName) && udriver[i]!=null) {//有驾驶证
										System.out.println("经过检验，您的驾驶证是："+udriver[i]);
									} else {
										System.out.println("经过检验，没有查找到您的驾驶证，请重新输入！");
										//a9="y";
										continue;
									}
								}
								System.out.println("请输入您的电话号码：");
								String inPho=input.next();
								uphone[i] = inPho;
								System.out.println("恭喜你，你通过租车资格验证！");
								username = inName;
								break;
							} 
						}
						boolean isFlag=false;
						for(int i=0;i<10;i++) {
							if(cname[i]!=null) {
								if(ctype[i].equals(typeName)) {
									if(cid[i]==i2) {//选中的编号存在
										isFlag=true;
										break;
									}
								}
							}
						}
						if(isFlag==false) {//编号错误，重新输入
							System.out.println("车辆编号输入错误，请重新选择!");
							a4="y";
						}
					} while(a4.equals("y"));
					int i3 = 0;//租赁的数量
					String a5 = null;
					do {//输入租赁数量
						a5 = "n";
						boolean isFlag = false;
						System.out.println("请选择请输入您的租赁数量：");
						i3 = input.nextInt();
						for(int i=0; i<10; i++) {
							if(cid[i]!=0 && cid[i]==i2) {
								if(cnum[i]<i3) {
									isFlag = true;//库存不足
								} else {
									cnum[i] = cnum[i] - i3;//库存减少
								}
							}
						}
						//System.out.println(cnum[i2-1]+"test"+isFlag);
						if(isFlag == true) {
							System.out.println("库存不足，请重新输入！");
							a5 = "y";
							for(int i=0; i<10; i++) {
								if(cid[i]!=0 && cid[i]==i2) { 
									System.out.println(cid[i]+"\t"+cname[i]+"\t"+cdep[i]+"\t"+cpri[i]+"\t"+cnum[i]+"\t"+clat[i]);
								}
							}
						}
					} while(a5.equals("y"));
					boolean fg = false;
					//加入清单
					for(int i=0; i<10; i++) {
						if(bid[i]!=0 && bid[i] == i2) {//重复汽车
							bnum[i] = bnum[i] + i3;
							fg = true;
							break;
						}
					}
					if(fg == false) {//新选择的汽车
						for(int i=0; i<10; i++) {
							if(bnum[i] == 0) {//找到第一个空的位置插入
								bid[i] = i2;
								bnum[i] = i3;
								bname[i]=username;
								break;
							}
						}
					}
					System.out.println("请问要继续租赁"+typeName+"吗?(y/n)");
					a3=input.next();
				} while(a3.equals("y"));
				System.out.println("请问要继续租赁吗?(y/n)");
				a1=input.next();
			} while(a1.equals("y"));
			System.out.println("------------------------------------------------------------");
			System.out.println("                              租车清单");
			double depsum = 0;//押金共计
			double prisum = 0;//租金共计
			System.out.println("编号\t名称\t数量\t押金\t日租金\t租车日期\t还车日期\t小计\t滞纳金");
			for(int i=0;i<20; i++) {
				if(bid[i]!=0 && bname[i].equals(username)) {
					for(int j=0; j<10; j++) {
						if(bid[i]==cid[j]) {
							System.out.println(bid[i]+"\t"+cname[j]+"\t"+bnum[i]+"\t"+cdep[j]+"\t"+cpri[j]+"\t"+cpri[j]*bnum[i]+"\t"+clat[j]);
							depsum = depsum+cdep[j];
							prisum = prisum+cpri[j]*bnum[i];
						}
					}
				}
			}
			System.out.println("押金合计："+depsum);
			System.out.println("租金合计："+prisum);
			System.out.println("合计："+(prisum+depsum));
			System.out.println("请问要付款吗?(y/n)：");
			String a6=input.next();
			if(a6.equals("y")) {
				System.out.println("谢谢您的惠顾，请问要继续租车吗?(y/n):");
				String a8=input.next();
				if (a8.equals("y")) {
					a7="y";
				}
			} else {
				System.out.println("那您先继续逛逛！");
				a7="y";
			}
		} while(a7.equals("y"));
		
	}
}