/*
*	作    者：grmaple
*	版    本：01
*	增加功能：实现了单用户的商场系统，完成了电器部分
*	解决 bug：
*/
import java.util.Scanner;
public class Shop {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//商品信息
		String[] goods = new String[5];
		goods[0] = "1";//商品编号
		goods[1] = "TCL42吋液晶彩电";//名称
		goods[2] = "CHINA";//原产地
		goods[3] = "50";//库存
		goods[4] = "2459";//单价
		//用户信息
		String[] user = new String[3];
		user[0] = "admin";//账号
		user[1] = "123456";//密码
		user[2] = "100";//余额
		//购物清单
		String[] list = new String[4];
		list[0] = "";//商品编号
		list[1] = "";//名称
		list[2] = "0";//数量
		list[3] = "0";//小计
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
					for (int i = 0; i < 5; i++) {
						System.out.print(goods[i]+"\t");
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
							String[] log = new String[2];
							System.out.print("请输入账号:");
							log[0] = input.next();
							if (!log[0].equals(user[0])) {
								System.out.println("账号不存在，请重新登录/注册");
								continue;
							}
							System.out.print("请输入密码:");
							log[1] = input.next();
							if (!log[1].equals(user[1])) {
								System.out.println("密码错误，请重新登录/注册");
								continue;
							}
							an="y";//已登录
							break;
						} else if (choose == 2) {//注册
							String[] newuser = new String[3];
							System.out.print("请输入账号:");
							newuser[0] = input.next();
							if (newuser[0].equals(user[0])) {
								System.out.println("账号已存在，请重新登录/注册");
								continue;
							}
							System.out.print("请输入密码:");
							newuser[1] = input.next();
							if (newuser[1].length() < 6) {
								System.out.println("密码长度过短，请重新登录/注册");
								continue;
							}
							
							System.out.print("请输入注册金额:");
							newuser[2] = input.next();
							if (Integer.parseInt(newuser[2]) < 100) {
								System.out.println("注册金额过低，请重新登录/注册");
								continue;
							}
							user[0] = newuser[0];
							user[1] = newuser[1];
							user[1] = newuser[1];
						} else {
							System.out.println("输入错误，请重新输入");
							continue;
						}
					}

					if (select == 1) {//选择第一件商品
						System.out.print("请输入购买数量:");
						while (true) {
							int buynum = input.nextInt();
							if (buynum <= Integer.parseInt(goods[3])) {//购买数量小于库存
								//String转int进行加减法，然后int转String
								goods[3] = String.valueOf(Integer.parseInt(goods[3])-buynum);
								//买完东西，加入购物清单
								list[0] = goods[0];
								list[1] = goods[1];
								//原购买数量
								int oldnum = Integer.parseInt(list[2]);
								list[2] = String.valueOf(buynum+oldnum);
								//原小计
								int oldsum = Integer.parseInt(list[3]);
								list[3] = String.valueOf(Integer.parseInt(goods[4])*buynum + oldsum);
								//继续购物
								System.out.println("请问要继续购买电器吗? y/n");
								char c = input.next().charAt(0);
								if (c == 'y') {//跳转到电器界面
									break;
								} else {//
									System.out.println("请问要继续购物吗? y/n");
									tag = input.next().charAt(0);
									break;
								}
							} else {
								System.out.println("库存不足，请重新输入:");
								continue;
							}
						}
					} else {
						System.out.println("输入商品编号错误，请重新输入!");
						continue;
					}
					if (tag == 'y') {//跳转到主界面
						break;
					} else if (tag == 'n') {
						break;
					}
				}
				if (tag == 'n') {
					System.out.println("您的购物清单如下");
					System.out.println("编号\t名称\t\t数量\t小计");
					for (int i = 0; i < 4; i++) {
						System.out.print(list[i]+"\t");
					}
					System.out.println();
					System.out.println("总计:"+list[3]);
					System.out.println("请问现在结账吗？y/n");
					char check = input.next().charAt(0);
					if (check == 'y') {//结账
						if (Integer.parseInt(user[2]) >= Integer.parseInt(list[3])) {
							System.out.println("购买成功，欢迎再次光临！");
						} else {
							System.out.println("您的余额不足，请充值！");
						}
						break;
					} else {
						System.out.println("那您继续逛逛呗！");
						continue;
					}
				}
			} else if (select == 2) {
				System.out.println("该类型商品已经卖完了，请重新输入!");
				continue;
			} else if (select == 3) {
				System.out.println("该类型商品已经卖完了，请重新输入!");
				continue;
			} else {
				System.out.println("输入错误，无该类型商品，请重新输入!");
				continue;
			}
		} 
		
	}
}