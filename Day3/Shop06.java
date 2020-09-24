/*
*	版    本：06
*	增加功能：
*	解决 bug：购买0个物品的bug
*/
import java.util.Scanner;
public class Shop06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//商品信息
		int[] gid=new int[10];//商品编号
		String[] game=new String[10];//商品名称
		String[] place=new String[10];//原产地
		int[] price=new int[10];//单价
		int[] number=new int[10];//库存
		String[] type=new String[10];//商品类型
		//用户信息
		//int[] uid=new int[10];//账号
		String[] uname=new String[10];//用户名
		String[] password=new String[10];//密码
		int[] money=new int[10];//余额
		//购物清单
		int[] id=new int[10];//清单编号
		int[] goodid=new int[10];//商品编号
		String[] goodname=new String[10];//商品名称
		int[] goodpri=new int[10];//商品单价
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
		//uid[0]=1001;
		uname[0]="admin";
		password[0]="123456";
		money[0]=1000;
		
		int elenum = 2;//电器总数
		int clonum = 2;//服饰总数
		int frunum = 2;//水果总数
		int goodsnum = 6;//商品总数
		int usernum = 1;//用户总数
		int listnum = 0;//清单总数
		int allsum =0;//总计
		int loc = 0;//记录当前是哪个账户登录
		String an = "n";//记录是否登录
		while (true) {//主界面
			System.out.println("------------------------------------------------------------");
			System.out.println("                              商城                          ");
			System.out.println("------------------------------------------------------------");
			System.out.println("商品类型:");
			System.out.println("                            1.电器");
			System.out.println("                            2.水果");
			System.out.println("                            3.服饰");
			System.out.println("11.购物清单");
			System.out.println("0 .退出商城");
			System.out.println("------------------------------------------------------------");
			System.out.print("请选择:");
			int select = input.nextInt();
			if (select == 1) {//电器界面
				char tag = 'z';//记录是否返回主界面
				while (true) {
					System.out.println("------------------------------------------------------------");
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
					System.out.println("0.返回主界面");
					System.out.println();
					System.out.print("请选择:");
					int select2 = input.nextInt();
					if (select2 == 0){
						break;
					}
					if(!an.equals("y")) {
						System.out.println("您还没有登录，请登录或注册先!");
					}
					while (!an.equals("y")) {//登录注册
						System.out.println("------------------------------------------------------------");
						System.out.println("                               1.登录");
						System.out.println("                               2.注册");
						System.out.print("请选择:");
						int choose = input.nextInt();
						if (choose == 1) {//登录
							String loguname;
							String logpassword;
							System.out.print("请输入用户名:");
							loguname = input.next();
							int i = 0;
							while (i<usernum) {
								if (loguname.equals(uname[i])) {
									loc = i;
									break;
								}
								i++;
							}
							if (i == usernum) {
								System.out.println("账号不存在，请重新登录/注册");
								continue;
							}
							System.out.print("请输入密  码:");
							logpassword = input.next();
							if (!logpassword.equals(password[loc])) {
								System.out.println("密码错误，请重新登录/注册");
								continue;
							}
							System.out.println("登录成功，欢迎回来！");
							an="y";//已登录
							break;
						} else if (choose == 2) {//注册
							//int newuid;
							String newuname;
							String newpassword;
							int newmoney;
							boolean a = true;
							System.out.print("请输入用户名:");
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
							System.out.print("请输入密  码:");
							newpassword = input.next();
							if (newpassword.length() < 6) {
								System.out.println("密码长度过短，请重新登录/注册");
								continue;
							}
							System.out.print("请输入注册金额:");
							newmoney = input.nextInt();
							
							if (newmoney < 100) {
								System.out.println("注册金额过低，请重新登录/注册");
								continue;
							}
							uname[usernum] = newuname;
							password[usernum] = newpassword;
							money[usernum] = newmoney;
							usernum++;
							System.out.println("注册成功，欢迎加入！");
						} else {
							System.out.println("输入错误，请重新输入");
							continue;
						}
					}
					if (select2>0 && select2<=goodsnum) {
						int pos = select2-1;
						if (!type[pos].equals("电器")) {//在电器界面，输入了其他商品的编号
							System.out.println("输入商品编号错误，请重新输入2!");
							continue;//重新输入
						}
						System.out.print("请输入购买数量:");
						while (true) {
							int buynum = input.nextInt();
							if (buynum > 0 && buynum <= number[pos]) {//购买数量小于库存
								number[pos] = number[pos]-buynum;
								//买完东西，加入购物清单
								int i = 0;
								while (i<listnum) {//在原有数据中添加
									if (gid[pos] == goodid[i]) {
										num[i] += buynum;
										sum[i] += buynum*price[pos];
										break;
									}
									i++;
								}
								if (i == listnum) {//新数据
									id[listnum] = listnum+1;
									goodid[listnum] = gid[pos];
									goodname[listnum] = game[pos];
									num[listnum] = buynum;
									goodpri[listnum] = price[pos];
									sum[listnum] = buynum*price[pos];
									listnum++;
								}
								//继续购物
								System.out.println("请问要继续购买电器吗? y/n");
								char c = input.next().charAt(0);
								if (c == 'y') {//跳转到电器界面
									break;
								} else if (c == 'n') {
									System.out.println("请问要继续购物吗? y/n");
									tag = input.next().charAt(0);
									break;
								}
							} else if (buynum == 0) {//买0个
								break;
							} else {
								System.out.println("现有"+number[pos]+"个"+goodname[pos]);
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
					System.out.println("------------------------------------------------------------");
					allsum = 0;
					System.out.println("您的购物清单如下");
					System.out.println("编号\t名称\t\t数量\t单价\t小计");
					for (int i = 0; i < listnum; i++) {
							System.out.print(id[i]+"\t");
							System.out.print(goodname[i]+"\t");
							System.out.print(num[i]+"\t");
							System.out.print(goodpri[i]+"\t");
							System.out.print(sum[i]+"\n");
							allsum = allsum+sum[i];
					}
					System.out.println();
					System.out.println("总计:"+allsum);
					System.out.println("您现在的余额是"+money[loc]);
					System.out.println("请问现在结账吗？y/n");
					char check = input.next().charAt(0);
					if (check == 'y') {//结账
						if (money[loc] >= allsum) {
							money[loc] -= allsum;
							System.out.println("购买成功，本次消费共计"+allsum+"，您的余额是"+money[loc]+"!");
							listnum = 0;//购物清单清空
						} else {
							System.out.println("您的余额不足，请充值！");
							System.out.print("请输入充值金额：");
							int mon = input.nextInt();
							money[loc] += mon;
							System.out.println("充值成功！");
							//money[loc] -= allsum;
							//System.out.println("购买成功，本次消费共计"+allsum+"，您的余额是"+money[loc]+"!");
						}
						continue;
					} else {
						System.out.println("那您继续逛逛呗！");
						continue;
					}
				}
			} else if (select == 2) {//水果界面
				char tag = 'z';//记录是否返回主界面
				while (true) {
					System.out.println("------------------------------------------------------------");
					System.out.println("编号\t名称\t\t原产地\t存库\t单价");
					for (int i = 0; i < goodsnum; i++) {
						if (type[i].equals("水果")) {
							System.out.print(gid[i]+"\t");
							System.out.print(game[i]+"\t");
							System.out.print(place[i]+"\t");
							System.out.print(number[i]+"\t");
							System.out.print(price[i]+"\n");
						}
					}
					System.out.println("0.返回主界面");
					System.out.println();
					System.out.print("请选择:");
					int select2 = input.nextInt();
					if (select2 == 0){
						break;
					}
					if(!an.equals("y")) {
						System.out.println("您还没有登录，请登录或注册先!");
					}
					while (!an.equals("y")) {//登录注册
						System.out.println("------------------------------------------------------------");
						System.out.println("                               1.登录");
						System.out.println("                               2.注册");
						System.out.print("请选择:");
						int choose = input.nextInt();
						if (choose == 1) {//登录
							String loguname;
							String logpassword;
							System.out.print("请输入用户名:");
							loguname = input.next();
							int i = 0;
							while (i<usernum) {
								if (loguname.equals(uname[i])) {
									loc = i;
									break;
								}
								i++;
							}
							if (i == usernum) {
								System.out.println("账号不存在，请重新登录/注册");
								continue;
							}
							System.out.print("请输入密  码:");
							logpassword = input.next();
							if (!logpassword.equals(password[loc])) {
								System.out.println("密码错误，请重新登录/注册");
								continue;
							}
							System.out.println("登录成功，欢迎回来！");
							an="y";//已登录
							break;
						} else if (choose == 2) {//注册
							//int newuid;
							String newuname;
							String newpassword;
							int newmoney;
							boolean a = true;
							System.out.print("请输入用户名:");
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
							System.out.print("请输入密  码:");
							newpassword = input.next();
							if (newpassword.length() < 6) {
								System.out.println("密码长度过短，请重新登录/注册");
								continue;
							}
							System.out.print("请输入注册金额:");
							newmoney = input.nextInt();
							
							if (newmoney < 100) {
								System.out.println("注册金额过低，请重新登录/注册");
								continue;
							}
							uname[usernum] = newuname;
							password[usernum] = newpassword;
							money[usernum] = newmoney;
							usernum++;
							System.out.println("注册成功，欢迎加入！");
						} else {
							System.out.println("输入错误，请重新输入");
							continue;
						}
					}
					if (select2>0 && select2<=goodsnum) {
						int pos = select2-1;
						if (!type[pos].equals("水果")) {//在水果界面，输入了其他商品的编号
							System.out.println("输入商品编号错误，请重新输入!");
							continue;//重新输入
						}
						System.out.print("请输入购买数量:");
						while (true) {
							int buynum = input.nextInt();
							if (buynum > 0 && buynum <= number[pos]) {//购买数量小于库存
								number[pos] = number[pos]-buynum;
								//买完东西，加入购物清单
								int i = 0;
								while (i<listnum) {//在原有数据中添加
									if (gid[pos] == goodid[i]) {
										num[i] += buynum;
										sum[i] += buynum*price[pos];
										break;
									}
									i++;
								}
								if (i == listnum) {//新数据
									id[listnum] = listnum+1;
									goodid[listnum] = gid[pos];
									goodname[listnum] = game[pos];
									num[listnum] = buynum;
									goodpri[listnum] = price[pos];
									sum[listnum] = buynum*price[pos];
									listnum++;
								}
								//继续购物
								System.out.println("请问要继续购买水果吗? y/n");
								char c = input.next().charAt(0);
								if (c == 'y') {//跳转到水果界面
									break;
								} else if (c == 'n') {
									System.out.println("请问要继续购物吗? y/n");
									tag = input.next().charAt(0);
									break;
								}
							} else if (buynum == 0) {//买0个
								break;
							} else {
								System.out.println("现有"+number[pos]+"个"+goodname[pos]);
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
					System.out.println("------------------------------------------------------------");
					allsum = 0;
					System.out.println("您的购物清单如下");
					System.out.println("编号\t名称\t\t数量\t小计");
					for (int i = 0; i < listnum; i++) {
							System.out.print(id[i]+"\t");
							System.out.print(goodname[i]+"\t");
							System.out.print(num[i]+"\t");
							System.out.print(sum[i]+"\n");
							allsum = allsum+sum[i];
					}
					System.out.println();
					System.out.println("总计:"+allsum);
					System.out.println("您现在的余额是"+money[loc]);
					System.out.println("请问现在结账吗？y/n");
					char check = input.next().charAt(0);
					if (check == 'y') {//结账
						if (money[loc] >= allsum) {
							money[loc] -= allsum;
							System.out.println("购买成功，本次消费共计"+allsum+"，您的余额是"+money[loc]+"!");
							listnum = 0;//购物清单清空
						} else {
							System.out.println("您的余额不足，请充值！");
							System.out.print("请输入充值金额：");
							int mon = input.nextInt();
							money[loc] += mon;
							System.out.println("充值成功！");
						}
						continue;
					} else {
						System.out.println("那您继续逛逛呗！");
						continue;
					}
				}
			} else if (select == 3) {//服饰界面
				char tag = 'z';//记录是否返回主界面
				while (true) {
					System.out.println("------------------------------------------------------------");
					System.out.println("编号\t名称\t\t原产地\t存库\t单价");
					for (int i = 0; i < goodsnum; i++) {
						if (type[i].equals("服饰")) {
							System.out.print(gid[i]+"\t");
							System.out.print(game[i]+"\t");
							System.out.print(place[i]+"\t");
							System.out.print(number[i]+"\t");
							System.out.print(price[i]+"\n");
						}
					}
					System.out.println("0.返回主界面");
					System.out.println();
					System.out.print("请选择:");
					int select2 = input.nextInt();
					if (select2 == 0){
						break;
					}
					if(!an.equals("y")) {
						System.out.println("您还没有登录，请登录或注册先!");
					}
					while (!an.equals("y")) {//登录注册
						System.out.println("------------------------------------------------------------");
						System.out.println("                               1.登录");
						System.out.println("                               2.注册");
						System.out.print("请选择:");
						int choose = input.nextInt();
						if (choose == 1) {//登录
							String loguname;
							String logpassword;
							System.out.print("请输入用户名:");
							loguname = input.next();
							int i = 0;
							while (i<usernum) {
								if (loguname.equals(uname[i])) {
									loc = i;
									break;
								}
								i++;
							}
							if (i == usernum) {
								System.out.println("账号不存在，请重新登录/注册");
								continue;
							}
							System.out.print("请输入密  码:");
							logpassword = input.next();
							if (!logpassword.equals(password[loc])) {
								System.out.println("密码错误，请重新登录/注册");
								continue;
							}
							System.out.println("登录成功，欢迎回来！");
							an="y";//已登录
							break;
						} else if (choose == 2) {//注册
							//int newuid;
							String newuname;
							String newpassword;
							int newmoney;
							boolean a = true;
							System.out.print("请输入用户名:");
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
							System.out.print("请输入密  码:");
							newpassword = input.next();
							if (newpassword.length() < 6) {
								System.out.println("密码长度过短，请重新登录/注册");
								continue;
							}
							System.out.print("请输入注册金额:");
							newmoney = input.nextInt();
							
							if (newmoney < 100) {
								System.out.println("注册金额过低，请重新登录/注册");
								continue;
							}
							uname[usernum] = newuname;
							password[usernum] = newpassword;
							money[usernum] = newmoney;
							usernum++;
							System.out.println("注册成功，欢迎加入！");
						} else {
							System.out.println("输入错误，请重新输入");
							continue;
						}
					}
					if (select2>0 && select2<=goodsnum) {
						int pos = select2-1;
						if (!type[pos].equals("服饰")) {//在服饰界面，输入了其他商品的编号
							System.out.println("输入商品编号错误，请重新输入!");
							continue;//重新输入
						}
						
						System.out.print("请输入购买数量:");
						while (true) {
							int buynum = input.nextInt();
							if (buynum > 0 && buynum <= number[pos]) {//购买数量小于库存
								number[pos] = number[pos]-buynum;
								//买完东西，加入购物清单
								int i = 0;
								while (i<listnum) {//在原有数据中添加
									if (gid[pos] == goodid[i]) {
										num[i] += buynum;
										sum[i] += buynum*price[pos];
										break;
									}
									i++;
								}
								if (i == listnum) {//新数据
									id[listnum] = listnum+1;
									goodid[listnum] = gid[pos];
									goodname[listnum] = game[pos];
									num[listnum] = buynum;
									goodpri[listnum] = price[pos];
									sum[listnum] = buynum*price[pos];
									listnum++;
								}
								//继续购物
								System.out.println("请问要继续购买服饰吗? y/n");
								char c = input.next().charAt(0);
								if (c == 'y') {//跳转到服饰界面
									break;
								} else if (c == 'n') {
									System.out.println("请问要继续购物吗? y/n");
									tag = input.next().charAt(0);
									break;
								}
							} else if (buynum == 0) {//买0个
								break;
							} else {
								System.out.println("现有"+number[pos]+"个"+goodname[pos]);
								System.out.println("库存不足，请重新输入:");
								continue;
							}
						}
					} else {
						System.out.println("输入商品编号错误，请重新输入!");
						continue;
					}
					if (tag == 'y') {//跳转到主界面，除'n'都回到主界面
						break;
					} else if (tag == 'n') {
						break;
					}
				}
				if (tag == 'n') {
					System.out.println("------------------------------------------------------------");
					allsum = 0;
					System.out.println("您的购物清单如下");
					System.out.println("编号\t名称\t\t数量\t小计");
					for (int i = 0; i < listnum; i++) {
							System.out.print(id[i]+"\t");
							System.out.print(goodname[i]+"\t");
							System.out.print(num[i]+"\t");
							System.out.print(sum[i]+"\n");
							allsum = allsum+sum[i];
					}
					System.out.println();
					System.out.println("总计:"+allsum);
					System.out.println("您现在的余额是"+money[loc]);
					System.out.println("请问现在结账吗？y/n");
					char check = input.next().charAt(0);
					if (check == 'y') {//结账
						if (money[loc] >= allsum) {
							money[loc] -= allsum;
							System.out.println("购买成功，本次消费共计"+allsum+"，您的余额是"+money[loc]+"!");
							listnum = 0;//购物清单清空
						} else {
							System.out.println("您的余额不足，请充值！");
							System.out.print("请输入充值金额：");
							int mon = input.nextInt();
							money[loc] += mon;
							System.out.println("充值成功！");
						}
						continue;
					} else {
						System.out.println("那您继续逛逛呗！");
						continue;
					}
				}
			} else if (select == 0) {//退出
				break;
			} else if (select == 11) {//购物清单
				System.out.println("------------------------------------------------------------");
				allsum = 0;
				System.out.println("您的购物清单如下");
				System.out.println("编号\t名称\t\t数量\t小计");
				for (int i = 0; i < listnum; i++) {
						System.out.print(id[i]+"\t");
						System.out.print(goodname[i]+"\t");
						System.out.print(num[i]+"\t");
						System.out.print(sum[i]+"\n");
						allsum = allsum+sum[i];
				}
				System.out.println();
				System.out.println("总计:"+allsum);
				System.out.println("您现在的余额是"+money[loc]);
				System.out.println("请问现在结账吗？y/n");
				char check = input.next().charAt(0);
				if (check == 'y') {//结账
					if (money[loc] >= allsum) {
						money[loc] -= allsum;
						System.out.println("购买成功，本次消费共计"+allsum+"，您的余额是"+money[loc]+"!");
						listnum = 0;//购物清单清空
					} else {
						System.out.println("您的余额不足，请充值！");
						System.out.print("请输入充值金额：");
						int mon = input.nextInt();
						money[loc] += mon;
						System.out.println("充值成功！");
					}
					continue;
				} else {
					System.out.println("那您继续逛逛呗！");
					continue;
				}
			} else {
				System.out.println("输入错误，无该类型商品，请重新输入!");
				continue;
			}
		} 
		
	}
}