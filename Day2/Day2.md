## Day2

### 理论基础

一、初始Java

- Java是一种面向对象的高级编程语言，主要用于移动端(安卓)和WEB端(网站)的开发
- Java语言严格区分大小写，对于文件名和类名之间的关系有着严格要求
- Java项目是一个或多个Java文件组成，Java文件是指后缀名为java，内容符合java文件编写要求的文件
- JDK，是一种环境，Java文件编译和执行的一种环境，需要根据相应的电脑进行下载，安装以及进行环境变量的配置
- 命令
  - javac：编译java源文件，编译成功会生成class文件
  - java：执行class文件，一般是执行拥有main方法的编译生成的class文件，得到运行的结果。

二、变量、运算符、表达式

- 变量：就是一个可以存储数据的空间，存储在这个空间里的值是可以变换的，是不唯一的，所以称之为变。

  - 变量是由三要素组成的：数据类型、变量名、变量值 

    int num = 9;

  - 数据类型-数据类型是指在声明变量的时候约束变量赋值的要求，常用数据类型有int、double、float、char、String、boolean

  - 变量名-变量命名是有要求的

    - 只能用字符、下划线和$符号开头
    - 其余的部分可以是字符、下划线、$和数字
    - 关键字不能做变量名
    - 驼峰命名法

  - 变量值-变量的值是根据变量的数据类型给变量的数据

    - int num = 9;
    - double m = 9.0;
    - float n = 9.0f;
    - char c = 'c';
    - String str = "hello";
    - boolean isFlag = true;

  - 在java中，变量声明之后，必须赋值后才能使用

- 运算符：

  - 算术运算符：+、-、*、/
    - +几乎在所有编程语言都被称之为连接运算符，只有前后都是数字的时候才称之为加号
  - 赋值运算符：=
  - 比较运算符：>、>=、<、<=、==、!=、
    - equals()用于判断字符串是否相同
    - "admin".equals("root"),使用比较运算符的结果只能是true/flase
  - 逻辑运算符：&&并且、||或者、!取反

- 表达式：数据和运算符连接在一起的这种结构称之为表达式

  - 5/2就是由两个整数和一个/连接起来的表达式
  - "admin".equals("root")是由两个字符串类型的数据加比较运算符equals连接起来的表达式
  - 表达式是有数据类型的，表达式的数据类型是由组成表达式的数据决定的

三、选择结构

- if…else结构
  - 最简单的if结构
    - if() {}
  - 最基本的if…else结构
    - if() {} else {}
  - 多重的if…else结构
    - if() {} else if() {} else {}
    - 每个else都去找最近的那个if和其匹配
    - 有if才有else
  - 嵌套if…else结构
    - if() {if() {} else {}} else {if() {} else {}}
- switch…case结构
  - switch(val) {case val1:{break;} case val2:{break;} default:{}}
  - switch…case结构就是一种傻瓜式的匹配结构，看哪一个case后面的val值和switch后面的val值相同，就执行哪一个case下的代码，如果没有任何一个case匹配，就执行default下的代码

四、循环

循环是指在满足条件下重复的去做某件和某些事情，直到条件不满足。

- while循环，先判断，再执行。

  - ```java
    while(条件){
        循环体
    }
    ```

    

- do…while循环，先执行，再判断。

  - ```java
    do {
    	循环体
    } while(条件);
    ```

    

- for循环

  - ```java
    for (初始值; 条件;值的变化) {
    	循环体
    }
    ```

    

五、数组

数组的本质是变量，普通的变量每个变量只能存储一个值，而数组根据其长度可以存储多个值。

- 声明数组的语法结构：
  - 数据类型[] 数组名 = new 数据类型[];
  - 数组的长度决定了数组可以存储多少个值，每个值称之为数组的一个元素，数组的元素的表示方式：数组名[下标]，数组的下标从0开始
- String[] str = new String[10];
  - 声明了一个字符串类型的数组，长度为10，意味着这个数组可以存储10个字符串类型的元素
  - 第一个元素：str[0] = "admin";
  - 最后一个元素：str[9] = "root";
- 数组的其他声明方式
  - String str[] = new String[10];
  - int[] num = {1,2,3,4,5,6};这种声明方式在声明数组的同时也给数组的元素赋值。

### 案例

1.冒泡排序算法

输入任意的整数，利用冒泡排序（从小到大）

```java
import java.util.Scanner;
import java.util.Arrays;
public class Demo05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入要排序的数组长度:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.print("请输入要排序的数字:");
        for (int i = 0; i<n; i++) {
            arr[i] = input.nextInt();
        }
        BubbleSort(arr);
		System.out.print("排序结果:");
		for (int i = 0; i<n; i++) {
            System.out.print(arr[i]+" ");
        }
		//System.out.println(Arrays.toString(arr));
    }
	public static void BubbleSort(int[] arr) {
		int temp;//定义一个临时变量
		boolean flag = false;
		for(int i=0;i<arr.length-1;i++){//冒泡趟数
			flag = true;
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j+1]<arr[j]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = false;
				}
			}
			if(flag == true){
				break;
			}
		}
	}
}

```

2.斐波拉契数列

1、1、2、3、5...

统计前二十位，并统计出前二十位有多少奇数和偶数

```java
import java.util.Scanner;
public class Demo06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入斐波那契数列的长度:");
		int n = input.nextInt();
		int[] arr = new int[n];
		int even = Fibonacci(arr);
		int odd = arr.length - even;
		System.out.println("斐波那契数列前"+n+"个数:");
		for (int i = 0; i<n; i++) {
            System.out.print(arr[i]+" ");
        }
		System.out.println();
		System.out.println("斐波那契数列前"+n+"个数中有"+odd+"个奇数");
		System.out.println("斐波那契数列前"+n+"个数中有"+even+"个偶数");
	}
	public static int Fibonacci(int[] arr) {
		int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                arr[0] = 1;
            }else if (i == 1) {
                arr[1] =1;
            }else {
                arr[i] = arr[i-1] +arr[i-2];
				if (arr[i]%2 == 0) {
					ret++;
				}
            }
        }
		return ret;
    }
}
```

### 小项目

利用数组和循环

商场小项目

商场主页面

![image-20200922201653353](C:\Users\xuyingfeng\AppData\Roaming\Typora\typora-user-images\image-20200922201653353.png)

电器页面

![image-20200922201715980](C:\Users\xuyingfeng\AppData\Roaming\Typora\typora-user-images\image-20200922201715980.png)

![image-20200922202620669](C:\Users\xuyingfeng\AppData\Roaming\Typora\typora-user-images\image-20200922202620669.png)

登录

![image-20200922202659741](C:\Users\xuyingfeng\AppData\Roaming\Typora\typora-user-images\image-20200922202659741.png)

注册

![image-20200922202740130](C:\Users\xuyingfeng\AppData\Roaming\Typora\typora-user-images\image-20200922202740130.png)

购买完后继续询问

![image-20200922203223440](C:\Users\xuyingfeng\AppData\Roaming\Typora\typora-user-images\image-20200922203223440.png)

购买完后继续询问

![image-20200922203358934](C:\Users\xuyingfeng\AppData\Roaming\Typora\typora-user-images\image-20200922203358934.png)

如果都是n，那就需要显示购物清单

![image-20200922203437995](C:\Users\xuyingfeng\AppData\Roaming\Typora\typora-user-images\image-20200922203437995.png)

单用户

```java
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
```

多用户

```java
import java.util.Scanner;
public class Shop03 {
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
		char tag = 'z';//记录是否返回主界面
		while (true) {//主界面
			System.out.println("------------------------------------------------------------");
			System.out.println("                        商城                                        ");
			System.out.println("------------------------------------------------------------");
			System.out.println("商品类型:");
			System.out.println("                            1.电器");
			System.out.println("                            2.水果");
			System.out.println("                            3.服饰");
			System.out.println("                            0.退出");
			System.out.println("------------------------------------------------------------");
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
							int newmoney;
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
							newmoney = input.nextInt();
							
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
					if (select>0 && select<=goodsnum) {
						int pos = select-1;
						System.out.print("请输入购买数量:");
						while (true) {
							int buynum = input.nextInt();
							if (buynum <= number[pos]) {//购买数量小于库存
								number[pos] = number[pos]-buynum;
								//买完东西，加入购物清单
								id[listnum] = listnum+1;
								goodid[listnum] = gid[pos];
								goodname[listnum] = game[pos];
								num[listnum] = buynum;
								sum[listnum] = buynum*price[pos];
								listnum++;
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
							System.out.println("购买成功，欢迎再次光临！");
						} else {
							System.out.println("您的余额不足，请充值！");
						}
						continue;
					} else {
						System.out.println("那您继续逛逛呗！");
						continue;
					}
				}
			} else if (select == 2) {//水果界面
				while (true) {
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
							int newmoney;
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
							newmoney = input.nextInt();
							
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
					if (select>0 && select<=goodsnum) {
						int pos = select-1;
						System.out.print("请输入购买数量:");
						while (true) {
							int buynum = input.nextInt();
							if (buynum <= number[pos]) {//购买数量小于库存
								number[pos] = number[pos]-buynum;
								//买完东西，加入购物清单
								id[listnum] = listnum+1;
								goodid[listnum] = gid[pos];
								goodname[listnum] = game[pos];
								num[listnum] = buynum;
								sum[listnum] = buynum*price[pos];
								listnum++;
								//继续购物
								System.out.println("请问要继续购买水果吗? y/n");
								char c = input.next().charAt(0);
								if (c == 'y') {//跳转到水果界面
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
							System.out.println("购买成功，欢迎再次光临！");
						} else {
							System.out.println("您的余额不足，请充值！");
						}
						continue;
					} else {
						System.out.println("那您继续逛逛呗！");
						continue;
					}
				}
			} else if (select == 3) {//服饰界面
				while (true) {
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
							int newmoney;
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
							newmoney = input.nextInt();
							
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
					if (select>0 && select<=goodsnum) {
						int pos = select-1;
						System.out.print("请输入购买数量:");
						while (true) {
							int buynum = input.nextInt();
							if (buynum <= number[pos]) {//购买数量小于库存
								number[pos] = number[pos]-buynum;
								//买完东西，加入购物清单
								id[listnum] = listnum+1;
								goodid[listnum] = gid[pos];
								goodname[listnum] = game[pos];
								num[listnum] = buynum;
								sum[listnum] = buynum*price[pos];
								listnum++;
								//继续购物
								System.out.println("请问要继续购买服饰吗? y/n");
								char c = input.next().charAt(0);
								if (c == 'y') {//跳转到服饰界面
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
							System.out.println("购买成功，欢迎再次光临！");
						} else {
							System.out.println("您的余额不足，请充值！");
						}
						continue;
					} else {
						System.out.println("那您继续逛逛呗！");
						continue;
					}
				}
			} else if (select == 0) {//退出
				break;
			} else {
				System.out.println("输入错误，无该类型商品，请重新输入!");
				continue;
			}
		} 
		
	}
}
```

