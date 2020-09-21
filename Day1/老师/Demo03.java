import java.util.Scanner;
public class Demo03
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		String am=null;
		do
		{
			System.out.println("请输入第一个数:");
			double m=input.nextDouble();
			System.out.println("请输入第二个数:");
			double n=input.nextDouble();
			String an=null;
			do
			{
				an="n";
				System.out.println("请输入运 算 符:");
				String oper=input.next();
				
				double rs=0;//运算的结果
				if(oper.equals("+"))
				{
					rs=m+n;
					System.out.println("运算结果是:"+rs);
				}
				else if(oper.equals("-"))
				{
					rs=m-n;
					System.out.println("运算结果是:"+rs);
				}
				else if(oper.equals("*"))
				{
					rs=m*n;
					System.out.println("运算结果是:"+rs);
				}
				else if(oper.equals("/"))
				{
					if(n==0)
					{
						System.out.println("除数不能为零!");
					}
					else
					{
						rs=m/n;
						System.out.println("运算结果是:"+rs);
					}
				}
				else if(oper.equals("%"))
				{
					if(n==0)
					{
						System.out.println("除数不能为零!");
					}
					else
					{
						rs=m%n;
						System.out.println("运算结果是:"+rs);
					}
				}
				else
				{
					System.out.println("运算符输入错误,请重新输入!");
					an="y";
				}
			}while(an.equals("y"));
			System.out.println("请问要继续吗?");
			am=input.next();
		}while(am.equals("y"));
	}
}