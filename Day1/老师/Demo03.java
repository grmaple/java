import java.util.Scanner;
public class Demo03
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		String am=null;
		do
		{
			System.out.println("�������һ����:");
			double m=input.nextDouble();
			System.out.println("������ڶ�����:");
			double n=input.nextDouble();
			String an=null;
			do
			{
				an="n";
				System.out.println("�������� �� ��:");
				String oper=input.next();
				
				double rs=0;//����Ľ��
				if(oper.equals("+"))
				{
					rs=m+n;
					System.out.println("��������:"+rs);
				}
				else if(oper.equals("-"))
				{
					rs=m-n;
					System.out.println("��������:"+rs);
				}
				else if(oper.equals("*"))
				{
					rs=m*n;
					System.out.println("��������:"+rs);
				}
				else if(oper.equals("/"))
				{
					if(n==0)
					{
						System.out.println("��������Ϊ��!");
					}
					else
					{
						rs=m/n;
						System.out.println("��������:"+rs);
					}
				}
				else if(oper.equals("%"))
				{
					if(n==0)
					{
						System.out.println("��������Ϊ��!");
					}
					else
					{
						rs=m%n;
						System.out.println("��������:"+rs);
					}
				}
				else
				{
					System.out.println("������������,����������!");
					an="y";
				}
			}while(an.equals("y"));
			System.out.println("����Ҫ������?");
			am=input.next();
		}while(am.equals("y"));
	}
}