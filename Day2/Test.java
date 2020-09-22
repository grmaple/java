import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//商品信息
		int[] gid=new int[10];//商品编号
		String[] game=new String[10];//商品名称
		String[] place=new String[10];//原产地
		double[] price=new double[10];//单价
		int[] number=new int[10];//库存
		String[] type=new String[10];//商品类型
		//用户信息
		int[] uid=new int[10];//账号
		String[] uname=new String[10];//用户名
		String[] password=new String[10];//密码
		double[] money=new double[10];//余额
		//购物清单
		int[] id=new int[10];//清单编号
		int[] goodid=new int[10];//商品编号
		//int[] userid=new int[10];//用户编号
		int[] num=new int[10];//商品数量
		int[] sum=new int[10];//小计

		//初始化数据
		//内置商品
		gid[0]=1;
		game[0]="TCL42吋液晶彩电";
		place[0]="CHINA";
		price[0]=2500;
		number[0]=50;
		type[0]="电器";

		gid[1]=2;
		game[1]="海尔节能电冰箱";
		place[1]="CHINA";
		price[1]=4500;
		number[1]=50;
		type[1]="电器";

		gid[2]=3;
		game[2]="李宁篮球鞋";
		place[2]="CHINA";
		price[2]=500;
		number[2]=50;
		type[2]="服饰";

		gid[3]=4;
		game[3]="乔丹10代球鞋";
		place[3]="USA";
		price[3]=1500;
		number[3]=20;
		type[3]="服饰";

		gid[4]=5;
		game[4]="山东烟台苹果";
		place[4]="CHINA";
		price[4]=5;
		number[4]=50;
		type[4]="水果";

		gid[5]=6;
		game[5]="美国红蛇果";
		place[5]="USA";
		price[5]=15;
		number[5]=20;
		type[5]="水果";
		//内置用户
		uid[0]=1001;
		uname[0]="admin";
		password[0]="123456";
		money[0]=1000;
		int goodsnum = 6;
		int usernum = 1;
		//商场主页
		System.out.println("------------------------------------------------------------");
		System.out.println("                        商城                                        ");
		System.out.println("------------------------------------------------------------");
		String an = "n";//记录是否登录
		char tag = 'z';//记录是否返回主界面
		while (true) {//主界面
			System.out.println("商品类型:");
			System.out.println("                            1.电器");
			System.out.println("                            2.水果");
			System.out.println("                            3.服饰");
			System.out.print("请选择:");
			int select = input.nextInt();
			if (select == 1) {//电器界面
				while (true) {
					System.out.println("编号\t名称\t\t原产地\t存库\t单价");
					for (int i = 0; i < goodsnum; i++) {
						if (type[i].equals("电器")) {
							System.out.print(gid[i]+"\t");
							System.out.print(game[i]+"\t");
							System.out.print(place[i]+"\t");
							System.out.print(number[i]+"\t");
							System.out.print(price[i]+"\n");
						}
					}
					System.out.println();
					System.out.print("请选择:");
					select = input.nextInt();
					if(!an.equals("y")) {
						System.out.println("您还没有登录，请登录或注册先!");
					}
					while (!an.equals("y")) {//登录注册
						System.out.println("---------------------------------------------------------");
						System.out.println("                               1.登录");
						System.out.println("                               2.注册");
						System.out.print("请选择:");
						int choose = input.nextInt();
						if (choose == 1) {//登录
							String loguname;
							String logpassword;
							System.out.print("请输入账号:");
							loguname = input.next();
							int loc = 0;
							int i = 0;
							// while (i<usernum) {
								// if (loguname.equals(uname[i])) {
									// loc = i;
									// break;
								// }
								// i++;
							// }
							for (int i = 0; i<usernum; i++) {
								if (loguname.equals(uname[i])) {
									loc = i;
									break;
								}
							}
							if (i == usernum) {
								System.out.println("账号不存在，请重新登录/注册");
								continue;
							}
							System.out.print("请输入密码:");
							logpassword = input.next();
							if (!logpassword.equals(password[loc])) {
								System.out.println("密码错误，请重新登录/注册");
								continue;
							}
							an="y";//已登录
							break;
						} else if (choose == 2) {//注册
							//int newuid;
							String newuname;
							String newpassword;
							double newmoney;
							boolean a = true;
							System.out.print("请输入账号:");
							newuname = input.next();
							for (int i = 0; i<usernum; i++) {
								if (newuname.equals(uname[i])) {
									System.out.println("账号已存在，请重新登录/注册");
									a = false;
									break;
								}
							}
							if (a == false) {
								continue;
							}
							System.out.print("请输入密码:");
							newpassword = input.next();
							if (newpassword.length() < 6) {
								System.out.println("密码长度过短，请重新登录/注册");
								continue;
							}
							System.out.print("请输入注册金额:");
							newmoney = input.nextDouble();
							
							if (newmoney < 100) {
								System.out.println("注册金额过低，请重新登录/注册");
								continue;
							}
							uname[usernum] = newuname;
							password[usernum] = newpassword;
							money[usernum] = newmoney;
							usernum++;
						} else {
							System.out.println("输入错误，请重新输入");
							continue;
						}
					}
				}
			}
		}
	}
}