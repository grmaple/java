import java.util.Scanner;

	/*
	 * Java实现实数四则运算：
	 * 输入格式：
	 * 2
	 * +
	 * 3
	 * 
	 * 输出格式：
	 * 5*/

public class Sizeyunsuan {
	
	static boolean flag;
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("请输入第一个数：");
		double a=input.nextDouble();
		// String str = null;
		// while(true){
			// System.out.println("请输入运算符：");
			// try{
				// str = input.next();
				// if(!str.matches(regex)) throw new Exception();
			// }
			// catch(Exception e){
				// System.out.println("您输入的不是纯汉字！");
				// continue;
			// }
			// break;
		// }
		System.out.print("请输入运算符：");
		String str=input.next();
		// while(!str.equals("+") || !str.equals("-") || !str.equals("*") || !str.equals("/") || !str.equals("%")) {
			// System.out.println("输入错误，请重新输入");
			// str=input.next();
		// }
		System.out.print("请输入第二个数：");
		double b=input.nextDouble();
		input.close();
		print(a,b,str);
		System.out.println();
		
	}
	public static void is_yunsuanfu(String str) {
		
	}
	public static void print(double a,double b,String str) {
		double c=0;
		if(str.equals("+")) {
			c=a+b;
		}else if(str.equals("-")) {
			c=a-b;
		}else if(str.equals("*")) {
			c=a*b;
		}else if(str.equals("/")) {
			if(b!=0) {
				c=a/b;
			}else {
				System.out.println("error");
				flag=true;
			}
		}else if(str.equals("%")) {
			c=a%b;
		}
		if(!flag) {
			if(c-(Math.round(c))==0) {
				//System.out.printf("%f%s%f=%f",a,str,b,Math.round(c));
				System.out.print(Math.round(c));
			}else {
				//System.out.printf("%f%s%f=%f",a,str,b,c);
				System.out.print(c);
			}
		}
	}

}

