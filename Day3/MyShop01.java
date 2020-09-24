import java.util.Scanner;
public class Myshop01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
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
		String al=null;//置y为重新循环，置n为跳出循环
		do {//商场界面
			String typeName = null;
			String an = null;//置y为重新循环，置n为跳出循环
			do {//商品种类界面
				an = "n";
				System.out.println("商品类型");
				System.out.println("                   1.电器");
				System.out.println("                   2.服饰");
				System.out.println("                   3.水果");
				System.out.println("请选择:");
				int m=input.nextInt();
				if (m == 1) {
					typeName = "电器";
				} else if (m == 2) {
					typeName = "服饰";
				} else if (m == 3) {
					typeName = "水果";
				} else {
					System.out.println("类型选择错误，请重新选择!");
					an="y";
				}
			} while(an.equals("y"));
			String ap=null;
			do {//输入商品编号
				int p = 0;//购买的商品编号
				do {//商品界面
					an = "n";
					System.out.println("编号\t名称\t\t产地\t单价\t库存");
					for(int i=0;i<10;i++) {
						if(game[i]!=null) {//有数据
							if(type[i].equals(typeName)) {//符合当前类型的商品
								System.out.println(gid[i]+"\t"+game[i]+"\t"+place[i]+"\t"+price[i]+"\t"+num[i]);
							}
						}
					}
					System.out.println("请输入要购买的商品编号:");
					p=input.nextInt();
					if(username==null) {//登录界面
						System.out.println("您还没有登录，请登录或注册先!");
						System.out.println("----------------------------------------------------");
						System.out.println("                       1.登录");
						System.out.println("                       2.注册");
						System.out.println("请选择:");
					}
					boolean isFlag=false;
					for(int i=0;i<10;i++) {
						if(game[i]!=null) {
							if(type[i].equals(typeName)) {
								if(gid[i]==p) {//选中的编号存在
									isFlag=true;
									break;
								}
							}
						}
					}
					if(isFlag==false) {//编号错误，重新输入
						System.out.println("商品编号输入错误，请重新选择!");
						an="y";
					}
				} while(an.equals("y"));
				int n = 0;//购买数量
				do {//输入购买数量
					an = "n";
					boolean isFlag=false;
					System.out.println("请输入要购买的数量:");
					n=input.nextInt();
					for(int i=0;i<10;i++) {
						if (gid[i]!=0 && gid[i]==p) {//编号不为0，且是这件商品
							if (num[i]<n){//库存不足
								isFlag = true;
							} else {
								num[i] = num[i]-n;//库存减少
							}
						}
					}
					if(isFlag==true){
						System.out.println("库存不足，请重新输入!");
						an="y";
						for(int i=0;i<10;i++) {
							if(gid[i]!=0&&gid[i]==p) {
								System.out.println(gid[i]+"\t"+game[i]+"\t"+place[i]+"\t"+price[i]+"\t"+num[i]);
							}
						}
					}
				} while(an.equals("y"));
				System.out.println("请问要继续购买"+typeName+"吗?");
				ap=input.next();
			} while (ap.equals("y"));
			System.out.println("请问要继续购物吗?");
			al=input.next();
		} while(al.equals("y"));
	}
}