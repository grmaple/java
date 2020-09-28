package view;
import java.util.Scanner;
import bean.Good;

public class ShopView
{
	public static void main(String[] args)
	{
		/*
		 * 不同包中的类想要相互引用必须使用import引入包类名
		 * 包类名:包名.类名
		 */
		Scanner input=new Scanner(System.in);
		Good g=new Good();//声明Good类的对象g并实例化,g就是Good类的具体个体，可以使用类的属性和方法
		g.show();
	}
}
